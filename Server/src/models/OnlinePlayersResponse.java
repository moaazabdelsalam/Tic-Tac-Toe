/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author moaaz
 */
public class OnlinePlayersResponse {
    String op;
    private int status;
    private ArrayList<PlayerModel> onlinePlayers;

    public OnlinePlayersResponse(String op) {
        this.op = op;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<PlayerModel> getOnlinePlayers() {
        return onlinePlayers;
    }

    public void setOnlinePlayers(ArrayList<PlayerModel> onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }
    
}
