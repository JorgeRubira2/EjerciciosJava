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
	public double fuerzaViento=(Math.random()-0.5)/3;
    @Override
    public void decision(INave n, int segundos) {
       n.setPropulsion(true);
       n.girarMando(45);
       
       if (fuerzaViento <0) {
    	   if(n.getAltura()>200) {
        	   n.setPropulsion(false);
        	   n.girarMando(-45);
        	   n.getAltura();
           }
    	   
       }else if(fuerzaViento==0) {
    	   if(n.getAltura()>90) {
        	   n.setPropulsion(false);
        	   n.girarMando(-45);
        	   n.getAltura();
           }
    	   
       }else if(fuerzaViento >0){
    	   if(n.getAltura()>100) {
        	   n.setPropulsion(false);
        	   n.girarMando(-45);
        	   n.getAltura();
           }
       }
       }
       
    }
    

