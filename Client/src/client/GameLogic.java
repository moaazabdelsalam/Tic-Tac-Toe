/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javafx.scene.control.Label;
import models.BoardModel;
import models.BoardStatus;
import models.InGamePlayer;
import models.Move;
import models.Symboles;

/**
 *
 * @author moaaz
 */
public class GameLogic {

    Label[][] cellsArray;
    Queue<InGamePlayer> playersTurn = new LinkedList();
    InGamePlayer player1;
    InGamePlayer player2;
    BoardModel board;
    InGamePlayer currentPlayer;
    int size = 3;
    ArrayList<Move> movesRecord;
    private static boolean orig = false;

    public static void setOrig(boolean orig) {
        GameLogic.orig = orig;
    }

    public GameLogic(Label[][] cellsArray) {
        this.movesRecord = new ArrayList();
        this.cellsArray = cellsArray;
    }
    
    public GameLogic(Label[][] cellsArray, String playerOneName, String playerTwoName) {
        this.movesRecord = new ArrayList();
        this.cellsArray = cellsArray;

        setPlayer1(playerOneName);
        setPlayer2(playerTwoName);

        if (player1.getSymbole() == Symboles.X) {
            playersTurn.add(player1);
            playersTurn.add(player2);
        } else {
            playersTurn.add(player2);
            playersTurn.add(player1);
        }
        board = new BoardModel(player1, player2, cellsArray);
    }

    private void setPlayer1(String playerOneName) {
        Random random = new Random();
        int randNumber = random.nextInt(2);
        System.out.println(randNumber);
        player1 = new InGamePlayer(playerOneName,
                randNumber == Symboles.X.getId() ? Symboles.X : Symboles.O);
        System.out.println("player1: " + player1.getName() + ", " + player1.getSymbole());
    }

    private void setPlayer2(String playerTwoName) {
        player2 = new InGamePlayer(playerTwoName,
                player1.getSymbole() == Symboles.O ? Symboles.X : Symboles.O);
        System.out.println("player2: " + player2.getName() + ", " + player2.getSymbole());

    }

    public InGamePlayer getTurn() {
        currentPlayer = playersTurn.poll();
        return currentPlayer;
    }

    public void makeMove(Move move) {
        board.updateBoard(move);
        board.updateMoves();
        movesRecord.add(move);
        analyzeBoard(move.getRow(), move.getColumn());
        playersTurn.add(currentPlayer);
    }

    public void analyzeBoard(int row, int column) {
        int rowMatch = 0;
        int columnMatch = 0;
        int diagonalMatch = 0;
        int reverseDiagonalMatch = 0;
        //check rows
        for (int i = 0; i < size; i++) {
            if (cellsArray[row][i].getText().equals(currentPlayer.getSymbole().getValue())) {
                rowMatch++;
            }
        }
        //check columns
        for (int i = 0; i < size; i++) {
            if (cellsArray[i][column].getText().equals(currentPlayer.getSymbole().getValue())) {
                columnMatch++;
            }
        }
        //check diagonal && reverse diagonal
        if (row == column || row + column == size - 1) {
            for (int i = 0; i < size; i++) {
                if (cellsArray[i][i].getText().equals(currentPlayer.getSymbole().getValue())) {
                    diagonalMatch++;
                }
            }
            for (int i = 0; i < size; i++) {
                if (cellsArray[i][size - i - 1].getText().equals(currentPlayer.getSymbole().getValue())) {
                    reverseDiagonalMatch++;
                }
            }
        }

        if (rowMatch == 3 || columnMatch == 3 || diagonalMatch == 3 || reverseDiagonalMatch == 3) {
            board.setBoardStatus(BoardStatus.WIN);
        } else if (board.getMoves() == 9) {
            board.setBoardStatus(BoardStatus.DRAW);
        } else {
            board.setBoardStatus(BoardStatus.PLAYING);
        }
    }

    public BoardStatus getGameStatus() {
        return board.getBoardStatus();
    }

    public InGamePlayer getPlayer1() {
        return player1;
    }

    public InGamePlayer getPlayer2() {
        return player2;
    }

    public void setP1Online(String p1UserName, Symboles symbole) {
        player1 = new InGamePlayer(p1UserName, symbole);
    }

    public void setP2Online(String p2UserName, Symboles symbole) {
        player2 = new InGamePlayer(p2UserName, symbole);
    }
}
