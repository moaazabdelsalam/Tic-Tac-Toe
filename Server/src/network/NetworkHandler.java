
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.*;
import models.LoginRequest;
import models.LoginResponse;
import models.OnlineGameInvitationRequest;
import models.OnlineGameInvitationResponse;
import models.OnlinePlayersRequest;
import models.OnlinePlayersResponse;
import models.PlayerModel;
import models.UpdateStatusRequest;
import server.DatabaseHandler;

public class NetworkHandler extends Thread {

    private final AtomicBoolean running = new AtomicBoolean(true);
    DataInputStream inStream;
    PrintStream outStream;
    String clientUsername;
    int clientConnectionID = 0;
    Socket clientSocket;
    int dataBaseID = -1;
    DatabaseHandler dbHandler = new DatabaseHandler();
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public void closeConnection() {
        System.out.println("Closing Socket #" + clientConnectionID);
        try {

            inStream.close();
            outStream.close();
            clientSocket.close();
            dataBaseID = -1;

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
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            bufferedReader = new BufferedReader(new InputStreamReader(inStream));

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
                    receivedMsg = bufferedReader.readLine();
                    Gson gson = new Gson();
                    JsonObject jsonResponse = gson.fromJson(receivedMsg, JsonObject.class);
                    String operationToDo = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
                    switch (operationToDo) {
                        case JsonableConst.VALUE_LOGIN:
                            LoginRequest loginRequest = new Gson().fromJson(jsonResponse, LoginRequest.class);
                            bufferedWriter.write(loginUser(loginRequest));
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            break;
                        case JsonableConst.VALUE_ONLINE_PLAYERS:
                            OnlinePlayersRequest onlinePlayersRequest = new Gson().fromJson(jsonResponse, OnlinePlayersRequest.class);
                            bufferedWriter.write(getOnlinePlayers(onlinePlayersRequest));
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            break;
                        case JsonableConst.VALUE_UPDATE_STATUS:
                            UpdateStatusRequest updateStatusRequest = new Gson().fromJson(jsonResponse, UpdateStatusRequest.class);
                            updateStatus(updateStatusRequest);
                            break;
                        case JsonableConst.VALUE_ONLINE_GAME_INVITAION:
                            OnlineGameInvitationRequest onlineGameInvitationRequest = new Gson().fromJson(jsonResponse, OnlineGameInvitationRequest.class);
                            sendInvitation(onlineGameInvitationRequest);
                            break;
                        case JsonableConst.VALUE_ONLINE_GAME_INVITAION_RESPONSE:
                            OnlineGameInvitationResponse onlineInvitationResponse = new Gson().fromJson(jsonResponse, OnlineGameInvitationResponse.class);
                            sendInvitationResponse(onlineInvitationResponse);
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

    private String loginUser(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse(loginRequest.getOp());
        //String username = loginRequest.getUserName().replaceAll("[^a-zA-Z0-9]", "");

        if (validateUsername(loginRequest.getUserName())
                && !(loginRequest.getPassword().isEmpty())) {
            //username is clean of any malicious sql characters
            //start connection to db and check if player exists
            //DatabaseHandler dbHandler = new DatabaseHandler();
            PlayerModel player = dbHandler.getPlayerByUsername(loginRequest.getUserName());
            if (player != null) {
                //Player already exists in database
                if (player.getPassword().equals(loginRequest.getPassword())) {
                    loginResponse.setStatus(JsonableConst.VALUE_STATUS_SUCCESS);
                    loginResponse.setMessage(player.getUserName());
                    this.dataBaseID = player.getId();
                    System.out.println("ID after login: " + this.dataBaseID);
                    dbHandler.updateStatus(player.getUserName(), 1);
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
        System.out.println(json.toString());
        return json.toString();
    }

    private String getOnlinePlayers(OnlinePlayersRequest onlinePlayersRequest) {
        System.out.println("getting online players..");
        OnlinePlayersResponse onlinePlayersResponse = new OnlinePlayersResponse(onlinePlayersRequest.getOp());
        //DatabaseHandler dbHandler = new DatabaseHandler();
        ArrayList<PlayerModel> onlinePlayers = dbHandler.getOnlinePlayers().stream()
                .filter(player -> player.getId() != this.dataBaseID)
                .collect(Collectors.toCollection(ArrayList::new));
        if (onlinePlayers != null) {
            onlinePlayersResponse.setStatus(JsonableConst.VALUE_STATUS_SUCCESS);
            onlinePlayersResponse.setOnlinePlayers(onlinePlayers);
            System.out.println("got some players!!");
        } else {
            onlinePlayersResponse.setStatus(JsonableConst.VALUE_STATUS_FAILED);
            onlinePlayersResponse.setOnlinePlayers(null);
        }

        Gson gson = new Gson();
        JsonObject json = gson.fromJson(gson.toJson(onlinePlayersResponse), JsonObject.class);
        System.out.println(json.toString());
        return json.toString();
    }

    private boolean validateUsername(String username) {
        String trimmedUsername = username.trim();
        if (trimmedUsername.isEmpty()
                || trimmedUsername.length() <= 3) {

            return false;
        }

        return true;
    }

    private void updateStatus(UpdateStatusRequest updateStatusRequest) {
        //DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.updateStatus(updateStatusRequest.getUserName(), updateStatusRequest.getStatus());
        System.out.println("status updated for client: " + updateStatusRequest.getUserName() + "to: " + updateStatusRequest.getStatus());
    }

    private void sendInvitation(OnlineGameInvitationRequest onlineGameInvitationRequest) {
        AtomicInteger receiverID = new AtomicInteger(-1);
        Optional<PlayerModel> optionalReceiverPlayer = dbHandler.getOnlinePlayers().stream()
                .filter(player -> player.getUserName().equals(onlineGameInvitationRequest.getReciverUserName()))
                .findAny();
        optionalReceiverPlayer.ifPresent(player -> receiverID.set(player.getId()));
        if (receiverID.get() != -1) {
            System.out.println("play request loginID: " + receiverID);
            ReceiveConnectionThread.clients.stream()
                    .filter(client -> client.dataBaseID == receiverID.get())
                    .findAny()
                    .ifPresent(client -> {
                        OnlineGameInvitationRequest onlineGameRequest = new OnlineGameInvitationRequest(JsonableConst.VALUE_ONLINE_GAME_INVITAION,
                                onlineGameInvitationRequest.getSenderUserName());
                        System.out.println("sending request to player: "
                                + onlineGameInvitationRequest.getReciverUserName()
                                + ", from player: " + onlineGameInvitationRequest.getSenderUserName());

                        Gson gson = new Gson();
                        JsonObject onlineGameRequestJson = gson.fromJson(gson.toJson(onlineGameRequest), JsonObject.class);
                        try {
                            client.bufferedWriter.write(onlineGameRequestJson.toString());
                            client.bufferedWriter.newLine();
                            client.bufferedWriter.flush();
                            System.out.println(onlineGameRequestJson.toString());
                        } catch (IOException ex) {
                            System.out.println("error sending message to player");
                        }
                    });
        }
    }

    private void sendInvitationResponse(OnlineGameInvitationResponse onlineInvitationResponse) {
        AtomicInteger receiverID = new AtomicInteger(-1);
        Optional<PlayerModel> optionalReceiverPlayer = dbHandler.getOnlinePlayers().stream()
                .filter(player -> player.getUserName().equals(onlineInvitationResponse.getReciverUserName()))
                .findAny();
        optionalReceiverPlayer.ifPresent(player -> receiverID.set(player.getId()));
        if (receiverID.get() != -1) {
            System.out.println("play request loginID: " + receiverID);
            ReceiveConnectionThread.clients.stream()
                    .filter(client -> client.dataBaseID == receiverID.get())
                    .findAny()
                    .ifPresent(client -> {
                        OnlineGameInvitationResponse onlineGameResponse = new OnlineGameInvitationResponse(JsonableConst.VALUE_ONLINE_GAME_INVITAION_RESPONSE);
                        onlineGameResponse.setStatus(onlineInvitationResponse.getStatus());
                        onlineGameResponse.setSenderUserName(onlineInvitationResponse.getSenderUserName());
                        onlineGameResponse.setReciverUserName(onlineInvitationResponse.getReciverUserName());
                        System.out.println("sending response from player: "
                                + onlineGameResponse.getSenderUserName()
                                + ", to player: " + onlineGameResponse.getReciverUserName());

                        Gson gson = new Gson();
                        JsonObject onlineGameRequestJson = gson.fromJson(gson.toJson(onlineGameResponse), JsonObject.class);
                        try {
                            client.bufferedWriter.write(onlineGameRequestJson.toString());
                            client.bufferedWriter.newLine();
                            client.bufferedWriter.flush();
                            System.out.println(onlineGameRequestJson.toString());
                        } catch (IOException ex) {
                            System.out.println("error sending response to player");
                        }
                    });
        }
    }
}
