/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/*
 *
 * @author Omar El Samahy
 *
 */
public class RegisterRequest {

    String op;
    String name;
    String userName;
    String password;
    String confirmPassword;

    public RegisterRequest(String op, String name, String userName, String password, String confirmPassword) {
        this.op = op;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getconfirmPassword() {
        return confirmPassword;
    }
}
