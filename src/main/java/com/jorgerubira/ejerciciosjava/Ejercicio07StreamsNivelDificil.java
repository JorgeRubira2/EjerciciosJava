package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicio07StreamsNivelDificil {

    /**
     * Recibimos tres listas con las personas que han estudiado GradoMedio,
     * Universidad o un Certificado. Debe devolver las personas que tengan al
     * menos dos de los tres tipos de estudios.
     */
    public Set<Persona> personaEnDosGrupos(Set<Persona> personasGradoMedio, Set<Persona> personasUniversidad, Set<Persona> personasCertificado) {
        Set<Persona> resultado = new HashSet<>();
        personasGradoMedio.stream().filter(x -> {
            boolean x1 = personasUniversidad.stream().anyMatch(y -> x.getNombre().equals(y.getNombre()));
            boolean x2 = personasCertificado.stream().anyMatch(y -> x.getNombre().equals(y.getNombre()));
            return x1 || x2;
        }).forEach(x -> resultado.add(new Persona(x.getNombre())));
        personasUniversidad.stream().filter(x -> {
            boolean x1 = personasGradoMedio.stream().anyMatch(y -> x.getNombre().equals(y.getNombre()));
            boolean x2 = personasCertificado.stream().anyMatch(y -> x.getNombre().equals(y.getNombre()));
            return x1 || x2;
        }).forEach(x -> resultado.add(new Persona(x.getNombre())));
        return resultado;
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Realización de una compra conjunta. Se ha realizado una compra conjunta y
     * se debe distribuir los articulos entre las personas que llegan a la
     * lista. Para repartir la lista recibiremos un Mapa donde indicaremos el
     * porcentaje de la compra que se lleva cada persona. La clave de este mapa
     * será el nombre de la persona y el integer el porcentaje. Por ejemplo: 10
     * significa que se lleva el 10% de los artículos de la compraConjunta. Si
     * la persona en el mapa no se le dará ningún artículo y se le pondrá la
     * compra a Empty
     */
    public void repartoDeCompraPersona(Compra compraConjunta, List<Persona> personasARepartirLaCompra, Map<String, Integer> porcentajes) {
        porcentajes.entrySet().stream().forEach(x -> {
            personasARepartirLaCompra.forEach(y -> {
                if (y.getNombre().equals(x.getKey())) {
                    int porcentaje = x.getValue();
                    y.setCesta(new Compra(porcentaje * compraConjunta.getTotalArticulos() / 100, true));
                }
            });
        }
        );
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Debe generar una lista de personas del tamaño indicado en "totalPersonas"
     * con un nombre obtenido al azar de la lista nombres. Con rellenar el
     * nombre de la persona es suficiente. Hacer con un stream.
     */
    public List<Persona> generadorDePersonasAlAzar(int totalPersonas, List<String> nombres) {
        //List<Persona> resultado=new ArrayList<>();
        //resultado.
        //nombres.stream().limit(totalPersonas).map(x->new Persona(x)).collect(Collectors.toList());
        //return resultado;
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devolver una tupla que contenga las personas menores de edad en uno y las
     * mayores de edad (18 años) en el otro valor No deberán aparecer los
     * nombres de las personas que esten en descartes. Pair esta creado en el
     * código pero existe una librería llamada Javatuples que funciona igual
     */
    public Pair<List<Persona>, List<Persona>> obtenerTuplaPorEdad(List<Persona> nombres, Set<String> descartes) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devolver de que personas son las compras. Recibios dos listas una con
     * personas que tienen compras y otra con compras. Hay que devolver de que
     * personas corresponden esas compras. Los objetos serán los mismos por lo
     * que no es necesario mirar ningún campo de la compra. Devolver la
     * información ordenada por Nombre
     */
    public List<Persona> devolverDeQuePersonasCorrespondenLasCompras(List<Persona> nombres, Set<Compra> descartes) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /*
     * Devolver una lista de personas pero en caso de tener menos de 5 productos dejar la compra a empty.
     */
    public List<Persona> eliminarCompraDePersonas(List<Persona> nombres) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /*
     * Crea un clone de la lista recibida. Duplica los objetos copiando los valores con la misma información.
     */
    public List<Persona> clone(List<Persona> nombres) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve en un mapa las personas que hay en cada ciudad. La clave del
     * mapa será la ciudad y la lista de Personas de cada ciudad .
     */
    public Map<String, List<Persona>> obtenerPersonasDeCadaCiudad(List<Persona> persona) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve en un mapa la persona con más edad de cada ciudad. La clave del
     * mapa será la ciudad y Persona será la persona con edad mas alta.
     */
    public Map<String, Persona> obtenerPersonaMasMayorDeCadaCiudad(List<Persona> persona) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve en un mapa con las 3 las personas con más edad de cada ciudad.
     * La clave del mapa será la ciudad y la lista de tres personas de cada
     * ciudad con mas edad.
     */
    public Map<String, List<Persona>> obtenerLasTresPersonasMasMayoresDeCadaCiudad(List<Persona> persona) {
        throw new RuntimeException("Pendiente de hacer");
    }

}
