package screens;

import client.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LocalPlayersNamesUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final TextField player1TextField;
    protected final TextField player2TextField;
    protected final AnchorPane anchorPane0;
    protected final Button btnStart;
    protected final Button btnCancel;
    protected final Button backBtn;
    protected final ImageView imageView;

    public LocalPlayersNamesUI() {

        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        player1TextField = new TextField();
        player2TextField = new TextField();
        anchorPane0 = new AnchorPane();
        btnStart = new Button();
        btnCancel = new Button();
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
        anchorPane.setId("AnchorPane");
        anchorPane.setPrefHeight(118.0);
        anchorPane.setPrefWidth(600.0);

        label.setLayoutX(116.0);
        label.setLayoutY(35.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(110.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("Player #1 Name");

        label0.setLayoutX(114.0);
        label0.setLayoutY(121.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(110.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Player #2 Name");

        player1TextField.setLayoutX(298.0);
        player1TextField.setLayoutY(37.0);
        player1TextField.setPromptText("Enter First Player Name");

        player2TextField.setLayoutX(296.0);
        player2TextField.setLayoutY(122.0);
        player2TextField.setPromptText("Enter Second Player Name");
        setCenter(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(116.0);
        anchorPane0.setPrefWidth(600.0);

        btnStart.setLayoutX(154.0);
        btnStart.setLayoutY(44.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(25.0);
        btnStart.setPrefWidth(110.0);
        btnStart.getStyleClass().add("custom-button-large");
        btnStart.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnStart.setText("START");

        btnCancel.setLayoutX(352.0);
        btnCancel.setLayoutY(44.0);
        btnCancel.setMaxHeight(USE_PREF_SIZE);
        btnCancel.setMaxWidth(USE_PREF_SIZE);
        btnCancel.setMinHeight(USE_PREF_SIZE);
        btnCancel.setMinWidth(USE_PREF_SIZE);
        btnCancel.setMnemonicParsing(false);
        btnCancel.setPrefHeight(53.0);
        btnCancel.setPrefWidth(116.0);
        btnCancel.getStyleClass().add("custom-button-large");
        btnCancel.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnCancel.setText("Cancel");
        setBottom(anchorPane0);
        setPadding(new Insets(5.0));

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
        imageView.setImage(new Image(Constants.ProfileImagePath.toUri().toString()));
        backBtn.setGraphic(imageView);
        BorderPane.setMargin(backBtn, new Insets(15.0));
        setTop(backBtn);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(player1TextField);
        anchorPane.getChildren().add(player2TextField);
        anchorPane0.getChildren().add(btnStart);
        anchorPane0.getChildren().add(btnCancel);

    }


    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

    public TextField getPlayer1TextField() {
        return player1TextField;
    }

    public TextField getPlayer2TextField() {
        return player2TextField;
    }
}    

