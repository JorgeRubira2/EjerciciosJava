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
        n.setPropulsion(true); 
        n.girarMando(40);
        if(n.getAltura()>200){
            n.setPropulsion(false);
            n.girarMando(-26);
        }
        if(n.getAltura()<100){
            n.setPropulsion(true);
            n.girarMando(20);
        }
    }
    
}
