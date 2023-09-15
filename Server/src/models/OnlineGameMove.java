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
public class OnlineGameMove {
    String op;
    Move move;
    String reciverUserName;

    public OnlineGameMove(String op, Move move, String reciverUserName) {
        this.op = op;
        this.move = move;
        this.reciverUserName = reciverUserName;
    }

    public String getOp() {
        return op;
    }

    public Move getMove() {
        return move;
    }

    public String getReciverUserName() {
        return reciverUserName;
    }
    
}
