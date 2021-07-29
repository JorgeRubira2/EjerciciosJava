
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;


public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
        return origen.stream().filter(x->x>=0).collect(toList());
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
        Optional<Integer> max = lista.stream().max((x,y)->x-y);
        return max.get().intValue();
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){ //los repetidos se borran y no cuentan
        return (int)lista.stream()
                    .collect(Collectors.groupingBy(x->x))
                    .entrySet()
                    .stream()
                    .filter(x-> x.getValue().size() == 1)
                    .count();
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        return lista.stream()
                .filter(x->x.getCiudad().equalsIgnoreCase("Huesca"))
                .collect(toList());
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        Persona[] hues = lista.stream()
                .filter(x->x.getCiudad().equalsIgnoreCase("Huesca"))
                .toArray(x->new Persona[x]);
                //.collect(toList());
        /*Persona[] per = new Persona[hues.size()]; //preguntar
        for (int i = 0; i < per.length; i++) {
            per[i] = hues.get(i);
        }*/
        return hues;
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
        if (!lista.isEmpty()){
            Optional<Persona> res = lista.stream()
                    .filter(x->x.getCesta().isPresent())
                    .max((x,y)->x.getCesta().get().getTotalArticulos()-y.getCesta().get().getTotalArticulos())
                    ;
            if (res.isEmpty()){
                res = lista.stream().findFirst();
            }
            return res;
        }
        return Optional.empty();
        
        
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
        List<Compra> res = lista.stream()
                .filter(x->x.getCesta().isPresent())
                .map(x->x.getCesta().get())
                .collect(toList())
                ;
        return res;
    }    
    
    /**
     * Devuelve las edades de las personas.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        return lista.stream()
                .mapToInt(x->x.getEdad())
                .toArray();
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
         return lista.stream()
                            .collect(Collectors.groupingBy(x->x.getCiudad()))
                            .entrySet()
                            .stream()
                            .map(x->new Ciudad(x.getKey(),x.getValue().size()))
                            .collect(Collectors.toList())
                            ;
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
        return lista.stream()
                .sorted((x,y)->{
                    if (x.getCesta().isPresent() && y.getCesta().isPresent()){
                        return y.getCesta().get().getTotalArticulos()-x.getCesta().get().getTotalArticulos();
                    }
                    if (x.getCesta().isEmpty()){
                        return 1;
                    }
                    if (y.getCesta().isEmpty()){
                        return -1;
                    }
                    return 0;
                })
                .limit(3)
                .collect(toList());

    }    
    
    /**
     * Top 3 ciudades. 
     * Devuelve las tres ciudades con más personas en un Set.
     * No hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista){
         return lista.stream()
                .collect(Collectors.groupingBy(x->x.getCiudad()))
                .entrySet()
                .stream()
                .sorted((x,y)->y.getValue().size()-x.getValue().size())
                .limit(3)
                .map(x->x.getKey())
                .collect(Collectors.toSet())
                ;
         //throw new RuntimeException("Pendiente de hacer");
    }    

    /**
     * Devuelve una lista con 3 objetos RangoEdad.
     * Posicion 0-Cuantas personas hay menores de 18 años.
     * Posicion 1-Cuantas personas hay entre 18 y 60 años.
     * Posicion 2-Cuantas personas hay mayores de 60 años.
     * No hace falta verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista){
       /*Map<RangoEdad.Rango, Integer>  res = lista.stream()
                .collect(Collectors.groupingBy(x->RangoEdad.Rango ,
                         Collectors.mapping(x->x.getEdad(), Collectors.toList())))
                ;
        System.out.println(res);*/
        List<RangoEdad> res = new ArrayList<>();
        long menos18 = lista.stream()
                .filter(x->x.getEdad()<18)
                .count()
                ;
        long mas18 = lista.stream()
                .filter(x->x.getEdad()>=18 && x.getEdad()<=60)
                .count()
                ;
        long mas60 = lista.stream()
                .filter(x->x.getEdad()>60)
                .count()
                ;
        res.add(new RangoEdad(RangoEdad.Rango.Menor18,(int)menos18));
        res.add(new RangoEdad(RangoEdad.Rango.Entre18y60,(int)mas18));
        res.add(new RangoEdad(RangoEdad.Rango.Mayor60,(int)mas60));
        
        return res;
    }    

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad.
     * Si una ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de personas.
     * No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista){
        Map<String, Integer> res = new HashMap<>();
        /*res = lista.stream()
                .collect(Collectors.groupingBy(x->x.getCiudad()))
                .entrySet()
                .stream()
                .filter(x->x.getValue().get)
                .filter(x->x.getValue().size()>=1)
                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue().size()))
                ;*/
        res = lista.stream()
                .filter(x->x.getEdad()>=18)
                .collect(Collectors.groupingBy(x->x.getCiudad()))
                .entrySet()
                .stream()
                //.forEach(x->System.out.println(x.getKey() + " " + x.getValue().size()))
                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue().size()))
                ;
        return res;
    }     
    
}
