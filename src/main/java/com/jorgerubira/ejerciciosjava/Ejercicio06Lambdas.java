
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
        /*return (o1, o2) -> {
            return o1.compareTo(o2);
        };*/
        return (o1, o2) -> {
            return o1-o2;
        };
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * Los valores null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings(){
        
        /*return (o1, o2) -> {
            if(o1 == null){
                return "0".compareTo(o2);
            }else if(o2==null){
                return "0".compareTo(o1);
            }else if(o1 == null && o2 == null){
                return 0;
            }
            return o1. compareTo(o2);
        };*/
        
        return ((o1, o2) -> {
            if(o1 == null && o2 == null){
            return 0; 
            }else if(o1 == null){
                return 0-Integer.parseInt(o2);
            
            }else if(o2 == null){
                return Integer.parseInt(o1)-0;
            }else{
            return Integer.parseInt(o1)-Integer.parseInt(o2); 
            }
        });
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de menor a mayor.
     * No hace falta comprobar personas con valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente(){
        return (o1, o2) -> {
            int comp1 = o1.getNombre().compareTo(o2.getNombre());
            return comp1 != 0 ? comp1 : o1.getEdad() - o2.getEdad();
        };
    } 
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente(){
        return (o1, o2) -> {
            int comp1 = o1.getNombre().compareTo(o2.getNombre());
            return comp1 != 0 ? comp1 : o2.getEdad() - o1.getEdad();
        };
    }     
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para ordenar 
     * ascendentemente por la ciudad y los que tengan la misma ciudad por nombre.
     * No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre(){
        return (o1, o2) -> {
            int compararCiudad = o1.getCiudad().compareTo(o2.getCiudad());
            return compararCiudad != 0 ? compararCiudad : o1.getNombre().compareTo(o2.getNombre());
        };
    }     
    
    /**
     * Devolver una función Predicate que permita saber si la persona es de Huesca.
     * tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca(){
        return (t) -> t.getCiudad().equals("Huesca");
        
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad laboral:
     * Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral(){
        return (persona) -> persona.getEdad()>16 && persona.getEdad()<64;
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas(){
       return (persona) -> persona.getNombre();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas(){
        return (compra) -> compra.getCesta().isPresent() ? compra.getCesta() : Optional.empty();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     * Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas(){
        return (compra) -> compra.getCesta().isPresent() ? compra.getCesta().get() : null;
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad(){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a la primera.
     * La cesta de la segunda persona debe quedar empty.
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio(){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve una compra vacia.
     */
    public Supplier<Optional<Compra>> generarCompraVacia(){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve una compra con 0 unidades y false en el carro.
     */
    public Supplier<Compra> generarCompra0Unidades(){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve la cadena enviada en mayúsculas
     * No hace falta comprobar valores nulos.
     */
    public UnaryOperator<String> convertirAMayusculas(){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Devuelve la suma de dos enteros.
     */
    public IntBinaryOperator sumar(){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que la compra recibida.
     * Se comparará el número de artículos y si tiene mas devolverá true
     * Comprobar si la compra recibida vale empty. En ese caso será equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra(){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las mismas unidades que otra compra.
     * Tener el valor empty equivale a tener 0 unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades(){
        throw new RuntimeException("Pendiente de hacer");
    }

}
