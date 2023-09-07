package screens;

import client.Client;
import client.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import models.LoginRequest;
import network.JsonableConst;
import network.NetworkUtils;
import network.RequestHandler;

public class LoginRegisterScreenUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button btnLogin;
    protected final Button btnRegister;
    protected final AnchorPane anchorPane0;
    protected final Label label;
    protected final Label label0;
    protected final TextField tfUsername;
    protected final TextField tfPassword;
    protected final Button btnBack;
    protected final ImageView imageView;

    public LoginRegisterScreenUI() {

        anchorPane = new AnchorPane();
        btnLogin = new Button();
        btnRegister = new Button();
        anchorPane0 = new AnchorPane();
        label = new Label();
        label0 = new Label();
        tfUsername = new TextField();
        tfPassword = new TextField();
        btnBack = new Button();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        btnLogin.setLayoutX(142.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.getStyleClass().add("custom-button-large");
        btnLogin.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnLogin.setText("LOGIN");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //first check if connected to server
                if (NetworkUtils.connectToServer()) {

                    //Create request model with required data
                    LoginRequest loginRequestModel = new LoginRequest(JsonableConst.VALUE_LOGIN,
                            tfUsername.getText(), tfPassword.getText());
                    //convert request model to Json object
                    Gson gson = new Gson();
                    JsonObject loginRequestJson = gson.fromJson(gson.toJson(loginRequestModel), JsonObject.class);
                    RequestHandler loginHandler = new RequestHandler(loginRequestJson);
                    loginHandler.start();
                } else {
                    System.out.println("Socket is  not created or not connected");
                }

            }
        });

        btnRegister.setLayoutX(327.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.getStyleClass().add("custom-button-large");
        btnRegister.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnRegister.setText("REGISTER");
        BorderPane.setMargin(anchorPane, new Insets(10.0));
        anchorPane.setPadding(new Insets(5.0));
        setBottom(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setId("AnchorPane");

        label.setLayoutX(135.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(70.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("Username");

        label0.setLayoutX(135.0);
        label0.setLayoutY(129.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(70.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Password");

        tfUsername.setLayoutX(256.0);
        tfUsername.setLayoutY(47.0);
        tfUsername.setPrefHeight(31.0);
        tfUsername.setPrefWidth(231.0);
        tfUsername.setPromptText("Enter User Name");

        tfPassword.setLayoutX(256.0);
        tfPassword.setLayoutY(130.0);
        tfPassword.setPrefHeight(31.0);
        tfPassword.setPrefWidth(231.0);
        tfPassword.setPromptText("Enter Password");
        setCenter(anchorPane0);

        BorderPane.setAlignment(btnBack, javafx.geometry.Pos.CENTER_LEFT);
        btnBack.setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
        btnBack.setMaxHeight(USE_PREF_SIZE);
        btnBack.setMaxWidth(USE_PREF_SIZE);
        btnBack.setMinHeight(USE_PREF_SIZE);
        btnBack.setMinWidth(USE_PREF_SIZE);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(50.0);
        btnBack.setPrefWidth(50.0);
        btnBack.getStyleClass().add("transparent-button");
        btnBack.getStylesheets().add(Constants.transparentButtonsCSSPath.toUri().toString());
        btnBack.setText("Back");

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setImage(new Image(Constants.backArrowCSSPath.toUri().toString()));
        btnBack.setGraphic(imageView);
        BorderPane.setMargin(btnBack, new Insets(15.0));
        setTop(btnBack);

        anchorPane.getChildren().add(btnLogin);
        anchorPane.getChildren().add(btnRegister);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(tfUsername);
        anchorPane0.getChildren().add(tfPassword);

    }

    public Button getBtnLogin() {
        return btnLogin;
    }

}
