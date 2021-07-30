package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Ejercicio07StreamsNivelDificil {


    /**
     * Recibimos tres listas con las personas que han estudiado GradoMedio, Universidad o un Certificado.
     * Debe devolver las personas que tengan al menos dos de los tres tipos de estudios.
     */
    public Set<Persona> personaEnDosGrupos(Set<Persona> personasGradoMedio, Set<Persona> personasUniversidad, Set<Persona> personasCertificado){
        List<Persona> listaTodos = new ArrayList<>();
        listaTodos.addAll(personasGradoMedio);
        listaTodos.addAll(personasCertificado);
        listaTodos.addAll(personasUniversidad);

        return listaTodos.stream()
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet()
                            .stream()
                            .filter(x->x.getValue()>=2)
                            .map(x->x.getKey())
                            .collect(Collectors.toSet());
    }
    /**
     * Realización de una compra conjunta. Se ha realizado una compra conjunta y se debe distribuir los articulos entre las personas que llegan a la lista.
     * Para repartir la lista recibiremos un Mapa donde indicaremos el porcentaje de la compra que se lleva cada persona.
     * La clave de este mapa será el nombre de la persona y el integer el porcentaje. Por ejemplo: 10 significa que se lleva el 10% de los artículos de la compraConjunta.
     * Si la persona en el mapa no se le dará ningún artículo y se le pondrá la compra a Empty
     */
    public void repartoDeCompraPersona(Compra compraConjunta, List<Persona> personasARepartirLaCompra, Map<String,Integer> porcentajes){
        personasARepartirLaCompra.stream()
                                    .forEach(p->{
                                        if(porcentajes.keySet().contains(p.getNombre())) {
                                            int articulos = compraConjunta.getTotalArticulos() * porcentajes.get(p.getNombre()) / 100;
                                            p.setCesta(new Compra(articulos, compraConjunta.isCarro()));
                                        } else {
                                            p.setCesta(null);
                                        };
                                    });
    }    

    /**
     * Debe generar una lista de personas del tamaño indicado en "totalPersonas" con un nombre obtenido al azar de la lista nombres.
     * Con rellenar el nombre de la persona es suficiente.
     * Hacer con un stream.
     */
    public List<Persona> generadorDePersonasAlAzar(int totalPersonas, List<String> nombres){
        List<Persona> personas = Arrays.asList(new Persona[totalPersonas]);
        return personas.stream()
                            .map(x-> new Persona(nombres.get((int) (Math.random()*nombres.size()))))
                            .collect(Collectors.toList());
    }

    
    /**
     * Devolver una tupla que contenga las personas menores de edad en uno y las mayores de edad (18 años) en el otro valor
     * No deberán aparecer los nombres de las personas que esten en descartes.
     * Pair esta creado en el código pero existe una librería llamada Javatuples que funciona igual
     */
    public Pair<List<Persona>,List<Persona>> obtenerTuplaPorEdad(List<Persona> nombres, Set<String> descartes){
        List<Persona> t1 = nombres.stream()
                                    .filter(p->p.getEdad()<18)
                                    .filter(p->!descartes.contains(p.getNombre()))
                                    .collect(Collectors.toList());

        List<Persona> t2 = nombres.stream()
                                    .filter(p->p.getEdad()>=18)
                                    .filter(p->!descartes.contains(p.getNombre()))
                                    .collect(Collectors.toList());

        Pair<List<Persona>, List<Persona>> tupla = new Pair<>(t1, t2);

        return tupla;
    }    
    
    /**
     * Devolver de que personas son las compras.
     * Recibios dos listas una con personas que tienen compras y otra con compras.
     * Hay que devolver de que personas corresponden esas compras. Los objetos serán los mismos por lo que no es necesario mirar ningún campo de la compra.
     * Devolver la información ordenada por Nombre
     */
    public List<Persona> devolverDeQuePersonasCorrespondenLasCompras(List<Persona> nombres, Set<Compra> descartes){
        return nombres.stream()
                        .filter(p-> p.getCesta().isPresent())
                        .filter(p-> descartes.contains(p.getCesta().get()))
                        .sorted((p1,p2)-> p1.getNombre().compareTo(p2.getNombre()))
                        .collect(Collectors.toList());
    }

    /*
     * Devolver una lista de personas pero en caso de tener menos de 5 productos dejar la compra a empty.
     */
    public List<Persona> eliminarCompraDePersonas(List<Persona> nombres){
        nombres.stream()
                    .forEach(p->{
                        if(p.getCesta().isPresent() && p.getCesta().get().getTotalArticulos()<5){
                            p.setCesta(null);
                        }
                    });
        return nombres;
    }

    /*
     * Crea un clone de la lista recibida. Duplica los objetos copiando los valores con la misma información.
     */
    public List<Persona> clone(List<Persona> nombres){
        List<Persona> clon = new ArrayList<>();
        nombres.stream()
                    .forEach(p->{
                        clon.add(new Persona(p.getNombre(),
                                p.getCiudad(),
                                p.getEdad(),
                                (Date) p.getFechaNacimiento().clone(),
                                p.getAltura(),
                                p.getPeso(),
                                new Compra(p.getCesta().get().getTotalArticulos(), p.getCesta().get().isCarro())));
                    });
        return clon;
    }

    /**
     * Devuelve en un mapa las personas que hay en cada ciudad.
     * La clave del mapa será la ciudad y la lista de Personas de cada ciudad .
     */
    public Map<String, List<Persona>> obtenerPersonasDeCadaCiudad(List<Persona> persona){
        return persona.stream()
                        .collect(Collectors.groupingBy(p->p.getCiudad()));
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
