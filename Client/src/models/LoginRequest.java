package models;

public class LoginRequest {
    String op;
    String userName;
    String password;
    public LoginRequest(){
    }
    public LoginRequest(String op, String userName, String password){
        this.op = op;
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
    
}