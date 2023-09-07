package screens;

import client.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class RegisterScreenUI extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final TextField userNameTxtf;
    protected final Bloom bloom;
    protected final TextField nameTxtf;
    protected final Bloom bloom0;
    protected final TextField passwordTxtf;
    protected final Bloom bloom1;
    protected final TextField confirmPasswordTxtf;
    protected final Bloom bloom2;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final AnchorPane anchorPane;
    protected final Button registerBtn;
    protected final Button backBtn;
    protected final ImageView imageView;

    public RegisterScreenUI() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        userNameTxtf = new TextField();
        bloom = new Bloom();
        nameTxtf = new TextField();
        bloom0 = new Bloom();
        passwordTxtf = new TextField();
        bloom1 = new Bloom();
        confirmPasswordTxtf = new TextField();
        bloom2 = new Bloom();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        anchorPane = new AnchorPane();
        registerBtn = new Button();
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

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(291.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(169.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(462.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(431.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(userNameTxtf, 1);
        GridPane.setHalignment(userNameTxtf, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(userNameTxtf, javafx.geometry.VPos.CENTER);
        userNameTxtf.setAlignment(javafx.geometry.Pos.CENTER);
        userNameTxtf.setPromptText("Enter A Unique User Name");

        userNameTxtf.setEffect(bloom);
        GridPane.setMargin(userNameTxtf, new Insets(10.0));

        GridPane.setColumnIndex(nameTxtf, 1);
        GridPane.setHalignment(nameTxtf, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(nameTxtf, 1);
        GridPane.setValignment(nameTxtf, javafx.geometry.VPos.CENTER);
        nameTxtf.setAlignment(javafx.geometry.Pos.CENTER);
        nameTxtf.setPromptText("Enter Your Name");

        nameTxtf.setEffect(bloom0);
        GridPane.setMargin(nameTxtf, new Insets(10.0));

        GridPane.setColumnIndex(passwordTxtf, 1);
        GridPane.setHalignment(passwordTxtf, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(passwordTxtf, 2);
        GridPane.setValignment(passwordTxtf, javafx.geometry.VPos.CENTER);
        passwordTxtf.setAlignment(javafx.geometry.Pos.CENTER);
        passwordTxtf.setPromptText("Choose Password");

        passwordTxtf.setEffect(bloom1);
        GridPane.setMargin(passwordTxtf, new Insets(10.0));

        GridPane.setColumnIndex(confirmPasswordTxtf, 1);
        GridPane.setHalignment(confirmPasswordTxtf, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(confirmPasswordTxtf, 3);
        GridPane.setValignment(confirmPasswordTxtf, javafx.geometry.VPos.CENTER);
        confirmPasswordTxtf.setAlignment(javafx.geometry.Pos.CENTER);
        confirmPasswordTxtf.setPromptText("Choose Password");

        confirmPasswordTxtf.setEffect(bloom2);
        GridPane.setMargin(confirmPasswordTxtf, new Insets(10.0));

        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("User Name");

        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label0, 1);
        GridPane.setValignment(label0, javafx.geometry.VPos.CENTER);
        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Name");

        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label1, 2);
        GridPane.setValignment(label1, javafx.geometry.VPos.CENTER);
        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.getStyleClass().add("custom-label");
        label1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label1.setText("Password");

        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label2, 3);
        GridPane.setValignment(label2, javafx.geometry.VPos.CENTER);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.getStyleClass().add("custom-label");
        label2.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label2.setText("Confirm Password");
        BorderPane.setMargin(gridPane, new Insets(10.0));
        gridPane.setPadding(new Insets(10.0));
        setCenter(gridPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        GridPane.setHalignment(registerBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(registerBtn, javafx.geometry.VPos.CENTER);
        registerBtn.setAlignment(javafx.geometry.Pos.CENTER);
        registerBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        registerBtn.setLayoutX(246.0);
        registerBtn.setLayoutY(10.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.getStyleClass().add("custom-button");
        registerBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        registerBtn.setText("Register");
        registerBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(registerBtn, new Insets(5.0));
        registerBtn.setPadding(new Insets(5.0));
        registerBtn.setFont(new Font("Impact", 25.0));
        BorderPane.setMargin(anchorPane, new Insets(5.0));
        anchorPane.setPadding(new Insets(5.0));
        setBottom(anchorPane);

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
        backBtn.getStylesheets().add(Constants.transparentButtonsCSSPath.toUri().toString());
        backBtn.setText("Back");

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setImage(new Image(Constants.backArrowCSSPath.toUri().toString()));
        backBtn.setGraphic(imageView);
        BorderPane.setMargin(backBtn, new Insets(15.0));
        setTop(backBtn);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(userNameTxtf);
        gridPane.getChildren().add(nameTxtf);
        gridPane.getChildren().add(passwordTxtf);
        gridPane.getChildren().add(confirmPasswordTxtf);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        anchorPane.getChildren().add(registerBtn);

    }
}