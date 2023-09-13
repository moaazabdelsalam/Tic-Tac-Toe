/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.scene.control.Label;
import models.InGamePlayer;
import models.Symboles;

/**
 *
 * @author moaaz
 */
public class ComputerRound {
    public static String NAME = "COMPUTER";
    Symboles[][] cellsArray;
    int size = 3;
    InGamePlayer computer;
    InGamePlayer localPlayer;

    public ComputerRound(InGamePlayer computer, InGamePlayer playerTwoName) {
        cellsArray = new Symboles[size][size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellsArray[i][j] = Symboles.EMPTY;
            }
        }

        this.computer = computer;
        System.out.println("AI: " + " " + computer.getSymbole());

        this.localPlayer = playerTwoName;
        System.out.println("player2: " + localPlayer.getName() + ", " + localPlayer.getSymbole());
    }

    public boolean isGameFinished(Symboles[][] cellsArray) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cellsArray[i][j] == Symboles.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public int evaluateBoard(Symboles[][] cellsArray) {
        //check rows 
        for (int row = 0; row < 3; row++) {
            if (cellsArray[row][0] == cellsArray[row][1]
                    && cellsArray[row][1] == cellsArray[row][2]) {
                if (cellsArray[row][0] == computer.getSymbole()) {
                    return +10;
                } else if (cellsArray[row][0] == localPlayer.getSymbole()) {
                    return -10;
                }
            }
        }
        //check columns 
        for (int col = 0; col < 3; col++) {
            if (cellsArray[0][col] == cellsArray[1][col]
                    && cellsArray[1][col] == cellsArray[2][col]) {
                if (cellsArray[0][col] == computer.getSymbole()) {
                    return +10;
                } else if (cellsArray[0][col] == localPlayer.getSymbole()) {
                    return -10;
                }
            }
        }
        //check diagonals
        if (cellsArray[0][0] == cellsArray[1][1] && cellsArray[1][1] == cellsArray[2][2]) {
            if (cellsArray[0][0] == computer.getSymbole()) {
                return +10;
            } else if (cellsArray[0][0] == localPlayer.getSymbole()) {
                return -10;
            }
        }
        //check reverse diagonals
        if (cellsArray[0][2] == cellsArray[1][1] && cellsArray[1][1] == cellsArray[2][0]) {
            if (cellsArray[0][2] == computer.getSymbole()) {
                return +10;
            } else if (cellsArray[0][2] == localPlayer.getSymbole()) {
                return -10;
            }
        }
        return 0;
    }

    public int minimax(Symboles[][] cellsArray, int depth, int alpha, int beta, boolean isMaximizing) {

        if (evaluateBoard(cellsArray) == 10 || evaluateBoard(cellsArray) == -10) {
            return evaluateBoard(cellsArray);
        } else if (isGameFinished(cellsArray)) {
            return 0;
        } else {
            if (isMaximizing) {
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (cellsArray[i][j] == Symboles.EMPTY) {
                            cellsArray[i][j] = computer.getSymbole();
                            maxValue = Math.max(maxValue,
                                    minimax(cellsArray, depth + 1, alpha, beta, !isMaximizing));
                            cellsArray[i][j] = Symboles.EMPTY;
                            alpha = Math.max(alpha, maxValue);
                            if (beta <= alpha) {
                                return alpha;
                            }
                        }
                    }
                }
                return maxValue;
            } else {
                int minValue = Integer.MAX_VALUE;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (cellsArray[i][j] == Symboles.EMPTY) {
                            cellsArray[i][j] = localPlayer.getSymbole();
                            minValue = Math.min(minValue,
                                    minimax(cellsArray, depth + 1, alpha, beta, !isMaximizing));
                            cellsArray[i][j] = Symboles.EMPTY;
                            beta = Math.min(beta, minValue);
                            if (beta <= alpha) {
                                return beta;
                            }
                        }
                    }
                }
                return minValue;
            }
        }
    }

    public int[] getBestMove() {
        int maxValue = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cellsArray[i][j] == Symboles.EMPTY) {
                    cellsArray[i][j] = computer.getSymbole();
                    int moveValue = minimax(cellsArray, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                    cellsArray[i][j] = Symboles.EMPTY;
                    if (moveValue > maxValue) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        maxValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    public void updateArray(Label[][] labelCellsArray) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String currentSymbole = labelCellsArray[i][j].getText();
                if (currentSymbole.equals(Symboles.X.getValue())) {
                    this.cellsArray[i][j] = Symboles.X;
                } else if (currentSymbole.equals(Symboles.O.getValue())) {
                    this.cellsArray[i][j] = Symboles.O;
                } else {
                    this.cellsArray[i][j] = Symboles.EMPTY;
                }
                //System.out.print(this.cellsArray[i][j].getValue() + "    ");
            }
            //System.out.println();
        }
    }
}
