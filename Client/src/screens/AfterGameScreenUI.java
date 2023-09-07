package screens;


import client.Constants;
import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AfterGameScreenUI extends BorderPane {

    protected final MediaView mediaViewer;
    protected final AnchorPane anchorPane;
    protected final Button ExitBtn;
    protected final Button playAgainBtn;

    public AfterGameScreenUI() {

        MediaPlayer mediaPlayer;
        /*//File file = new File("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client\\src\\resources\\success1.mp4");
        Path absolutePath1 = Paths.get("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client\\src\\resources\\success1.mp4");
        Path absolutePath2 = Paths.get("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client");

        // convert the absolute path to relative path
        Path relativePath = absolutePath2.relativize(absolutePath1);
        System.out.println(relativePath);*/
        File file = new File(Constants.successVideoPath.toUri());
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaViewer = new MediaView(mediaPlayer);
        mediaViewer.setPreserveRatio(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
        playAgainBtn = new Button();

        anchorPane = new AnchorPane();

        ExitBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");

        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());


        BorderPane.setAlignment(mediaViewer, javafx.geometry.Pos.CENTER);
        mediaViewer.setFitHeight(200.0);
        mediaViewer.setFitWidth(200.0);
        BorderPane.setMargin(mediaViewer, new Insets(0.0));
        setCenter(mediaViewer);


        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.getStyleClass().add("custom-button");
        playAgainBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        playAgainBtn.setText("Play Again");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(anchorPane, new Insets(0.0, 0.0, 16.0, 0.0));


        ExitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        ExitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        ExitBtn.setLayoutX(356.0);
        ExitBtn.setMnemonicParsing(false);
        ExitBtn.setPrefHeight(25.0);
        ExitBtn.setPrefWidth(66.0);
        ExitBtn.getStyleClass().add("custom-button");
        ExitBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        ExitBtn.setText("Exit");

        playAgainBtn.setLayoutX(159.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.getStyleClass().add("custom-button");
        playAgainBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        playAgainBtn.setText("Play Again");
        setBottom(anchorPane);

        anchorPane.getChildren().add(ExitBtn);
        anchorPane.getChildren().add(playAgainBtn);

    }

    public MediaView getMediaViewer() {
        return mediaViewer;
    }

    public Button getPlayAgainBtn() {
        return playAgainBtn;
    }

    public Button getExitBtn() {
        return ExitBtn;
    }
    
}
