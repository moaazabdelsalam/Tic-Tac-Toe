/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.ComputerRound;
import client.GameLogic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.GameType;
import models.InGamePlayer;
import models.Move;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class GameScreenController implements Initializable {

    public static String GAME_TYPE = "";
    public static String P1_NAME = "";
    public static String P2_NAME = "";
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
    Navigation navigation;
    Stage stage;
    GameLogic gameLogic;
    ComputerRound AIModel;
    InGamePlayer currentTurn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(GAME_TYPE);
        cellsArray = new Label[][]{
            {cellC0R0, cellC1R0, cellC2R0},
            {cellC0R1, cellC1R1, cellC2R1},
            {cellC0R2, cellC1R2, cellC2R2}};
        //computer game
        if (GAME_TYPE.equals(GameType.COMPUTER)) {
            gameLogic = new GameLogic(cellsArray, "YOU", ComputerRound.NAME);
            AIModel = new ComputerRound(gameLogic.getPlayer2(), gameLogic.getPlayer1());
        }

        //Two players local game
        if (GAME_TYPE.equals(GameType.TWO_PLAYERS)) {
            gameLogic = new GameLogic(cellsArray, P1_NAME, P2_NAME);
        }

        //Two players online game
        if (GAME_TYPE.equals(GameType.ONLINE)) {

        }

        currentTurn = gameLogic.getTurn();

        turnsTxt.setText(currentTurn.getName() + " turn");
        playerOneUserName.setText(gameLogic.getPlayer1().getName());
        playerOneRole.setText(gameLogic.getPlayer1().getSymbole().getValue());
        playerTwoUserName.setText(gameLogic.getPlayer2().getName());
        playerTwoRole.setText(gameLogic.getPlayer2().getSymbole().getValue());
        System.out.println(currentTurn.getName() + " || turn");

        play();
    }

    public void handleActions() {
        exitGameBtn.setOnAction(event -> {
            check(event);
            navigation.goHome();
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int finalI = i;
                final int finalJ = j;
                cellsArray[i][j].setOnMouseClicked(event -> {
                    gameLogic.makeMove(new Move(finalI, finalJ,
                            currentTurn.getSymbole().getValue()));
                    handleGameResult();
                });
            }
        }
    }

    public void handleGameResult() {
        switch (gameLogic.getGameStatus()) {
            case WIN:
                turnsTxt.setText(currentTurn.getName() + " won!!!");
                System.out.println(currentTurn.getName() + " won!!!");
                disableAllLabels();
                break;
            case DRAW:
                turnsTxt.setText("DRAW!!!");
                System.out.println("DRAW!!!");
                disableAllLabels();
                break;
            default:
                currentTurn = gameLogic.getTurn();
                turnsTxt.setText("now " + currentTurn.getName() + " turn");
                AIModel.updateArray(cellsArray);
                play();
                break;
        }
    }

    public void play() {
        if (GAME_TYPE.equals(GameType.COMPUTER)) {
            if (currentTurn.getName().equals(ComputerRound.NAME)) {
                System.out.println("AI playing...");
                AIMove();
                handleGameResult();
            } else {
                System.out.println("other player playing...");
                handleActions();
            }
        }

    }

    public void AIMove() {
        int[] aiMove = AIModel.getBestMove();
        gameLogic.makeMove(new Move(aiMove[0], aiMove[1], currentTurn.getSymbole().getValue()));
    }

    public void check(Event event) {
        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

    public void disableAllLabels() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellsArray[i][j].setMouseTransparent(true);
            }
        }
    }

}
