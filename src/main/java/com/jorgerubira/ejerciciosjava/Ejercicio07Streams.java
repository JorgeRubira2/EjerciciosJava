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
import static java.util.stream.Collectors.toList;

public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen No hace falta
     * verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen) {
        return origen.stream()
                .filter(v1 -> v1 >= 0)
                .collect(toList());
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        return lista.stream()
                .max((v1, v2) -> v1 - v2).get();
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {
        return (int) lista.stream()
                .collect(Collectors.groupingBy(v1 -> v1))
                .entrySet()
                .stream()
                .filter(v1 -> v1.getValue().size() == 1)
                .count();
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {
        return lista.stream()
                .filter(v1 -> v1.getCiudad().equals("Huesca"))
                .collect(toList());
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {
        Persona[] resultado = lista.stream()
                .filter(v1 -> v1.getCiudad().equals("Huesca"))
                .toArray(v1 -> new Persona[v1]);
        return resultado;
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {
        Optional<Persona> resultado = lista.stream()
                .max((v1, v2) -> v1.getCesta().orElse(new Compra(0, false)).getTotalArticulos() - v2.getCesta().orElse(new Compra(0, false)).getTotalArticulos());
        return resultado;
    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {
        return lista.stream()
                .filter(v1 -> v1.getCesta().isPresent())
                .map(v1 -> v1.getCesta().get())
                .collect(toList());
    }

    /**
     * Devuelve las edades de las personas. No hace falta verificar si valen
     * nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        int[] resultado = lista.stream()
                .mapToInt(v1 -> v1.getEdad())
                .toArray();
        return resultado;
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {
        Map<String, Long> persona = lista.stream()
                .collect(Collectors.groupingBy(v1 -> v1.getCiudad(), Collectors.counting()));

        List<Ciudad> resultado = persona.entrySet().stream()
                .map(v1 -> new Ciudad(v1.getKey(), v1.getValue().intValue()))
                .collect(Collectors.toList());

        return resultado;
    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        return lista.stream()
                .sorted((v1, v2) -> v2.getCesta().orElse(new Compra(0, false)).getTotalArticulos() - v1.getCesta().orElse(new Compra(0, false)).getTotalArticulos())
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        Map<String, Long> personas = lista.stream()
                .collect(Collectors.groupingBy(v1 -> v1.getCiudad(), Collectors.counting()));

        Set<String> resultado = personas.entrySet().stream()
                .sorted((v1, v2) -> (int) (v2.getValue() - v1.getValue()))
                .limit(3)
                .map(v1 -> v1.getKey())
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
        Integer joven = (int) lista.stream()
                .filter(v1 -> v1.getEdad() < 18)
                .count();

        Integer adulto = (int) lista.stream()
                .filter(v1 -> v1.getEdad() >= 18 && v1.getEdad() <= 60)
                .count();

        Integer viejo = (int) lista.stream()
                .filter(v1 -> v1.getEdad() > 60)
                .count();

        List<RangoEdad> resultado = new ArrayList<>();
        resultado.add(new RangoEdad(RangoEdad.Rango.Menor18, joven));
        resultado.add(new RangoEdad(RangoEdad.Rango.Entre18y60, adulto));
        resultado.add(new RangoEdad(RangoEdad.Rango.Mayor60, viejo));

        return resultado;
    }

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad. Si una
     * ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de
     * personas. No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {
        Map<String, Long> personas = lista.stream()
                .filter(v1 -> v1.getEdad() >= 18)
                .collect(Collectors.groupingBy(v1 -> v1.getCiudad(), Collectors.counting()));

        Map<String, Integer> resultado = personas.entrySet().stream()
                .collect(Collectors.toMap(v1 -> v1.getKey(), v1 -> v1.getValue().intValue()));

        return resultado;
    }

}
