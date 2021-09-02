package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;


public class Ejercicio07StreamsNivelDificil {


    /**
     * Recibimos tres listas con las personas que han estudiado GradoMedio, Universidad o un Certificado.
     * Debe devolver las personas que tengan al menos dos de los tres tipos de estudios.
     */
    public Set<Persona> personaEnDosGrupos(Set<Persona> personasGradoMedio, Set<Persona> personasUniversidad, Set<Persona> personasCertificado){
        List<Persona> todos =new ArrayList<>();
        todos.addAll(personasGradoMedio);
        todos.addAll(personasUniversidad);
        todos.addAll(personasCertificado);
        Set<Persona> dosEstudios= todos.stream()
                                    .collect(Collectors.groupingBy(x->x.getNombre()))
                                    .entrySet()
                                    .stream()
                                    .filter(x->x.getValue().size()>=2)
                                    .map(x->x.getValue().get(0))
                                    .collect(Collectors.toSet());
        return dosEstudios;
    }
    /**
     * Realización de una compra conjunta. Se ha realizado una compra conjunta y se debe distribuir los articulos entre las personas que llegan a la lista.
     * Para repartir la lista recibiremos un Mapa donde indicaremos el porcentaje de la compra que se lleva cada persona.
     * La clave de este mapa será el nombre de la persona y el integer el porcentaje. Por ejemplo: 10 significa que se lleva el 10% de los artículos de la compraConjunta.
     * Si la persona en el mapa no se le dará ningún artículo y se le pondrá la compra a Empty
     */
    public void repartoDeCompraPersona(Compra compraConjunta, List<Persona> personasARepartirLaCompra, Map<String,Integer> porcentajes){
        porcentajes.entrySet().stream()
                .forEach(por->{
                    personasARepartirLaCompra.stream()
                            .forEach(p->{
                                if(p.getNombre().equals(por.getKey()))
                                    p.setCesta(new Compra((compraConjunta.getTotalArticulos()*por.getValue()/100),true));
                            });
                });
    }    

    /**
     * Debe generar una lista de personas del tamaño indicado en "totalPersonas" con un nombre obtenido al azar de la lista nombres.
     * Con rellenar el nombre de la persona es suficiente.
     * Hacer con un stream.
     */
    public List<Persona> generadorDePersonasAlAzar(int totalPersonas, List<String> nombres){
        List<Persona> perAz=new ArrayList<>();
        Collections.nCopies(totalPersonas, new Persona(""))
                .stream()
                .forEach(x->perAz.add(new Persona(nombres.get((int)Math.random()*nombres.size()))));
        return perAz;
    }

    
    /**
     * Devolver una tupla que contenga las personas menores de edad en uno y las mayores de edad (18 años) en el otro valor
     * No deberán aparecer los nombres de las personas que esten en descartes.
     * Pair esta creado en el código pero existe una librería llamada Javatuples que funciona igual
     */
    public Pair<List<Persona>,List<Persona>> obtenerTuplaPorEdad(List<Persona> nombres, Set<String> descartes){
        List<Persona> menor=new ArrayList<>();
        List<Persona> mayor=new ArrayList<>();
        
        nombres.stream()
                .filter(x->x.getEdad()<18)
                .filter(x->!descartes.contains(x.getNombre()))
                .forEach(x->menor.add(new Persona(x.getNombre())));
        nombres.stream()
                .filter(x->x.getEdad()>=18)
                .filter(x->!descartes.contains(x.getNombre()))
                .forEach(x->mayor.add(new Persona(x.getNombre())));
        Pair<List<Persona>,List<Persona>> tupla=new Pair<>(menor,mayor);
        return tupla;
    }    
    
    /**
     * Devolver de que personas son las compras.
     * Recibios dos listas una con personas que tienen compras y otra con compras.
     * Hay que devolver de que personas corresponden esas compras. Los objetos serán los mismos por lo que no es necesario mirar ningún campo de la compra.
     * Devolver la información ordenada por Nombre
     */
    public List<Persona> devolverDeQuePersonasCorrespondenLasCompras(List<Persona> nombres, Set<Compra> descartes){
        List<Persona> per=new ArrayList<>();
        nombres.stream()
                .filter(x-> x.getCesta().isPresent())
                .sorted((x,y) -> x.getNombre().compareTo(y.getNombre()))
                .forEach(x-> {
                    if(descartes.contains(x.getCesta().get()))
                        per.add(x);
                });
        return per;
    }

    /*
     * Devolver una lista de personas pero en caso de tener menos de 5 productos dejar la compra a empty.
     */
    public List<Persona> eliminarCompraDePersonas(List<Persona> nombres){
        List<Persona> compra=new ArrayList<>();
        nombres.stream()
                .forEach(x->{
                    if(x.getCesta().isPresent() && x.getCesta().get().getTotalArticulos()<5)
                        x.setCesta(null);
                    else if(!x.getCesta().isPresent())
                        x.setCesta(null);
                    compra.add(x);
                });
        return compra;
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
        throw new RuntimeException("Pendiente de hacer");
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
