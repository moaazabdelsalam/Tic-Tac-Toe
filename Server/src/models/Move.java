/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author moaaz
 */
public class Move {
    int row;
    int column;
    String symbole;

    public Move(int row, int column, String symbole) {
        this.row = row;
        this.column = column;
        this.symbole = symbole;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getSymbole() {
        return symbole;
    }
    
}
