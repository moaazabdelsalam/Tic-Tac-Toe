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
public enum RequestCode {
    LOGIN(1),
    REGISTER(2),
    ONLINE_USERES(3);
    
    int requestNumber;
    private RequestCode(int requestNumber){
        this.requestNumber = requestNumber;
    }
}
