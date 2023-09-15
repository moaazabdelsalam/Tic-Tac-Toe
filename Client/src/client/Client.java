package client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.UpdateStatusRequest;
import network.JsonableConst;
import network.NetworkUtils;
import network.RequestHandler;
import screens.ClientMainScreenController;
import screens.InvitationDialogController;
import screens.Navigation;

public class Client extends Application {

    Stage stage;
    private static boolean isLoggedIn = false;
    private static String userName = null;
    private static Client instance = null;
    public static volatile String sceneToSwitch = null;

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        Client.isLoggedIn = isLoggedIn;
    }

    public static void setUserName(String userName) {
        Client.userName = userName;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Navigation navigation = new Navigation(stage);
        navigation.goTo("/screens/ClientMainScreen.fxml");
        stage.setResizable(false);
        stage.show();
        checkForSceneSwitch(stage);
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

    public void showDialog(String sender) {
        try {
            System.out.println("showing dialog");
            Stage dialogStage = new Stage();
            dialogStage.setTitle("game invitation");
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(stage);

            InvitationDialogController.sender = sender;
            Parent root = FXMLLoader.load(getClass().getResource("/screens/InvitationDialog.fxml"));
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Client getInstance() {
        if (instance == null) {
            return new Client();
        } else {
            return instance;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void checkForSceneSwitch(Stage stage) {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (sceneToSwitch != null) {

                    Platform.runLater(() -> {
                        try {
                            System.out.println(sceneToSwitch);
                            Parent root = FXMLLoader.load(getClass().getResource(sceneToSwitch));
                            Scene scene = new Scene(root);
                            Stage primaryStage = stage;
                            primaryStage.setScene(scene);
                            primaryStage.show();
                            sceneToSwitch = null;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });

                    //sceneToSwitch = null;
                }
            }
        }, 1000, 1000);
    }
}
