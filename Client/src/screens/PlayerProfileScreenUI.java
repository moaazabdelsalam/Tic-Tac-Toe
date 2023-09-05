package screens;

import client.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PlayerProfileScreenUI extends AnchorPane {

    protected final Label lblPlayerName;
    protected final Label label;
    protected final Label lblScore;
    protected final AnchorPane anchorPane;
    protected final Label lblGameCount;
    protected final Label lblGameDate;
    protected final Button playRecordBtn;
    protected final Label label0;
    protected final Label lblOpponentName;
    protected final Label lblGameStatus;
    protected final Label label1;
    protected final Label lblOpponentUserName;
    protected final Label label2;
    protected final AnchorPane anchorPane0;
    protected final Label lblGameCount1;
    protected final Label lblGameDate1;
    protected final Button btnPlayRecord1;
    protected final Label label3;
    protected final Label lblOpponentName1;
    protected final Label lblGameStatus1;
    protected final Label label4;
    protected final Label lblOpponentUserName1;

    public PlayerProfileScreenUI() {

        lblPlayerName = new Label();
        label = new Label();
        lblScore = new Label();
        anchorPane = new AnchorPane();
        lblGameCount = new Label();
        lblGameDate = new Label();
        playRecordBtn = new Button();
        label0 = new Label();
        lblOpponentName = new Label();
        lblGameStatus = new Label();
        label1 = new Label();
        lblOpponentUserName = new Label();
        label2 = new Label();
        anchorPane0 = new AnchorPane();
        lblGameCount1 = new Label();
        lblGameDate1 = new Label();
        btnPlayRecord1 = new Button();
        label3 = new Label();
        lblOpponentName1 = new Label();
        lblGameStatus1 = new Label();
        label4 = new Label();
        lblOpponentUserName1 = new Label();

        setId("AnchorPane");
        setOpacity(0.85);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        lblPlayerName.setLayoutX(27.0);
        lblPlayerName.setLayoutY(21.0);
        lblPlayerName.setPrefHeight(40.0);
        lblPlayerName.setPrefWidth(98.0);
        lblPlayerName.getStyleClass().add("custom-label");
        lblPlayerName.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblPlayerName.setText("Player Name");
        lblPlayerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblPlayerName.setTextFill(javafx.scene.paint.Color.valueOf("#fffbfb"));

        label.setLayoutX(490.0);
        label.setLayoutY(31.0);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label.setText("Score:");

        lblScore.setLayoutX(543.0);
        lblScore.setLayoutY(31.0);
        lblScore.getStyleClass().add("custom-label");
        lblScore.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblScore.setText("50");

        anchorPane.setLayoutX(49.0);
        anchorPane.setLayoutY(137.0);
        anchorPane.setPrefHeight(64.0);
        anchorPane.setPrefWidth(508.0);

        lblGameCount.setLayoutX(14.0);
        lblGameCount.setLayoutY(4.0);
        lblGameCount.getStyleClass().add("custom-label");
        lblGameCount.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameCount.setText("Game #1");

        lblGameDate.setLayoutX(85.0);
        lblGameDate.setLayoutY(4.0);
        lblGameDate.setPrefHeight(21.0);
        lblGameDate.setPrefWidth(81.0);
        lblGameDate.getStyleClass().add("custom-label");
        lblGameDate.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameDate.setText("20-11-2023");

        playRecordBtn.setLayoutX(369.0);
        playRecordBtn.setLayoutY(10.0);
        playRecordBtn.setMnemonicParsing(false);
        playRecordBtn.setPrefHeight(45.0);
        playRecordBtn.setPrefWidth(131.0);
        playRecordBtn.getStyleClass().add("custom-button-mid");
        playRecordBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        playRecordBtn.setText("PLAY RECORD");

        label0.setLayoutX(14.0);
        label0.setLayoutY(22.0);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label0.setText("Opponent Name: ");

        lblOpponentName.setLayoutX(126.0);
        lblOpponentName.setLayoutY(22.0);
        lblOpponentName.setPrefHeight(21.0);
        lblOpponentName.setPrefWidth(45.0);
        lblOpponentName.getStyleClass().add("custom-label");
        lblOpponentName.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblOpponentName.setText("Yasser");

        lblGameStatus.setLayoutX(227.0);
        lblGameStatus.setLayoutY(4.0);
        lblGameStatus.getStyleClass().add("custom-label");
        lblGameStatus.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameStatus.setText("You WON");

        label1.setLayoutX(14.0);
        label1.setLayoutY(40.0);
        label1.getStyleClass().add("custom-label");
        label1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label1.setText("Opponent Username: ");

        lblOpponentUserName.setLayoutX(154.0);
        lblOpponentUserName.setLayoutY(40.0);
        lblOpponentUserName.setPrefHeight(21.0);
        lblOpponentUserName.setPrefWidth(65.0);
        lblOpponentUserName.getStyleClass().add("custom-label");
        lblOpponentUserName.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblOpponentUserName.setText("yas2033");

        label2.setLayoutX(236.0);
        label2.setLayoutY(106.0);
        label2.setPrefHeight(21.0);
        label2.setPrefWidth(98.0);
        label2.getStyleClass().add("custom-label");
        label2.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label2.setText("Game History");

        anchorPane0.setLayoutX(49.0);
        anchorPane0.setLayoutY(208.0);
        anchorPane0.setPrefHeight(64.0);
        anchorPane0.setPrefWidth(508.0);

        lblGameCount1.setLayoutX(14.0);
        lblGameCount1.setLayoutY(4.0);
        lblGameCount1.getStyleClass().add("custom-label");
        lblGameCount1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameCount1.setText("Game #2");

        lblGameDate1.setLayoutX(85.0);
        lblGameDate1.setLayoutY(4.0);
        lblGameDate1.setPrefHeight(21.0);
        lblGameDate1.setPrefWidth(81.0);
        lblGameDate1.getStyleClass().add("custom-label");
        lblGameDate1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameDate1.setText("20-11-2023");

        btnPlayRecord1.setDisable(true);
        btnPlayRecord1.setLayoutX(369.0);
        btnPlayRecord1.setLayoutY(10.0);
        btnPlayRecord1.setMnemonicParsing(false);
        btnPlayRecord1.setPrefHeight(45.0);
        btnPlayRecord1.setPrefWidth(131.0);
        btnPlayRecord1.getStyleClass().add("custom-button-mid");
        btnPlayRecord1.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnPlayRecord1.setText("PLAY RECORD");

        label3.setLayoutX(14.0);
        label3.setLayoutY(22.0);
        label3.getStyleClass().add("custom-label");
        label3.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label3.setText("Opponent Name: ");

        lblOpponentName1.setLayoutX(126.0);
        lblOpponentName1.setLayoutY(22.0);
        lblOpponentName1.setPrefHeight(21.0);
        lblOpponentName1.setPrefWidth(45.0);
        lblOpponentName1.getStyleClass().add("custom-label");
        lblOpponentName1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblOpponentName1.setText("Yasser");

        lblGameStatus1.setLayoutX(227.0);
        lblGameStatus1.setLayoutY(4.0);
        lblGameStatus1.getStyleClass().add("custom-label");
        lblGameStatus1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblGameStatus1.setText("Yasser WON");

        label4.setLayoutX(14.0);
        label4.setLayoutY(40.0);
        label4.getStyleClass().add("custom-label");
        label4.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        label4.setText("Opponent Username: ");

        lblOpponentUserName1.setLayoutX(154.0);
        lblOpponentUserName1.setLayoutY(40.0);
        lblOpponentUserName1.setPrefHeight(21.0);
        lblOpponentUserName1.setPrefWidth(65.0);
        lblOpponentUserName1.getStyleClass().add("custom-label");
        lblOpponentUserName1.getStylesheets().add(Constants.labelsCSSPath.toUri().toString());
        lblOpponentUserName1.setText("yas2033");

        getChildren().add(lblPlayerName);
        getChildren().add(label);
        getChildren().add(lblScore);
        anchorPane.getChildren().add(lblGameCount);
        anchorPane.getChildren().add(lblGameDate);
        anchorPane.getChildren().add(playRecordBtn);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(lblOpponentName);
        anchorPane.getChildren().add(lblGameStatus);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(lblOpponentUserName);
        getChildren().add(anchorPane);
        getChildren().add(label2);
        anchorPane0.getChildren().add(lblGameCount1);
        anchorPane0.getChildren().add(lblGameDate1);
        anchorPane0.getChildren().add(btnPlayRecord1);
        anchorPane0.getChildren().add(label3);
        anchorPane0.getChildren().add(lblOpponentName1);
        anchorPane0.getChildren().add(lblGameStatus1);
        anchorPane0.getChildren().add(label4);
        anchorPane0.getChildren().add(lblOpponentUserName1);
        getChildren().add(anchorPane0);

    }
}
