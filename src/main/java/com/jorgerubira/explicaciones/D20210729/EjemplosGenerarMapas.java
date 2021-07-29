/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.HashSet;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class EjemplosGenerarMapas {

    public static void main(String[] args) {
        List<Persona> lista = List.of(
                new Persona("Ana", "Madrid", 42),
                new Persona("Juan", "Zaragoza", 52),
                new Persona("Pepe", "Huesca", 23),
                new Persona("Fran", "Madrid", 23)
        );

        
        //Obtener la media directamente
        Map<String, Double> mapaContarPersonas3=
                                lista.stream()
                                     .collect(Collectors.groupingBy(
                                             x->x.getCiudad(),
                                             Collectors.averagingLong(x->x.getEdad())
                                     ));
        mapaContarPersonas3.values().forEach(x-> System.out.print( x + " "));

        //52.0 23.0 32.5 52.0  

        
        //Obtener summary (Sum, Count, Promedio)
        Map<String, LongSummaryStatistics> mapaContarPersonas2=
                                lista.stream()
                                     .collect(Collectors.groupingBy(
                                             x->x.getCiudad(),
                                             Collectors.summarizingLong(x->x.getEdad())
                                     ));
        mapaContarPersonas2.values().forEach(
                x->System.out.println(x.getAverage())
        );
        
        

        //Contar personas
        Map<String, Long> mapaContarPersonas=
                                lista.stream()
                                     .collect(Collectors.groupingBy(
                                             x->x.getCiudad(),
                                             Collectors.counting()
                                     ));
        System.out.println(mapaContarPersonas.size());
        mapaContarPersonas.values().forEach(System.out::print);
        
        //Utilizar el nombre como clave
        Map<String, List<Persona>> mapa2 = lista.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getCiudad(),
                        Collectors.toList()
                ));

        System.out.println(mapa2.size());
        mapa2.entrySet().stream()
                .forEach(xLis -> {
                    System.out.println("Personas de " + xLis.getKey());
                    xLis.getValue().stream().forEach(
                            persona -> System.out.println(persona.getNombre())
                    );
                }
                );


        
        //3 pulgar
        //4 carita
        //Utilizar el nombre como clave
        Map<String, Persona> mapa = lista.stream()
                .collect(Collectors.toMap(
                        x -> x.getNombre(),
                        x -> x
                ));

        mapa.entrySet().forEach(x
                -> System.out.println(x.getKey() + " " + x.getValue().getNombre())
        );

        //Duplicate key Madrid (attempted merging values com.jorgerubira.ejerciciosjava.pojo.Persona@2752f6e2 and
    }
}
