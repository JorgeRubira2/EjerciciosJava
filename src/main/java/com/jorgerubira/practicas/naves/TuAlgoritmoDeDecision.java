package com.jorgerubira.practicas.naves;

import java.lang.System.Logger;
import java.time.LocalTime;
import java.util.logging.Level;


public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
       n.setPropulsion(true);
       boolean exit= false;
       LocalTime currentTime= LocalTime.now();

            while (!exit){
           try {
               Thread.sleep(100L);
           } catch (InterruptedException ex) {
               java.util.logging.Logger.getLogger(TuAlgoritmoDeDecision.class.getName()).log(Level.SEVERE, null, ex);
           }
                LocalTime local = LocalTime.now();
           try {
               Thread.sleep(10000L);
           } catch (InterruptedException ex) {
               java.util.logging.Logger.getLogger(TuAlgoritmoDeDecision.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
       
    }
    }
