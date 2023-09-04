package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class OnlineUsersUI extends BorderPane {

    protected final Label label;
    protected final TextArea textArea;

    public OnlineUsersUI() {

        label = new Label();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("Players");
        label.setWrapText(true);
        label.setFont(new Font("Impact", 40.0));
        setTop(label);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setEditable(false);
        BorderPane.setMargin(textArea, new Insets(5.0));
        textArea.setPadding(new Insets(10.0));
        setCenter(textArea);

    }
}
