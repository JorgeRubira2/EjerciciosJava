/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210728;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
interface ICalculo{
    public void IPrueba(int a, int b);
}

public class EjemploComparator {
    public static void main(String[] args) {
        
        //ICalculo ob=(a,b)->a+b;
        
        List<Persona4> personas=List.of(
                    new Persona4("Juan"),
                    new Persona4("Ana", new Compra2(4, true)),
                    new Persona4("Pepe", new Compra2(2, false))
        ); 
        
        Math.max(2, 3);
        
        Persona4 p4[]= personas.toArray(x->new Persona4[x]);
        Persona4 p4b[]= personas.toArray(Persona4[]::new);
        
        /*List<Persona4> orden=personas.stream()
                                     .sorted((x,y)->x.getNombre().compareTo(y.getNombre()))
                                     .collect(Collectors.toList());*/
        
        List<Persona4> orden=personas.stream()
                                     .sorted((x,y)->{
                                         int x1=0;//No tuvieran compra
                                         int y1=0;//No tuvieran compra
                                         if (x.getCompra().isPresent()){
                                             x1=x.getCompra().get().getTotalProductos();
                                         }
                                         if (y.getCompra().isPresent()){
                                             y1=y.getCompra().get().getTotalProductos();
                                         }
                                         return (y1-x1);
                                     })
                                     .collect(Collectors.toList());
        //Ana 4 Juan Pepe 2
        //Ana 4 Pepe 2 Juan 
        orden.stream()
             .forEach(x-> {
                 System.out.print(x.getNombre() + " ");
                 if (x.getCompra().isPresent()){
                     System.out.print(x.getCompra().get().getTotalProductos() + " ");
                 }
              });

        //Ana Juan Pepe 
        //Juan Pepe 2 Ana 4 
        
    }
}
