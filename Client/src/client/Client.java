
package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.AfterGameScreenUI;
import screens.ClientMainScreenUI;
import screens.GameScreenUI;


public class Client extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //GameScreenUI root = new GameScreenUI();
        //AfterGameScreenUI root = new AfterGameScreenUI();
        ClientMainScreenUI root = new ClientMainScreenUI();
                
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        stage.setScene(scene);
        stage.show();
        
        //  root.mediaViewer.setMediaPlayer(mediaPlayer);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
