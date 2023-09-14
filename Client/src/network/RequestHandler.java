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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import models.LoginRequest;
import models.LoginResponse;
import models.OnlineGameInvitationRequest;
import models.OnlinePlayersResponse;
import models.PlayerModel;
import screens.ClientMainScreenController;
import screens.LoginRegisterScreenController;
import screens.OnlineUsersController;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public final class RequestHandler extends Thread {

    private PrintStream outStream;
    private DataInputStream inStream;
    private JsonObject request;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    //String response;
    public RequestHandler(JsonObject request) {
        try {
            this.request = request;
            outStream = new PrintStream(NetworkUtils.getSocketInstance().getOutputStream());
            inStream = new DataInputStream(NetworkUtils.getSocketInstance().getInputStream());
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            bufferedReader = new BufferedReader(new InputStreamReader(inStream));
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        if (NetworkUtils.connectToServer()) {
            try {
                bufferedWriter.write(request.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException ex) {
                System.out.println("unable to send to server");
            }
            String response;
            while (true) {
                try {
                    response = bufferedReader.readLine();
                    if (response != null) {
                        System.out.println("Response:" + response);
                        handleResonse(response);
                    } else {
                        System.out.println("null response!!");
                    }

                } catch (IOException ex) {
                    Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void handleResonse(String response) {
        System.out.println("from method, response: " + response);
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
        System.out.println("from method, object response: " + jsonResponse.toString());
        String operation = jsonResponse.get(JsonableConst.KEY_OPERATION).getAsString();
        switch (operation) {
            case JsonableConst.VALUE_LOGIN:
                LoginResponse loginResponse = gson.fromJson(jsonResponse, LoginResponse.class);
                if (loginResponse.getStatus() == JsonableConst.VALUE_STATUS_SUCCESS) {
                    System.out.println("success login");
                    Platform.runLater(() -> {
                        Client.isLoggedIn = true;
                        Client.userName = loginResponse.getMessage();
                        LoginRegisterScreenController.latch.countDown();
                    });
                } else {
                    System.out.println("invalid username or password");
                }
                break;
            case JsonableConst.VALUE_ONLINE_PLAYERS:
                OnlinePlayersResponse onlinePlayersResponse = new Gson().fromJson(jsonResponse, OnlinePlayersResponse.class);
                if (onlinePlayersResponse.getStatus() == JsonableConst.VALUE_STATUS_SUCCESS) {
                    System.out.println("online players request got some results!!");
                    ArrayList<PlayerModel> onlinePlayers = onlinePlayersResponse.getOnlinePlayers();
                    Platform.runLater(() -> {
                        OnlineUsersController.updateList(onlinePlayers);
                    });
                } else {
                    System.out.println("error fetching data");
                }
                break;
            case JsonableConst.VALUE_ONLINE_GAME_INVITAION:
                OnlineGameInvitationRequest onlineGameInvitationRequest = new Gson().fromJson(jsonResponse, OnlineGameInvitationRequest.class);

                System.out.println("got invitation from player: "
                        + onlineGameInvitationRequest.getSenderUserName());
                break;
            default:
                System.out.println("Invalid response!!");
        }
    }
}
