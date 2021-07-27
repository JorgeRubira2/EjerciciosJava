/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jorgerubira.explicaciones.D20210722;

/**
 *
 * @author PC
 */
public class Informatico extends Persona{
    
    public void programar(){
    }

    @Override
    public void comer() {
        super.comer();
        System.out.println("Comer viendo youtube");
    }

    @Override
    public void trabajar() {
        System.out.println("Golpeamos el teclado impulsivamente");
    }
    
    

 
    
}
