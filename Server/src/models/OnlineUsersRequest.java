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
public class OnlineUsersRequest {
    String userName;

    public OnlineUsersRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    
}
