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
       //Works 
       if(n.getAltura()<230 && n.getAngulo() != 60 && n.getMetrosRecorridos()<900){
           n.setPropulsion(true);
           n.girarMando(45);
       }else{
           n.setPropulsion(false);
           n.girarMando(-25);
       }
       
       
    }
    
}
