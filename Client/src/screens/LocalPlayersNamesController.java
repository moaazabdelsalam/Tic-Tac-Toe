/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class LocalPlayersNamesController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField player1TextField;
    @FXML
    private TextField player2TextField;

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
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });
        
        
    }
    public void check(ActionEvent event){
        if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
        }
    }
}
