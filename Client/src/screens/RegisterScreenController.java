/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.RegisterRequest;
import network.JsonableConst;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class RegisterScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField userNameTxtf;
    @FXML
    private TextField nameTxtf;
    @FXML
    private TextField passwordTxtf;
    @FXML
    private TextField confirmPasswordTxtf;

//    @FXML
//    private Label usernameError;
//    @FXML
//    private Label passwordError;
//    @FXML
//    private Label matchError;

    Navigation navigation;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleAction();
    }

    public void handleAction() {
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });
        registerBtn.setOnAction(event -> {
            
            if (userNameTxtf.getText().isEmpty() || nameTxtf.getText().isEmpty() || passwordTxtf.getText().isEmpty() || confirmPasswordTxtf.getText().isEmpty()) {
                // Create and configure an alert dialog
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields");

                // Display the alert
                alert.showAndWait();

                return; // Exit the method to prevent further processing
            }
//            userNameTxtf.setOnKeyTyped(new EventHandler<KeyEvent>() {
//                @Override
//                public void handle(KeyEvent event) {
//                    removeErrorMessage(usernameError);
//                    if (userNameTxtf.getText().length() < 3) {
//                        showErrorMessage(usernameError, "Username must be 4 characters or more.");
//                        return;
//                    }
//                }
//
//            });
//
//            //Validate username while typing
//            passwordTxtf.setOnKeyTyped(new EventHandler<KeyEvent>() {
//                @Override
//                public void handle(KeyEvent event) {
//                    removeErrorMessage(passwordError);
//                    if (passwordTxtf.getText().length() < 4) {
//                        showErrorMessage(passwordError, "Password must be 5 characters or more.");
//                    }
//                }
//            });
//            confirmPasswordTxtf.setOnKeyTyped(new EventHandler<KeyEvent>() {
//                @Override
//                public void handle(KeyEvent event) {
//                    removeErrorMessage(matchError);
//                    if (!RegisterRequest.getPassword().equals(RegisterRequest.getconfirmPassword())) {
//                        showErrorMessage(matchError, "Passwords Don't Match");
//                    }
//                }
//            });
            RegisterRequest registerRequestModel = new RegisterRequest(JsonableConst.VALUE_REGISTER,
                    userNameTxtf.getText(), nameTxtf.getText(), passwordTxtf.getText(), confirmPasswordTxtf.getText());
            //convert request model to Json object
            Gson gson = new Gson();
            JsonObject registerRequestJson = gson.fromJson(gson.toJson(registerRequestModel),
                    JsonObject.class);
            System.out.println(registerRequestJson.toString());
            RequestHandler registerHandler = new RequestHandler(registerRequestJson);
            registerHandler.start();
        });
    }

    public void check(ActionEvent event) {
        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

//    public void showErrorMessage(Label errorLabel, String message) {
//        errorLabel.setText(message);
//        errorLabel.setVisible(true);
//    }
//
//    private void removeErrorMessage(Label errorLabel) {
//        errorLabel.setText("");
//        errorLabel.setVisible(false);
//    }
}
