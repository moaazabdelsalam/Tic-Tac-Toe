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
public class InGamePlayer {
    
    String name;
    Symboles symbole;

    public InGamePlayer(String name, Symboles symbole) {
        this.name = name;
        this.symbole = symbole;
    }

    public String getName() {
        return name;
    }

    public Symboles getSymbole() {
        return symbole;
    }
    
}
