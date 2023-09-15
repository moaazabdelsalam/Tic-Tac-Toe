/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.GameType;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class LocalPlayersNamesController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField player1TextField;
    @FXML
    private TextField player2TextField;
    @FXML
    private Label playerOneNameError;
    @FXML
    private Label playerTwoNameError;

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
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });
        btnCancel.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });
        player1TextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                removeErrorMessage(playerOneNameError);
            }

        });
        player2TextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                removeErrorMessage(playerTwoNameError);
            }

        });
        btnStart.setOnAction(event -> {
            check(event);
            String p1Name = player1TextField.getText();
            String nameValidation = validatePlayerName(p1Name);
            if (!(nameValidation.isEmpty())) {
                showErrorMessage(playerOneNameError, nameValidation);
                return;
            }
            String p2Name = player2TextField.getText();
            nameValidation = validatePlayerName(p2Name);
            if (!(nameValidation.isEmpty())) {
                showErrorMessage(playerTwoNameError, nameValidation);
                return;
            }
            GameScreenController.GAME_TYPE = GameType.TWO_PLAYERS;
            GameScreenController.P1_NAME = p1Name;
            GameScreenController.P2_NAME = p2Name;
            navigation.goTo("/screens/GameScreen.fxml");
        });

    }

    public void check(ActionEvent event) {
        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

    private String validatePlayerName(String playerName) {
        String trimmedPlayerName = playerName.trim();
        if (trimmedPlayerName.isEmpty()) {
            return "username can't be empty.";
        }

        if (trimmedPlayerName.length() <= 3) {
            return "Name must be 4 characters or more.";
        }

        return "";
    }

    public void showErrorMessage(Label errorLabel, String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    private void removeErrorMessage(Label errorLabel) {
        errorLabel.setText("");
        errorLabel.setVisible(false);
    }
}
