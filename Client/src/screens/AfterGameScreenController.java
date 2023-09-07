/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
