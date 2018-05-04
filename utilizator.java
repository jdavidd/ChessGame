/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author c-tin
 */
public class utilizator {
    private final int id;
    private final String nume;
    
    public utilizator(int id, String nume){
        this.id=id;
        this.nume=nume;
    }
    
    public int getID(){
        return id;
    }
    
}
