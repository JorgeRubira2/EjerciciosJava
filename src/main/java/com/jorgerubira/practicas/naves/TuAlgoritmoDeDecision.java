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

    //velocidad <200
    //angulo -20,20
    
    
    @Override
    public void decision(INave n, int segundos) {
       n.setPropulsion(true);
       n.girarMando(45);
       if(n.getAltura() > 500){
           n.setPropulsion(false);
           n.girarMando(-45);
       }
       if(segundos > 5){
     n.setPropulsion(false);
    
       } if(n.getVelocidad() >130){
     n.setPropulsion(false);
    
       }
       
    }
    
}
