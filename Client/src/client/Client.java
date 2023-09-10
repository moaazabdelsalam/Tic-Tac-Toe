package client;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.Navigation;

public class Client extends Application {

    public static boolean isLoggedIn = false;

    @Override
    public void start(Stage stage) throws Exception {
        
        Navigation navigation = new Navigation(stage);
        navigation.goTo("/screens/ClientMainScreen.fxml");
        stage.setResizable(false);
        stage.show();
        
        //  root.mediaViewer.setMediaPlayer(mediaPlayer);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
