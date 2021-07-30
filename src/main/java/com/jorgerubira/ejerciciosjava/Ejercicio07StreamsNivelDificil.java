package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.HashMap;


public class Ejercicio07StreamsNivelDificil {


    /**
     * Recibimos tres listas con las personas que han estudiado GradoMedio, Universidad o un Certificado.
     * Debe devolver las personas que tengan al menos dos de los tres tipos de estudios.
     */
    public Set<Persona> personaEnDosGrupos(Set<Persona> personasGradoMedio, Set<Persona> personasUniversidad, Set<Persona> personasCertificado){
        List<Persona> resultado = new ArrayList();
        resultado.addAll(personasGradoMedio);
        resultado.addAll(personasUniversidad);
        resultado.addAll(personasCertificado);
        Set<Persona> resultado2 = resultado.stream()
        		.collect(Collectors.groupingBy(x->x.getNombre()))
        		.entrySet()
        		.stream()
        		.filter(x->x.getValue().size()>=2)
                .map(x->x.getValue().get(0))
                .collect(Collectors.toSet())
                ;
        return resultado2;
        
        
        
    }
    /**
     * Realización de una compra conjunta. Se ha realizado una compra conjunta y se debe distribuir los articulos entre las personas que llegan a la lista.
     * Para repartir la lista recibiremos un Mapa donde indicaremos el porcentaje de la compra que se lleva cada persona.
     * La clave de este mapa será el nombre de la persona y el integer el porcentaje. Por ejemplo: 10 significa que se lleva el 10% de los artículos de la compraConjunta.
     * Si la persona en el mapa no se le dará ningún artículo y se le pondrá la compra a Empty
     */
    public void repartoDeCompraPersona(Compra compraConjunta, List<Persona> personasARepartirLaCompra, Map<String,Integer> porcentajes){
    	 porcentajes.entrySet().stream().forEach(x -> {
             personasARepartirLaCompra.forEach(y -> {
                 if (y.getNombre().equals(x.getKey())) {
                     int porcentaje = x.getValue();
                     y.setCesta(new Compra(porcentaje * compraConjunta.getTotalArticulos() / 100, true));
                 }
             });
         }
         );
    }    

    /**
     * Debe generar una lista de personas del tamaño indicado en "totalPersonas" con un nombre obtenido al azar de la lista nombres.
     * Con rellenar el nombre de la persona es suficiente.
     * Hacer con un stream.
     */
    public List<Persona> generadorDePersonasAlAzar(int totalPersonas, List<String> nombres){
    	List<Persona> resultado = new ArrayList<>();
        Collections.nCopies(totalPersonas, new Persona(""))
                .stream()
                .forEach(x -> resultado.add(new Persona(nombres.get((int) (Math.random() * nombres.size())))));
        ;
        return resultado;
    	
        
        
    }

    
    /**
     * Devolver una tupla que contenga las personas menores de edad en uno y las mayores de edad (18 años) en el otro valor
     * No deberán aparecer los nombres de las personas que esten en descartes.
     * Pair esta creado en el código pero existe una librería llamada Javatuples que funciona igual
     */
    public Pair<List<Persona>,List<Persona>> obtenerTuplaPorEdad(List<Persona> nombres, Set<String> descartes){
    	List<Persona> encima18 = new ArrayList<>();
        List<Persona> debajo18 = new ArrayList<>();
        nombres.stream()
                .filter(x -> x.getEdad() >= 18)
                .filter(x -> !descartes.contains(x.getNombre()))
                .forEach(x -> encima18.add(new Persona(x.getNombre())));
        nombres.stream()
                .filter(x -> x.getEdad() < 18)
                .filter(x -> !descartes.contains(x.getNombre()))
                .forEach(x -> debajo18.add(new  Persona(x.getNombre())));
        Pair<List<Persona>, List<Persona>> resultado = new Pair<> (debajo18, encima18);
        return resultado;
    }    
    
    /**
     * Devolver de que personas son las compras.
     * Recibios dos listas una con personas que tienen compras y otra con compras.
     * Hay que devolver de que personas corresponden esas compras. Los objetos serán los mismos por lo que no es necesario mirar ningún campo de la compra.
     * Devolver la información ordenada por Nombre
     */
    public List<Persona> devolverDeQuePersonasCorrespondenLasCompras(List<Persona> nombres, Set<Compra> descartes){
    	List<Persona> resultado = new ArrayList<>();
        nombres.stream()
                .filter(x ->x.getCesta().isPresent())
                .sorted((x, y) -> x.getNombre().compareTo(y.getNombre()))
                .forEach(x ->{
                    if (descartes.contains(x.getCesta().get())) {
                        resultado.add(x);
                    }
                });

        return resultado;
    }

    /*
     * Devolver una lista de personas pero en caso de tener menos de 5 productos dejar la compra a empty.
     */
    public List<Persona> eliminarCompraDePersonas(List<Persona> nombres){
    	List<Persona> resultado = new ArrayList<>();
        nombres.stream()
                .forEach(x->{
                    if (x.getCesta().isPresent() && x.getCesta().get().getTotalArticulos()<5){
                        x.setCesta(null);
                    }else if (!x.getCesta().isPresent()){
                        x.setCesta(null);
                    }
                    resultado.add(x);
                });
        
        return resultado;
    }

    /*
     * Crea un clone de la lista recibida. Duplica los objetos copiando los valores con la misma información.
     */
    public List<Persona> clone(List<Persona> nombres){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve en un mapa las personas que hay en cada ciudad.
     * La clave del mapa será la ciudad y la lista de Personas de cada ciudad .
     */
    public Map<String, List<Persona>> obtenerPersonasDeCadaCiudad(List<Persona> persona){
    	Map<String, List<Persona>> resultado = new HashMap<>();
        resultado = persona.stream()
                .collect(Collectors.groupingBy(x->x.getCiudad()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue()));
        return resultado;
    }
    
    /**
     * Devuelve en un mapa la persona con más edad de cada ciudad.
     * La clave del mapa será la ciudad y Persona será la persona con edad mas alta.
     */
    public Map<String, Persona> obtenerPersonaMasMayorDeCadaCiudad(List<Persona> persona){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve en un mapa con las 3 las personas con más edad de cada ciudad.
     * La clave del mapa será la ciudad y la lista de tres personas de cada ciudad con mas edad.
     */
    public Map<String, List<Persona>> obtenerLasTresPersonasMasMayoresDeCadaCiudad(List<Persona> persona){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    
}
