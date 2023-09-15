/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
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
            showCustomPopup(event);
        });
//        computerBtn.setOnAction(event -> {
//            check(event);
//            navigation.goTo("/screens/GameScreen.fxml");
//        });
        onlineBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/LoginRegisterScreen.fxml");
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
////////////////////////////////////Popup Function And Formatting -Samahy //////////////////////////////////////////////////

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
            System.out.println("Easy clicked");
            alert.close();
        });

        medium.setOnAction(e -> {
            // Handle Medium button click
            System.out.println("Medium clicked");
            alert.close();
        });

        hard.setOnAction(e -> {
            // Handle Hard button click
            System.out.println("Hard clicked");
            alert.close();
        });
        alert.showAndWait();
    }
}
