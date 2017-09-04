/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcflesson1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gebruiker
 */
public class MainFormController implements Initializable {

    @FXML
    public TextArea input;
    @FXML
    public TextArea output;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    public void action_aantal() {
        
    }
    
    @FXML
    public void action_sorteer() {
        
    }
    
    @FXML
    public void action_frequentie() {
        
    }
    
    @FXML
    public void action_concordantie() {
        
    }
}
