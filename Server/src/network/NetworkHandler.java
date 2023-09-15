
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.LoginRequest;
import models.LoginResponse;
import models.PlayerModel;
import models.RegisterRequest;
import models.RegisterResponse;
import server.DatabaseHandler;

public class NetworkHandler extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(true);
    DataInputStream inStream;
    PrintStream outStream;
    String clientUsername;
    int clientConnectionID = 0;
    Socket clientSocket;

    public void closeConnection() {
        System.out.println("Closing Socket #" + clientConnectionID);
        try {

            inStream.close();
            outStream.close();
            clientSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        running.set(false);

    }

    public NetworkHandler(Socket socket, int clientID) {
        this.clientConnectionID = clientID;
        clientSocket = socket;
        try {

            inStream = new DataInputStream(socket.getInputStream());
            outStream = new PrintStream(socket.getOutputStream());

            System.out.println("------------- NetworkHandler Started -------------");
        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        System.out.println("------------- Client Connected -------------");
        while (running.get() && NetworkUtils.getServerStatus()) {
            if (clientSocket.isConnected()) {
                String receivedMsg;
                try {
                    receivedMsg = inStream.readLine();
                    Gson gson = new Gson();
                    JsonObject jsonResponse = gson.fromJson(receivedMsg, JsonObject.class);
                    String operationToDo = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
                    switch (operationToDo) {
                        case JsonableConst.VALUE_LOGIN:
                            LoginRequest loginRequest = new Gson().fromJson(jsonResponse, LoginRequest.class);
                            outStream.println(loginUser(loginRequest));
                            break;
                        case JsonableConst.VALUE_REGISTER:
                            RegisterRequest registerRequest = new Gson().fromJson(jsonResponse, RegisterRequest.class);
                            
                            outStream.println(registerUser(registerRequest));
                            break;

                        default:
                            System.out.println("Invalid Operation");
                    }

                } catch (IOException ex) {
                    break;
                }

            }

        }
    }

    private String registerUser(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse(registerRequest.getOp());
        DatabaseHandler dbHandler = new DatabaseHandler();
        Gson gson = new Gson();

        // Check if the password matches the confirm password
        if (!registerRequest.getPassword().equals(registerRequest.getconfirmPassword())) {
            registerResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
            registerResponse.setMessage(JsonableConst.VALUE_MESSAGE_REGISTER_FAILED_PASSWORD);
            JsonObject json = gson.fromJson(gson.toJson(registerResponse), JsonObject.class);
            return json.toString();
        }

        // Check if the username is already used
        if (dbHandler.getPlayerByUsername(registerRequest.getUserName()) != null) {
            registerResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
            registerResponse.setMessage(JsonableConst.VALUE_MESSAGE_REGISTER_FAILED_USERNAME);
        } else {
            dbHandler.addNewPlayer(
                    new PlayerModel(registerRequest.getName(), registerRequest.getUserName(), registerRequest.getPassword(), 1, 0));
            registerResponse.setStatus(JsonableConst.VALUE_STATUS_SUCCESS);
            registerResponse.setMessage(JsonableConst.VALUE_MESSAGE_REGISTER_SUCCESS);
        }

        JsonObject json = gson.fromJson(gson.toJson(registerResponse), JsonObject.class);
        return json.toString();
    }

    private String loginUser(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse(loginRequest.getOp());
        //String username = loginRequest.getUserName().replaceAll("[^a-zA-Z0-9]", "");

        if (validateUsername(loginRequest.getUserName())
                && !(loginRequest.getPassword().isEmpty())) {
            //username is clean of any malicious sql characters
            //start connection to db and check if player exists
            DatabaseHandler dbHandler = new DatabaseHandler();
            PlayerModel player = dbHandler.getPlayerByUsername(loginRequest.getUserName());
            if (player != null) {
                //Player already exists in database
                if (player.getPassword().equals(loginRequest.getPassword())) {
                    loginResponse.setStatus(JsonableConst.VALUE_STATUS_SUCCESS);
                    loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_SUCCESS);
                    dbHandler.updateStatus(player);
                } else {
                    loginResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
                    loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_FAILED);
                }

            } else {
                loginResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
                loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_FAILED);
            }
        } else {
            loginResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
            loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_FAILED_INVALID_USERNAME);
        }

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(gson.toJson(loginResponse), JsonObject.class);
        return json.toString();
    }

    private boolean validateUsername(String username) {
        String trimmedUsername = username.trim();
        return !(trimmedUsername.isEmpty()
                || trimmedUsername.length() <= 3);
    }

}
