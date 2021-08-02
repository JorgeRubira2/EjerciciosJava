/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class EjemploGroupBy {
    public static void main(String[] args) {
        List<Persona> lista = List.of(
                new Persona("Ana", "Madrid", 42),
                new Persona("Juan", "Zaragoza", 52),
                new Persona("Pepe", "Huesca", 23),
                new Persona("Fran", "Madrid", 23)
        );
        Map<String, List<Persona>> res=lista.stream()
                                        .collect(Collectors.groupingBy(
                                                x->x.getCiudad(), Collectors.toList()
                                        ));
        
        res.values().forEach(x->System.out.println(x));

        Map<String, Long> res2=lista.stream()
                                        .collect(Collectors.groupingBy(
                                                x->x.getCiudad(), Collectors.counting()
                                        ));

        Map<String, IntSummaryStatistics> res3=lista.stream()
                                .collect(Collectors.groupingBy(
                                    x->x.getCiudad(), Collectors.summarizingInt(x->x.getEdad())
                                ));
        
        res3.values().forEach(x->System.out.println(x.getSum()));
        
    }
}
