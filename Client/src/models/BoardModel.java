/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.scene.control.Label;

/**
 *
 * @author moaaz
 */
public class BoardModel {

    InGamePlayer player1;
    InGamePlayer player2;
    Label[][] cellsArray;
    int moves;
    BoardStatus status;

    public BoardModel(InGamePlayer player1, InGamePlayer player2, Label[][] cellsArray) {
        this.player1 = player1;
        this.player2 = player2;
        this.cellsArray = cellsArray;
        moves = 0;
        status = BoardStatus.PLAYING;
    }

    public InGamePlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(InGamePlayer player1) {
        this.player1 = player1;
    }

    public InGamePlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(InGamePlayer player2) {
        this.player2 = player2;
    }

    public Label[][] getCellsArray() {
        return cellsArray;
    }

    public void setCellsArray(Label[][] cellsArray) {
        this.cellsArray = cellsArray;
    }

    public int getMoves() {
        return moves;
    }

    public void resetMoves() {
        this.moves = 0;
    }

    public void updateMoves() {
        this.moves++;
    }

    public void updateBoard(int row, int column, InGamePlayer player) {
        cellsArray[row][column].setText(player.getSymbole().getValue());
        cellsArray[row][column].setMouseTransparent(true);
    }

    public void setBoardStatus(BoardStatus status) {
        this.status = status;
    }

    public BoardStatus getBoardStatus() {
        return this.status;
    }
}
