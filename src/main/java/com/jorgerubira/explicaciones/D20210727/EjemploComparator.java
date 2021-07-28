/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210727;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


class Per3 {
    private String nombre;
    private int edad;

    public Per3(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
  
    
}

public class EjemploComparator {
    public static void main(String[] args) {
        List<Per3> lista=new ArrayList<>();
        lista.add(new Per3("Juan", 20));
        lista.add(new Per3("Ana", 70));        
        lista.add(new Per3("Fran", 10));
        lista.add(new Per3("Ana", 20));        
        
        //lista.sort((p1,p2)-> p1.getEdad()-p2.getEdad() );
        //lista.sort((p1,p2)-> p1.getNombre().compareTo(p2.getNombre()));
        lista.sort((p1,p2)-> {
            int primeraComparacion=p1.getNombre().compareTo(p2.getNombre());
            if (primeraComparacion!=0){
                return primeraComparacion;
            }else{
                return (p1.getEdad()-p2.getEdad());
            }
        });
        
        for (Per3 per3 : lista) {
            System.out.println(per3.getNombre() + " " + per3.getEdad());
        }

    }

}
