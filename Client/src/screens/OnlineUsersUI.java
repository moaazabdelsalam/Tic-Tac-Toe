package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class OnlineUsersUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Button backBtn;
    protected final ImageView imageView;
    protected final TextArea textArea;

    public OnlineUsersUI() {

        anchorPane = new AnchorPane();
        label = new Label();
        backBtn = new Button();
        imageView = new ImageView();
        textArea = new TextArea();

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
        backBtn.getStylesheets().add("/screens/../resources/transparentButton.css");
        backBtn.setText("Back");

        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);
        imageView.setImage(new Image(getClass().getResource("../resources/backArrow.png").toExternalForm()));
        backBtn.setGraphic(imageView);
        anchorPane.setPadding(new Insets(5.0));
        setTop(anchorPane);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setEditable(false);
        BorderPane.setMargin(textArea, new Insets(5.0));
        textArea.setPadding(new Insets(10.0));
        setCenter(textArea);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(backBtn);

    }
}
