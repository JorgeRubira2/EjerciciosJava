/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;


interface Mostrar{
    public void suma(int a, int b);
}

interface Operacion{
    public void mensaje(int a,int b);
}

public class PruebaVoid {

    public static int oper(int a,int b){
        return b;
    }
    
    public static void main(String[] args) {
        Operacion o=PruebaVoid::oper;
        o.mensaje(2,3);
        
        
        Math.abs(3);
        
        
    }
    
}
