package screens;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LocalPlayersNamesUI extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final TextField tfPlayerOneName;
    protected final TextField tfPlayerTwoName;
    protected final Button btnStart;
    protected final Button btnCancel;

    public LocalPlayersNamesUI() {

        label = new Label();
        label0 = new Label();
        tfPlayerOneName = new TextField();
        tfPlayerTwoName = new TextField();
        btnStart = new Button();
        btnCancel = new Button();

        setId("AnchorPane");
        setPrefHeight(263.0);
        setPrefWidth(401.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add("/screens/../resources/regbg.css");

        label.setLayoutX(55.0);
        label.setLayoutY(53.0);
        label.setPrefHeight(34.0);
        label.setPrefWidth(110.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add("/screens/../resources/labels.css");
        label.setText("Player #1 Name");

        label0.setLayoutX(55.0);
        label0.setLayoutY(90.0);
        label0.setPrefHeight(34.0);
        label0.setPrefWidth(110.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add("/screens/../resources/labels.css");
        label0.setText("Player #2 Name");

        tfPlayerOneName.setLayoutX(173.0);
        tfPlayerOneName.setLayoutY(57.0);

        tfPlayerTwoName.setLayoutX(173.0);
        tfPlayerTwoName.setLayoutY(95.0);

        btnStart.setLayoutX(55.0);
        btnStart.setLayoutY(169.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(25.0);
        btnStart.setPrefWidth(110.0);
        btnStart.getStyleClass().add("custom-button-large");
        btnStart.getStylesheets().add("/screens/../resources/buttons.css");
        btnStart.setText("START");

        btnCancel.setLayoutX(242.0);
        btnCancel.setLayoutY(169.0);
        btnCancel.setMnemonicParsing(false);
        btnCancel.setPrefHeight(53.0);
        btnCancel.setPrefWidth(116.0);
        btnCancel.getStyleClass().add("custom-button-large");
        btnCancel.getStylesheets().add("/screens/../resources/buttons.css");
        btnCancel.setText("Cancel");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(tfPlayerOneName);
        getChildren().add(tfPlayerTwoName);
        getChildren().add(btnStart);
        getChildren().add(btnCancel);

    }
}
