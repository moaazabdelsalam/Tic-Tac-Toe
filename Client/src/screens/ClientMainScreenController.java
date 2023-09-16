/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import java.io.IOException;
import client.ComputerRound;
import client.GameLogic;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.GameType;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class ClientMainScreenController implements Initializable {

    @FXML
    private Button profileBtn;
    @FXML
    private Button mainExitBtn;
    @FXML
    private Button computerBtn;
    @FXML
    private Button localBtn;
    @FXML
    private Button onlineBtn;
    @FXML
    private Button btnLogin;

    Navigation navigation;
    Stage stage;
    GameLogic gameLogic;
    ComputerRound AIModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (Client.getInstance().isIsLoggedIn()) {
            btnLogin.setText("LOGOUT");
        } else {
            btnLogin.setText("LOGIN");
        }
        handleActions();
    }

    public void handleActions() {
        profileBtn.setOnAction(event -> {
            check(event);
            if (Client.getInstance().isIsLoggedIn()) {
                navigation.goTo("/screens/PlayerProfileScreen.fxml");
            } else {
                showLoginAlert("You should be logged in to access profile");
            }
        });
//        onlineBtn.setOnAction(event -> {
//            check(event);
//            if(Client.isLoggedIn){
//                GameScreenController.GAME_TYPE = GameType.ONLINE;
//                navigation.goTo("/screens/OnlineUsers.fxml");
//            }else{
//                showLoginAlert("You should be logged in to play online");
//            }
//        });
        computerBtn.setOnAction(event -> {
            showCustomPopup(event);
            check(event);
            GameScreenController.GAME_TYPE = GameType.COMPUTER;
            navigation.goTo("/screens/GameScreen.fxml");
        });
        btnLogin.setOnAction(event -> {
            check(event);
            if (Client.getInstance().isIsLoggedIn()) {
                //do logout
            } else {
                navigation.goTo("/screens/LoginRegisterScreen.fxml");
            }
        });
        onlineBtn.setOnAction(event -> {
            System.out.println("registered? " + Client.getInstance().isIsLoggedIn());
            if (!Client.getInstance().isIsLoggedIn()) {
                check(event);
                navigation.goTo("/screens/LoginRegisterScreen.fxml");
            } else {
                check(event);
                navigation.goTo("/screens/OnlineUsers.fxml");
            }

        });
        localBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/LocalPlayersNames.fxml");
        });
        mainExitBtn.setOnAction(event -> {
            Platform.exit();
        });
    }

    public void check(ActionEvent event) {
        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

    public void showLoginAlert(String alertText) {
        Alert loginAlert = new Alert(Alert.AlertType.WARNING);
        loginAlert.setContentText(alertText);
        loginAlert.show();
    }
////////////////////////////////////Popup Function, Formatting & Setting The Difficulty -Samahy //////////////////////////////////////////////////

    @FXML
    private void showCustomPopup(ActionEvent event) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("Select Difficulty");
        alert.setHeaderText(null);

        Button easy = new Button("Easy");
        Button medium = new Button("Medium");
        Button hard = new Button("Hard");

        easy.setStyle("-fx-background-color: #60BFC1;"
                + "-fx-text-fill: white;"
                + "-fx-padding: 10px 20px;"
                + "-fx-border-radius: 5px;-fx-border-color: #ffffff;-fx-border-width: 1px;"
                + " -fx-border-insets: 0 2px 2px 0;-fx-font-family: \"Impact\";");
        medium.setStyle("-fx-background-color: #60BFC1;"
                + "-fx-text-fill: white;"
                + "-fx-padding: 10px 20px;"
                + "-fx-border-radius: 5px;-fx-border-color: #ffffff;-fx-border-width: 1px;"
                + " -fx-border-insets: 0 2px 2px 0;-fx-font-family: \"Impact\";");
        hard.setStyle("-fx-background-color: #60BFC1;"
                + "-fx-text-fill: white;"
                + "-fx-padding: 10px 20px;"
                + "-fx-border-radius: 5px;-fx-border-color: #ffffff;-fx-border-width: 1px;"
                + " -fx-border-insets: 0 2px 2px 0;-fx-font-family: \"Impact\";");
        alert.getDialogPane().setStyle(
                "-fx-background-color: #ffffff;");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().add(cancelButton);

        Node cancelButtonNode = alert.getDialogPane().lookupButton(cancelButton);
        cancelButtonNode.setStyle("-fx-background-color: #60BFC1;"
                + "-fx-text-fill: white;"
                + "-fx-padding: 10px 20px;"
                + "-fx-border-radius: 5px;-fx-border-color: #ffffff;-fx-border-width: 1px;"
                + " -fx-border-insets: 0 2px 2px 0;-fx-font-family: \"Impact\";");

        alert.getDialogPane().setContent(new HBox(easy, medium, hard));
        easy.setOnAction(e -> {
            // Handle Easy button click
            GameScreenController.difficultyLevel = 1;
//            check(event);
//            navigation.goTo("/screens/GameScreen.fxml");
            alert.close();

        });

        medium.setOnAction(e -> {
            // Handle Medium button click
            GameScreenController.difficultyLevel = 2;
//            check(event);
//            navigation.goTo("/screens/GameScreen.fxml");
            alert.close();

        });

        hard.setOnAction(e -> {
            // Handle Hard button click
            GameScreenController.difficultyLevel = 3;
//            check(event);
//            navigation.goTo("/screens/GameScreen.fxml");
            alert.close();

        });
        alert.showAndWait();
    }
}
