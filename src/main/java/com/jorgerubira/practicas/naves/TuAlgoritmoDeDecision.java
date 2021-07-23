/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.naves;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 * 
 */
public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
       n.setPropulsion(true);
       boolean exit= false;
       LocalTime currentTime= LocalTime.now();
        try {
            while (!exit){
                Thread.sleep(100L);
                LocalTime local = LocalTime.now();
                Thread.sleep(10000L);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TuAlgoritmoDeDecision.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
