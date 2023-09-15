/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import java.io.IOException;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
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

    Navigation navigation;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleActions();
    }

    public void handleActions() {
        profileBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/PlayerProfileScreen.fxml");
        });
        computerBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/GameScreen.fxml");
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
    
    public  void goToGameScreen() {
        if (stage != null) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/screens/GameScreen.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("no stage!!");
        }
    }
}