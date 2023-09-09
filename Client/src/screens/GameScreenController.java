/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.GameLogic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import models.InGamePlayer;

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
    @FXML
    private Text turnsTxt;
    
    Label[][] cellsArray;
    //String turn = "X";
    Navigation navigation;
    Stage stage;
    GameLogic gameLogic;
    InGamePlayer currentTurn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellsArray = new Label[][]{
        {cellC0R0,cellC1R0,cellC2R0},
        {cellC0R1,cellC1R1,cellC2R1},
        {cellC0R2,cellC1R2,cellC2R2}};
        gameLogic = new GameLogic(cellsArray,"moaaz", "ahmed");
        currentTurn = gameLogic.getTurn();
        turnsTxt.setText(currentTurn.getName() + " turn");
        playerOneUserName.setText(gameLogic.getPlayer1().getName());
        playerOneRole.setText(gameLogic.getPlayer1().getSymbole().getValue());
        playerTwoUserName.setText(gameLogic.getPlayer2().getName());
        playerTwoRole.setText(gameLogic.getPlayer2().getSymbole().getValue());
        System.out.println(currentTurn.getName());
        
        //cellC0R0.setBackground(Background.EMPTY);
        //gameGrid.setBackground(Background.EMPTY);
        handleActions();
    }    
    public void handleActions(){
//        cellC0R0.setOnMouseClicked(event -> {
//            cellC0R0.setText("X");
//        });
//        cellC0R1.setOnMouseClicked(event -> {
//            cellC0R1.setText("X");
//        });
//        cellC0R2.setOnMouseClicked(event -> {
//            cellC0R2.setText("X");
//        });
//        cellC1R0.setOnMouseClicked(event -> {
//            cellC1R0.setText("X");
//        });
//        cellC1R1.setOnMouseClicked(event -> {
//            cellC1R1.setText("X");
//        });
//        cellC1R2.setOnMouseClicked(event -> {
//            cellC1R2.setText("X");
//        });
//        cellC2R0.setOnMouseClicked(event -> {
//            cellC2R0.setText("X");
//        });
//        cellC2R1.setOnMouseClicked(event -> {
//            cellC2R1.setText("X");
//        });
//        cellC2R2.setOnMouseClicked(event -> {
//            cellC2R2.setText("X");
//        });
        exitGameBtn.setOnAction(event -> {
            check(event);
           navigation.goHome();
        });
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                final int finalI = i;
                final int finalJ = j;
                cellsArray[i][j].setOnMouseClicked(event -> {
                    gameLogic.updateBoard(cellsArray[finalI][finalJ], currentTurn);
                    //cellsArray[finalI][finalJ].setMouseTransparent(true);
                    //cellsArray[finalI][finalJ].setText(currentTurn.getSymbole().getValue());
                    if(gameLogic.isWin(finalI,finalJ,currentTurn)){
                        turnsTxt.setText(currentTurn.getName() + " won!");
                        System.out.println(currentTurn.getName() + " won!!");
                        disableAllLabels();
                        check(event);
                        navigation.goTo("/screens/AfterGameScreen.fxml");
                    } else if(gameLogic.getMoves() == 9){
                        turnsTxt.setText("DRAW!!!");
                    } else {
                        currentTurn = gameLogic.getTurn();
                        turnsTxt.setText(currentTurn.getName() + " turn");
                    }
                });
            }
        }
    }
    public void check(Event event){
        if(navigation == null && stage == null){
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                navigation = new Navigation(stage);
        }
    }
    
    public void disableAllLabels(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cellsArray[i][j].setMouseTransparent(true);
            }
        }
    }
}
