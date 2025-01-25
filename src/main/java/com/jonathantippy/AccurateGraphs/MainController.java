package com.jonathantippy.AccurateGraphs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.canvas.GraphicsContext;



public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Canvas chart;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'main.fxml'.";
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main.fxml'.";
        assert x2 != null : "fx:id=\"x2\" was not injected: check your FXML file 'main.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";

        double chartWidth = chart.getWidth();
        double chartHeight = chart.getHeight();

        GraphicsContext gc = chart.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.fillRect(0, 0, chartWidth, chartHeight);

        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2.0);
        for (int i=0; i<chartWidth; i+=4) {
            gc.strokeLine(i + 0.5, 0.0, i + 0.5, chartHeight);
        }

        //gc.setFill(Color.GREEN);

        /*for (int i=0; i<chartWidth;i+=8) {
            gc.fillRect(i, 0, 4, chartHeight);
        }*/

        // fillRect uses x, y pos and x, y size

        /*for (int i=0; i<chartWidth;i++) {
            if (i%2==0) {
                gc.fillRect(0, i, 0, chartHeight);
            }

        }*/
        /*
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillRect(50, 50, 200, 100);
        gc.strokeRect(50, 50, 200, 100);
        */
    }

}
