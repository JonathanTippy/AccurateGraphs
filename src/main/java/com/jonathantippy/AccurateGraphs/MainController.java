package com.jonathantippy.AccurateGraphs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Platform;

//import com.jonathantippy.RationalRange;



public class MainController {

    @FXML
    private Slider factorSelector;

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

        factorSelector.setMin(0);
        factorSelector.setMax(10);
        factorSelector.setValue(1);

        renderLoop();
    }

    @FXML
    void renderLoop() {
        render();
        Platform.runLater(() -> renderLoop());
    }


    @FXML
    void render() {

        

        double factor = factorSelector.getValue();

        double[] screenOffset = {1/2,1/2};

        double chartWidth = chart.getWidth();
        double chartHeight = chart.getHeight();

        GraphicsContext gc = chart.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, chartWidth, chartHeight);


        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        
        for (int pixel=0; pixel<chartWidth; pixel++) {

            double pixelWidth = 1 / chartWidth;
            double lowerBound = pixel * pixelWidth;
            double upperBound = (pixel + 1) * pixelWidth;

            double lowerAnswer = lowerBound * factor;
            double upperAnswer = upperBound * factor;

            double lowerAnswerPixel = lowerAnswer * chartWidth;
            double upperAnswerPixel = upperAnswer * chartWidth;

            double lineDensity = pixelWidth/(upperAnswer-lowerAnswer);
            
            int color;
            
            if (lineDensity<1) {
                color = (int) (lineDensity * 255);
            } else {
                color = 255;
            }

            color = 255 - color; // must invert for black
            

            gc.setStroke(Color.rgb(color, color, color));

            gc.strokeLine(pixel + 0.5, lowerAnswerPixel + 0.5, pixel + 0.5, upperAnswerPixel+0.5);
        }
    }

}
