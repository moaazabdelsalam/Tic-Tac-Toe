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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class GameScreenController implements Initializable {

    @FXML
    private Label cellC0R0;
    @FXML
    private Label cellC0R1;
    @FXML
    private Label cellC0R2;
    @FXML
    private Label cellC1R0;
    @FXML
    private Label cellC1R1;
    @FXML
    private Label cellC1R2;
    @FXML
    private Label cellC2R0;
    @FXML
    private Label cellC2R1;
    @FXML
    private Label cellC2R2;
    @FXML
    private ImageView playerOneIcon;
    @FXML
    private ImageView playerTwoIcon;
    @FXML
    private Button exitGameBtn;
    @FXML
    private RadioButton recordBtn;
    @FXML
    private Text playerOneUserName;
    @FXML
    private Text playerTwoUserName;
    @FXML
    private Label playerOneRole;
    @FXML
    private Label playerTwoRole;
    @FXML
    private GridPane gameGrid;
    
    Navigation navigation;
    Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellC0R0.setBackground(Background.EMPTY);
        gameGrid.setBackground(Background.EMPTY);
        handleActions();
    }    
    public void handleActions(){
        cellC0R0.setOnMouseClicked(event -> {
            cellC0R0.setText("X");
        });
        cellC0R1.setOnMouseClicked(event -> {
            cellC0R1.setText("X");
        });
        cellC0R2.setOnMouseClicked(event -> {
            cellC0R2.setText("X");
        });
        cellC1R0.setOnMouseClicked(event -> {
            cellC1R0.setText("X");
        });
        cellC1R1.setOnMouseClicked(event -> {
            cellC1R1.setText("X");
        });
        cellC1R2.setOnMouseClicked(event -> {
            cellC1R2.setText("X");
        });
        cellC2R0.setOnMouseClicked(event -> {
            cellC2R0.setText("X");
        });
        cellC2R1.setOnMouseClicked(event -> {
            cellC2R1.setText("X");
        });
        cellC2R2.setOnMouseClicked(event -> {
            cellC2R2.setText("X");
        });
        exitGameBtn.setOnAction(event -> {
            check(event);
            navigation.goHome();
        });
    }
    public void check(ActionEvent event){
        if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
        }
    }
}
