
package com.jorgerubira.ejerciciosjava;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;


public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
        List<Double> dobles = origen.stream()
        		.filter((d) -> d >= 0)
        		.collect(Collectors.toList());
        return dobles;
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
        int max = lista.stream()
        		.max((x, y) -> x - y).get();
        return max;
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
        long noRepetidos = lista.stream()
        		.distinct()
        		.count();
        return (int) noRepetidos;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        List<Persona> personas = lista.stream()
        		.filter((x) -> x.getCiudad().equalsIgnoreCase("Huesca"))
        		.collect(Collectors.toList());
        return personas;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        Persona[] personas = lista.stream()
        		.filter((x) -> x.getCiudad().equalsIgnoreCase("Huesca"))
        		.toArray(Persona[]::new);
        return personas;
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
    	Optional<Persona> persona = lista.stream()
    			.max((x, y) -> x.getCesta().get().getTotalArticulos() - y.getCesta().get().getTotalArticulos())
    			.or(() -> Optional.empty());
    	return persona;
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
        List<Compra> compras = lista.stream()
        		.filter((p) -> p.getCesta().isPresent())
        		.map((c) -> c.getCesta().get())
        		.collect(Collectors.toList());
        return compras;
    }    
    
    /**
     * Devuelve las edades de las personas
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        int[] edades = lista.stream()
        		.mapToInt(p -> p.getEdad())
        		.toArray();
        return edades;
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
    	//List<Ciudad> poblacion = lista.stream().
    	return null;
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
    	List<Persona>  personas = lista.stream()
    			.sorted((x,y) -> x.getCesta().get().getTotalArticulos() - y.getCesta().get().getTotalArticulos())
    			.limit(3)
    			.collect(Collectors.toList());
    	return personas;
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
