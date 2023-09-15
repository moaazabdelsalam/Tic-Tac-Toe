/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.RegisterRequest;
import network.JsonableConst;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        handleAction();
    }

    public void handleAction() {
        backBtn.setOnAction(event -> {
            check(event);
            navigation.goBack();
        });
        registerBtn.setOnAction(event -> {
            RegisterRequest registerRequestModel = new RegisterRequest(JsonableConst.VALUE_REGISTER,
                    userNameTxtf.getText(), nameTxtf.getText(), passwordTxtf.getText(), confirmPasswordTxtf.getText());
            //convert request model to Json object
            Gson gson = new Gson();
            JsonObject registerRequestJson = gson.fromJson(gson.toJson(registerRequestModel),
                    JsonObject.class);
            System.out.println(registerRequestJson.toString());
            RequestHandler registerHandler = new RequestHandler(registerRequestJson);
            registerHandler.start();
        });
    }

    public void check(ActionEvent event) {
        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }
}
