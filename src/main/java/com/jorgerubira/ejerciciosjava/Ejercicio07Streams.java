
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){

        return origen.stream()
                        .filter(x->x>=0)
                        .collect(Collectors.toList());
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){

        return lista.stream().max((x,y)->x-y).get();
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
        return (int) lista.stream()
                        .collect(Collectors.groupingBy(x->x))
                        .entrySet()
                        .stream()
                        .filter(x->x.getValue().size() == 1)
                        .count();
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        return lista.stream()
                        .filter(p->p.getCiudad().equals("Huesca"))
                        .collect(Collectors.toList());
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        return lista.stream()
                .filter(p->p.getCiudad().equals("Huesca"))
                .toArray(p->new Persona[p]);
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
        return lista.stream()
                .max((p1,p2)->
                        p1.getCesta().orElse(new Compra(0, false)).getTotalArticulos()
                                -p2.getCesta().orElse(new Compra(0, false)).getTotalArticulos());
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
        return lista.stream()
                        .filter(p->p.getCesta().isPresent())
                        .map(p-> p.getCesta().get())
                        .collect(Collectors.toList());
    }    
    
    /**
     * Devuelve las edades de las personas.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        return lista.stream()
                        .mapToInt(p->p.getEdad())
                        .toArray();
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
        return lista.stream()
                        .collect(Collectors.groupingBy(p->p.getCiudad()))
                        .entrySet()
                        .stream()
                        .map(x-> new Ciudad(x.getKey(), x.getValue().size()))
                        .collect(Collectors.toList());
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
        return lista.stream()
                        .sorted((p1,p2)->{
                            if(p1.getCesta().isPresent() && p2.getCesta().isPresent()){
                                return p2.getCesta().get().getTotalArticulos()-p1.getCesta().get().getTotalArticulos();
                            } else if (p1.getCesta().isEmpty() && p2.getCesta().isPresent()){
                                return 1;
                            } else if (p1.getCesta().isPresent() && p2.getCesta().isEmpty()){
                                return -1;
                            } else {
                                return 0;
                            }
                        })
                        .limit(3)
                        .collect(Collectors.toList());

    }    
    
    /**
     * Top 3 ciudades. 
     * Devuelve las tres ciudades con más personas en un Set.
     * No hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista){
        return lista.stream()
                        .collect(Collectors.groupingBy(p->p.getCiudad()))
                        .entrySet()
                        .stream()
                        .sorted((x,y)->y.getValue().size()-x.getValue().size())
                        .map(x->x.getKey())
                        .limit(3)
                        .collect(Collectors.toSet());
    }    

    /**
     * Devuelve una lista con 3 objetos RangoEdad.
     * Posicion 0-Cuantas personas hay menores de 18 años.
     * Posicion 1-Cuantas personas hay entre 18 y 60 años.
     * Posicion 2-Cuantas personas hay mayores de 60 años.
     * No hace falta verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista){
        long r1 = lista.stream()
                            .filter(p->p.getEdad()<18)
                            .count();
        long r2 = lista.stream()
                            .filter(p->p.getEdad()>=18 && p.getEdad()<=60)
                            .count();
        long r3 = lista.stream()
                            .filter(p->p.getEdad()>60)
                            .count();

        RangoEdad menor18 = new RangoEdad(RangoEdad.Rango.Menor18, (int)r1);
        RangoEdad entre18y60 = new RangoEdad(RangoEdad.Rango.Entre18y60, (int)r2);
        RangoEdad mayor60 = new RangoEdad(RangoEdad.Rango.Mayor60, (int)r3);

        List<RangoEdad> rangos = new ArrayList<>();
        rangos.add(menor18);
        rangos.add(entre18y60);
        rangos.add(mayor60);

        return rangos;
    }    

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad.
     * Si una ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de personas.
     * No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista){
        return lista.stream()
                        .filter(p->p.getEdad()>=18)
                        .collect(Collectors.groupingBy(p->p.getCiudad()))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(x->x.getKey(), x->x.getValue().size()));
    }     
    
}
