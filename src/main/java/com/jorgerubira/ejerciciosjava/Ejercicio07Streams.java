package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio07Streams {

    /**
     * Devolver los elementos positivos >=0 del Array origen No hace falta
     * verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen) {
        return origen.stream()
                .filter(val -> val.intValue() >= 0)
                .collect(Collectors.toList());
    }

    /**
     * Devuelve el valor maximo de la lista. No hace falta verificar si valen
     * nulo.
     */
    public int maximoElemento(List<Integer> lista) {
        return lista.stream().max((o1, o2) -> o1.compareTo(o2)).get();
    }

    /**
     * Devuelve cuantos elementos no hay repetidos. No hace falta verificar si
     * valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista) {
        // return lista.stream().collect(Collectors.toSet()).size();
        // return (int)lista.stream().distinct().count();
        List<Integer> list = new ArrayList<>();
        List<Integer> listAux = new ArrayList<>();
        lista.stream().forEach((t) -> {
            boolean ex = false;
            if (!list.contains(t)) {
                list.add(t);
                listAux.add(t);
            } else {
                ex=true;
            }

            if (ex) {
                list.stream().forEach((n) -> {
                    if(Objects.equals(n, t))
                    listAux.remove(n);
                });
            }
        });
        return listAux.size();
    }

    /**
     * Devuelve una lista de las personas que son de Huesca. No hace falta
     * verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista) {
        return lista.stream().filter((t) -> {
            return t.getCiudad().equals("Huesca");
        }).collect(Collectors.toList());
    }

    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo
     * primario. No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista) {
        return lista.stream().filter((t) -> {
            return t.getCiudad().equals("Huesca");
        }).toArray(Persona[]::new);
    }

    /**
     * Devuelve la persona que tenga más articulos en la cesta. Devuelve empty
     * si no hay personas. No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista) {

        /*
          
          .filter((t) -> {            
            return t.getCesta().isPresent();
        })
          
         */
        if (lista.size() > 1) {
            return lista.stream().filter((t) -> {
                return t.getCesta().isPresent();
            })
                    .max((o1, o2) -> {
                        int cant1 = o1.getCesta().get().getTotalArticulos();
                        int cant2 = o2.getCesta().get().getTotalArticulos();
                        return cant1 - cant2;
                    });
        } else {
            return lista.stream().findFirst();
        }

    }

    /**
     * Devuelve las compras que tienen las personas. Puede haber personas sin
     * Cesta, estos casos no hay que devolverlos. No hace falta verificar si
     * valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista) {
        return lista.stream().filter(persona -> persona.getCesta().isPresent())
                .map((t) -> {
                    return t.getCesta().get();
                }).collect(Collectors.toList());
    }

    /**
     * Devuelve las edades de las personas. No hace falta verificar si valen
     * nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista) {
        return lista.stream().mapToInt(p -> p.getEdad()).toArray();
    }

    /**
     * Devuelve cuantas personas hay en cada ciudad. Ciudad contiene dos campos
     * Nombre de la ciudad y cuantas personas hay de la lista. No hace falta
     * verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista) {
        List<Ciudad> lst = new LinkedList<>();
        lista.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getCiudad(),
                        Collectors.counting()
                )).forEach((ciudad, cant) -> {
            int personas = Math.toIntExact(cant);
            Ciudad c = new Ciudad(ciudad, personas);
            lst.add(c);
        });

        return lst;
    }

    /**
     * Top 3 clientes. Devuelve los tres clientes que más articulos en la cesta
     * tienen. No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista) {
        return lista.stream()
                .sorted((o1, o2) -> {
                    if (!o1.getCesta().isPresent()) {
                        o1.setCesta(new Compra(0, true));
                    } else if (!o2.getCesta().isPresent()) {
                        o2.setCesta(new Compra(0, true));
                    }
                    return o2.getCesta().get().getTotalArticulos() - o1.getCesta().get().getTotalArticulos();

                }).limit(3).collect(Collectors.toList());
    }

    /**
     * Top 3 ciudades. Devuelve las tres ciudades con más personas en un Set. No
     * hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista) {
        /* List<Ciudad> lst = new LinkedList<>();
            lista.stream()
                    .collect(Collectors.groupingBy(
                            x->x.getCiudad(),
                            Collectors.counting()
                            )).forEach((ciudad, cant) -> {
                                int personas = Math.toIntExact(cant);
                                Ciudad c = new Ciudad(ciudad, personas);
                                lst.add(c);
            });*/

        return lista.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getCiudad(),
                        Collectors.counting()
                )).keySet().stream()
                .limit(3)
                .collect(Collectors.toSet());

    }

    /**
     * Devuelve una lista con 3 objetos RangoEdad. Posicion 0-Cuantas personas
     * hay menores de 18 años. Posicion 1-Cuantas personas hay entre 18 y 60
     * años. Posicion 2-Cuantas personas hay mayores de 60 años. No hace falta
     * verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista) {
        List<RangoEdad> lst = new ArrayList<>();
        lst.add(new RangoEdad(RangoEdad.Rango.Menor18, 0));
        lst.add(new RangoEdad(RangoEdad.Rango.Entre18y60, 0));
        lst.add(new RangoEdad(RangoEdad.Rango.Mayor60, 0));

        lista.stream().map((t) -> {
            return t.getEdad();
        }).forEach((edad) -> {
            System.out.println(edad);
            if (edad < 18) {
                int a = lst.get(0).getPersonas();
                lst.set(0, new RangoEdad(RangoEdad.Rango.Menor18, ++a));
            } else if (edad >= 18 && edad <= 60) {
                int b = lst.get(1).getPersonas();
                lst.set(1, new RangoEdad(RangoEdad.Rango.Entre18y60, ++b));
            } else if (edad > 60) {
                int c = lst.get(2).getPersonas();
                lst.set(2, new RangoEdad(RangoEdad.Rango.Mayor60, ++c));
            }
        });

        return lst;
    }

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad. Si una
     * ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de
     * personas. No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista) {
        Map<String, Integer> map = new HashMap<>();

        Map<String, LongSummaryStatistics> map2
                = lista.stream()
                        .collect(Collectors.groupingBy(
                                x -> x.getCiudad(),
                                Collectors.summarizingLong(x -> x.getEdad() > 18 ? x.getEdad() : 0)
                        ));
        // System.out.println(map2.entrySet());
        map2.entrySet().stream()
                .forEach((t) -> {
                    if (t.getValue().getSum() != 0) {
                        map.put(t.getKey(), (int) t.getValue().getCount());
                    }
                });

        return map;

    }

}
