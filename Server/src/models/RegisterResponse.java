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
        this.status = 0; // Initialize status to a default value, you can change this as needed
        this.message = ""; // Initialize message to an empty string, you can change this as needed
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
