package screens;

import client.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class PlayerProfileScreenUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Label lblPlayerName;
    protected final Label label;
    protected final Label lblScore;
    protected final ListView listView;
    protected final Button backBtn;
    protected final ImageView imageView;

    public PlayerProfileScreenUI() {

        anchorPane = new AnchorPane();
        lblPlayerName = new Label();
        label = new Label();
        lblScore = new Label();
        listView = new ListView();
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

        anchorPane.setId("AnchorPane");
        anchorPane.setOpacity(0.85);

        lblPlayerName.setLayoutX(59.0);
        lblPlayerName.setLayoutY(22.0);
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

        listView.setLayoutY(69.0);
        listView.setPrefHeight(240.0);
        listView.setPrefWidth(600.0);
        setCenter(anchorPane);

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

        anchorPane.getChildren().add(lblPlayerName);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(lblScore);
        anchorPane.getChildren().add(listView);

    }
}
