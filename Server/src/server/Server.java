package server;

import java.util.ArrayList;
import screen.MainUI;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.PlayerModel;

public class Server extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        MainUI root = new MainUI();
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/resources/buttons.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/background.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/labels.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/regbg.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/transparentButton.css").toString());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
//        DatabaseHandler dbhandler = new DatabaseHandler();
//        ArrayList<PlayerModel> onlinePlayers = dbhandler.getOnlinePlayers();
//        for(PlayerModel player: onlinePlayers){
//            player.setStatus(0);
//            dbhandler.updateStatus(player);
//        }
            
    }
}
