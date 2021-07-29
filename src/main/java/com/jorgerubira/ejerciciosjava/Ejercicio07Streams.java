package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen No hace falta
     * verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen) {
        return origen.stream().filter(x -> x >= 0).collect(Collectors.toList());
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        Optional<Integer> aux = lista.stream().max((x, y) -> x - y);
        return (int) aux.get();
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {
        /*lista=lista.stream().sorted().collect(Collectors.toList());
        
        return (int)lista.stream().distinct().count(); //no contar repetidos */
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {

        return lista.stream().filter(x -> x.getCiudad().equals("Huesca")).collect(Collectors.toList());
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {

        return lista.stream().filter(x -> x.getCiudad().equals("Huesca")).toArray(x -> new Persona[x]);
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {
        return lista.stream().max((x, y) -> {
            int x1 = 0;
            int y1 = 0;
            if (x.getCesta().isPresent()) {
                x1 = x.getCesta().get().getTotalArticulos();
            }
            if (y.getCesta().isPresent()) {
                y1 = y.getCesta().get().getTotalArticulos();
            }
            return x1 - y1;
        });
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {
        return lista.stream().filter(x -> x.getCesta().isPresent())
                .map(x -> x.getCesta().get())
                .collect(Collectors.toList());
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve las edades de las personas Puede haber personas sin Cesta, estos
     * casos no hay que devolverlos. No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        return lista.stream().mapToInt(x -> x.getEdad()).toArray();
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {
        Map<String, Long> aux = lista.stream().collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));
        return aux.entrySet().stream().map((x) -> new Ciudad(x.getKey(), x.getValue().intValue())).collect(Collectors.toList());

    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        return lista.stream().limit(3)
                .sorted((x, y) -> {
                    int x1 = 0, y1 = 0;
                    if (x.getCesta().isPresent()) {
                        x1 = x.getCesta().get().getTotalArticulos();
                    }
                    if (y.getCesta().isPresent()) {
                        y1 = y.getCesta().get().getTotalArticulos();
                    }
                    return y1 - x1;
                })
                .collect(Collectors.toList());
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        Map<String, Long> aux = lista.stream().collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));
        Set<String> result = aux.entrySet().stream().sorted((x, y) -> y.getValue().intValue() - x.getValue().intValue()).limit(3).map(x -> x.getKey()).collect(Collectors.toSet());
        return result;
//throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {
        throw new RuntimeException("Pendiente de hacer");
    }

}
