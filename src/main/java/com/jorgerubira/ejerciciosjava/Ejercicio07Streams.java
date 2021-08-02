
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;


public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
    	return origen.stream()
                .filter((x) -> x >= 0)
                .collect(toList());
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
    	 Optional<Integer> max = lista.stream()
    			 .max((x,y)->x-y);
         return max.get();
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
    	Map<Integer, Long> Repetidos = lista.stream()
                .collect(Collectors.groupingBy((x) -> x, Collectors.counting()));
        long contar = Repetidos.values().stream()
                .filter((x) -> x == 1)
                .count();

        return (int) contar;
 }
    
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
    	List<Persona> personasHuesca = lista.stream()
                .filter(x -> x.getCiudad().equals("Huesca"))
                .collect(Collectors.toList());
    
    return personasHuesca;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
    	Persona[] per = lista.stream()
                .filter(x -> x.getCiudad().equals("Huesca"))
                .toArray(x -> new Persona[x]);
    
    return per;
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
    	Optional<Persona> resultado = lista.stream()
                .max((p1, p2) -> p1.getCesta().orElse(new Compra(0, false)).getTotalArticulos() - p2.getCesta().orElse(new Compra(0, false)).getTotalArticulos());
        return resultado;
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
    	return lista.stream()
                .filter(x -> x.getCesta().isPresent())
                .map(x -> x.getCesta().get())
                .collect(toList());
    }
      
    
    /**
     * Devuelve las edades de las personas.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
    	 int[] resultado = lista.stream()
                 .mapToInt(x -> x.getEdad())
                 .toArray();
         return resultado;
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
    	Map<String, Long> persona = lista.stream()
                .collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));

        List<Ciudad> resultado = persona.entrySet().stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().intValue()))
                .collect(Collectors.toList());

        return resultado;
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
    	List<Persona> resultado = lista.stream()
                .sorted((x,y)->y.getCesta()
                .orElse(new Compra(0,false))
                .getTotalArticulos()-x.getCesta()
                .orElse(new Compra(0,false))
                .getTotalArticulos())
                .limit(3)
                .collect(Collectors.toList());
    	
return resultado;
    }    
    
    /**
     * Top 3 ciudades. 
     * Devuelve las tres ciudades con más personas en un Set.
     * No hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista){
    	Set<String> ciudades = lista.stream()
				.collect(Collectors.groupingBy(x->x.getCiudad()))
				.entrySet()
				.stream()
				.sorted((x,y)->y.getValue().size()-x.getValue().size())
				.limit(3)
				.map(x->x.getKey())
				.collect(Collectors.toSet());
		return ciudades;
    }    

    /**
     * Devuelve una lista con 3 objetos RangoEdad.
     * Posicion 0-Cuantas personas hay menores de 18 años.
     * Posicion 1-Cuantas personas hay entre 18 y 60 años.
     * Posicion 2-Cuantas personas hay mayores de 60 años.
     * No hace falta verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista){
    	 List<RangoEdad> resultado = new ArrayList<>();//Lista de objetos
         long menos18 = lista.stream()//Posicion 0
                 .filter(x->x.getEdad()<18)
                 .count();
         long mas18 = lista.stream()//Posicion1
                 .filter(x->x.getEdad()>=18 && x.getEdad()<=60)
                 .count()
                 ;
         long mas60 = lista.stream()/*Posicion 2*/
                 .filter(x->x.getEdad()>60)
                 .count()
                 ;
         //Lista con 3 objetos RangoEdad
         resultado.add(new RangoEdad(RangoEdad.Rango.Menor18,(int)menos18));
         resultado.add(new RangoEdad(RangoEdad.Rango.Entre18y60,(int)mas18));
         resultado.add(new RangoEdad(RangoEdad.Rango.Mayor60,(int)mas60));
         
         return resultado;
    }    

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad.
     * Si una ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de personas.
     * No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista){
    	Map<String, Integer> mayores = new HashMap<>();

        Map<String, Long> grupo = lista.stream()
                .filter(x -> x.getEdad() >= 18)
                .collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));

        return mayores = grupo.entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()
                		.intValue()));
        }     
    
}
