package TestPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.gui.WoordenController;

/**
 *
 * @author Sander
 */
public class WoordenAppTest {
    
    WoordenController wc = new WoordenController();
    
    public WoordenAppTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    
    @Test
    public void WoordenTestGenerate100()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        String testString = wc.DEFAULT_TEXT_Extended(100);
        String[] testStringAsArray = testString.split("\\s");
        int testWordCount = testStringAsArray.length;
        
        Assert.assertSame("niet 100 in testGenerate100", 100, testWordCount);
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestGenerate10000()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        String testString = wc.DEFAULT_TEXT_Extended(10000);
        String[] testStringAsArray = testString.split("\\s");
        int testWordCount = testStringAsArray.length;
        
        Assert.assertSame("niet 10000 in testGenerate10000", 10000, testWordCount);
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestGenerate1000000()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        String testString = wc.DEFAULT_TEXT_Extended(1000000);
        String[] testStringAsArray = testString.split("\\s");
        int testWordCount = testStringAsArray.length;
        
        Assert.assertSame("niet 1000000 in testGenerate1000000", 1000000, testWordCount);
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestAantalDefault()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        //show total amount of words (expected = 68)
        String[] testDefaultWoorden = wc.DEFAULT_TEXT_asArray();
        System.out.println("Totaal aantal woorden:" + testDefaultWoorden.length);
        Assert.assertSame("Totaal aantal woorden klopt niet", 68, testDefaultWoorden.length);

        //show amount of different words
        //System.out.println("Aantal verschillende woorden:" + noDuplicates.size());
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestSorteerDefault()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestFrequentieDefault()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
                
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    @Test
    public void WoordenTestconcordatieDefault()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
                
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
