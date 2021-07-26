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
        //Angulo [-20,20]
        
        
        n.setPropulsion(true);
        n.girarMando(45);
        if (n.getAltura()>300){
            n.setPropulsion(false);
            n.girarMando(45);
        }
    }
    
}
