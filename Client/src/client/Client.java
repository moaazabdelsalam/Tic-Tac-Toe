package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.UpdateStatusRequest;
import network.JsonableConst;
import network.NetworkUtils;
import network.RequestHandler;
import screens.ClientMainScreenController;
import screens.Navigation;

public class Client extends Application {

    public static boolean isLoggedIn = false;
    public static String userName = null;

    @Override
    public void start(Stage stage) throws Exception {

        Navigation navigation = new Navigation(stage);
        navigation.goTo("/screens/ClientMainScreen.fxml");
        stage.setResizable(false);
        stage.show();

        //  root.mediaViewer.setMediaPlayer(mediaPlayer);
    }

    @Override
    public void stop() {
        System.out.println("Stop");
        boolean isConnected = NetworkUtils.connectToServer();
        System.out.println(isConnected);
        if (isConnected && Client.isLoggedIn) {
            UpdateStatusRequest updateStatusRequest = new UpdateStatusRequest(
                    JsonableConst.VALUE_UPDATE_STATUS,
                    Client.userName,
                    0);
            Gson gson = new Gson();
            JsonObject onlinePlayersJson = gson.fromJson(gson.toJson(updateStatusRequest), JsonObject.class);
            System.out.println("requesting status update");
            RequestHandler updateStatusHandler = new RequestHandler(onlinePlayersJson);
            updateStatusHandler.start();
        } else {
            System.out.println("not logged in");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
