package screens;

import client.Constants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import models.PlayerModel;

public class OnlineUsersUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Button backBtn;
    protected final ImageView imageView;
    protected final ListView<PlayerModel> listView;
    
    private ObservableList<PlayerModel> onlinePlayersList;
    public OnlineUsersUI() {

        anchorPane = new AnchorPane();
        label = new Label();
        backBtn = new Button();
        imageView = new ImageView();
        listView = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        label.setLayoutX(239.0);
        label.setLayoutY(14.0);
        label.setText("Players");
        label.setWrapText(true);
        label.setFont(new Font("Impact", 40.0));

        backBtn.setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
        backBtn.setLayoutX(35.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMaxHeight(USE_PREF_SIZE);
        backBtn.setMaxWidth(USE_PREF_SIZE);
        backBtn.setMinHeight(USE_PREF_SIZE);
        backBtn.setMinWidth(USE_PREF_SIZE);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(50.0);
        backBtn.getStyleClass().add("transparent-button");
        backBtn.getStylesheets().add(Constants.transparentButtonsCSSPath.toUri().toString());
        backBtn.setText("Back");

        imageView.setFitHeight(55.0);
        imageView.setFitWidth(55.0);
        imageView.setImage(new Image(Constants.backArrowCSSPath.toUri().toString()));
        backBtn.setGraphic(imageView);
        anchorPane.setPadding(new Insets(5.0));
        setTop(anchorPane);

        BorderPane.setAlignment(listView, javafx.geometry.Pos.CENTER);
        listView.setPrefHeight(400.0);
        listView.setPrefWidth(600.0);
        setCenter(listView);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(backBtn);
        
        
        
    }
}
