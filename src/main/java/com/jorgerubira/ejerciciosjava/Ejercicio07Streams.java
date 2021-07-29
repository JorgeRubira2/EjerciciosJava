package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
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
        List<Double> flujo = origen.stream()
                .filter((i) -> i >= 0)
                .collect(Collectors.toList());
        return flujo;
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        int i = lista.stream().reduce(Integer.MIN_VALUE, (a, b) -> (a > b) ? a : b);
        return i;
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {

        Map<Integer, List<Integer>> poblacionCiudades = lista.stream()
                .collect(Collectors.groupingBy(lista::get));
        long salida = poblacionCiudades.entrySet().stream()
                .filter(x -> x.getValue().size() == 1)
                .count();
        return (int) salida;
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {
        List<Persona> oscenses = lista.stream()
                //.filter(p -> (p.getCiudad() == "Huesca") ? true : false)
                .filter(p -> (p.getCiudad() == "Huesca") )
                .collect(Collectors.toList());

        return oscenses;
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {
        Persona[] pers = lista.stream()
                .filter(p -> (p.getCiudad() == "Huesca") ? true : false)
                .toArray(Persona[]::new);
        return pers;

    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {
        Optional<Persona> per = lista.stream()
                .max((x, y) -> {
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
        return per;
    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {
        List<Compra> compras = lista.stream()
                .filter(p -> p.getCesta().isPresent())
                .map(x -> x.getCesta().get())
                .collect(Collectors.toList());

        return compras;
    }

    /**
     * Devuelve las edades de las personas Puede haber personas sin Cesta, estos
     * casos no hay que devolverlos. No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        int[] edades = lista.stream()
                .map(p -> p.getEdad())
                .mapToInt(Integer::intValue)
                .toArray();

        return edades;
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {

        Map<String, List<Persona>> poblacionCiudades = lista.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad));
        //Map
        List<Ciudad> ciudades = poblacionCiudades.entrySet()
                .stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().size()))
                .collect(Collectors.toList());
        return ciudades;
 }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        List<Persona> mejoresCompradores = lista.stream()
                .sorted((x, y) -> {
                    int ax = (x.getCesta().isPresent()) ? x.getCesta().get().getTotalArticulos() : 0;
                    int ay = (y.getCesta().isPresent()) ? y.getCesta().get().getTotalArticulos() : 0;
                    return ay - ax;
                }
                )
                .limit(3)
                .collect(Collectors.toList());
        return mejoresCompradores;

    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        //debería sacarse a metodo
        Map<String, List<Persona>> poblacionCiudades = lista.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad));
        //
        Set<String> ciudades = poblacionCiudades.entrySet()
                .stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().size()))
                .sorted((x, y) -> y.getPersonas() - x.getPersonas())
                .limit(3)
                .map(x -> x.getNombre())
                .collect(Collectors.toSet());
        return ciudades;

    }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     */
    public static int rango(Persona per) {
        if (per.getEdad() < 18) {
            return 0;
        } else if (per.getEdad() > 60) {
            return 2;
        } else {
            return 1;
        }
    }

    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {
        throw new UnsupportedOperationException("Pendiente Implementar");
    }

    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {
        throw new RuntimeException("Pendiente de hacer");
    }
}
