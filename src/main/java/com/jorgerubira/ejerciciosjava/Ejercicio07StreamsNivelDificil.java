package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Ejercicio07StreamsNivelDificil {


    /**
     * Recibimos tres listas con las personas que han estudiado GradoMedio, Universidad o un Certificado.
     * Debe devolver las personas que tengan al menos dos de los tres tipos de estudios.
     */
    public Set<Persona> personaEnDosGrupos(Set<Persona> personasGradoMedio, Set<Persona> personasUniversidad, Set<Persona> personasCertificado){
        List<Persona> pers1 = new ArrayList<Persona>();
        personasGradoMedio.stream().forEach(x->pers1.add(x));
        personasCertificado.stream().forEach(x->pers1.add(x));
        personasUniversidad.stream().forEach(x->pers1.add(x));
        
        Set<Persona> salida = pers1.stream()
                .collect(Collectors.groupingBy(Persona::getNombre, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(x -> new Persona(x.getKey()))
                .collect(Collectors.toSet());
                
        
//        List<Set<Persona>> personas = List.of(personasCertificado,personasGradoMedio,personasUniversidad);
        return salida ;
    }
    /**
     * Realización de una compra conjunta. Se ha realizado una compra conjunta y se debe distribuir los articulos entre las personas que llegan a la lista.
     * Para repartir la lista recibiremos un Mapa donde indicaremos el porcentaje de la compra que se lleva cada persona.
     * La clave de este mapa será el nombre de la persona y el integer el porcentaje. Por ejemplo: 10 significa que se lleva el 10% de los artículos de la compraConjunta.
     * Si la persona en el mapa no se le dará ningún artículo y se le pondrá la compra a Empty
     */
    public void repartoDeCompraPersona(Compra compraConjunta, List<Persona> personasARepartirLaCompra, Map<String,Integer> porcentajes){
        
        porcentajes.entrySet().stream()
                .forEach(x-> {
                    personasARepartirLaCompra.stream()
                            .filter(y -> y.getNombre().equals(x.getKey()))
                            .forEach(y-> y.setCesta(new Compra( x.getValue() * compraConjunta.getTotalArticulos() / 100 ,true )));
                        });
                
    }    

    /**
     * Debe generar una lista de personas del tamaño indicado en "totalPersonas" con un nombre obtenido al azar de la lista nombres.
     * Con rellenar el nombre de la persona es suficiente.
     * Hacer con un stream.
     */
    public List<Persona> generadorDePersonasAlAzar(int totalPersonas, List<String> nombres){
        List<Persona> personas = Arrays.asList(new Persona[totalPersonas]);
        List<Persona> salida = personas.stream()
                .map(x -> new Persona(nombres.get((int) ((Math.random())*nombres.size()))))
                                .collect(Collectors.toList());
        
        return  salida;
    }

    
    /**
     * Devolver una tupla que contenga las personas menores de edad en uno y las mayores de edad (18 años) en el otro valor
     * No deberán aparecer los nombres de las personas que esten en descartes.
     * Pair esta creado en el código pero existe una librería llamada Javatuples que funciona igual
     */
    public Pair<List<Persona>,List<Persona>> obtenerTuplaPorEdad(List<Persona> nombres, Set<String> descartes){
       //Pair Pair<List<Persona>,List<Persona>> tuplas =
       List<Persona> personas =  nombres.stream()
               .filter(x -> !descartes.contains(x.getNombre()) )
               .collect(Collectors.toList());
     
       return new Pair(personas.stream().filter(x->x.getEdad() <18).collect(Collectors.toList())
                        ,personas.stream().filter(x->x.getEdad() >=18 ).collect(Collectors.toList()) );
        
    }    
    
    /**
     * Devolver de que personas son las compras.
     * Recibios dos listas una con personas que tienen compras y otra con compras.
     * Hay que devolver de que personas corresponden esas compras. Los objetos serán los mismos por lo que no es necesario mirar ningún campo de la compra.
     * Devolver la información ordenada por Nombre
     */
    public List<Persona> devolverDeQuePersonasCorrespondenLasCompras(List<Persona> nombres, Set<Compra> descartes){
        List<Persona> personas = nombres.stream()
                .filter(x->x.getCesta().isPresent())
                .filter(x -> descartes.contains((x.getCesta().get())))
                .collect(Collectors.toList());
        
        
        return personas;
    }

    /*
     * Devolver una lista de personas pero en caso de tener menos de 5 productos dejar la compra a empty.
     */
    public List<Persona> eliminarCompraDePersonas(List<Persona> nombres){
          nombres.forEach(x -> { 
              if (x.getCesta().isPresent() && x.getCesta().get().getTotalArticulos()<5 ){
                                  x.setCesta(null);}
                                }
                  );
          return nombres;
    }

    /*
     * Crea un clone de la lista recibida. Duplica los objetos copiando los valores con la misma información.
     */
    public List<Persona> clone(List<Persona> nombres){
        List<Persona> personas = nombres.stream()
                .map(x-> new Persona(x.getNombre()
                        , x.getCiudad()
                        , x.getEdad()
                        ,(Date) x.getFechaNacimiento().clone()
                        , x.getAltura(), x.getPeso()
                        , ((x.getCesta().isPresent())? new Compra(x.getCesta().get().getTotalArticulos(),x.getCesta().get().isCarro()):null)))
                .collect(Collectors.toList());
        return personas;
    }

    /**
     * Devuelve en un mapa las personas que hay en cada ciudad.
     * La clave del mapa será la ciudad y la lista de Personas de cada ciudad .
     */
    public Map<String, List<Persona>> obtenerPersonasDeCadaCiudad(List<Persona> persona){
        Map<String, List<Persona>>  poblaciones = persona.stream().collect(Collectors.groupingBy(Persona::getCiudad));
        return poblaciones;
    }
    
    
    /**
     * Devuelve en un mapa la persona con más edad de cada ciudad.
     * La clave del mapa será la ciudad y Persona será la persona con edad mas alta.
     */
    public Map<String, Persona> obtenerPersonaMasMayorDeCadaCiudad(List<Persona> persona){
        Map<String, Persona>  poblaciones = persona.stream()
                .filter(x -> x.equals( (persona.stream()
                                            .filter( y-> y.getCiudad()== x.getCiudad())
                                            .max((a,b) ->a.getEdad()- b.getEdad())
                                            .get()
                                )
                            )
                )
                .collect(Collectors.groupingBy(Persona::getCiudad))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x->x.getKey(), x->x.getValue().get(0)));

        
         
         return poblaciones;
        
    }
    
    
    /**
     * Devuelve en un mapa con las 3 las personas con más edad de cada ciudad.
     * La clave del mapa será la ciudad y la lista de tres personas de cada ciudad con mas edad.
     */
    public Map<String, List<Persona>> obtenerLasTresPersonasMasMayoresDeCadaCiudad(List<Persona> persona){
        Map<String, List<Persona>>  poblaciones = persona.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x->x.getKey()
                                        , x->x.getValue().stream()
                                                        .sorted((a,b) ->b.getEdad()- a.getEdad())
                                                        .limit(3)
                                                        .collect(Collectors.toList())));
   
    return poblaciones;
    }
}
