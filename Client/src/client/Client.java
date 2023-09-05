package client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.AfterGameScreenUI;
import screens.ClientMainScreenUI;
import screens.GameScreenUI;
import screens.LocalPlayersNamesUI;
import screens.LoginRegisterScreenUI;
import screens.OnlineUsersUI;
import screens.PlayerProfileScreenUI;
import screens.RegisterScreenUI;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ClientMainScreenUI clientMainScreenLabel = new ClientMainScreenUI();
        Scene mainScreenScene = new Scene(clientMainScreenLabel);
        
        PlayerProfileScreenUI palyerProfileScreenLabel = new PlayerProfileScreenUI();
        Scene palyerProfileScreenScene = new Scene(palyerProfileScreenLabel);
        
        GameScreenUI gameScreenLabel = new GameScreenUI();
        Scene gameScreenScene = new Scene(gameScreenLabel);
        
        LocalPlayersNamesUI localPlayersNamesLabel = new LocalPlayersNamesUI();
        Scene localPlayersNamesScene = new Scene(localPlayersNamesLabel);
        
        LoginRegisterScreenUI loginRegisterScreenLabel = new LoginRegisterScreenUI();
        Scene loginRegisterScreenScene = new Scene(loginRegisterScreenLabel);
        
        RegisterScreenUI registerScreenLabel = new RegisterScreenUI();
        Scene registerScreenScene = new Scene(registerScreenLabel);
        
        OnlineUsersUI onlineUsersLabel = new OnlineUsersUI();
        Scene onlineUsersScene = new Scene(onlineUsersLabel);
        
        AfterGameScreenUI afterGameScreenLabel = new AfterGameScreenUI();
        Scene afterGameScreenScene = new Scene(afterGameScreenLabel);
        
        clientMainScreenLabel.getProfileBtn().setOnAction(event -> {
            stage.setScene(palyerProfileScreenScene);
        });
        clientMainScreenLabel.getComputerBtn().setOnAction(event -> {
            
        });
        clientMainScreenLabel.getLocalBtn().setOnAction(event -> {
            stage.setScene(localPlayersNamesScene);
        });
        clientMainScreenLabel.getOnlineBtn().setOnAction(event -> {
            stage.setScene(loginRegisterScreenScene);
        });
        clientMainScreenLabel.getMainExitBtn().setOnAction(event -> {
            stage.setScene(afterGameScreenScene);
        });
        localPlayersNamesLabel.getBtnStart().setOnAction(event -> {
            stage.setScene(gameScreenScene);
        });
        localPlayersNamesLabel.getBtnCancel().setOnAction(event -> {
            stage.setScene(mainScreenScene);
        });
        loginRegisterScreenLabel.getLoginBtn().setOnAction(event -> {
           stage.setScene(gameScreenScene); 
        });
        gameScreenLabel.getExitGameBtn().setOnAction(event -> {
           stage.setScene(mainScreenScene);
        });
        
        mainScreenScene.getStylesheets().add(getClass().getResource("style.css").toString());
        mainScreenScene.getStylesheets().add(getClass().getResource("/resources/buttons.css").toString());
        mainScreenScene.getStylesheets().add(getClass().getResource("/resources/background.css").toString());
        mainScreenScene.getStylesheets().add(getClass().getResource("/resources/labels.css").toString());
        mainScreenScene.getStylesheets().add(getClass().getResource("/resources/regbg.css").toString());
        mainScreenScene.getStylesheets().add(getClass().getResource("/resources/transparentButton.css").toString());

        stage.setScene(mainScreenScene);
        stage.show();

        //  root.mediaViewer.setMediaPlayer(mediaPlayer);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
