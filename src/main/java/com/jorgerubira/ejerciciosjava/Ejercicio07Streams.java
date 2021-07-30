
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;


public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Devuelve las edades de las personas
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Top 3 ciudades. 
     * Devuelve las tres ciudades con más personas en un Set.
     * No hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }    

    /**
     * Devuelve una lista con 3 objetos RangoEdad.
     * Posicion 0-Cuantas personas hay menores de 18 años.
     * Posicion 1-Cuantas personas hay entre 18 y 60 años.
     * Posicion 2-Cuantas personas hay mayores de 60 años.
     * No hace falta verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }    

    
}
