package com.jonathantippy.AccurateGraphs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

 
    @Override
    public void start(Stage stage) {
       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/jonathantippy/AccurateGraphs/main.fxml"));
            Scene scene = new Scene(root);
            stage.setResizable(true);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
