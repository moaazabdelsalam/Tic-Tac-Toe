/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import models.LoginRequest;
import models.LoginResponse;
import models.OnlinePlayersResponse;
import models.PlayerModel;
import screens.OnlineUsersController;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public final class RequestHandler extends Thread {

    private PrintStream outStream;
    private DataInputStream inStream;
    private JsonObject request;
    private String serverResponse = null;

    //String response;
    public RequestHandler(JsonObject request) {
        try {
            this.request = request;
            outStream = new PrintStream(NetworkUtils.getSocketInstance().getOutputStream());
            inStream = new DataInputStream(NetworkUtils.getSocketInstance().getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        String response = null;
        if (NetworkUtils.connectToServer()) {
            outStream.println(request);
            try {
                response = inStream.readLine();
                System.out.println("Response:" + response);
//                Gson gson = new Gson();
//                LoginResponse loginResponse = gson.fromJson(response, LoginResponse.class);
//                String operationToDo = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
//                switch (operationToDo) {
//                    case JsonableConst.VALUE_LOGIN:
//                        LoginRequest loginRequest = new Gson().fromJson(jsonResponse, LoginRequest.class);
//                        outStream.println(loginUser(loginRequest));
//                        break;
//                    default:
//                        System.out.println("Invalid Operation");
//
//                }
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
                serverResponse = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
                switch (serverResponse) {
                    case JsonableConst.VALUE_ONLINE_PLAYERS:
                        OnlinePlayersResponse onlinePlayersResponse = new Gson().fromJson(jsonResponse, OnlinePlayersResponse.class);
                        System.out.println("Status: " + onlinePlayersResponse.getStatus());
                        if (onlinePlayersResponse.getStatus() == JsonableConst.VALUE_STATUS_SUCCESS) {
                            ArrayList<PlayerModel> onlinePlayers = onlinePlayersResponse.getOnlinePlayers();
                            System.out.println("online Players: " + onlinePlayers.toString());
                            Platform.runLater(() -> {
                                OnlineUsersController.updateList(onlinePlayers);
                            });
                            System.out.println("from handler");
                            for (PlayerModel player : onlinePlayers) {
                                System.out.println(player.getName());
                            }
                        } else {
                            System.out.println("error fetching data");
                        }

                        break;
                    default:
                        System.out.println("Invalid response!!");
                }
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public String getServerResponse() {
        return serverResponse;
    }

}
