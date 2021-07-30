package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
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

        return origen.stream()
                .filter((x) -> x >= 0)
                .collect(toList());

        // throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {

        Optional<Integer> maximo = lista.stream()
                .max((x, y) -> x - y);
        return maximo.get();
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {

        Map<Integer, Long> agruparRepetidos = lista.stream()
                .collect(Collectors.groupingBy((x) -> x, Collectors.counting()));
        long contar = agruparRepetidos.values().stream()
                .filter((x) -> x == 1)
                .count();

        return (int) contar;
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {

        return lista.stream().filter((x) -> x.getCiudad().equals("Huesca"))
                .collect(Collectors.toList());

        // throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {

        return lista.stream()
                .filter((x) -> x.getCiudad().equals("Huesca"))
                .toArray((x) -> new Persona[x]);

        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {

        Optional<Persona> persona = lista.stream()
                .max((x, y) -> x.getCesta().orElse(new Compra(0, false)).getTotalArticulos() - y.getCesta().orElse(new Compra(0, false)).getTotalArticulos());

        return persona;
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {

        return lista.stream()
                .filter(x -> x.getCesta().isPresent())
                .map(x -> x.getCesta().get())
                .collect(toList());

        // throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve las edades de las personas. No hace falta verificar si valen
     * nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {

        int[] edades = lista.stream()
                .mapToInt(x -> x.getEdad())
                .toArray();

        return edades;

        // throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {

        Map<String, Long> ciudades = lista.stream()
                .collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));

        //System.out.println(ciudades);
        List<Ciudad> personasEnCiudad = ciudades.entrySet()
                .stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().intValue()))
                .collect(Collectors.toList());

        return personasEnCiudad;
        // throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {

        return (List<Persona>) lista.stream()
                .sorted((x, y) -> {
                    int x1 = 0;
                    int y1 = 0;
                    if (x.getCesta().isPresent()) {
                        x1 = x.getCesta().get().getTotalArticulos();
                    }
                    if (y.getCesta().isPresent()) {

                        y1 = y.getCesta().get().getTotalArticulos();
                    }
                    //return x1 - y1;
                    return y1 - x1;
                })
                .limit(3)
                .collect(Collectors.toList());

    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {

        Map<String, Long> ciudades = lista.stream()
                .collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));

        Set<String> topCiudades = (Set<String>) ciudades.entrySet().stream()
                .sorted((x, y) -> {
                    int x1 = x.getValue().intValue();
                    int y1 = y.getValue().intValue();
                    return y1 - x1;
                })
                .limit(3)
                .map(x -> x.getKey())
                .collect(Collectors.toSet());

        return topCiudades;
    }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     *
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {

        List<RangoEdad> clasificacion = new ArrayList<>();
        long menor18 = lista.stream()
                .filter(x -> x.getEdad() < 18)
                .count();

        long entre18y60 = lista.stream()
                .filter(x -> x.getEdad() >= 18)
                .filter(x -> x.getEdad() <= 60).count();

        long mayor60 = lista.stream()
                .filter(x -> x.getEdad() > 60)
                .count();

        clasificacion.add(0, new RangoEdad(RangoEdad.Rango.Menor18, (int) menor18));
        clasificacion.add(1, new RangoEdad(RangoEdad.Rango.Entre18y60, (int) entre18y60));
        clasificacion.add(2, new RangoEdad(RangoEdad.Rango.Mayor60, (int) mayor60));

        return clasificacion;

    }

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad. Si una
     * ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de
     * personas. No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {

        Map<String, Integer> mayoresEdad = new HashMap<>();

        Map<String, Long> agrupados = lista.stream()
                .filter(x -> x.getEdad() >= 18)
                .collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));

        return mayoresEdad = agrupados.entrySet().stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().intValue()));

        //throw new RuntimeException("Pendiente de hacer");
    }

}
