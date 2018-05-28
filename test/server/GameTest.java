/*
*
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
public class GameTest {
    
    public GameTest() {
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
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game instance = new Game();
        Board expResult = null;
        Board result = instance.getBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoard method, of class Game.
     */
    @Test
    public void testSetBoard() {
        System.out.println("setBoard");
        Board board = null;
        Game instance = new Game();
        instance.setBoard(board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTurn method, of class Game.
     */
  /*  @Test
    public void testIsTurn() {
        System.out.println("isTurn");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.isTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurn method, of class Game.
     */
  /*  @Test
    public void testSetTurn() {
        System.out.println("setTurn");
        int turn = 0;
        Game instance = new Game();
        instance.setTurn(turn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlack method, of class Game.
     */
    @Test
    public void testGetBlack() {
        System.out.println("getBlack");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getBlack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlack method, of class Game.
     */
    @Test
    public void testSetBlack() {
        System.out.println("setBlack");
        String black = "";
        Game instance = new Game();
        instance.setBlack(black);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhite method, of class Game.
     */
    @Test
    public void testGetWhite() {
        System.out.println("getWhite");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getWhite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWhite method, of class Game.
     */
    @Test
    public void testSetWhite() {
        System.out.println("setWhite");
        String white = "";
        Game instance = new Game();
        instance.setWhite(white);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int fromX = 0;
        int toX = 0;
        int fromY = 0;
        int toY = 0;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.move(fromX, toX, fromY, toY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
