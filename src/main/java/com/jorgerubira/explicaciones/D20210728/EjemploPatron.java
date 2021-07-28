package com.jorgerubira.explicaciones.D20210728;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Persona2{
    private String nombre;
    private String ciudad;

    public Persona2(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
}

public class EjemploPatron {
    
    public static void main(String[] args) {
        String a;
        
        List<Persona2> persona=List.of(new Persona2("Ana", "MAdrid"), 
                                      new Persona2("Ana Belen", "Bilbao"),
                                      new Persona2("Juan", "Murcia"),
                                      new Persona2("Juana", "Murcia")
                                      );
        String filtroCiudad="Ma";
        long i=persona.stream()
                .filter(x->x.getNombre().charAt(1)=='n')
                .filter(x->x.getNombre().startsWith("A"))
                .filter(x->x.getNombre().substring(1,3).equals("na"))
                //.filter(x->x.getCiudad().equalsIgnoreCase("Madrid"))
                .filter(x->x.getCiudad().toLowerCase().startsWith(filtroCiudad.toLowerCase()))
                .filter(x->{
                    if (true){
                        return true;    
                    }
                    if (x.getNombre().equalsIgnoreCase("Madrid")){
                        return true;
                    }
                    if (x.getNombre().equalsIgnoreCase("Zaragoza")){
                        return true;
                    }
                    return false;
                })
                .count();
        
        System.out.println(i);
        //0 Pulgar
        //2 Carita
        
        
    }
}
