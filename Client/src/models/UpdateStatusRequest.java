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
public class UpdateStatusRequest {

    private String op;
    private String userName;
    private int Status;

    public UpdateStatusRequest(String op, String userName, int Status) {
        this.op = op;
        this.userName = userName;
        this.Status = Status;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
