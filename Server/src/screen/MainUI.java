package screen;

/**
 *
 * @author Eng Abdullah Hegazy
 */
import client.Constants;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import network.NetworkUtils;
import network.ReceiveConnectionThread;

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
        getStylesheets().add(Constants.regbgCSSPath.toUri().toString());

        chartCategory.setSide(javafx.geometry.Side.BOTTOM);

        chartNumber.setSide(javafx.geometry.Side.LEFT);
        stackedBarChart.setLayoutX(14.0);
        stackedBarChart.setLayoutY(110.0);
        stackedBarChart.setPrefHeight(284.0);
        stackedBarChart.setPrefWidth(520.0);
        stackedBarChart.setTitle("Server Stats");

        btnStart.setLayoutX(this.getPrefWidth()/2 - 52);
        btnStart.setLayoutY(45.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(53.0);
        btnStart.setPrefWidth(104.0);
        btnStart.getStyleClass().add("custom-button-large");
        btnStart.getStylesheets().add(Constants.buttonsCSSPath.toUri().toString());
        btnStart.setText("START");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!NetworkUtils.getServerStatus()) {
                    if (NetworkUtils.startServer()) {
                        System.out.println("--- Server Socket Created -------------");
                        if (NetworkUtils.receiveConnections()) {
                            System.out.println("--- Ready to Receive Connections -------------");
                            btnStart.setText("STOP");
                        }
                    }

                } else {
                    if (NetworkUtils.stopServer()) {
                        btnStart.setText("START");
                    }
                }

            }
        });
        

        getChildren().add(stackedBarChart);
        getChildren().add(btnStart);
    }
}
