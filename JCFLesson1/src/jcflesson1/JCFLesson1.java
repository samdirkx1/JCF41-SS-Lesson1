/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcflesson1;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Gebruiker
 */
public class JCFLesson1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MainForm.fxml"));

       Pane myPane = (Pane)myLoader.load();

       Scene myScene = new Scene(myPane);        
       primaryStage.setScene(myScene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
