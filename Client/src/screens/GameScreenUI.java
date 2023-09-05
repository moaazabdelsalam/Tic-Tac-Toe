package screens;

import client.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameScreenUI extends AnchorPane {

    protected final Rectangle rectangle;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label cellC0R0;
    protected final Label cellC0R1;
    protected final Label cellC0R2;
    protected final Label cellC1R0;
    protected final Label cellC1R1;
    protected final Label cellC1R2;
    protected final Label cellC2R0;
    protected final Label cellC2R1;
    protected final Label cellC2R2;
    protected final Rectangle rectangle0;
    protected final Circle circle;
    protected final ImageView playerOneIcon;
    protected final Rectangle rectangle1;
    protected final Circle circle0;
    protected final ImageView playerTwoIcon;
    protected final Button exitGameBtn;
    protected final RadioButton recordBtn;
    protected final Text playerOneUserName;
    protected final Text playerTwoUserName;
    protected final Label playerOneRole;
    protected final Label playerTwoRole;

    public GameScreenUI() {

        rectangle = new Rectangle();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        cellC0R0 = new Label();
        cellC0R1 = new Label();
        cellC0R2 = new Label();
        cellC1R0 = new Label();
        cellC1R1 = new Label();
        cellC1R2 = new Label();
        cellC2R0 = new Label();
        cellC2R1 = new Label();
        cellC2R2 = new Label();
        rectangle0 = new Rectangle();
        circle = new Circle();
        playerOneIcon = new ImageView();
        rectangle1 = new Rectangle();
        circle0 = new Circle();
        playerTwoIcon = new ImageView();
        exitGameBtn = new Button();
        recordBtn = new RadioButton();
        playerOneUserName = new Text();
        playerTwoUserName = new Text();
        playerOneRole = new Label();
        playerTwoRole = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("regbg-pane");
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#c0c3c6"));
        rectangle.setHeight(233.0);
        rectangle.setLayoutX(102.0);
        rectangle.setLayoutY(107.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(397.0);

        gridPane.setLayoutX(104.0);
        gridPane.setLayoutY(107.0);
        gridPane.setPrefHeight(233.0);
        gridPane.setPrefWidth(397.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        cellC0R0.setAlignment(javafx.geometry.Pos.CENTER);
        cellC0R0.setEllipsisString("");
        cellC0R0.setLayoutX(373.0);
        cellC0R0.setLayoutY(10.0);
        cellC0R0.setPrefHeight(94.0);
        cellC0R0.setPrefWidth(185.0);
        cellC0R0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC0R0.setFont(new Font(50.0));

        GridPane.setRowIndex(cellC0R1, 1);
        cellC0R1.setAlignment(javafx.geometry.Pos.CENTER);
        cellC0R1.setEllipsisString("");
        cellC0R1.setLayoutX(10.0);
        cellC0R1.setLayoutY(10.0);
        cellC0R1.setPrefHeight(94.0);
        cellC0R1.setPrefWidth(185.0);
        cellC0R1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC0R1.setFont(new Font(50.0));

        GridPane.setRowIndex(cellC0R2, 2);
        cellC0R2.setAlignment(javafx.geometry.Pos.CENTER);
        cellC0R2.setEllipsisString("");
        cellC0R2.setLayoutX(10.0);
        cellC0R2.setLayoutY(10.0);
        cellC0R2.setPrefHeight(94.0);
        cellC0R2.setPrefWidth(185.0);
        cellC0R2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC0R2.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC1R0, 1);
        cellC1R0.setAlignment(javafx.geometry.Pos.CENTER);
        cellC1R0.setEllipsisString("");
        cellC1R0.setLayoutX(10.0);
        cellC1R0.setLayoutY(10.0);
        cellC1R0.setPrefHeight(94.0);
        cellC1R0.setPrefWidth(185.0);
        cellC1R0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC1R0.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC1R1, 1);
        GridPane.setRowIndex(cellC1R1, 1);
        cellC1R1.setAlignment(javafx.geometry.Pos.CENTER);
        cellC1R1.setEllipsisString("");
        cellC1R1.setLayoutX(10.0);
        cellC1R1.setLayoutY(10.0);
        cellC1R1.setPrefHeight(94.0);
        cellC1R1.setPrefWidth(185.0);
        cellC1R1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC1R1.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC1R2, 1);
        GridPane.setRowIndex(cellC1R2, 2);
        cellC1R2.setAlignment(javafx.geometry.Pos.CENTER);
        cellC1R2.setEllipsisString("");
        cellC1R2.setLayoutX(10.0);
        cellC1R2.setLayoutY(10.0);
        cellC1R2.setPrefHeight(94.0);
        cellC1R2.setPrefWidth(185.0);
        cellC1R2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC1R2.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC2R0, 2);
        cellC2R0.setAlignment(javafx.geometry.Pos.CENTER);
        cellC2R0.setEllipsisString("");
        cellC2R0.setPrefHeight(94.0);
        cellC2R0.setPrefWidth(185.0);
        cellC2R0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC2R0.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC2R1, 2);
        GridPane.setRowIndex(cellC2R1, 1);
        cellC2R1.setAlignment(javafx.geometry.Pos.CENTER);
        cellC2R1.setEllipsisString("");
        cellC2R1.setLayoutX(10.0);
        cellC2R1.setLayoutY(10.0);
        cellC2R1.setPrefHeight(94.0);
        cellC2R1.setPrefWidth(185.0);
        cellC2R1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC2R1.setFont(new Font(50.0));

        GridPane.setColumnIndex(cellC2R2, 2);
        GridPane.setRowIndex(cellC2R2, 2);
        cellC2R2.setAlignment(javafx.geometry.Pos.CENTER);
        cellC2R2.setEllipsisString("");
        cellC2R2.setLayoutX(373.0);
        cellC2R2.setLayoutY(95.0);
        cellC2R2.setPrefHeight(94.0);
        cellC2R2.setPrefWidth(185.0);
        cellC2R2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cellC2R2.setFont(new Font(50.0));

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.WHITE);
        rectangle0.setHeight(67.0);
        rectangle0.setLayoutX(102.0);
        rectangle0.setLayoutY(30.0);
        rectangle0.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(75.0);

        circle.setFill(javafx.scene.paint.Color.WHITE);
        circle.setLayoutX(140.0);
        circle.setLayoutY(30.0);
        circle.setRadius(18.0);
        circle.setStroke(javafx.scene.paint.Color.WHITE);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        playerOneIcon.setFitHeight(43.0);
        playerOneIcon.setFitWidth(36.0);
        playerOneIcon.setLayoutX(122.0);
        playerOneIcon.setLayoutY(12.0);
        playerOneIcon.setPickOnBounds(true);
        playerOneIcon.setPreserveRatio(true);
        playerOneIcon.setImage(new Image(Constants.ProfileImagePath.toUri().toString()));

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.WHITE);
        rectangle1.setHeight(67.0);
        rectangle1.setLayoutX(426.0);
        rectangle1.setLayoutY(32.0);
        rectangle1.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(75.0);

        circle0.setFill(javafx.scene.paint.Color.WHITE);
        circle0.setLayoutX(464.0);
        circle0.setLayoutY(32.0);
        circle0.setRadius(18.0);
        circle0.setStroke(javafx.scene.paint.Color.WHITE);
        circle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        playerTwoIcon.setFitHeight(43.0);
        playerTwoIcon.setFitWidth(36.0);
        playerTwoIcon.setLayoutX(446.0);
        playerTwoIcon.setLayoutY(14.0);
        playerTwoIcon.setPickOnBounds(true);
        playerTwoIcon.setPreserveRatio(true);
        playerTwoIcon.setImage(new Image(Constants.ProfileImagePath.toUri().toString()));

        exitGameBtn.setLayoutX(104.0);
        exitGameBtn.setLayoutY(356.0);
        exitGameBtn.setMnemonicParsing(false);
        exitGameBtn.setPrefHeight(30.0);
        exitGameBtn.setPrefWidth(132.0);
        exitGameBtn.getStyleClass().add("custom-button");
        exitGameBtn.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        exitGameBtn.setText("Exit");

        recordBtn.setLayoutX(382.0);
        recordBtn.setLayoutY(356.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record Game");
        recordBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        recordBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        recordBtn.setWrapText(true);
        recordBtn.setFont(new Font("Impact", 15.0));

        playerOneUserName.setLayoutX(105.0);
        playerOneUserName.setLayoutY(65.0);
        playerOneUserName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOneUserName.setStrokeWidth(0.0);
        playerOneUserName.setText("player1");
        playerOneUserName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerOneUserName.setWrappingWidth(75.0);

        playerTwoUserName.setLayoutX(427.0);
        playerTwoUserName.setLayoutY(65.0);
        playerTwoUserName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTwoUserName.setStrokeWidth(0.0);
        playerTwoUserName.setText("player2");
        playerTwoUserName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerTwoUserName.setWrappingWidth(75.0);

        playerOneRole.setAlignment(javafx.geometry.Pos.CENTER);
        playerOneRole.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        playerOneRole.setLayoutX(101.0);
        playerOneRole.setLayoutY(68.0);
        playerOneRole.setPrefHeight(30.0);
        playerOneRole.setPrefWidth(75.0);
        playerOneRole.setText("X");
        playerOneRole.setFont(new Font(21.0));

        playerTwoRole.setAlignment(javafx.geometry.Pos.CENTER);
        playerTwoRole.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        playerTwoRole.setLayoutX(426.0);
        playerTwoRole.setLayoutY(68.0);
        playerTwoRole.setPrefHeight(30.0);
        playerTwoRole.setPrefWidth(75.0);
        playerTwoRole.setText("O");
        playerTwoRole.setFont(new Font(21.0));

        getChildren().add(rectangle);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(cellC0R0);
        gridPane.getChildren().add(cellC0R1);
        gridPane.getChildren().add(cellC0R2);
        gridPane.getChildren().add(cellC1R0);
        gridPane.getChildren().add(cellC1R1);
        gridPane.getChildren().add(cellC1R2);
        gridPane.getChildren().add(cellC2R0);
        gridPane.getChildren().add(cellC2R1);
        gridPane.getChildren().add(cellC2R2);
        getChildren().add(gridPane);
        getChildren().add(rectangle0);
        getChildren().add(circle);
        getChildren().add(playerOneIcon);
        getChildren().add(rectangle1);
        getChildren().add(circle0);
        getChildren().add(playerTwoIcon);
        getChildren().add(exitGameBtn);
        getChildren().add(recordBtn);
        getChildren().add(playerOneUserName);
        getChildren().add(playerTwoUserName);
        getChildren().add(playerOneRole);
        getChildren().add(playerTwoRole);

        cellC0R0.getStyleClass().add("cell");
        cellC0R1.getStyleClass().add("cell");
        cellC0R2.getStyleClass().add("cell");
        cellC1R0.getStyleClass().add("cell");
        cellC1R1.getStyleClass().add("cell");
        cellC1R2.getStyleClass().add("cell");
        cellC2R0.getStyleClass().add("cell");
        cellC2R1.getStyleClass().add("cell");
        cellC2R2.getStyleClass().add("cell");
        
        cellC0R0.setOnMouseClicked(event -> {
            cellC0R0.setText("X");
        });
        cellC0R1.setOnMouseClicked(event -> {
            cellC0R1.setText("X");
        });
        cellC0R2.setOnMouseClicked(event -> {
            cellC0R2.setText("X");
        });
        cellC1R0.setOnMouseClicked(event -> {
            cellC1R0.setText("X");
        });
        cellC1R1.setOnMouseClicked(event -> {
            cellC1R1.setText("X");
        });
        cellC1R2.setOnMouseClicked(event -> {
            cellC1R2.setText("X");
        });
        cellC2R0.setOnMouseClicked(event -> {
            cellC2R0.setText("X");
        });
        cellC2R1.setOnMouseClicked(event -> {
            cellC2R1.setText("X");
        });
        cellC2R2.setOnMouseClicked(event -> {
            cellC2R2.setText("X");
        });
    }

    public Label getCellC0R0() {
        return cellC0R0;
    }

    public Label getCellC0R1() {
        return cellC0R1;
    }

    public Label getCellC0R2() {
        return cellC0R2;
    }

    public Label getCellC1R0() {
        return cellC1R0;
    }

    public Label getCellC1R1() {
        return cellC1R1;
    }

    public Label getCellC1R2() {
        return cellC1R2;
    }

    public Label getCellC2R0() {
        return cellC2R0;
    }

    public Label getCellC2R1() {
        return cellC2R1;
    }

    public Label getCellC2R2() {
        return cellC2R2;
    }

    public ImageView getPlayerOneIcon() {
        return playerOneIcon;
    }

    public ImageView getPlayerTwoIcon() {
        return playerTwoIcon;
    }

    public Button getExitGameBtn() {
        return exitGameBtn;
    }

    public RadioButton getRecordBtn() {
        return recordBtn;
    }

    public Text getPlayerOneUserName() {
        return playerOneUserName;
    }

    public Text getPlayerTwoUserName() {
        return playerTwoUserName;
    }

    public Label getPlayerOneRole() {
        return playerOneRole;
    }

    public Label getPlayerTwoRole() {
        return playerTwoRole;
    }
    
    
}
