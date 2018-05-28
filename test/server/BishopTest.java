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
public class BishopTest {
    
    public BishopTest() {
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
     * Test of isValid method, of class Bishop.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        int fromX = 0;
        int fromY = 2;
        int toX = 1;
        int toY = 3;
        Bishop instance = new Bishop(0,2,"black");
        boolean expResult = true;
        boolean result = instance.isValid(fromX, fromY, toX, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        public void testIsValid2() {
        System.out.println("isValid");
        int fromX = 3;
        int fromY = 2;
        int toX = 4;
        int toY = 3;
        Bishop instance = new Bishop(0,2,"black");
        boolean expResult = true;
        boolean result = instance.isValid(fromX, fromY, toX, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
