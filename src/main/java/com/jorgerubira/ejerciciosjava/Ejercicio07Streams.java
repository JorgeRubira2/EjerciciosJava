
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
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    public List<Double> elementosPositivos(List<Double> origen){
        List <Double> positivo = origen.stream()
                                       .filter((x)-> x>=0)
                                       .collect(Collectors.toList());
        return positivo;
    }
    
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
        Optional <Integer> maximo = lista.stream()
                                         .max((x,y) -> x-y);
        return maximo.get();
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosNoRepetidos(List<Integer> lista){
        Map<Integer, Long> noRepetido = lista.stream()
                               .collect(Collectors.groupingBy(x->x, Collectors.counting()));
        long contarRepes = noRepetido.values().stream()
                           .filter(x->x==1)
                           .count();
        
        return (int)contarRepes;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        List <Persona> oscenses = lista.stream()
                                       .filter(x->x.getCiudad().equals("Huesca"))
                                       .collect(Collectors.toList());
        return oscenses;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        Persona[] oscenses = lista.stream()
                                       .filter(x->x.getCiudad().equals("Huesca"))
                                       .toArray(tam->new Persona[tam]);
        return oscenses;
        
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
        Optional<Persona> masArticulos = lista.stream()
                                              .max((x,y)-> x.getCesta().orElse(new Compra(0, false)).getTotalArticulos()-y.getCesta().orElse(new Compra(0, false)).getTotalArticulos());
                                              //El orElse de arriba es para que se trague los posibles nulos y los ponga a 0.
        return masArticulos;
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
       List <Compra> list = lista.stream()
                                 .filter(x-> x.getCesta().isPresent())
                                 .map(x-> x.getCesta().get())
                                 .collect(Collectors.toList());
       
       return list;
    }    
    
    /**
     * Devuelve las edades de las personas.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        int[] edades = lista.stream()
                                .mapToInt(x->x.getEdad())
                                .toArray();
        
        return edades;
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
        Map <String, Long> personas = lista.stream()
                                           .collect(Collectors.groupingBy(x->x.getCiudad(), Collectors.counting()));
        
        List<Ciudad> listaCiudades = personas.entrySet().stream()
                                             .map(x-> new Ciudad(x.getKey(), (int)(long)x.getValue()))//Damos la clave y el valor de Map, por eso hay que convertir a Long el x.getValue
                                             .collect(Collectors.toList());
        return listaCiudades;
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
        List<Persona> top = lista.stream()
                                              .sorted((x,y)-> y.getCesta()
                                                            .orElse(new Compra(0, false)).getTotalArticulos()
                                                      - x.getCesta()//El orElse de arriba es para que se trague los posibles nulos y los ponga a 0.
                                                            .orElse(new Compra(0, false)).getTotalArticulos())
                                              .limit(3)
                                              .collect(Collectors.toList());
                                              
        return top;

        //throw new RuntimeException("Pendiente de hacer");
        //Parecido al de orElse de arriba
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

    /**
     * Devuelve cuantas personas mayores de edad hay en cada ciudad.
     * Si una ciudad no tiene personas mayores de edad no hace falta devolver ese dato.
     * Devolver un mapa donde la clave sería la ciudad y el número el número de personas.
     * No hace falta verificar si valen nulo.
     */
    public Map<String, Integer> cuantasPersonasMayoresDeEdadPorCiudad(List<Persona> lista){
        throw new RuntimeException("Pendiente de hacer");
    }     
    
}
