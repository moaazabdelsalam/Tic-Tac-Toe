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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import models.BoardStatus;
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
    ComputerRound AIModel;
    InGamePlayer currentTurn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cellsArray = new Label[][]{
            {cellC0R0, cellC1R0, cellC2R0},
            {cellC0R1, cellC1R1, cellC2R1},
            {cellC0R2, cellC1R2, cellC2R2}};
        gameLogic = new GameLogic(cellsArray, "Moaaz", "Ahmed");
        AIModel = new ComputerRound(gameLogic.getPlayer2(), gameLogic.getPlayer1());
        currentTurn = gameLogic.getTurn();

        turnsTxt.setText(currentTurn.getName() + " turn");
        playerOneUserName.setText(gameLogic.getPlayer1().getName());
        playerOneRole.setText(gameLogic.getPlayer1().getSymbole().getValue());
        playerTwoUserName.setText(gameLogic.getPlayer2().getName());
        playerTwoRole.setText(gameLogic.getPlayer2().getSymbole().getValue());
        System.out.println(currentTurn.getName() + " || turn");

        //playVsComputer();
        //cellC0R0.setBackground(Background.EMPTY);
        //gameGrid.setBackground(Background.EMPTY);
        //handleActions();
        play();
    }

    public void handleActions() {
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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int finalI = i;
                final int finalJ = j;
                cellsArray[i][j].setOnMouseClicked(event -> {
                    gameLogic.makeMove(finalI, finalJ);
                    handleGameResult();
//                    gameLogic.updateBoard(cellsArray[finalI][finalJ], currentTurn);
//                    int[] computerMove = computerRound.getBestMove();
//                    gameLogic.updateBoard(cellsArray[computerMove[0]][1], currentTurn);
//                    if (gameLogic.isWin(finalI, finalJ, currentTurn)) {
//                        turnsTxt.setText(currentTurn.getName() + " won!");
//                        System.out.println(currentTurn.getName() + " won!!");
//                        disableAllLabels();
//                        check(event);
//                        navigation.goTo("/screens/AfterGameScreen.fxml");
//                    } else if (gameLogic.getMoves() == 9) {
//                        turnsTxt.setText("DRAW!!!");
//                    } else {
//                        currentTurn = gameLogic.getTurn();
//                        turnsTxt.setText(currentTurn.getName() + " turn");
//                    }
                });
            }
        }
    }

    public void setupCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int finalI = i;
                final int finalJ = j;
                cellsArray[i][j].setOnMouseClicked(event -> {
                    System.out.println("other player playing again ...");
                    gameLogic.makeMove(finalI, finalJ);
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
        if (currentTurn.getName().equals("AI")) {
            System.out.println("AI playing...");
            AIMove();
            handleGameResult();
        } else {
            System.out.println("other player playing...");
            handleActions();
        }
    }

    public void AIMove() {
        int[] aiMove = AIModel.getBestMove();
        gameLogic.makeMove(aiMove[0], aiMove[1]);
//        AIModel.updateArray(cellsArray);
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

//    public void playVsComputer() {
//        //int[] move = new int[2];
//        Thread AIThread;
//        AtomicInteger row = new AtomicInteger(0);
//        AtomicInteger column = new AtomicInteger(0);
//        while (gameLogic.getMoves() <= 9) {
//            if (currentTurn.getName().equals(playerOneUserName.getText())) {
//                AIThread = new Thread(() -> {
//                    int[] computerMove = computerRound.getBestMove();
//                    row.set(computerMove[0]);
//                    column.set(computerMove[1]);
//                    Platform.runLater(() -> gameLogic.updateBoard(cellsArray[row.get()][column.get()], currentTurn));
//                });
//                AIThread.start();
////                int[] computerMove = computerRound.getBestMove();
////                row.set(computerMove[0]);
////                column.set(computerMove[1]);
////                gameLogic.updateBoard(cellsArray[row.get()][column.get()], currentTurn);
////                
//                System.out.println("computer move: " + row.get() + ", " + column.get());
//                System.out.println("current turn: " + currentTurn.getName());
//            } else {
//                
//                System.out.println("current turn: " + currentTurn.getName());
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        final int finalI = i;
//                        final int finalJ = j;
//                        cellsArray[i][j].setOnMouseClicked(event -> {
//                            gameLogic.updateBoard(cellsArray[finalI][finalJ], currentTurn);
//                        });
//                        row.set(i);
//                        column.set(j);
//                    }
//                }
//            }
//            if (gameLogic.isWin(row.get(), column.get(), currentTurn)) {
//                turnsTxt.setText(currentTurn.getName() + " won!");
//                System.out.println(currentTurn.getName() + " won!!");
//                disableAllLabels();
//                break;
//                //check(event);
//                //navigation.goTo("/screens/AfterGameScreen.fxml");
//            } else if (gameLogic.getMoves() == 9) {
//                turnsTxt.setText("DRAW!!!");
//            } else {
//                computerRound.updateArray(cellsArray);
//                currentTurn = gameLogic.getTurn();
//                System.out.println(currentTurn.getName() + " turn");
//                turnsTxt.setText(currentTurn.getName() + " turn");
//            }
//        }
//    }
}
