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
    
    Navigation navigation;
    Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file = new File(Constants.successVideoPath.toUri());
        System.out.println(file.exists());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaViewer.setMediaPlayer(mediaPlayer);
        mediaViewer.setPreserveRatio(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        handleActions();
    }    
    public void handleActions(){
        ExitBtn.setOnAction(event -> {
            if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
            }
            navigation.goHome();
        });
    }
}
