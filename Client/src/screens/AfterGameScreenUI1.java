package screens;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class AfterGameScreenUI1 extends AnchorPane {

    protected final Button playAgainBtn;
    protected final Button exitBtn;
    protected final Label labelID;
    protected final MediaView mediaViewer;

    public AfterGameScreenUI1() {

        playAgainBtn = new Button();
        exitBtn = new Button();
        labelID = new Label();
        
        MediaPlayer mediaPlayer;
        File file = new File("F:\\iti\\Developing Applications using Java SE\\Project\\Tic Tac Toe\\Client\\src\\client\\success1.mp4");
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaViewer = new MediaView(mediaPlayer);
        
        HBox hbox = new HBox(mediaViewer);
        hbox.setAlignment(Pos.CENTER);
        labelID.setGraphic(hbox);
        
        mediaViewer.fitWidthProperty().bind(labelID.widthProperty());
        mediaViewer.fitHeightProperty().bind(labelID.heightProperty());
        
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        playAgainBtn.setLayoutX(61.0);
        playAgainBtn.setLayoutY(328.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setPrefHeight(39.0);
        playAgainBtn.setPrefWidth(103.0);
        playAgainBtn.setText("Play Again");

        exitBtn.setLayoutX(440.0);
        exitBtn.setLayoutY(328.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(39.0);
        exitBtn.setPrefWidth(103.0);
        exitBtn.setText("Exit");

        AnchorPane.setLeftAnchor(labelID, 16.0);
        AnchorPane.setRightAnchor(labelID, 16.0);
        AnchorPane.setTopAnchor(labelID, 16.0);
        
        labelID.setLayoutX(11.0);
        labelID.setLayoutY(14.0);
        labelID.setPrefHeight(292.0);
        labelID.setPrefWidth(578.0);

        
        labelID.setGraphic(mediaViewer);

        getChildren().add(playAgainBtn);
        getChildren().add(exitBtn);
        getChildren().add(labelID);

    }
}
