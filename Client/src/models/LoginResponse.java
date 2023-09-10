package models;

/**
 *
 * @author Eng Abdullah Hegazy
 */
public class LoginResponse {
    String op;
    int status;
    String message;
    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
