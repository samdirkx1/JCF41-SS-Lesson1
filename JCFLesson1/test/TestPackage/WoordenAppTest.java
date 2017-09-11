package TestPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sander
 */
public class WoordenAppTest {
    
    public WoordenAppTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void WoordenTest10000()
    {
        long start = System.currentTimeMillis();
        
        //Implement test here
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
