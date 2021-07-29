/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class EjemploMaps {
    public static void main(String[] args) {
        Map<String, Persona> mapa=Map.of(
                                        "Ana", new Persona("Ana", "Huesca", 50),
                                        "Juan", new Persona("Juan", "Madrid", 13),
                                        "Fran", new Persona("Fran", "Madrid", 52),
                                        "Pepe", new Persona("Pepe", "Zaragoza", 34)
                                  );

        
        
        //Obtener la ciudad de la persona la persona mas mayor.
        Map<String, Persona> mapa2=new HashMap<>();
        String ciudad2=mapa2.values().stream()
                                   .max((x,y)->x.getEdad()-y.getEdad())
                                   .orElse(new Persona("Nadie","Ningun sitio")).getCiudad();

        System.out.println(ciudad2);

        //Obtener la ciudad de la persona la persona mas mayor.
        Optional<Persona> mayor=mapa.values().stream()
                                   .max((x,y)->x.getEdad()-y.getEdad());
        if (mayor.isPresent()){
            String ciudad=mayor.get().getCiudad();
        }
        
        
        //Obtener el nombre de las personas de Madrid.
        List<String> nombres=mapa.values().stream()
                                          .filter(x->x.getCiudad().equals("Madrid"))
                                          .map(x->x.getNombre())
                                          .collect(Collectors.toList());

        //Obtener los mayore de edad.
        Set<Persona> mayores=mapa.values().stream()
                                          .filter(x->x.getEdad()>=18)
                                          .collect(Collectors.toSet());
        
        //Cuantos hay en zaragoza
        long total=mapa.values().stream()
                               .filter(x->x.getCiudad().equals("Zaragoza"))
                               .count();
        System.out.println(total);

        

        
        
    }
}
