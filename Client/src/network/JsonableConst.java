/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public interface JsonableConst {
    //Keys
    String KEY_OPERATION = "op";
    String KEY_USERNAME = "username";
    String KEY_PASSWORD = "password";
    
    //Values
    String VALUE_LOGIN = "login";
    int VALUE_STATUS_SUCCESS = 1;
    int VALUE_STATUS_FAILED = 0;
    String VALUE_ONLINE_PLAYERS = "online_players";
    String VALUE_REIGSTER = "register";
    
}
