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
public class codeRequestTest {
    
    public codeRequestTest() {
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
     * Test of codeRequestLoginRegisterMail method, of class codeRequest.
     */
    @Test
    public void testCodeRequestLoginRegisterMail() {
        System.out.println("codeRequestLoginRegisterMail");
        String type = "";
        String nume = "";
        String parola = "";
        String id = "";
        codeRequest instance = new codeRequest();
        String expResult = "";
        String result = instance.codeRequestLoginRegisterMail(type, nume, parola, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
