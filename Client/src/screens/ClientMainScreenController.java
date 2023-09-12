/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
            System.out.println("registered? " + Client.isLoggedIn);
            if (!Client.isLoggedIn) {
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
}
