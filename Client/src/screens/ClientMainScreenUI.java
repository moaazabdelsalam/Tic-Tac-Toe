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
    protected final Button login;
    protected final ImageView imageView;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final AnchorPane anchorPane0;
    protected final Button button2;

    public ClientMainScreenUI() {

        anchorPane = new AnchorPane();
        login = new Button();
        imageView = new ImageView();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        anchorPane0 = new AnchorPane();
        button2 = new Button();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(900.0);
        getStyleClass().add("background-pane");
        getStylesheets().add("/screens/../resources/background.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        login.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        login.setContentDisplay(javafx.scene.control.ContentDisplay.GRAPHIC_ONLY);
        login.setLayoutX(789.0);
        login.setLayoutY(25.0);
        login.setMaxHeight(Double.MAX_VALUE);
        login.setMaxWidth(Double.MAX_VALUE);
        login.setMinHeight(USE_PREF_SIZE);
        login.setMinWidth(USE_PREF_SIZE);
        login.setMnemonicParsing(false);
        login.setPrefHeight(60.0);
        login.setPrefWidth(60.0);
        login.getStyleClass().add("transparent-button");
        login.getStylesheets().add("/screens/../resources/transparentButton.css");
        login.setText("Login / Register");
        login.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        login.setWrapText(true);
        login.setPadding(new Insets(5.0));

        AnchorPane.setRightAnchor(imageView, 41.0);
        imageView.setFitHeight(60.0);
        imageView.setFitWidth(60.0);
        imageView.setLayoutX(789.0);
        imageView.setLayoutY(25.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/profile.png").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(253.0);
        label.setLayoutY(39.0);
        label.setText("Tic Tac Toe!");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#60bfc1"));
        label.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        label.setWrapText(true);
        label.setFont(new Font("Comic Sans MS Bold Italic", 65.0));
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

        GridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button, javafx.geometry.VPos.CENTER);
        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("custom-button");
        button.getStylesheets().add("/screens/../resources/buttons.css");
        button.setText("VS Computer");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(button, new Insets(5.0));
        button.setPadding(new Insets(5.0));
        button.setFont(new Font("Impact", 25.0));

        GridPane.setHalignment(button0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button0, 1);
        GridPane.setValignment(button0, javafx.geometry.VPos.CENTER);
        button0.setAlignment(javafx.geometry.Pos.CENTER);
        button0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("custom-button");
        button0.getStylesheets().add("/screens/../resources/buttons.css");
        button0.setText("Local PvP");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(button0, new Insets(5.0));
        button0.setPadding(new Insets(5.0));
        button0.setFont(new Font("Impact", 25.0));

        GridPane.setHalignment(button1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button1, 2);
        GridPane.setValignment(button1, javafx.geometry.VPos.CENTER);
        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button1.setMnemonicParsing(false);
        button1.getStyleClass().add("custom-button");
        button1.getStylesheets().add("/screens/../resources/buttons.css");
        button1.setText("Online PvP");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(button1, new Insets(5.0));
        button1.setPadding(new Insets(5.0));
        button1.setFont(new Font("Impact", 25.0));
        BorderPane.setMargin(gridPane, new Insets(10.0));
        setCenter(gridPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);

        button2.setAlignment(javafx.geometry.Pos.CENTER);
        button2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button2.setLayoutX(22.0);
        button2.setLayoutY(20.0);
        button2.setMnemonicParsing(false);
        button2.getStyleClass().add("custom-button");
        button2.getStylesheets().add("/screens/../resources/buttons.css");
        button2.setText("Exit");
        button2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button2.setPadding(new Insets(5.0));
        button2.setFont(new Font("Impact", 25.0));
        anchorPane0.setPadding(new Insets(10.0));
        BorderPane.setMargin(anchorPane0, new Insets(0.0));
        setBottom(anchorPane0);

        anchorPane.getChildren().add(login);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        anchorPane0.getChildren().add(button2);

    }
}
