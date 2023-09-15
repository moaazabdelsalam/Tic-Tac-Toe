/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import client.Client;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javafx.application.Platform;
import models.GameType;
import models.LoginResponse;
import models.OnlineGameInvitationRequest;
import models.OnlineGameInvitationResponse;
import models.OnlineGameMove;
import models.OnlinePlayersResponse;
import models.PlayerModel;
import models.RegisterResponse;
import screens.GameScreenController;
import screens.LoginRegisterScreenController;
import screens.OnlineUsersController;
import screens.RegisterScreenController;

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

    public RequestHandler() {
        try {
            outStream = new PrintStream(NetworkUtils.getSocketInstance().getOutputStream());
            inStream = new DataInputStream(NetworkUtils.getSocketInstance().getInputStream());
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            bufferedReader = new BufferedReader(new InputStreamReader(inStream));
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //String response;
    public RequestHandler(JsonObject request) {
        this();
        this.request = request;
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
                    System.out.println("Login Successful");
                    Platform.runLater(() -> {
                        Client.getInstance().setIsLoggedIn(true);
                        Client.getInstance().setUserName(loginResponse.getMessage());
                        LoginRegisterScreenController.latch.countDown();
                    });
                } else {
                    System.out.println("Invalid Username or Password");
                }
                break;
            case JsonableConst.VALUE_REGISTER:
                RegisterResponse registerResponse = gson.fromJson(jsonResponse, RegisterResponse.class);
                if (registerResponse.getStatus() == JsonableConst.VALUE_STATUS_SUCCESS) {
                    System.out.println("Register Success");
                    Platform.runLater(() -> {
                        Client.getInstance().setIsLoggedIn(true);
                        Client.getInstance().setUserName(registerResponse.getMessage());
                        LoginRegisterScreenController.latch.countDown();
                    });
                } else {
                    Platform.runLater(() -> {
                        RegisterScreenController.userNameTaken = true;
//                        RegisterScreenController.userNameAlert();
                    });
                    
                    System.out.println("Please Check Your Inputs");
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
                Platform.runLater(() -> {
                    Client.getInstance().showDialog(onlineGameInvitationRequest.getSenderUserName());
                });
                break;
            case JsonableConst.VALUE_ONLINE_GAME_INVITAION_RESPONSE:
                OnlineGameInvitationResponse onlineGameResponse = new Gson().fromJson(jsonResponse, OnlineGameInvitationResponse.class);
                System.out.println("got response from player: "
                        + onlineGameResponse.getSenderUserName()
                        + ", with status: " + onlineGameResponse.getStatus());
                if (onlineGameResponse.getStatus() == JsonableConst.VALUE_STATUS_ACCEPT) {
                    System.out.println("request to player: " + onlineGameResponse.getSenderUserName() + " is accepted");
                    Platform.runLater(() -> {
                        GameScreenController.GAME_TYPE = GameType.ONLINE;
                        GameScreenController.P1_NAME = Client.getInstance().getUserName(); //sender of invitation is first player
                        GameScreenController.P2_NAME = onlineGameResponse.getSenderUserName(); //reciver of invitation is second player
                        Client.sceneToSwitch = "/screens/GameScreen.fxml";
                    });
                } else {
                    System.out.println("request to player: " + onlineGameResponse.getSenderUserName() + " is refused");
                }
                break;
            case JsonableConst.VALUE_ONLINE_GAME_MOVES:
                OnlineGameMove onlineMoveRequest = new Gson().fromJson(jsonResponse, OnlineGameMove.class);
                System.out.println(onlineMoveRequest.toString());
                break;
            default:
                System.out.println("Invalid response!!");
        }
    }

    public void sendMessage(JsonObject request) {
        try {
            bufferedWriter.write(request.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println("unable to send to server");
        }
    }
}
