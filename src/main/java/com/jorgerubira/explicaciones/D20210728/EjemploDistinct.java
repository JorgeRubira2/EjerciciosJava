/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210728;

import java.util.List;

/**
 *
 * @author PC
 */
public class EjemploDistinct {
    
    public void mostrar(String x){
        System.out.print(x);
    }
    
    public int resta(int a, int b){
        return a-b;
    }

    public void mostrarLista2(List<Integer> lista){
        lista.stream()
             .sorted(this::resta)       //.sorted((x,y)->this::resta(x,y))
             .forEach(System.out::print);
    }

    
    public void mostrarLista(List<String> lista){
        lista.stream().forEach(x->this.mostrar(x));
        
        lista.stream().forEach(this::mostrar);
    }
    
    
    
    public static void main(String[] args) {
        List<Integer> lista=List.of(12,3,4,5);
        EjemploDistinct obj=new EjemploDistinct();
        obj.mostrarLista2(lista);
        
        
        List<Persona5> personas=List.of(
                    new Persona5("Juan", 20),
                    new Persona5("Ana", 64, new Compra3(4, true)),
                    new Persona5("Pepe", 54, new Compra3(2, false)),
                    new Persona5("Ana", 24, new Compra3(4, true)),
                    new Persona5("Ana", 34, new Compra3(4, true))
        ); 
        
        List<String> ciudades=List.of("Madrid", "Almeria", "Zaragoza", "Madrid");
        
        ciudades.stream().forEach(x->System.out.println(x));
        
        ciudades.stream().forEach(System.out::println);
        ciudades.stream().forEach(x->System.out.println(x));

        
        
        /*ciudades.stream()
                .distinct()
                .forEach(x->System.out.println(x));*/
        //5 Pulgar 3 carita
        //equals ->
        personas.stream()
                .distinct() //Persona p1, Persona p2  hashcode - equals
                .forEach(x->System.out.println(x.getNombre() + " " + x.getEdad()));        
        
        //Juan 20
        //Ana 64
        //Pepe 54
        
        
    }
        
}
