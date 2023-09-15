/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import client.ComputerRound;
import client.GameLogic;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import models.OnlineGameMove;
import network.JsonableConst;
import network.RequestHandler;

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
    RequestHandler onlineGameHandler;
    Move move;
    public static int difficultyLevel = 1;
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
            AIModel = new ComputerRound(gameLogic.getPlayer2(), gameLogic.getPlayer1(),difficultyLevel);
        }

        //Two players local game
        if (GAME_TYPE.equals(GameType.TWO_PLAYERS)) {
            gameLogic = new GameLogic(cellsArray, P1_NAME, P2_NAME);
        }

        //Two players online game
        if (GAME_TYPE.equals(GameType.ONLINE)) {
            onlineGameHandler = new RequestHandler();
            if (P1_NAME.equals(Client.getInstance().getUserName())) {
                gameLogic = new GameLogic(cellsArray, P1_NAME, P2_NAME);
                //send to p2 symbole
                //onlineGameHandler.sendMessage();
            } else {
                gameLogic = new GameLogic(cellsArray);
                //got symbole of p1
            }
        }

        currentTurn = gameLogic.getTurn();

        turnsTxt.setText(currentTurn.getName() + " turn");
        playerOneUserName.setText(gameLogic.getPlayer1().getName());
        playerOneRole.setText(gameLogic.getPlayer1().getSymbole().getValue());
        playerTwoUserName.setText(gameLogic.getPlayer2().getName());
        playerTwoRole.setText(gameLogic.getPlayer2().getSymbole().getValue());
        System.out.println(currentTurn.getName() + " || turn");

        exitGameBtn.setOnAction(event -> {
            check(event);
            navigation.goHome();
        });

        play();
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
        } else if (GAME_TYPE.equals(GameType.TWO_PLAYERS)) {
            handleActions();
        } else if (GAME_TYPE.equals(GameType.ONLINE)) {
            if (currentTurn.getName().equals(Client.getInstance().getUserName())) { //my turn
                setDisableAllLabels(false);
                handleActions();
                sendMoveToOpponent(move);
            } else { //opponent turn
                setDisableAllLabels(true);
            }
        }
    }

    public void handleActions() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int finalI = i;
                final int finalJ = j;
                cellsArray[i][j].setOnMouseClicked(event -> {
                    gameLogic.makeMove(new Move(finalI, finalJ,
                            currentTurn.getSymbole().getValue()));
                    move = new Move(finalI, finalJ, currentTurn.getSymbole().getValue());
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
                setDisableAllLabels(true);
                break;
            case DRAW:
                turnsTxt.setText("DRAW!!!");
                System.out.println("DRAW!!!");
                setDisableAllLabels(true);
                break;
            default:
                currentTurn = gameLogic.getTurn();
                turnsTxt.setText("now " + currentTurn.getName() + " turn");
                if (GAME_TYPE.equals(GameType.COMPUTER)) {
                    AIModel.updateArray(cellsArray);
                }
                play();
                break;
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

    public void setDisableAllLabels(boolean disable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellsArray[i][j].setMouseTransparent(disable);
            }
        }
    }

    private void sendMoveToOpponent(Move move) {
        String reciverName = currentTurn.getName().equals(P1_NAME) ? P2_NAME : P1_NAME;
        OnlineGameMove moveToSend = new OnlineGameMove(JsonableConst.VALUE_ONLINE_GAME_MOVES,
                move,
                reciverName);
        System.out.println("Sending move in row: " + moveToSend.getMove().getRow()
                + ", column: " + moveToSend.getMove().getColumn()
                + ", with symbole: " + moveToSend.getMove().getSymbole()
                + ", to player: " + moveToSend.getReciverUserName());
        Gson gson = new Gson();
        JsonObject moveToSendJson = gson.fromJson(gson.toJson(moveToSend), JsonObject.class);
        onlineGameHandler.sendMessage(moveToSendJson);
    }

}
