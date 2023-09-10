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
public class PlayerModel {

    private int id;
    private String userName;
    private String name;
    private String password;
    private int score;
    private int status;

    public PlayerModel() {
    }

    public PlayerModel(String name, String userName, String password
            , int score, int status) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.score = score;
        this.status = status;
    }
    public PlayerModel(int id,String name, String userName, String password
            , int score, int status) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.score = score;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
