package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class RegisterScreenUI extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final TextField textField;
    protected final Bloom bloom;
    protected final TextField textField0;
    protected final Bloom bloom0;
    protected final TextField textField1;
    protected final Bloom bloom1;
    protected final TextField textField2;
    protected final Bloom bloom2;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final AnchorPane anchorPane;
    protected final Button button;

    public RegisterScreenUI() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        textField = new TextField();
        bloom = new Bloom();
        textField0 = new TextField();
        bloom0 = new Bloom();
        textField1 = new TextField();
        bloom1 = new Bloom();
        textField2 = new TextField();
        bloom2 = new Bloom();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        anchorPane = new AnchorPane();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add("/screens/../resources/regbg.css");

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(291.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(169.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(462.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(431.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(textField, 1);
        GridPane.setHalignment(textField, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(textField, javafx.geometry.VPos.CENTER);
        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setPromptText("Enter A Unique User Name");

        textField.setEffect(bloom);
        GridPane.setMargin(textField, new Insets(10.0));

        GridPane.setColumnIndex(textField0, 1);
        GridPane.setHalignment(textField0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(textField0, 1);
        GridPane.setValignment(textField0, javafx.geometry.VPos.CENTER);
        textField0.setAlignment(javafx.geometry.Pos.CENTER);
        textField0.setPromptText("Enter Your Name");

        textField0.setEffect(bloom0);
        GridPane.setMargin(textField0, new Insets(10.0));

        GridPane.setColumnIndex(textField1, 1);
        GridPane.setHalignment(textField1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(textField1, 2);
        GridPane.setValignment(textField1, javafx.geometry.VPos.CENTER);
        textField1.setAlignment(javafx.geometry.Pos.CENTER);
        textField1.setPromptText("Choose Password");

        textField1.setEffect(bloom1);
        GridPane.setMargin(textField1, new Insets(10.0));

        GridPane.setColumnIndex(textField2, 1);
        GridPane.setHalignment(textField2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(textField2, 3);
        GridPane.setValignment(textField2, javafx.geometry.VPos.CENTER);
        textField2.setAlignment(javafx.geometry.Pos.CENTER);
        textField2.setPromptText("Choose Password");

        textField2.setEffect(bloom2);
        GridPane.setMargin(textField2, new Insets(10.0));

        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label, javafx.geometry.VPos.CENTER);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.getStyleClass().add("custom-label");
        label.getStylesheets().add("/screens/../resources/labels.css");
        label.setText("User Name");

        GridPane.setHalignment(label0, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label0, 1);
        GridPane.setValignment(label0, javafx.geometry.VPos.CENTER);
        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.getStyleClass().add("custom-label");
        label0.getStylesheets().add("/screens/../resources/labels.css");
        label0.setText("Name");

        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label1, 2);
        GridPane.setValignment(label1, javafx.geometry.VPos.CENTER);
        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.getStyleClass().add("custom-label");
        label1.getStylesheets().add("/screens/../resources/labels.css");
        label1.setText("Password");

        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label2, 3);
        GridPane.setValignment(label2, javafx.geometry.VPos.CENTER);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.getStyleClass().add("custom-label");
        label2.getStylesheets().add("/screens/../resources/labels.css");
        label2.setText("Confirm Password");
        BorderPane.setMargin(gridPane, new Insets(10.0));
        gridPane.setPadding(new Insets(10.0));
        setCenter(gridPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);

        GridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(button, javafx.geometry.VPos.CENTER);
        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setLayoutX(246.0);
        button.setLayoutY(10.0);
        button.setMnemonicParsing(false);
        button.getStylesheets().add("/screens/../resources/buttons.css");
        button.setText("Register");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        GridPane.setMargin(button, new Insets(5.0));
        button.setPadding(new Insets(5.0));
        button.setFont(new Font("Impact", 25.0));
        BorderPane.setMargin(anchorPane, new Insets(5.0));
        anchorPane.setPadding(new Insets(5.0));
        setBottom(anchorPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(textField);
        gridPane.getChildren().add(textField0);
        gridPane.getChildren().add(textField1);
        gridPane.getChildren().add(textField2);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        anchorPane.getChildren().add(button);

    }
}
