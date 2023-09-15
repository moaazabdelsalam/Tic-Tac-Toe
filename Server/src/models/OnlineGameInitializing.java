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
public class OnlineGameInitializing {

    String op;
    Symboles symbole;
}

enum Symboles {
    X("X", 0), O("O", 1), EMPTY(" ", -1);
    int id;
    String value;

    Symboles(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
