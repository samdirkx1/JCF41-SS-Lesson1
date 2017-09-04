package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import static javafx.scene.input.KeyCode.T;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkast\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;
    
    private String[] splittedInput;
    Set<String> noDuplicates = new HashSet<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        
        String input = DEFAULT_TEXT.replaceAll("[\\s\\n]+"," ");
        splittedInput = input.split("\\s"); 
        
        //Only keep a-z and A-Z
        for (int i = 0; i < splittedInput.length; i++)
        {
            String newString = splittedInput[i].replaceAll(",|\'", "");
            splittedInput[i] = newString;
        }  
        
        for (String set : splittedInput) {
            noDuplicates.add(set);
        }
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {  
        //Show total amount of words
        System.out.println("Totaal aantal woorden:" + splittedInput.length);

        //show amount of different words
        System.out.println("Aantal verschillende woorden:" + noDuplicates.size());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        List list = new ArrayList(noDuplicates);
        Collections.sort(list, Collections.reverseOrder());
        Set resultSet = new LinkedHashSet(list);
        this.taOutput.setText(resultSet.toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        ArrayList<String> splittedInputAsArrayList = new ArrayList<>(Arrays.asList(splittedInput));

        for (String word : noDuplicates) {
            int frequency = Collections.frequency(splittedInputAsArrayList, word);
            System.out.println("Frequency of " + word + ": " + frequency);
        }
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}
