/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.PlayerModel;

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
    private ObservableList<PlayerModel> onlinePlayersList;

    public OnlineUsersController(){
        onlinePlayersList = FXCollections.observableArrayList();
        onlinePlayersList.addAll(new PlayerModel("moaaz","Moaaz197",5,1));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(onlinePlayersList);
        listView.setCellFactory(playersListView -> new OnlineUserListItem());
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
        
        if(empty || player == null){
            setText(null);
            setGraphic(null);
        } else {
            try {
                if(mLLoader == null){
                    mLLoader = new FXMLLoader(getClass().getResource("OnlineUsersListItem.fxml"));
                    mLLoader.setController(this);
                }
                mLLoader.load();
            } catch (IOException ex) {
                Logger.getLogger(OnlineUserListItem.class.getName()).log(Level.SEVERE, null, ex);
            }
            userName.setText(player.getUserName());
            userStatus.setText(player.getStatus() == 0? "Online" : "inGame");
            userScore.setText(player.getScore() + "");
            setText(null);
            setGraphic(anchorPane);
        }
    }
}
