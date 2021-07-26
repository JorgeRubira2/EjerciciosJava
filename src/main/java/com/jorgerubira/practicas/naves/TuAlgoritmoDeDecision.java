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
        if(n.getAltura()<200){
            n.setPropulsion(true); 
            n.girarMando(45);
        }
        if(n.getAltura()>250 || n.getMetrosRecorridos()>420){
            n.setPropulsion(false);
            n.girarMando(-30);
        }
        if(n.getVelocidad()>150 && n.getAltura()<200 && n.getMetrosRecorridos()<1100){
            n.setPropulsion(true);
            n.girarMando(30);
        }
        if(segundos>8)
        n.setPropulsion(false);
       
        
        
      
    }
    
}
