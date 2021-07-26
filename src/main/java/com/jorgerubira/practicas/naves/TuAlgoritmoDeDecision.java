package com.jorgerubira.practicas.naves;

import java.lang.System.Logger;
import java.time.LocalTime;
import java.util.logging.Level;


public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
 
    if(segundos>2){
//            n.setPropulsion(false);
//            n.girarMando(-45);
//        }
//        if(segundos>5){
//            n.girarMando(0);
//            n.setPropulsion(true);
//        }
//        if(segundos>6){
//            n.setPropulsion(false);
//        }

        if(n.getAltura()<100 || n.getMetrosRecorridos()<200){
            n.setPropulsion(true);
        } else {
            n.setPropulsion(false);
        }
        if(segundos<3){
            n.girarMando(45);
        }else {
            n.girarMando(-45);
        }
    }
        
    }
}
