/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mirce
 */
public class KingTest {
    
    public KingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class King.
     */
    @Test
    public void testIsValid() {
       // System.out.println("isValid");
        int fromX = 0;
        int fromY = 4;
        int toX = -1;
        int toY = 4;
        King instance = new King(0,4,"white");
        boolean expResult = false;
        boolean result = instance.isValid(fromX, fromY, toX, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
        @Test
        
    //regele merge pe diagonala si nu in toate directiile cate o patratica --- al doilea test e pt cand regele se poate muta in orice dir o patratica
    public void testIsValid2() {
       // System.out.println("isValid");
        int fromX = 0;
        int fromY = 4;
        int toX = 1;
        int toY = 4;
        King instance = new King(0,4,"white");
        boolean expResult = true;
        boolean result = instance.isValid(fromX, fromY, toX, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
