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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class PlayerProfileScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Label lblPlayerName;
    @FXML
    private Label lblScore;
    @FXML
    private ListView<?> listView;

    Navigation navigation;
    Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setBackground(Background.EMPTY);
        handleActions();
    }    
    public void handleActions(){
        backBtn.setOnAction(event -> {
            if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
            }
            navigation.goBack();
        });
        
        
    }
}
