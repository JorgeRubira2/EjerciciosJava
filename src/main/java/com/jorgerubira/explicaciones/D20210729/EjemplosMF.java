/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class EjemplosMF {
    public static void main(String[] args) {
        List<Persona> lista = List.of(
                new Persona("Ana", "Madrid", 42),
                new Persona("Juan", "Zaragoza", 52),
                new Persona("Pepe", "Huesca", 23),
                new Persona("Fran", "Madrid", 23)
        );
        
        String nombre=lista.stream()
                .map(x->x.getNombre())
                .collect(Collectors.joining(","));
        
        System.out.println(nombre);
        //Ana
        //Juan
        //Pepe
        //Fran
        //Ana,Juan,Pepe,Fran
        
        List<Integer> edades=List.of(4,3,5,2);
        Optional<Integer> i=edades.stream()
                                   .reduce((x,y)->x+y);
        
        if (i.isPresent()){
            System.out.println(i.get());
        }
        
        Optional<String> nombre2=lista.stream()
                .map(x->x.getNombre())
                .reduce((x,y)->x+y + ",");
        System.out.println(nombre2.get());

        Optional<Integer> max=edades.stream()
                                   .reduce((x,y)->x>y?x:y);
        System.out.println(max.get());
        //5
        
    }
}
