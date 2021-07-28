
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.IComparadorPersonaCompra;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class Ejercicio06Lambdas {

    /**
     * Devolver una función Comparator con Lambdas que compare dos enteros 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * No hace falta comprobar los valores nulos.
     */
    public Comparator<Integer> compararIntegers(){
        return (a, b)-> a-b;
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * Los valores null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings(){
        return (p1, p2) -> {
            if(p1==null && p2!=null){
                return -1;
            } else if (p1!=null && p2==null){
                return 1;
            } else if (p1==null && p2==null){
                return 0;
            } else {
                return p1.compareTo(p2);
            }
        };
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de menor a mayor.
     * No hace falta comprobar personas con valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente(){
        return (p1, p2) -> p1.getEdad()-p2.getEdad();
    } 
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente(){
        return (p1, p2) -> p2.getEdad()-p1.getEdad();
    }     
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para ordenar 
     * ascendentemente por la ciudad y los que tengan la misma ciudad por nombre.
     * No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre(){
        return (p1, p2) -> {
          if(p1.getCiudad().equals(p2.getCiudad())){
              return p1.getNombre().compareTo(p2.getNombre());
          } else {
              return p1.getCiudad().compareTo(p2.getCiudad());
          }
        };
    }     
    
    /**
     * Devolver una función Predicate que permita saber si la persona es de Huesca.
     * tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca(){
        return p -> p.getCiudad() != null && p.getCiudad().equals("Huesca");
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad laboral:
     * Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral(){
        return p -> p.getEdad()>=16 && p.getEdad()<64;
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas(){
        return p -> p.getNombre();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas(){
        return p -> p.getCesta();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     * Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas(){
        return p -> {
            if(p.getCesta().isPresent()){
                return p.getCesta().get();
            } else {
                return null;
            }
        };
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad(){
        return p -> p.setEdad(p.getEdad()+1);
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a la primera.
     * La cesta de la segunda persona debe quedar empty.
     * BiConsumer recibe dos parametros y lleva void
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio(){
        return (p1, p2) -> {
            if(p2.getCesta().isPresent()) {
                p1.setCesta(p2.getCesta().get());
                p2.setCesta(null);
            }
        };
    }
    
    /**
     * Devuelve una compra vacia.
     */
    public Supplier<Optional<Compra>> generarCompraVacia(){
        return () -> Optional.empty();
    }

    /**
     * Devuelve una compra con 0 unidades y false en el carro.
     */
    public Supplier<Compra> generarCompra0Unidades(){
        return () -> new Compra(0, false);
    }
    
    /**
     * Devuelve la cadena enviada en mayúsculas
     * No hace falta comprobar valores nulos.
     */
    public UnaryOperator<String> convertirAMayusculas(){
        return s -> s.toUpperCase();
    }    
    
    /**
     * Devuelve la suma de dos enteros.
     * Recibe dos parametros int y devuelve un parametro int
     */
    public IntBinaryOperator sumar(){
        return (a, b) -> a+b;
    }    
    
    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que la compra recibida.
     * Se comparará el número de artículos y si tiene mas devolverá true
     * Comprobar si la compra recibida vale empty. En ese caso será equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra(){
        return (p, c) -> {
            if(c.isEmpty()){
                c = Optional.of(new Compra(0, false));
            }
            if(p.getCesta().isEmpty()){
                p.setCesta(new Compra(0, false));
            }
            return p.getCesta().get().getTotalArticulos()>c.get().getTotalArticulos();
        };
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las mismas unidades que otra compra.
     * Tener el valor empty equivale a tener 0 unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades(){
        return (p, c) -> {
            if(c.isEmpty()){
                c = Optional.of(new Compra(0, false));
            }
            if(p.getCesta().isEmpty()){
                p.setCesta(new Compra(0, false));
            }
            return p.getCesta().get().getTotalArticulos()==c.get().getTotalArticulos();
        };
    }

}
