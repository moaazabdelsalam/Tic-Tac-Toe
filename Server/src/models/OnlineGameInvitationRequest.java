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
public class OnlineGameInvitationRequest {

    String op;
    String senderUserName;
    String reciverUserName;

    public OnlineGameInvitationRequest(String op, String senderUserName, String reciverUserName) {
        this.op = op;
        this.senderUserName = senderUserName;
        this.reciverUserName = reciverUserName;
    }

    public OnlineGameInvitationRequest(String op, String senderUserName) {
        this.op = op;
        this.senderUserName = senderUserName;
    }

    public String getOp() {
        return op;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public String getReciverUserName() {
        return reciverUserName;
    }

}
