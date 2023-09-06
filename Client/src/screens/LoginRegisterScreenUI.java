/**
 *
 * @author Eng Abdullah Hegazy
 */
package screens;

import client.Client;
import client.Constants;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import network.RequestHandler;

public class LoginRegisterScreenUI extends AnchorPane {

    public static String loginResponse;

    protected final Label label;
    protected final Label label0;
    protected final Button loginBtn;
    protected final Button registerBtn;
    protected final TextField loginUserName;
    protected final TextField loginPassword;

    public LoginRegisterScreenUI() {
        try {
            Client.socket = new Socket("127.0.0.1", 5005);
            Client.socket.setSoTimeout(0);

        } catch (IOException ex) {
            Logger.getLogger(LoginRegisterScreenUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        label = new Label();
        label0 = new Label();
        loginBtn = new Button();
        registerBtn = new Button();
        loginUserName = new TextField();
        loginPassword = new TextField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        label.setLayoutX(135.0);
        label.setLayoutY(91.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(70.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("Username");

        label0.setLayoutX(135.0);
        label0.setLayoutY(174.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(70.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Password");

        loginBtn.setLayoutX(110.0);
        loginBtn.setLayoutY(296.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(45.0);
        loginBtn.setPrefWidth(120.0);
        loginBtn.getStyleClass().add("custom-button-large");
        loginBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        loginBtn.setText("LOGIN");
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Client.socket.isConnected()) {
                    System.out.println("Socket is created and connected");
                    RequestHandler loginHandler = new RequestHandler(Client.socket, "Login");
                    loginHandler.start();
                } else {
                    System.out.println("Socket is  not created or not connected");
                }

            }
        });
        registerBtn.setLayoutX(379.0);
        registerBtn.setLayoutY(296.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.setPrefHeight(34.0);
        registerBtn.setPrefWidth(136.0);
        registerBtn.getStyleClass().add("custom-button-large");
        registerBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        registerBtn.setText("REGISTER");

        loginUserName.setLayoutX(256.0);
        loginUserName.setLayoutY(92.0);
        loginUserName.setPrefHeight(31.0);
        loginUserName.setPrefWidth(231.0);
        loginUserName.setPromptText("Enter User Name");

        loginPassword.setLayoutX(256.0);
        loginPassword.setLayoutY(175.0);
        loginPassword.setPrefHeight(31.0);
        loginPassword.setPrefWidth(231.0);
        loginPassword.setPromptText("Enter Password");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(loginBtn);
        getChildren().add(registerBtn);
        getChildren().add(loginUserName);
        getChildren().add(loginPassword);

    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public Button getRegisterBtn() {
        return registerBtn;
    }

    public TextField getLoginUserName() {
        return loginUserName;
    }

    public TextField getLoginPassword() {
        return loginPassword;
    }

}
