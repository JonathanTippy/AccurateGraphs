package com.jonathantippy.AccurateGraphs;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class ExampleTestFXTest {

    private Label label;

    @Start
    public void start(Stage stage) {
        label = new Label("Example Test");
        Button button = new Button("Test!");

        button.setOnAction(e -> label.setText("Tested!"));

        VBox vbox = new VBox(label, button);
        Scene scene = new Scene(vbox, 200, 100);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void exampleTestFXTest(FxRobot robot) {
        robot.clickOn("Test!");
        
    }
}