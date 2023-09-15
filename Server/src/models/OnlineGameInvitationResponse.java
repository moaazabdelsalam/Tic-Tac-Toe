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
public class OnlineGameInvitationResponse {

    private String op;
    private int status;
    private String reciverUserName;
    private String senderUserName;

    public OnlineGameInvitationResponse(String op, int status, String reciverUserName, String senderUserName) {
        this.op = op;
        this.status = status;
        this.reciverUserName = reciverUserName;
        this.senderUserName = senderUserName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setReciverUserName(String reciverUserName) {
        this.reciverUserName = reciverUserName;
    }

    public OnlineGameInvitationResponse(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    public int getStatus() {
        return status;
    }

    public String getReciverUserName() {
        return reciverUserName;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

}
