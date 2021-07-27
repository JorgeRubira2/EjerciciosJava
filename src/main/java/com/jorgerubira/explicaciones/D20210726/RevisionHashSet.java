/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210726;

import java.util.HashSet;
import java.util.Set;

//Alt+Intro
class Per {
    
    private final static int UUID=(int)(2222*Math.random());
    
    private String nombre;
    private int edad;

    public Per(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return UUID; //Equals
    }

    @Override
    public boolean equals(Object obj) {
        return nombre.equals(((Per)obj).nombre);
    }

    
}



public class RevisionHashSet {
    public static void main(String[] args) {
        //
        Object o1=new Per("Juan", 30);
        Object o2=new Per("Juan", 30);
        if (o1.hashCode()==o2.hashCode()){
            
        }
        
        //Ctrl+Mayu+i
        //Ctrl+Espa
        Set<Per> conjunto=new HashSet<Per>();
        conjunto.add(new Per("Juan", 30));
        conjunto.add(new Per("Ana", 30));
        conjunto.add(new Per("Juan", 30));
        
        for (Per per : conjunto) {
            System.out.print(per.getNombre() + " ");
        }
        //Ana Juan Juan 
        
    }
}
