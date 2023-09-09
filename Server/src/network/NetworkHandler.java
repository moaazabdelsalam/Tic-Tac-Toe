
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

public class NetworkHandler extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(true);
    DataInputStream inStream;
    PrintStream outStream;
    int clientID = 0;
    Socket clientSocket;

    public void closeConnection() {
        System.out.println("Closing Socket #" + clientID);
        try {
            clientSocket.close();
            inStream.close();
            outStream.close();

        } catch (IOException ex) {
            Logger.getLogger(NetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        running.set(false);

    }

    public NetworkHandler(Socket socket, int clientID) {
        this.clientID = clientID;
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
                            //Object  loginObject = new Gson().fromJson(requestReceived, Object.class);
                            LoginRequest loginRequest = new Gson().fromJson(jsonResponse, LoginRequest.class);
                            //loginJsonObject.getFromJson(receivedObject);
                            outStream.println(loginUser(loginRequest));
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

    private JsonObject loginUser(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse(loginRequest.getOp());
        if (loginRequest.getUserName().equals("abc")
                && loginRequest.getPassword().equals("123")) {
            loginResponse.setStatus(JsonableConst.VALUE_STATUS_SUCCESS);
            loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_SUCCESS);
        } else {
            loginResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
            loginResponse.setMessage(JsonableConst.VALUE_MESSAGE_LOGIN_FAILED);
        }
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(loginResponse), JsonObject.class);
    }
}
