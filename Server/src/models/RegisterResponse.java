package models;

/**
 *
 * @author Omar El Samahy
 */
public class RegisterResponse {

    private String op;
    private int status;
    private String message;

    public RegisterResponse(String op) {
        this.op = op;
        
    }

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
