/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.LoginRequest;
import models.LoginResponse;
import network.JsonableConst;
import network.NetworkUtils;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class LoginRegisterScreenController implements Initializable {

    private static LoginRegisterScreenController loginController;
    @FXML
    private Button backBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField loginUserName;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private Label usernameError;

    @FXML
    private Label passwordError;

    Navigation navigation;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleActions();
        loginController = this;
    }

    public void handleActions() {
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });

        loginBtn.setOnAction(event -> {
            //remove all special characters
            String username = loginUserName.getText().replaceAll("[^a-zA-Z0-9]", "");
            if (validateUsername(username)
                    && validatePassword(loginPassword.getText())) {
                //Start connection and send request
                //first check if connected to server
                boolean isConnected = NetworkUtils.connectToServer();
                System.out.println("isConnected:" + isConnected);
                if (isConnected) {
                    //Create request model with required data
                    LoginRequest loginRequestModel = new LoginRequest(JsonableConst.VALUE_LOGIN,
                            loginUserName.getText(), loginPassword.getText());
                    //convert request model to Json object
                    Gson gson = new Gson();
                    JsonObject loginRequestJson = gson.fromJson(gson.toJson(loginRequestModel),
                            JsonObject.class);
                    System.out.println(loginRequestJson.toString());
                    RequestHandler loginHandler = new RequestHandler(loginRequestJson);

                    loginHandler.start();

                } else {
                    System.out.println("Socket is  not created or not connected");
                }
            }

        });

        registerBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/RegisterScreen.fxml");
        });

        //Validate username while typing
        loginUserName.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                removeErrorMessage(usernameError);
                if (loginUserName.getText().length() < 3) {
                    showErrorMessage(usernameError, "Username must be 4 characters or more.");
                    return;
                }
            }

        });

        //Validate username while typing
        loginPassword.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                removeErrorMessage(passwordError);
                if (loginPassword.getText().length() < 4) {
                    showErrorMessage(passwordError, "Password must be 5 characters or more.");
                }
            }
        });
    }

    public void check(ActionEvent event) {
        //navigation.goTo("OnlineUsers.fxml");

        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

    private boolean validateUsername(String username) {
        String trimmedUsername = username.trim();
        if (trimmedUsername.isEmpty()) {
            //Show error message
            showErrorMessage(usernameError, "username can't be empty.");
            return false;
        }

        if (trimmedUsername.length() <= 3) {
            return false;
        }

        return true;
    }

    private boolean validatePassword(String password) {
        String trimmedPassword = password.trim();
        if (trimmedPassword.isEmpty()) {
            //Show error message
            showErrorMessage(passwordError, "password can't be empty.");
            return false;
        }

        if (trimmedPassword.length() <= 4) {
            return false;
        }

        return true;
    }

    public void showErrorMessage(Label errorLabel, String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    private void removeErrorMessage(Label errorLabel) {
        errorLabel.setText("");
        errorLabel.setVisible(false);
    }

    public static LoginRegisterScreenController getInstance() {
        if(loginController == null){
            
        }
        return loginController;
    }

    public void handleLogin(LoginResponse response) {
        if (response == null) {
            System.out.println("NULL Response");
        } else {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Login Status");
            dialog.setContentText(response.getMessage());
            ButtonType dialogOkBtn = new ButtonType("Ok", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(dialogOkBtn);
            dialog.setResizable(false);
            dialog.showAndWait();
            switch (response.getStatus()) {
                case JsonableConst.VALUE_STATUS_SUCCESS:
                    Client.isLoggedIn = true;
                    
                    //check(loginBtn.get());
                    navigation.goTo("/screens/ClientMainScreen.fxml");
                    break;
                case JsonableConst.VALUE_STATUS_FAILED:
                    Client.isLoggedIn = false;
                    break;
            }
        }
    }

}
