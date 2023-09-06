package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaView;

public class AfterGameScreenUI extends BorderPane {

    protected final MediaView mediaViewer;
    protected final AnchorPane anchorPane;
    protected final Button ExitBtn;
    protected final Button playAgainBtn;

    public AfterGameScreenUI() {

        mediaViewer = new MediaView();
        anchorPane = new AnchorPane();
        ExitBtn = new Button();
        playAgainBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add("/screens/../resources/regbg.css");

        BorderPane.setAlignment(mediaViewer, javafx.geometry.Pos.CENTER);
        mediaViewer.setFitHeight(200.0);
        mediaViewer.setFitWidth(200.0);
        BorderPane.setMargin(mediaViewer, new Insets(0.0));
        setCenter(mediaViewer);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(anchorPane, new Insets(0.0, 0.0, 16.0, 0.0));

        ExitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        ExitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        ExitBtn.setLayoutX(356.0);
        ExitBtn.setMnemonicParsing(false);
        ExitBtn.setPrefHeight(25.0);
        ExitBtn.setPrefWidth(66.0);
        ExitBtn.getStyleClass().add("custom-button");
        ExitBtn.getStylesheets().add("/screens/../resources/buttons.css");
        ExitBtn.setText("Exit");

        playAgainBtn.setLayoutX(159.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.getStyleClass().add("custom-button");
        playAgainBtn.getStylesheets().add("/screens/../resources/buttons.css");
        playAgainBtn.setText("Play Again");
        setBottom(anchorPane);

        anchorPane.getChildren().add(ExitBtn);
        anchorPane.getChildren().add(playAgainBtn);

    }
}
