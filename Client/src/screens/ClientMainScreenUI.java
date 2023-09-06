package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class ClientMainScreenUI extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button profileBtn;
    protected final ImageView imageView;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button computerBtn;
    protected final Button localBtn;
    protected final Button onlineBtn;
    protected final AnchorPane anchorPane0;
    protected final Button mainExitBtn;

    public ClientMainScreenUI() {

        anchorPane = new AnchorPane();
        profileBtn = new Button();
        imageView = new ImageView();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        computerBtn = new Button();
        localBtn = new Button();
        onlineBtn = new Button();
        anchorPane0 = new AnchorPane();
        mainExitBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("background-pane");
        getStylesheets().add("/screens/../resources/background.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        profileBtn.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        profileBtn.setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
        profileBtn.setLayoutX(516.0);
        profileBtn.setLayoutY(14.0);
        profileBtn.setMaxHeight(Double.MAX_VALUE);
        profileBtn.setMaxWidth(Double.MAX_VALUE);
        profileBtn.setMinHeight(USE_PREF_SIZE);
        profileBtn.setMinWidth(USE_PREF_SIZE);
        profileBtn.setMnemonicParsing(false);
        profileBtn.setPrefHeight(60.0);
        profileBtn.setPrefWidth(60.0);
        profileBtn.getStyleClass().add("transparent-button");
        profileBtn.getStylesheets().add("/screens/../resources/transparentButton.css");
        profileBtn.setText("Login / Register");
        profileBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        profileBtn.setWrapText(true);
        profileBtn.setPadding(new Insets(5.0));

        imageView.setFitHeight(60.0);
        imageView.setFitWidth(60.0);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/profile.png").toExternalForm()));
        profileBtn.setGraphic(imageView);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(141.0);
        label.setLayoutY(14.0);
        label.setText("Tic Tac Toe!");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#60bfc1"));
        label.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        label.setWrapText(true);
        label.setFont(new Font("Comic Sans MS Bold Italic", 50.0));
        BorderPane.setMargin(anchorPane, new Insets(5.0));
        anchorPane.setPadding(new Insets(5.0));
        setTop(anchorPane);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(computerBtn, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(computerBtn, javafx.geometry.VPos.CENTER);
        computerBtn.setAlignment(javafx.geometry.Pos.CENTER);
        computerBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        computerBtn.setMnemonicParsing(false);
        computerBtn.getStyleClass().add("custom-button");
        computerBtn.getStylesheets().add("/screens/../resources/buttons.css");
        computerBtn.setText("VS Computer");
        computerBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(computerBtn, new Insets(5.0));
        computerBtn.setPadding(new Insets(5.0));
        computerBtn.setFont(new Font("Impact", 25.0));

        GridPane.setHalignment(localBtn, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(localBtn, 1);
        GridPane.setValignment(localBtn, javafx.geometry.VPos.CENTER);
        localBtn.setAlignment(javafx.geometry.Pos.CENTER);
        localBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        localBtn.setMnemonicParsing(false);
        localBtn.getStyleClass().add("custom-button");
        localBtn.getStylesheets().add("/screens/../resources/buttons.css");
        localBtn.setText("Local PvP");
        localBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(localBtn, new Insets(5.0));
        localBtn.setPadding(new Insets(5.0));
        localBtn.setFont(new Font("Impact", 25.0));

        GridPane.setHalignment(onlineBtn, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(onlineBtn, 2);
        GridPane.setValignment(onlineBtn, javafx.geometry.VPos.CENTER);
        onlineBtn.setAlignment(javafx.geometry.Pos.CENTER);
        onlineBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.getStyleClass().add("custom-button");
        onlineBtn.getStylesheets().add("/screens/../resources/buttons.css");
        onlineBtn.setText("Online PvP");
        onlineBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(onlineBtn, new Insets(5.0));
        onlineBtn.setPadding(new Insets(5.0));
        onlineBtn.setFont(new Font("Impact", 25.0));
        BorderPane.setMargin(gridPane, new Insets(10.0));
        setCenter(gridPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);

        mainExitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        mainExitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        mainExitBtn.setLayoutX(14.0);
        mainExitBtn.setLayoutY(-14.0);
        mainExitBtn.setMnemonicParsing(false);
        mainExitBtn.getStyleClass().add("custom-button");
        mainExitBtn.getStylesheets().add("/screens/../resources/buttons.css");
        mainExitBtn.setText("Exit");
        mainExitBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        mainExitBtn.setPadding(new Insets(5.0));
        mainExitBtn.setFont(new Font("Impact", 25.0));
        anchorPane0.setPadding(new Insets(10.0));
        BorderPane.setMargin(anchorPane0, new Insets(0.0));
        setBottom(anchorPane0);

        anchorPane.getChildren().add(profileBtn);
        anchorPane.getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(computerBtn);
        gridPane.getChildren().add(localBtn);
        gridPane.getChildren().add(onlineBtn);
        anchorPane0.getChildren().add(mainExitBtn);

    }
}
