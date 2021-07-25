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
        //velocidad < 200
        //Angulo [-20, 20]
        //Una vez conseguido, se activa el modo viento
        
        n.setPropulsion(true);
        n.girarMando(45);
        
//        if (n.getFuerzaViento()<0){
//            
//        }
                        
        if (n.getAltura()>235){
            n.setPropulsion(false);
            n.girarMando(-45);
        }
        
        if (n.getAltura()<100){
            n.setPropulsion(true);              
        }
                      
    }
    
}
