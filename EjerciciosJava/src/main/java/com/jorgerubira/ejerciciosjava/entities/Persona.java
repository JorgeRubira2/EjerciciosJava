/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava.entities;

import java.util.Optional;

/**
 *
 * @author PC
 */
public class Persona {
    private String nombre;
    private int edad;
    private String direccion;
    
    public void formas(){
        Optional<Integer> i1=Optional.of(2);
        Optional<Integer> i2=Optional.empty();
        Optional<Integer> i3=Optional.ofNullable(null);
        
    }
    
    public static void main(String[] args) {
        int a=2;
        long b=2;
        if (a==b){
            
        }
        Optional<Integer> i1=Optional.of(2);
        Optional<Long> i2=Optional.of(3L);
        if (i1.get().intValue() == i2.get().longValue() ){
            
        }
        
    }
    
    
    
}
