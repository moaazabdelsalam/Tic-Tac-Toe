package screens;



import client.Client;
import client.Constants;
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
import network.RequestHandler;

public class LoginRegisterScreenUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button loginBtn;
    protected final Button registerBtn;
    protected final AnchorPane anchorPane0;
    protected final Label label;
    protected final Label label0;
    protected final TextField loginUserName;
    protected final TextField loginPassword;
    protected final Button backBtn;
    protected final ImageView imageView;

    public LoginRegisterScreenUI() {

        try {
            Client.socket = new Socket("127.0.0.1", 5005);
            Client.socket.setSoTimeout(0);

        } catch (IOException ex) {
            Logger.getLogger(LoginRegisterScreenUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        anchorPane = new AnchorPane();
        loginBtn = new Button();
        registerBtn = new Button();
        anchorPane0 = new AnchorPane();
        label = new Label();
        label0 = new Label();
        loginUserName = new TextField();
        loginPassword = new TextField();
        backBtn = new Button();
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

        loginBtn.setLayoutX(142.0);
        loginBtn.setMnemonicParsing(false);
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

        registerBtn.setLayoutX(327.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.getStyleClass().add("custom-button-large");
        registerBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        registerBtn.setText("REGISTER");
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

        loginUserName.setLayoutX(256.0);
        loginUserName.setLayoutY(47.0);
        loginUserName.setPrefHeight(31.0);
        loginUserName.setPrefWidth(231.0);
        loginUserName.setPromptText("Enter User Name");

        loginPassword.setLayoutX(256.0);
        loginPassword.setLayoutY(130.0);
        loginPassword.setPrefHeight(31.0);
        loginPassword.setPrefWidth(231.0);
        loginPassword.setPromptText("Enter Password");
        setCenter(anchorPane0);

        BorderPane.setAlignment(backBtn, javafx.geometry.Pos.CENTER_LEFT);
        backBtn.setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
        backBtn.setMaxHeight(USE_PREF_SIZE);
        backBtn.setMaxWidth(USE_PREF_SIZE);
        backBtn.setMinHeight(USE_PREF_SIZE);
        backBtn.setMinWidth(USE_PREF_SIZE);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(50.0);
        backBtn.getStyleClass().add("transparent-button");
        backBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        backBtn.setText("Back");

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setImage(new Image(Constants.backArrowCSSPath.toUri().toString()));
        backBtn.setGraphic(imageView);
        BorderPane.setMargin(backBtn, new Insets(15.0));
        setTop(backBtn);

        anchorPane.getChildren().add(loginBtn);
        anchorPane.getChildren().add(registerBtn);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(loginUserName);
        anchorPane0.getChildren().add(loginPassword);

    }
}