/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import client.Client;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.OnlineGameInvitationRequest;
import models.OnlinePlayersRequest;
import models.PlayerModel;
import network.JsonableConst;
import network.NetworkUtils;
import network.RequestHandler;

/**
 * FXML Controller class
 *
 * @author moaaz
 */
public class OnlineUsersController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private ListView<PlayerModel> listView;
    //public static List<PlayerModel> onlinePlayersList = new ArrayList();
    private static ObservableList<PlayerModel> onlinePlayersObservableList = FXCollections.observableArrayList();
    Navigation navigation;
    Stage stage;
    String senderUserName;

    public OnlineUsersController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //onlinePlayersObservableList = FXCollections.observableArrayList();
        //onlinePlayersObservableList.addAll(onlinePlayersList);
//        System.out.println("from controller");
//        System.out.println(onlinePlayersObservableList.size());
//        for(PlayerModel player : onlinePlayersList){
//            System.out.println(player.getName());
//        }

        listView.setBackground(Background.EMPTY);
        listView.setItems(onlinePlayersObservableList);
        listView.setCellFactory(playersListView -> new OnlineUserListItem());
        handleActions();
        getOnlineList();
    }

    public void handleActions() {
        backBtn.setOnAction(event -> {
            onlinePlayersObservableList.clear();
            check(event);
            if (Client.getInstance().isIsLoggedIn()) {
                navigation.goHome();
            } else {
                navigation.goBack();
            }
        });
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends PlayerModel> observable, PlayerModel oldValue, PlayerModel newValue) -> {
            if (newValue != null) {
                boolean isConnected = NetworkUtils.connectToServer();
                if (isConnected) {
                    OnlineGameInvitationRequest onlineGameRequest = new OnlineGameInvitationRequest(JsonableConst.VALUE_ONLINE_GAME_INVITAION,
                            Client.getInstance().getUserName(), newValue.getUserName());
                    System.out.println("sending request to player: "
                            + newValue.getUserName()
                            + ", from player: " + Client.getInstance().getUserName());
                    Gson gson = new Gson();
                    JsonObject onlineGameRequestJson = gson.fromJson(gson.toJson(onlineGameRequest), JsonObject.class);
                    RequestHandler onlineGameRequestHandler = new RequestHandler(onlineGameRequestJson);
                    onlineGameRequestHandler.start();
                }
            }
//                System.out.println("sending request to player: "
//                        + newValue.getUserName());
//newValue.setStatus(oldValue.getStatus() == 0 ? 1 : 0);
        });
    }

    public void check(ActionEvent event) {
        //navigation.goTo("OnlineUsers.fxml");

        if (navigation == null && stage == null) {
            stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
            navigation = new Navigation(stage);
        }
    }

    public void getOnlineList() {
        boolean isConnected = NetworkUtils.connectToServer();
        if (isConnected) {
            OnlinePlayersRequest onlinePlayersRequest = new OnlinePlayersRequest(
                    JsonableConst.VALUE_ONLINE_PLAYERS);
            Gson gson = new Gson();
            JsonObject onlinePlayersJson = gson.fromJson(gson.toJson(onlinePlayersRequest), JsonObject.class);
            System.out.println("requesting online players");
            RequestHandler onlinePlayersHandler = new RequestHandler(onlinePlayersJson);
            onlinePlayersHandler.start();
        }
    }

    public static void updateList(List<PlayerModel> onlinePlayersList) {
        onlinePlayersObservableList.clear();
        onlinePlayersObservableList.addAll(onlinePlayersList);
    }
}

class OnlineUserListItem extends ListCell<PlayerModel> {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView userProfileIcon;
    @FXML
    private Text userName;
    @FXML
    private Text userStatus;
    @FXML
    private Text userScore;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(PlayerModel player, boolean empty) {
        super.updateItem(player, empty);

        if (empty || player == null) {
            setText(null);
            setGraphic(null);
        } else {
            try {
                if (mLLoader == null) {
                    mLLoader = new FXMLLoader(getClass().getResource("OnlineUsersListItem.fxml"));
                    mLLoader.setController(this);
                }
                mLLoader.load();
            } catch (IOException ex) {
                //Logger.getLogger(OnlineUserListItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            userName.setText(player.getUserName());
            userStatus.setText(player.getStatus() == 1 ? "Online" : "inGame");
            userScore.setText(player.getScore() + "");
            setText(null);
            setGraphic(anchorPane);
        }
    }
}
