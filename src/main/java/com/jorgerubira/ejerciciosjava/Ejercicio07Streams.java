
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
     * Devolver los elementos positivos >=0 del Array origen
     * No hace falta verificar si valen nulo.
     */
    
    //NOTAS: NO ES NECESARIO AÑADIR LA "d" AL LADO DEL 0 EN EL FILTER
    public List<Double> elementosPositivos(List<Double> origen){
        List<Double>destino = origen.stream().filter(x->x>=0d)
                                             .collect(Collectors.toList());
        return destino;
    }
    
    /**
     * Devuelve el valor maximo de la lista.
     * No hace falta verificar si valen nulo.
     */
    public int maximoElemento(List<Integer> lista){
       int res = lista.stream().max(Integer::compare).get();
       return res;
    }
    
    /**
     * Devuelve cuantos elementos no hay repetidos.
     * No hace falta verificar si valen nulo.
     */
    
    
    public int contarElementosNoRepetidos(List<Integer> lista){
        Map<Integer,Long> aux = lista.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        int res=(int)aux.values().stream().filter(x->x==1).count();
        return res;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> personasDeHuescaALista(List<Persona> lista){
        List<Persona> persona =lista.stream().filter(x->x.getCiudad().equals("Huesca"))
                                    .collect(Collectors.toList());
        return persona;
    }
    
    /**
     * Devuelve una lista de las personas que son de Huesca en array de tipo primario.
     * No hace falta verificar si valen nulo.
     */
    public Persona[] personasDeHuescaAArrayBasico(List<Persona> lista){
        Persona[] persona =lista.stream().filter(x->x.getCiudad().equals("Huesca")).toArray(tam->new Persona[tam]);
        return persona;
    }
    
    /**
     * Devuelve la persona que tenga más articulos en la cesta.
     * Devuelve empty si no hay personas.
     * No hace falta verificar si valen nulo.
     */
    public Optional<Persona> personasConMasArticulo(List<Persona> lista){
       Optional<Persona> per =lista.stream().max((x,y)->(x.getCesta().orElse(new Compra(0,true)).getTotalArticulos()-y.getCesta()
                                                        .orElse(new Compra(0,true)).getTotalArticulos()));
       return per;
    }    
    
    /**
     * Devuelve las compras que tienen las personas.
     * Puede haber personas sin Cesta, estos casos no hay que devolverlos.
     * No hace falta verificar si valen nulo.
     */
    public List<Compra> cestasDeLasPersonas(List<Persona> lista){
        List<Compra> res = lista.stream().filter(x->x.getCesta().isPresent()).map(x->x.getCesta().get()).collect(Collectors.toList());
        return res;
    }    
    
    /**
     * Devuelve las edades de las personas.
     * No hace falta verificar si valen nulo.
     */
    public int[] edadesDeLasPersonas(List<Persona> lista){
        int[] res = lista.stream().mapToInt(x->x.getEdad()).toArray();
        return res;
    }      
    
    /**
     * Devuelve cuantas personas hay en cada ciudad. 
     * Ciudad contiene dos campos Nombre de la ciudad y cuantas personas hay de la lista.
     * No hace falta verificar si valen nulo.
     */
    public List<Ciudad> cuantasPersonasHayPorCiudad(List<Persona> lista){
        Map<String,Long> aux = lista.stream().collect(Collectors.groupingBy(x->x.getCiudad(),Collectors.counting()));
        List<Ciudad> res = aux.entrySet().stream().map(x->new Ciudad(x.getKey(),(int)(long)x.getValue())).collect(Collectors.toList());
        return res;
    }

    /**
     * Top 3 clientes. 
     * Devuelve los tres clientes que más articulos en la cesta tienen.
     * No hace falta verificar si valen nulo.
     */
    public List<Persona> top3Personas(List<Persona> lista){
        
        List<Persona> res = lista.stream()
                                          .sorted((x,y)->y.getCesta().orElse(new Compra(0,false)).getTotalArticulos()-x.getCesta()
                                          .orElse(new Compra(0,false)).getTotalArticulos())
                                          .limit(3).collect(Collectors.toList());
        return res;
    }    
    
    /**
     * Top 3 ciudades. 
     * Devuelve las tres ciudades con más personas en un Set.
     * No hace falta verificar si valen nulo.
     */
    public Set<String> top3Ciudades(List<Persona> lista){
        Map<String,Long> aux = lista.stream().collect(Collectors.groupingBy(x->x.getCiudad(),Collectors.counting()));
        Set<String> res = aux.entrySet().stream().sorted((x,y)->(int)(long)(y.getValue()-x.getValue())).limit(3).map(x->x.getKey()).collect(Collectors.toSet());
        return res;
    }    

    /**
     * Devuelve una lista con 3 objetos RangoEdad.
     * Posicion 0-Cuantas personas hay menores de 18 años.
     * Posicion 1-Cuantas personas hay entre 18 y 60 años.
     * Posicion 2-Cuantas personas hay mayores de 60 años.
     * No hace falta verificar si valen nulo.
     */
    public List<RangoEdad> clasificacionPorRangoDeEdad(List<Persona> lista){
        Integer aux = (int)(long)lista.stream().filter(x->x.getEdad()<18).count();
        Integer aux1 = (int)(long)lista.stream().filter(x->x.getEdad()>=18 && x.getEdad()<=60).count();
        Integer aux2= (int)(long)lista.stream().filter(x->x.getEdad()>60).count();
        
        List<RangoEdad> res = List.of(new RangoEdad(RangoEdad.Rango.Menor18, aux),new RangoEdad(RangoEdad.Rango.Entre18y60, aux1),
                                      new RangoEdad(RangoEdad.Rango.Mayor60, aux2));
        return res;
        /*List<RangoEdad> res2 = new ArrayList<>();
        res2.add(new RangoEdad(RangoEdad.Rango.Menor18, aux));
        res2.add(new RangoEdad(RangoEdad.Rango.Entre18y60, aux1));
        res2.add(new RangoEdad(RangoEdad.Rango.Mayor60, aux2));*/

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
