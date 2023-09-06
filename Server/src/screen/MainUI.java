package screen;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import server.ServerConnection;

public class MainUI extends AnchorPane {

    protected final CategoryAxis chartCategory;
    protected final NumberAxis chartNumber;
    protected final StackedBarChart stackedBarChart;
    protected final Button btnStart;
    protected final Button btnStop;

    public MainUI() {

        chartCategory = new CategoryAxis();
        chartNumber = new NumberAxis();
        stackedBarChart = new StackedBarChart(chartCategory, chartNumber);
        btnStart = new Button();
        btnStop = new Button();

        setId("AnchorPane");
        setPrefHeight(415.0);
        setPrefWidth(547.0);
        getStylesheets().add("/server/../resources/regbg.css");

        chartCategory.setSide(javafx.geometry.Side.BOTTOM);

        chartNumber.setSide(javafx.geometry.Side.LEFT);
        stackedBarChart.setLayoutX(14.0);
        stackedBarChart.setLayoutY(110.0);
        stackedBarChart.setPrefHeight(284.0);
        stackedBarChart.setPrefWidth(520.0);
        stackedBarChart.setTitle("Server Stats");

        btnStart.setLayoutX(60.0);
        btnStart.setLayoutY(45.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(53.0);
        btnStart.setPrefWidth(104.0);
        btnStart.getStyleClass().add("custom-button-large");
        btnStart.getStylesheets().add("/server/../resources/buttons.css");
        btnStart.setText("START");

        btnStop.setLayoutX(412.0);
        btnStop.setLayoutY(45.0);
        btnStop.setMnemonicParsing(false);
        btnStop.getStyleClass().add("custom-button-large");
        btnStop.getStylesheets().add("/server/../resources/buttons.css");
        btnStop.setText("Stop");

        getChildren().add(stackedBarChart);
        getChildren().add(btnStart);
        getChildren().add(btnStop);
        
        btnStart.setOnAction(event -> {
            ServerConnection connection = new ServerConnection();
            connection.startServer();
        });
    }
}
