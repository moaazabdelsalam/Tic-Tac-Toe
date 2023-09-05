package screens;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public  class LoginRegisterUI extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final TextField tfUserName;
    protected final TextField tfPassword;
    protected final Button btnLogin;
    protected final Button btnRegister;

    public LoginRegisterUI() {

        label = new Label();
        label0 = new Label();
        tfUserName = new TextField();
        tfPassword = new TextField();
        btnLogin = new Button();
        btnRegister = new Button();

        setId("AnchorPane");
        setPrefHeight(263.0);
        setPrefWidth(401.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add("/screens/../resources/regbg.css");

        label.setLayoutX(55.0);
        label.setLayoutY(52.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(70.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add("/screens/../resources/labels.css");
        label.setText("Username");

        label0.setLayoutX(55.0);
        label0.setLayoutY(90.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(70.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add("/screens/../resources/labels.css");
        label0.setText("Password");

        tfUserName.setLayoutX(135.0);
        tfUserName.setLayoutY(56.0);

        tfPassword.setLayoutX(135.0);
        tfPassword.setLayoutY(94.0);

        btnLogin.setLayoutX(65.0);
        btnLogin.setLayoutY(172.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(45.0);
        btnLogin.setPrefWidth(120.0);
        btnLogin.getStyleClass().add("custom-button-large");
        btnLogin.getStylesheets().add("/screens/../resources/buttons.css");
        btnLogin.setText("LOGIN");

        btnRegister.setLayoutX(228.0);
        btnRegister.setLayoutY(172.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(34.0);
        btnRegister.setPrefWidth(136.0);
        btnRegister.getStyleClass().add("custom-button-large");
        btnRegister.getStylesheets().add("/screens/../resources/buttons.css");
        btnRegister.setText("REGISTER");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(tfUserName);
        getChildren().add(tfPassword);
        getChildren().add(btnLogin);
        getChildren().add(btnRegister);

    }
}
