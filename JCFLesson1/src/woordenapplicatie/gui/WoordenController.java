package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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

    public String[] DEFAULT_TEXT_asArray() {
        //houd enkel woorden en spaties over
        String input = DEFAULT_TEXT.replaceAll("[\\s\\n]+", " ");
        input = input.replaceAll(",|\'", "");
        input.replaceAll("\n\n", "\n");
        input.replaceAll("\'", "");
        input.replaceAll("[\\s\\n]+", " ");
        input.replaceAll("[,|.]+", "");
        
        String[] textAsArray = input.split("\\s");
        return textAsArray;
    }

    
    public Set<String> noDuplicatesText(String input)
    {
        Set<String> noDuplicates = new HashSet<String>();
        
        for (String set : DEFAULT_TEXT_asArray()) {
            noDuplicates.add(set);
        }
        
        return noDuplicates;
    }

    
    public String DEFAULT_TEXT_Extended(int totalwords)
    {
        String result = "";
        
        String[] textAsArray = this.DEFAULT_TEXT_asArray();
        int wordNumber = 0;
                
        for (int i = 0; i < totalwords; i++)
        {
            result += textAsArray[wordNumber] + " ";
            wordNumber++;
            if (wordNumber >= textAsArray.length-1)
            {
                wordNumber = 0;
            }
        }
        
        result = result.trim();
        return result;
    }
   
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
        
        String testverlengd = this.DEFAULT_TEXT_Extended(100);
        //String kleinverlengd = this.DEFAULT_TEXT_Extended(10000);
        //String grootverlengd = this.DEFAULT_TEXT_Extended(1000000); //duurt te lang, niet proberen
        String[] testVerlengdAsArray = testverlengd.split("\\s");

        String input = DEFAULT_TEXT.replaceAll("[\\s\\n]+"," ");
        splittedInput = input.split("\\s"); 
        
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
    private void aantalAction() {  
        //Show total amount of words
        System.out.println("Totaal aantal woorden:" + splittedInput.length);

        //show amount of different words
        System.out.println("Aantal verschillende woorden:" + noDuplicates.size());
    }

    @FXML
    private void sorteerAction() {
        List list = new ArrayList(noDuplicates);
        Collections.sort(list, Collections.reverseOrder());
        Set resultSet = new LinkedHashSet(list);
        this.taOutput.setText(resultSet.toString());
    }

    @FXML
    private void frequentieAction() {
        ArrayList<String> splittedInputAsArrayList = new ArrayList<>(Arrays.asList(splittedInput));

        for (String word : noDuplicates) {
            int frequency = Collections.frequency(splittedInputAsArrayList, word);
            System.out.println("Frequency of " + word + ": " + frequency);
        }
    }

    @FXML
    private void concordatieAction() {
        String textNoWhiteSpaces = DEFAULT_TEXT.replaceAll("\n\n", "\n");
        textNoWhiteSpaces = textNoWhiteSpaces.replaceAll("\'", "");

        String[] inputPerLine = textNoWhiteSpaces.split("\n");
        
        ArrayList<String[]> wordsPerLine = new ArrayList<String[]>();
        
        for (int i = 0; i < inputPerLine.length; i++)
        {
            inputPerLine[i] = inputPerLine[i].replaceAll("[\\s\\n]+"," ");
            inputPerLine[i] = inputPerLine[i].replaceAll("[,|.]+","");
            String[] wordsOfLine = inputPerLine[i].split("\\s");
            
            wordsPerLine.add(wordsOfLine);
        }
        
        HashMap<String,String> hash = new HashMap<String,String>();
        
        //Print die con cordashian
        for (int i = 0; i < wordsPerLine.size(); i++)
        {
            for (String word : wordsPerLine.get(i))
            {
                String normalWord = Normalizer.normalize(word, Normalizer.Form.NFD);
                normalWord = normalWord.replaceAll("[^\\p{ASCII}]", "");
                normalWord = normalWord.toLowerCase();
                if(hash.containsKey(normalWord))
                {
                    hash.put(normalWord, hash.get(normalWord) + ", " + (i + 1));
                }
                else
                {
                    hash.put(normalWord, "" + (i + 1));
                }
            }
        }
        
        for(Map.Entry<String,String> entry : hash.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
   
}
