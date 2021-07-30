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
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen No hace falta
     * verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen) {
        return origen.stream().filter(t -> t >= 0).collect(toList());
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        Optional<Integer> maxLista = lista.stream()
                .max((x, y) -> x - y);
        return maxLista.get();

    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {
        Map<Integer, Long> result = lista.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long x = result.values().stream().filter(y -> y == 1).count();

        return (int) x;
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {
        List<Persona> listaPersonasHuesca = lista.stream()
                .filter(x -> x.getCiudad().equals("Huesca"))
                .collect(Collectors.toList());

        return listaPersonasHuesca;
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {
        return lista.stream()
                .filter(x -> x.getCiudad().equals("Huesca"))
                .toArray(p -> new Persona[p]);
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {
        Optional<Persona> maxArticulos = lista.stream()
                .filter(p -> p.getCesta().isPresent())
                .max((p1, p2) -> p1.getCesta().get().getTotalArticulos() - p2.getCesta().get().getTotalArticulos());
        if (maxArticulos.isEmpty()) {
            return lista.stream().findFirst();
        } else {
            return maxArticulos;
        }
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
                .collect(Collectors.toList());
    }

    /**
     * Devuelve las edades de las personas. No hace falta verificar si valen
     * nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        return lista.stream()
                .mapToInt(x -> x.getEdad())
                .toArray();

    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(x -> x.getCiudad()))
                .entrySet()
                .stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().size()))
                .collect(Collectors.toList());
    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        return lista.stream()
                .sorted((p1, p2) -> {

                    if (p1.getCesta().isPresent() && p2.getCesta().isPresent()) {
                        return p2.getCesta().get().getTotalArticulos() - p1.getCesta().get().getTotalArticulos();
                    }

                    if (p1.getCesta().isEmpty()) {
                        return 1;
                    }

                    if (p2.getCesta().isEmpty()) {
                        return -1;
                    } else {
                        return 0;
                    }

                })
                .limit(3)
                .collect(Collectors.toList());

    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(c -> c.getCiudad()))
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().size() - c1.getValue().size())
                .limit(3)
                .map(c -> c.getKey())
                .collect(Collectors.toSet());
    }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {
        
        long menor18 = lista.stream()
                .filter(x -> x.getEdad() < 18)
                .count();
        
        long entre18y60 = lista.stream()
                .filter(x -> x.getEdad() >= 18 && x.getEdad() <= 60)
                .count();
        
        long mayor60 = lista.stream()
                .filter(x -> x.getEdad() > 60)
                .count();
        
        List<RangoEdad> edadesPersonas = new ArrayList<>();
        edadesPersonas.add(new RangoEdad(RangoEdad.Rango.Menor18,(int)menor18));
        edadesPersonas.add(new RangoEdad(RangoEdad.Rango.Entre18y60,(int)entre18y60));
        edadesPersonas.add(new RangoEdad(RangoEdad.Rango.Mayor60,(int)mayor60));
        
        return edadesPersonas;
    }

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad. Si una
     * ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número de
     * personas. No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {
         Map<String, Integer> result = lista.stream()
                .filter(x -> x.getEdad() >= 18)
                .collect(Collectors.groupingBy(x -> x.getCiudad()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().size())); 
                
                return result;
    }

}
