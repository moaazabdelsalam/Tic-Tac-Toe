/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javafx.scene.control.Label;
import models.InGamePlayer;
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
    int size = 3, moves = 0;
    
    public GameLogic(Label[][] cellsArray,String playerOneName, String playerTwoName){
        this.cellsArray = cellsArray;
        Random random = new Random();
        int randNumber = random.nextInt(2);
        System.out.println(randNumber);
        
        player1 = new InGamePlayer(playerOneName,
                randNumber == Symboles.X.getId() ? Symboles.X : Symboles.O);
        System.out.println("player1: " + player1.getName() + ", " + player1.getSymbole());
        
        player2 = new InGamePlayer(playerTwoName,
                player1.getSymbole() == Symboles.O ? Symboles.X : Symboles.O);
        System.out.println("player2: " + player2.getName() + ", " + player2.getSymbole());
        
        if(player1.getSymbole() == Symboles.X){
            playersTurn.add(player1);
            playersTurn.add(player2);
        } else {
            playersTurn.add(player2);
            playersTurn.add(player1);
        }
    }
    
    public InGamePlayer getTurn(){
        return playersTurn.poll();
    }
    
    public boolean isWin(int row, int column, InGamePlayer currentPlayer){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean reverseDiagonalMatch = true;
        //check rows
        for(int i = 0; i < size; i++)
            rowMatch = rowMatch && cellsArray[row][i].getText().equals(currentPlayer.getSymbole().getValue());
        //check columns
        for(int i = 0; i < size; i++)
            columnMatch = columnMatch && cellsArray[i][column].getText().equals(currentPlayer.getSymbole().getValue());
        //check diagonal && reverse diagonal
        if(row == column || row + column == size - 1){
            for(int i = 0; i < size; i++)
                diagonalMatch = diagonalMatch && cellsArray[i][i].getText().equals(currentPlayer.getSymbole().getValue());
            for(int i = 0; i < size; i++)
                reverseDiagonalMatch = reverseDiagonalMatch && cellsArray[i][size - i - 1].getText().equals(currentPlayer.getSymbole().getValue());
            return rowMatch || columnMatch || diagonalMatch || reverseDiagonalMatch;
        } else 
            return rowMatch || columnMatch;
    }
    
    public boolean isDraw(){
        
            return true;
    }
    public void updateBoard(Label cell, InGamePlayer player){
        cell.setMouseTransparent(true);
        cell.setText(player.getSymbole().getValue());
        playersTurn.add(player);
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public InGamePlayer getPlayer1() {
        return player1;
    }

    public InGamePlayer getPlayer2() {
        return player2;
    }
    
}


