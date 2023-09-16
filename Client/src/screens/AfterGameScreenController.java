/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Constants;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class AfterGameScreenController implements Initializable {

    @FXML
    private Button ExitBtn;
    @FXML
    private Button playAgainBtn;
    @FXML
    private MediaView mediaViewer;
    @FXML
    private Label gameResultTxt;
    
    public static String gameStatus;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file;
        
        if (gameStatus.equals("WIN")){
            file = new File(Constants.winVideoPath.toUri());
        } else if (gameStatus.equals("LOSE")){
            file = new File(Constants.loseVideoPath.toUri());
        } else {
            file = new File(Constants.drawVideoPath.toUri());
        }
        
        System.out.println(file.exists());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaViewer.setMediaPlayer(mediaPlayer);
        mediaViewer.setPreserveRatio(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
        gameResultTxt.setText(gameStatus);
        handleActions();
    }

    public void handleActions() {
        ExitBtn.setOnAction(event -> {
            if (stage == null) {
                stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            }
            stage.close();
        });
    }
}
