/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.naves;

/**
 *
    private boolean viento=false;
    private double fuerzaViento=(Math.random()-0.5)/3;
    
    private double altura=0;
    private double metrosRecorridos=0;
    private int velocidad=0;
    private double anguloNave=0;
    
    private int giro=0;
    private boolean propulsion=false;
    
    private double dx=0;
    private double dy=0;
 */
public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
        
        //por mejorar segun cantidad de viento y pa donde
        if (n.getMetrosRecorridos()==0){
            n.girarMando(45);
            n.setPropulsion(true);
        }else if(n.getMetrosRecorridos()>150 && n.getMetrosRecorridos()<600) {
            n.setPropulsion(false);
            n.girarMando(-25);
        }else if(n.getMetrosRecorridos()>600 && n.getMetrosRecorridos()<700) {
            n.setPropulsion(true);
            n.girarMando(-45);
        }else if(n.getMetrosRecorridos()>700 && n.getMetrosRecorridos()<1000) {
            n.setPropulsion(false);
            n.girarMando(10);
        }else if (n.getAltura()<220 && n.getAltura()>50){
            n.girarMando(20);
            n.setPropulsion(true);
        }
        /*//Sin viento
        if (n.getMetrosRecorridos()==0){
            n.girarMando(45);
            n.setPropulsion(true);
        }else if(n.getVelocidad()==185) {
            n.setPropulsion(false);
            n.girarMando(-25);
        }else if (n.getAltura()<220 && n.getAltura()>50){
            n.setPropulsion(true);
        }*/
        
        //throw new UnsupportedOperationException("Pendiente de hacer."); 
    }
    
}
