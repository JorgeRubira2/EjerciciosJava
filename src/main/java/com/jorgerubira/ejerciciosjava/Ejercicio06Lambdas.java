
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
        return (v1, v2)->v1-v2;
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * Los valores null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings(){
        return (String a, String b)-> {
            if (a != null && b != null){
            }else if(a == null && b == null){
                return 0;            
            }else if (a == null){
                return -1;
            }else if (b == null) {
                return -1;
            }
            return a.compareTo(b);
        };
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de menor a mayor.
     * No hace falta comprobar personas con valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente(){
        return (Persona a, Persona b)-> a.getEdad() - b.getEdad();
    } 
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente(){
        return (v1,v2)-> v2.getEdad() - v1.getEdad();
    }     
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para ordenar 
     * ascendentemente por la ciudad y los que tengan la misma ciudad por nombre.
     * No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre(){
        return (Persona a, Persona b) -> {
            if(a.getCiudad().compareTo(b.getCiudad()) != 0){
                return a.getCiudad().compareTo(b.getCiudad());
            }else{
                return a.getNombre().compareTo(b.getNombre());
            }
        };
    }     
    
    /**
     * Devolver una función Predicate que permita saber si la persona es de Huesca.
     * tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca(){
        return (Persona a)-> a.getCiudad().equals("Huesca");
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad laboral:
     * Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral(){
        return v1 ->{
            if (v1.getEdad() >= 16 && v1.getEdad() <= 64) {
                return true;
            }else{
                return false;
            }
        };
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     * return (Persona a, String b) -> a.getNombre();
     */
    public Function<Persona, String> obtenerNombreDePersonas(){
        return (Persona a) -> a.getNombre();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas(){
        return v1 -> v1.getCesta();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     * Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas(){
        return v1 -> {
            if (v1.getCesta().isPresent()){
                return v1.getCesta().get();
            }else{
                return null;
            }
        };
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad(){
        return (Persona a) -> a.setEdad(a.getEdad()+1);
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a la primera.
     * La cesta de la segunda persona debe quedar empty.
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio(){
        return (v1, v2) -> {
            if (v2.getCesta().isPresent()){
                v1.setCesta(v2.getCesta().get());
                v2.setCesta(null);
            }else{
                v1.setCesta(null);
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
        return () -> new Compra(0,false);
    }
    
    /**
     * Devuelve la cadena enviada en mayúsculas
     * No hace falta comprobar valores nulos.
     */
    public UnaryOperator<String> convertirAMayusculas(){
        return (String a) -> a.toUpperCase();
    }    
    
    /**
     * Devuelve la suma de dos enteros.
     */
    public IntBinaryOperator sumar(){
        return (int a, int b)->a+b;
    }    
    
    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que la compra recibida.
     * Se comparará el número de artículos y si tiene mas devolverá true
     * Comprobar si la compra recibida vale empty. En ese caso será equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra(){
        return (v1, v2) -> {
            if (v1.getCesta().isPresent() && v2.isEmpty()){
                return true;
            }
            if (v1.getCesta().isPresent() && v1.getCesta().isPresent()){
                if (v1.getCesta().get().getTotalArticulos() > v2.get().getTotalArticulos()){
                    return true;
                }
            }
            return false;
        };
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las mismas unidades que otra compra.
     * Tener el valor empty equivale a tener 0 unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades(){
        return (v1, v2) -> {
            if (v1.getCesta().isPresent() && v2.isPresent()){
                if (v1.getCesta().get().getTotalArticulos() == v2.get().getTotalArticulos()){
                    return true;
                }
            }
            if (v1.getCesta().isEmpty() && v2.isEmpty()){
                return true;
            }
            return false;
        };
    }

}
