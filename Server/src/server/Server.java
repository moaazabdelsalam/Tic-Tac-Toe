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
        /*PlayerModel player1 = new PlayerModel("moaaz74","Moaaz","moaaz74",0,0);
        PlayerModel player2 = new PlayerModel("moaaz7422","Moaaz A.","moaaz7422",0,0);
        PlayerModel player3 = new PlayerModel("super74","Super.","super74",0,0);
        PlayerModel player4 = new PlayerModel("super7422","Super.M","super7422",0,0);
        
        DatabaseHandler dbhandler = new DatabaseHandler();
        if(dbhandler.isPlayerExist(player1.getUserName()))
            System.out.println("player already exist");
        else
            dbhandler.addNewPlayer(player1);
        if(dbhandler.isPlayerExist(player2.getUserName()))
            System.out.println("player already exist");
        else
            dbhandler.addNewPlayer(player2);
        if(dbhandler.isPlayerExist(player3.getUserName()))
            System.out.println("player already exist");
        else
            dbhandler.addNewPlayer(player3);
        if(dbhandler.isPlayerExist(player4.getUserName()))
            System.out.println("player already exist");
        else
            dbhandler.addNewPlayer(player4);
        
        
        if(dbhandler.validatePlayer(player1.getUserName(),"moaaz74"))
            System.out.println("one logged in");
        else
            System.out.println("one, incroect username or password");
        if(dbhandler.validatePlayer(player2.getUserName(),player2.getPassword()))
            System.out.println("two logged in");
        else
            System.out.println("two, incroect username or password");
        if(dbhandler.validatePlayer(player3.getUserName(),"super740"))
            System.out.println("three, logged in");
        else
            System.out.println("three, incroect username or password");
        if(dbhandler.validatePlayer(player4.getUserName(),"Super7422"))
            System.out.println("four, logged in");
        else
            System.out.println("foure, incroect username or password");
        
        player1.setStatus(1);
        dbhandler.updateStatus(player1.getUserName(), player1.getStatus());
        dbhandler.updateScore(player1.getUserName(), player1.getScore()+3);
        
        ArrayList<PlayerModel> onlinePlayers = dbhandler.getOnlinePlayers();
        for(PlayerModel player: onlinePlayers)
            System.out.println("name: " + player.getName() + ", score: " + player.getScore());
        
        */
    }
}
