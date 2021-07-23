/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.naves;

/**
 *
 * @author PC
 */
public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
        //Velocidad < 200
        //Angulo [-20, 20]
        
        if(n.getVelocidad() == 0 && n.getMetrosRecorridos() == 0){
            n.setPropulsion(true);
        }
        if(n.getAngulo() == 0 && n.getMetrosRecorridos() == 0){
            n.girarMando(20);
        }
        if(segundos == 4){
            n.setPropulsion(false);
            n.girarMando(-13);
        }
        
        if(segundos >= 11 && segundos <= 12){
            n.setPropulsion(true);
            n.girarMando(2);
            
        }/*
        if(segundos >= 12 && segundos <= 13){
            n.setPropulsion(false);
        }
        if(segundos >= 13 && segundos <= 14){
             n.girarMando(5);
            n.setPropulsion(true);
        }*/
        if(segundos >= 13 ){
            n.setPropulsion(false);
        }
     
    }   
}
