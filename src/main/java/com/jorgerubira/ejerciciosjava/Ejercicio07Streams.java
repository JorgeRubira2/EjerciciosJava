package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen No hace falta
     * verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen) {
        return origen.stream().filter((x) -> x >= 0).collect(toList());
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        Optional<Integer> valorMax = lista.stream().max((x, y) -> x - y);
        return valorMax.get();
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {
        Map<Integer, Long> aux = lista.stream().collect(Collectors.groupingBy((x) -> x, Collectors.counting()));

        return (int) aux.values().stream().filter((x) -> x == 1).count();
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {
        return lista.stream()
                .filter((x) -> x.getCiudad().equals("Huesca"))
                .toList();
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {
        return lista.stream()
                .filter((x) -> x.getCiudad().equals("Huesca"))
                .toArray((x) -> new Persona[x]);
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {
        //orEslse() igual que el get(), pero este permite crear 
        return lista.stream()
                .max((x, y) -> x.getCesta().orElse(new Compra(0, true)).getTotalArticulos() - y.getCesta().orElse(new Compra(0, true)).getTotalArticulos());
    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {
        return lista.stream()
                .filter((x -> x.getCesta().isPresent()))
                .map(x -> x.getCesta().get())
                .toList();
    }

    /**
     * Devuelve las edades de las personas. No hace falta verificar si valen
     * nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        return lista.stream()
                .mapToInt((x) -> x.getEdad())
                .toArray();
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {
        Map<String,Long> aux = lista.stream()
                .collect(Collectors.groupingBy((x)->x.getCiudad(),Collectors.counting()));
        
        return aux.entrySet().stream().
                map((x)->new Ciudad(x.getKey(),(int)(long)x.getValue()))
                .collect(toList());
    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        return lista.stream()
                .sorted((x,y)->y.getCesta().orElse(new Compra(0,false)).getTotalArticulos()-x.getCesta().orElse(new Compra(0,false)).getTotalArticulos())
                .limit(3)
                .collect(toList());
    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        Map<String,Long> aux = lista.stream().
                collect(Collectors.groupingBy(x->x.getCiudad(),Collectors.counting()));
        Set<String> resultado = aux.entrySet().stream()
                .sorted((x,y)-> y.getValue().intValue() -x.getValue().intValue())
                .limit(3)
                .map(x->x.getKey())
                .collect(Collectors.toSet());
        return resultado;
         
   }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {
        List<RangoEdad> edades = new ArrayList<>();
        
        long pos1 = lista.stream()
                .filter(x->x.getEdad() < 18)
                .count();
        
        long pos2 = lista.stream()
                .filter(x->x.getEdad() >= 18 && x.getEdad() <= 60)
                .count();
        
        long pos3 = lista.stream()
                .filter(x->x.getEdad() > 60)
                .count();
        
        edades.add(new RangoEdad(RangoEdad.Rango.Menor18, (int)pos1));
        edades.add(new RangoEdad(RangoEdad.Rango.Entre18y60, (int)pos2));
        edades.add(new RangoEdad(RangoEdad.Rango.Mayor60, (int)pos3));
        
        return edades;
       
    }

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad. Si una
     * ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de
     * personas. No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {
        Map<String, Long> aux = lista.stream()
                .filter(x->x.getEdad() >= 18)
                .collect(Collectors.groupingBy(x->x.getCiudad(),Collectors.counting()));
        
        return  aux.entrySet().stream()
                .collect(Collectors.toMap(x->x.getKey(),x->x.getValue().intValue()));
    }

}
