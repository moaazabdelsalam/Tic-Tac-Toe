/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.GameType;
import models.OnlineGameInvitationResponse;
import network.JsonableConst;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class InvitationDialogController implements Initializable {

    @FXML
    private Text inviteTxt;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button rejectBtn;
    public static String sender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inviteTxt.setText(sender + " send you invitation to play together");
        handleActions();
    }

    private void handleActions() {
        acceptBtn.setOnAction(event -> {
            System.out.println("sending accept to " + sender);
            respondToInvitation(JsonableConst.VALUE_STATUS_ACCEPT);

            GameScreenController.GAME_TYPE = GameType.ONLINE;
            GameScreenController.P1_NAME = sender; //make the sender of invitaion the first player
            GameScreenController.P2_NAME = Client.getInstance().getUserName(); //accepter of invitaion is second player
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("unable to sleep");
            }
            Client.sceneToSwitch = "/screens/GameScreen.fxml";
            Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            stage.close();
        });
        rejectBtn.setOnAction(event -> {
            respondToInvitation(JsonableConst.VALUE_STATUS_REJECT);
            Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            stage.close();
        });
    }

    public void respondToInvitation(int reponseStatus) {
        OnlineGameInvitationResponse onlineInvitationResponse = new OnlineGameInvitationResponse(
                JsonableConst.VALUE_ONLINE_GAME_INVITAION_RESPONSE,
                reponseStatus,
                sender,
                Client.getInstance().getUserName());
        Gson gson = new Gson();
        JsonObject onlineInvitationResponseJson = gson.fromJson(gson.toJson(onlineInvitationResponse), JsonObject.class);
        RequestHandler onlineInvitationResponseHandler = new RequestHandler(onlineInvitationResponseJson);
        onlineInvitationResponseHandler.start();
    }
}
