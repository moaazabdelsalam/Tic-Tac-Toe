package client;

import java.util.Random;
import javafx.scene.control.Label;
import models.InGamePlayer;
import models.Symboles;

public class ComputerRound {

    public static String NAME = "COMPUTER";
    private final Symboles[][] cellsArray;
    private final int size = 3;
    private final InGamePlayer computer;
    private final InGamePlayer localPlayer;
    private int difficultyLevel; // 1 for easy, 2 for medium, 3 for hard

    public ComputerRound(InGamePlayer computer, InGamePlayer playerTwoName, int difficultyLevel) {
        cellsArray = new Symboles[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellsArray[i][j] = Symboles.EMPTY;
            }
        }

        this.computer = computer;
        System.out.println("AI: " + " " + computer.getSymbole());

        this.localPlayer = playerTwoName;
        System.out.println("player2: " + localPlayer.getName() + ", " + localPlayer.getSymbole());

        this.difficultyLevel = difficultyLevel;
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
        // Check rows 
        for (int row = 0; row < size; row++) {
            if (cellsArray[row][0] == cellsArray[row][1]
                    && cellsArray[row][1] == cellsArray[row][2]) {
                if (cellsArray[row][0] == computer.getSymbole()) {
                    return +10;
                } else if (cellsArray[row][0] == localPlayer.getSymbole()) {
                    return -10;
                }
            }
        }
        // Check columns 
        for (int col = 0; col < size; col++) {
            if (cellsArray[0][col] == cellsArray[1][col]
                    && cellsArray[1][col] == cellsArray[2][col]) {
                if (cellsArray[0][col] == computer.getSymbole()) {
                    return +10;
                } else if (cellsArray[0][col] == localPlayer.getSymbole()) {
                    return -10;
                }
            }
        }
        // Check diagonals
        if (cellsArray[0][0] == cellsArray[1][1] && cellsArray[1][1] == cellsArray[2][2]) {
            if (cellsArray[0][0] == computer.getSymbole()) {
                return +10;
            } else if (cellsArray[0][0] == localPlayer.getSymbole()) {
                return -10;
            }
        }
        // Check reverse diagonals
        if (cellsArray[0][2] == cellsArray[1][1] && cellsArray[1][1] == cellsArray[2][0]) {
            if (cellsArray[0][2] == computer.getSymbole()) {
                return +10;
            } else if (cellsArray[0][2] == localPlayer.getSymbole()) {
                return -10;
            }
        }
        return 0;
    }

    private int[] minimax(Symboles[][] cellsArray, int depth, int alpha, int beta, boolean isMaximizing) {

        if (evaluateBoard(cellsArray) == 10 || evaluateBoard(cellsArray) == -10) {
            return new int[]{evaluateBoard(cellsArray)};
        } else if (isGameFinished(cellsArray)) {
            return new int[]{0};
        } else {
            if (isMaximizing) {
                int maxValue = Integer.MIN_VALUE;
                int[] bestMove = new int[]{-1, -1};
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (cellsArray[i][j] == Symboles.EMPTY) {
                            cellsArray[i][j] = computer.getSymbole();
                            int[] moveValue = minimax(cellsArray, depth + 1, alpha, beta, false);
                            if (moveValue[0] > maxValue) {
                                maxValue = moveValue[0];
                                bestMove[0] = i;
                                bestMove[1] = j;
                            }
                            cellsArray[i][j] = Symboles.EMPTY;
                            alpha = Math.max(alpha, maxValue);
                            if (beta <= alpha) {
                                return new int[]{alpha};
                            }
                        }
                    }
                }
                return new int[]{maxValue, bestMove[0], bestMove[1]};
            } else {
                int minValue = Integer.MAX_VALUE;
                int[] bestMove = new int[]{-1, -1};
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (cellsArray[i][j] == Symboles.EMPTY) {
                            cellsArray[i][j] = localPlayer.getSymbole();
                            int[] moveValue = minimax(cellsArray, depth + 1, alpha, beta, true);
                            if (moveValue[0] < minValue) {
                                minValue = moveValue[0];
                                bestMove[0] = i;
                                bestMove[1] = j;
                            }
                            cellsArray[i][j] = Symboles.EMPTY;
                            beta = Math.min(beta, minValue);
                            if (beta <= alpha) {
                                return new int[]{beta};
                            }
                        }
                    }
                }
                return new int[]{minValue, bestMove[0], bestMove[1]};
            }
        }
    }

    public int[] getBestMove() {
        if (difficultyLevel == 1) {
            // Easy: Make a random move
            return getRandomMove();
        } else if (difficultyLevel == 2) {
            // Medium: Implement medium-level AI logic
            int[] mediumMove = getMediumLevelMove();
            if (mediumMove != null) {
                return mediumMove;
            } else {
                return getRandomMove(); // If no strategic move is found, make a random move
            }
        } else if (difficultyLevel == 3) {
            // Hard: Implement hard-level AI logic
            int[] hardMove = getHardLevelMove();
            return hardMove;
        } else {
            // Default to easy level if difficulty level is not recognized
            return getRandomMove();
        }
    }

    private int[] getRandomMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (cellsArray[row][col] != Symboles.EMPTY);
        return new int[]{row, col};
    }

    private int[] getMediumLevelMove() {
        // Check for a winning move or a move to block the opponent's win
        int[] winningMove = findWinningMove(computer.getSymbole());
        if (winningMove != null) {
            return winningMove;
        }

        int[] blockingMove = findWinningMove(localPlayer.getSymbole());
        if (blockingMove != null) {
            return blockingMove;
        }

        // If no winning or blocking move, return null
        return null;
    }

    private int[] getHardLevelMove() {
        // Implement a minimax algorithm with alpha-beta pruning for hard-level AI
        int[] bestMove = minimax(cellsArray, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        return new int[]{bestMove[1], bestMove[2]};
    }

    // Implement a method to find a winning move for the specified symbol
    private int[] findWinningMove(Symboles symbol) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (cellsArray[row][col] == Symboles.EMPTY) {
                    cellsArray[row][col] = symbol;
                    if (evaluateBoard(cellsArray) == 10) {
                        cellsArray[row][col] = Symboles.EMPTY; // Undo the move
                        return new int[]{row, col};
                    }
                    cellsArray[row][col] = Symboles.EMPTY; // Undo the move
                }
            }
        }
        return null;
    }

    public void updateArray(Label[][] labelCellsArray) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String currentSymbol = labelCellsArray[i][j].getText();
                if (currentSymbol.equals(Symboles.X.getValue())) {
                    this.cellsArray[i][j] = Symboles.X;
                } else if (currentSymbol.equals(Symboles.O.getValue())) {
                    this.cellsArray[i][j] = Symboles.O;
                } else {
                    this.cellsArray[i][j] = Symboles.EMPTY;
                }
            }
        }
    }
}
