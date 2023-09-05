package client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.AfterGameScreenUI;
import screens.GameScreenUI;
import screens.LocalPlayersNamesUI;
import screens.LoginRegisterUI;
import screens.PlayerProfileUI;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //LocalPlayersNamesUI root = new LocalPlayersNamesUI();
        Parent root = new PlayerProfileUI();
        //AfterGameScreenUI root = new AfterGameScreenUI();

        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/buttons.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/background.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/labels.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/regbg.css").toString());
        scene.getStylesheets().add(getClass().getResource("/resources/transparentButton.css").toString());

        stage.setScene(scene);
        stage.show();

        //  root.mediaViewer.setMediaPlayer(mediaPlayer);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
