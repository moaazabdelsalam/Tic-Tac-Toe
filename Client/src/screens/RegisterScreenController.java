package screens;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.PlayerModel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.DriverManager;

public class RegisterScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button registerBtn;
    @FXML
    private TextField userNameTxtf;
    @FXML
    private TextField nameTxtf;
    @FXML
    private TextField passwordTxtf;
    @FXML
    private TextField confirmPasswordTxtf;

    Navigation navigation;
    Stage stage;
    Connection connection;

    // Declare the playerModel variable at the class level
    private PlayerModel playerModel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleAction();
    }

    public void handleAction() {
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });

        // Set the action for the registerBtn button
        registerBtn.setOnAction(event -> {
            // Create a PlayerModel object using data from text fields
            String userName = userNameTxtf.getText();
            String name = nameTxtf.getText();
            String password = passwordTxtf.getText();
            String confirmPassword = confirmPasswordTxtf.getText();
            int score = 0;
            int status = 0;

            playerModel = new PlayerModel(userName, name, password, score, status);

            // Perform user registration
            addPlayer();
        });
    }

    public void check(ActionEvent event) {
        if (navigation == null && stage == null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            navigation = new Navigation(stage);
        }
    }

    public void addPlayer() {
        String url = "jdbc:derby://localhost:1527/tic_tac_toe";
        String username = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Check if the username is already in use
            if (isUsernameTaken(playerModel.getUserName())) {
                // Display an error message if the username is taken
                showAlert("Registration Error", "Username already exists. Please choose another one.");
                return;
            }

            PreparedStatement pst;
            String query;
            query = "INSERT INTO PLAYER(USER_NAME, NAME, PASSWORD, SCORE, STATUS) VALUES (?, ?, ?, ?, ?)";
            pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, playerModel.getUserName());
            pst.setString(2, playerModel.getName());
            pst.setString(3, hashPassword(playerModel.getPassword())); // Hash the password
            pst.setInt(4, playerModel.getScore());
            pst.setInt(5, playerModel.getStatus());
            pst.executeUpdate();

            // Get the generated ID if needed
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int playerId = generatedKeys.getInt(1);
                playerModel.setId(playerId);
            }

            pst.close();

            // Display a success message
            showAlert("Registration Successful", "Player registered successfully!");

            // Clear the text fields
            userNameTxtf.clear();
            nameTxtf.clear();
            passwordTxtf.clear();
            confirmPasswordTxtf.clear();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterScreenController.class.getName()).log(Level.SEVERE, null, ex);
            // Display an error message if registration fails
            showAlert("Registration Error", "Error occurred during registration. Please try again.");
        }
    }

    // Implement your database check logic for username existence
    private boolean isUsernameTaken(String userName) throws SQLException {
        PreparedStatement checkStmt = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT COUNT(*) FROM PLAYER WHERE USER_NAME = ?";
            checkStmt = connection.prepareStatement(query);
            checkStmt.setString(1, userName);
            resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            return false;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (checkStmt != null) {
                checkStmt.close();
            }
        }
    }

    // Implement password hashing (example using SHA-256, not recommended for production)
    private String hashPassword(String password) {
        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Update the digest with the salt
            digest.update(salt);

            // Convert the password to bytes and hash
            byte[] hashedPassword = digest.digest(password.getBytes());

            // Convert the hashed password to a hexadecimal string
            StringBuilder hexPassword = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexPassword.append('0');
                }
                hexPassword.append(hex);
            }

            // Concatenate the salt and hashed password
            String hashedPasswordStr = hexPassword.toString();
            String saltStr = bytesToHex(salt);
            return saltStr + hashedPasswordStr;
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    // Helper method to convert bytes to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
