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
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class LoginRegisterScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField loginUserName;
    @FXML
    private TextField loginPassword;

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
        
        loginBtn.setOnAction(event -> {
            
        });
        
        registerBtn.setOnAction(event -> {
            check(event);
            navigation.goTo("/screens/RegisterScreen.fxml");
        });
    }
    public void check(ActionEvent event){
        if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
        }
    }
}
