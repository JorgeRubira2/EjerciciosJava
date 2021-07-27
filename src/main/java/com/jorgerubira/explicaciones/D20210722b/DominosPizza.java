/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jorgerubira.explicaciones.D20210722b;

/**
 *
 * @author PC
 */
public class DominosPizza implements Pizzeria{

    @Override
    public String pedir(String producto) {
        return "Preparado " + producto;
    }

    @Override
    public void pagar() {
    }
    
}
