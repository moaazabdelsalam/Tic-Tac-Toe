package screens;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AfterGameScreenUI extends BorderPane {

    protected final MediaView mediaViewer;
    protected final HBox hBox;
    protected final Button playAgainBtn;
    protected final Button ExitBtn;

    public AfterGameScreenUI() {
        
        MediaPlayer mediaPlayer;
        /*//File file = new File("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client\\src\\resources\\success1.mp4");
        Path absolutePath1 = Paths.get("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client\\src\\resources\\success1.mp4");
        Path absolutePath2 = Paths.get("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client");

        // convert the absolute path to relative path
        Path relativePath = absolutePath2.relativize(absolutePath1);
        System.out.println(relativePath);*/
        File file = new File("src\\resources\\success1.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaViewer = new MediaView(mediaPlayer);
        mediaViewer.setPreserveRatio(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
        hBox = new HBox();
        playAgainBtn = new Button();
        ExitBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(mediaViewer, javafx.geometry.Pos.CENTER);
        
        BorderPane.setMargin(mediaViewer, new Insets(0.0));
        mediaViewer.setFitWidth(500);
        mediaViewer.setFitHeight(300);
        setCenter(mediaViewer);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(0.0);
        hBox.setPrefWidth(0.0);

        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setText("Play Again");

        ExitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        ExitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        ExitBtn.setMnemonicParsing(false);
        ExitBtn.setPrefHeight(25.0);
        ExitBtn.setPrefWidth(66.0);
        ExitBtn.setText("Exit");
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 16.0, 0.0));
        //BorderPane.setMargin(mediaViewer, new Insets(16.0, 16.0, 16.0, 16.0));
        setBottom(hBox);

        hBox.getChildren().add(playAgainBtn);
        hBox.getChildren().add(ExitBtn);

    }
}
