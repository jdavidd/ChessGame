/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
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
public class clientTest {
    
    public clientTest() {
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
     * Test of read method, of class client.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String expResult = "";
        String result = client.read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class client.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        String codedMessage = "";
        client.send(codedMessage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readplayer method, of class client.
     */
    @Test
    public void testReadplayer() {
        System.out.println("readplayer");
        ArrayList<String> expResult = null;
        ArrayList<String> result = client.readplayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readroom method, of class client.
     */
    @Test
    public void testReadroom() {
        System.out.println("readroom");
        ArrayList<String> expResult = null;
        ArrayList<String> result = client.readroom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listenerStart method, of class client.
     */
    @Test
    public void testListenerStart() {
        System.out.println("listenerStart");
        client.listenerStart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectToServer method, of class client.
     */
    @Test
    public void testConnectToServer() throws Exception {
        System.out.println("connectToServer");
        client instance = new client();
        instance.connectToServer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visible method, of class client.
     */
    @Test
    public void testVisible() {
        System.out.println("visible");
        client.visible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class client.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        client.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
