package screens;

import client.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LocalPlayersNamesUI extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Button btnStart;
    protected final Button btnCancel;
    protected final TextField player1TextField;
    protected final TextField player2TextField;

    public LocalPlayersNamesUI() {

        label = new Label();
        label0 = new Label();
        btnStart = new Button();
        btnCancel = new Button();
        player1TextField = new TextField();
        player2TextField = new TextField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        label.setLayoutX(118.0);
        label.setLayoutY(118.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(110.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("Player #1 Name");

        label0.setLayoutX(118.0);
        label0.setLayoutY(167.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(110.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Player #2 Name");

        btnStart.setLayoutX(118.0);
        btnStart.setLayoutY(298.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(25.0);
        btnStart.setPrefWidth(110.0);
        btnStart.getStyleClass().add("custom-button-large");
        btnStart.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnStart.setText("START");

        btnCancel.setLayoutX(393.0);
        btnCancel.setLayoutY(298.0);
        btnCancel.setMnemonicParsing(false);
        btnCancel.setPrefHeight(53.0);
        btnCancel.setPrefWidth(116.0);
        btnCancel.getStyleClass().add("custom-button-large");
        btnCancel.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnCancel.setText("Cancel");

        player1TextField.setLayoutX(300.0);
        player1TextField.setLayoutY(120.0);
        player1TextField.setPromptText("Enter First Player Name");

        player2TextField.setLayoutX(300.0);
        player2TextField.setLayoutY(168.0);
        player2TextField.setPromptText("Enter Second Player Name");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(btnStart);
        getChildren().add(btnCancel);
        getChildren().add(player1TextField);
        getChildren().add(player2TextField);

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
