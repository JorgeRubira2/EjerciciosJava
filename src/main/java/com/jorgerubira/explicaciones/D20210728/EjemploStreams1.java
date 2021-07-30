package com.jorgerubira.explicaciones.D20210728;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Persona1{
    private String nombre;
    private int edad;

    public Persona1(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}

public class EjemploStreams1 {
    public static void main(String[] args) {
        List<String> elementos=new ArrayList<>(List.of("Ana", "Juan", "Pepe"));
            
        //Programacion clasica
        for (int i = 0; i < elementos.size(); i++) {
            String valor = elementos.get(i);
            elementos.set(i, valor.toUpperCase());
            System.out.print(elementos.get(i) + " ");
        }
        
        long contador=elementos.stream().filter(x->x.startsWith("A")).count();
                            
        
        //ANA JUAN PEPE
        
        System.out.println("");
        //Programacion moderna
        List<String> elementos2=List.of("Ana", "Juan", "Pepe");
        elementos2.stream()
                  .map((x)->x.toUpperCase()) //Transformar
                  .forEach((x)->System.out.print(x + " ")); //Visualizar
      
        List<String> resultado=elementos2.stream()
                                        .map((x)->x.toUpperCase()) //Transformar
                                        .collect(Collectors.toList()); //Covierte en lista;

        
        elementos2.stream()
                  .filter((x)->x.startsWith("A"))  //Filtrar información
                  .map((x)->x.toUpperCase()) //Transformar
                  .forEach((x)->System.out.print(x + " ")); //Visualizar
        
        List<Persona1> res2=elementos2.stream()
                                      .filter((x)->x.startsWith("A"))  //Filtrar información
                                      .map((x)->new Persona1(x,0) ) //Transformar
                                      .collect(Collectors.toList());
        
        res2.stream().forEach(x->System.out.print("P:" + x.getNombre()));
        //P:Ana
    }
}
