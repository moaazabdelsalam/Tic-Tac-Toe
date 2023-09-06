package screens;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginScreenUI extends AnchorPane {

    protected final Text text;
    protected final TextField userNameTextField;
    protected final Text text0;
    protected final TextField passwordTextField;
    public final Button loginBtn;
    public final Button registerBtn;

    public LoginScreenUI() {

        text = new Text();
        userNameTextField = new TextField();
        text0 = new Text();
        passwordTextField = new TextField();
        loginBtn = new Button();
        registerBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        text.setLayoutX(93.0);
        text.setLayoutY(124.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("user Name");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(81.310546875);
        text.setFont(new Font(16.0));

        userNameTextField.setLayoutX(236.0);
        userNameTextField.setLayoutY(105.0);
        userNameTextField.setPrefHeight(25.0);
        userNameTextField.setPrefWidth(281.0);
        userNameTextField.setPromptText("enter you user name");

        text0.setLayoutX(93.0);
        text0.setLayoutY(204.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("password");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(81.310546875);
        text0.setFont(new Font(16.0));

        passwordTextField.setLayoutX(236.0);
        passwordTextField.setLayoutY(185.0);
        passwordTextField.setPrefHeight(25.0);
        passwordTextField.setPrefWidth(281.0);
        passwordTextField.setPromptText("enter your password");

        loginBtn.setLayoutX(436.0);
        loginBtn.setLayoutY(295.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(43.0);
        loginBtn.setPrefWidth(81.0);
        loginBtn.setText("Login");
        loginBtn.setFont(new Font(16.0));

        registerBtn.setLayoutX(107.0);
        registerBtn.setLayoutY(295.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.setPrefHeight(43.0);
        registerBtn.setPrefWidth(81.0);
        registerBtn.setText("Register");
        registerBtn.setFont(new Font(16.0));

        getChildren().add(text);
        getChildren().add(userNameTextField);
        getChildren().add(text0);
        getChildren().add(passwordTextField);
        getChildren().add(loginBtn);
        getChildren().add(registerBtn);

    }
}
