
package main.java.com.jorgerubira.ejerciciosjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.jorgerubira.ejerciciosjava.pojo.Persona;


public class Ejercicio06Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
    	 List<Double> l =(List<Double>) origen.stream()
    	           .filter((i)->i>0);
    	    return l;
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
       int max = 0; 
       
    	
       return max;
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devolver la lista ordenada por ciudad y si tienen la misma ciudad por nombre.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> ordenarListaPorCiudadYNombre(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }       
    
}
