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
public class BoardTest {
    
    public BoardTest() {
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
     * Test of isValid method, of class Board.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        int fromX = 0;
        int toX = 0;
        int fromY = 0;
        int toY = 0;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isValid(fromX, toX, fromY, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurn method, of class Board.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurn method, of class Board.
     */
    @Test
    public void testSetTurn() {
        System.out.println("setTurn");
        int turn = 0;
        Board instance = new Board();
        instance.setTurn(turn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
