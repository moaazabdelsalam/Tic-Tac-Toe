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
public class OnlinePlayersRequest {
    String op;
    String senderUserName;

    public OnlinePlayersRequest(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public String getSenderUserName() {
        return senderUserName;
    }
 
}
