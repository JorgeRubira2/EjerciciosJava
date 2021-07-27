
package com.jorgerubira.ejerciciosjava;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.jorgerubira.ejerciciosjava.interfaces.IComparadorPersonaCompra;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;


public class Ejercicio06Lambdas {
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos enteros 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * No hace falta comprobar los valores nulos.
     */
    public Comparator<Integer> compararIntegers(){
        return (i1,i2) -> i1-i2;
        
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * Los valores null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings(){
        return (s1, s2) -> (s1 != null && s2 != null) ? s1.compareTo(s2) : (s1 == null && s2 == null) ? 0 : s1 == null ? -1 : 1;
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de menor a mayor.
     * No hace falta comprobar personas con valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente(){
    	return (p1, p2) -> p1.getEdad() - p2.getEdad();
    } 
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente(){
    	return (p1,p2) -> p2.getEdad() - p1.getEdad();
    }     
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para ordenar 
     * ascendentemente por la ciudad y los que tengan la misma ciudad por nombre.
     * No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre(){
    	return (p1,p2) -> {
    		int compararCiudad = p1.getCiudad().compareTo(p2.getCiudad());
    		if(compararCiudad != 0) {
    			return compararCiudad;
    		}else
    			return p1.getNombre().compareTo(p2.getNombre());
    	};
    }     

    /**
     * Devolver una función Predicate que permita saber si la persona es de Huesca.
     * tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca(){
    	Predicate<Persona> predicado =(p) ->p.getCiudad() !=null && p.getCiudad() == "Huesca";
        return predicado;
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad laboral:
     * Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral(){
    	Predicate<Persona> predicado =(p) ->p.getEdad() >= 16 && p.getEdad() < 64;
        return predicado;
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas(){
    	Function<Persona, String> funcion = (p) -> p.getNombre();
    	return funcion;
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas(){
    	Function<Persona, Optional<Compra>> funcion = (p) -> p.getCesta();
    	return funcion;
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     * Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas(){
    	Function<Persona, Compra> funcion = (p) ->{
    		if (p.getCesta().isPresent()){
    			return p.getCesta().get();
    		}else {
    			return null;
    		}
    	};
    	return funcion;
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad(){
    	Consumer<Persona> consumidor = (p) ->{ 
    		p.setEdad(p.getEdad() + 1);
    	};
    	return consumidor;
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a la primera.
     * La cesta de la segunda persona debe quedar empty.
     * BiConsumer recibe dos parametros y lleva void
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio(){
    	BiConsumer<Persona, Persona> consumidor = (p1,p2) ->{
    		if (p2.getCesta().isPresent()) {
    			p1.setCesta(p2.getCesta().get());
    		} else {
    			p1.setCesta(null);
    		}
    		p2.setCesta(null);
    	};
    	return consumidor;
    }
    
    /**
     * Devuelve una compra vacia.
     */
    public Supplier<Optional<Compra>> generarCompraVacia(){
        Supplier<Optional<Compra>> proveedor=()->Optional.empty();
        return proveedor;
    }

    /**
     * Devuelve una compra con 0 unidades y false en el carro.
     */
    public Supplier<Compra> generarCompra0Unidades(){
        Supplier<Compra> proveedor=()-> new Compra(0, false);
        return proveedor;
    }
    
    /**
     * Devuelve la cadena enviada en mayúsculas
     * No hace falta comprobar valores nulos.
     */
    public UnaryOperator<String> convertirAMayusculas(){
    	UnaryOperator<String> funcion = (s) -> s.toUpperCase();
    	return funcion;
    }    
    
    /**
     * Devuelve la suma de dos enteros.
     * Recibe dos parametros int y devuelve un parametro int
     */
    public IntBinaryOperator sumar(){
    	IntBinaryOperator funcion = (a, b) -> a + b;
    	return funcion;
    }    
    
    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que la compra recibida.
     * Se comparará el número de artículos y si tiene mas devolverá true
     * Comprobar si la compra recibida vale empty. En ese caso será equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra(){
    	return (p , c) -> {
            int articulosCompra = (c.isEmpty() ? 0: c.get().getTotalArticulos());
            int articulosPersona = (p.getCesta().isEmpty() ? 0: p.getCesta().get().getTotalArticulos());
    		if(articulosPersona > articulosCompra) {
    			return true;
    		}else
    			return false;
    	};
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las mismas unidades que otra compra.
     * Tener el valor empty equivale a tener 0 unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades(){
    	return (p , c) -> {
            int articulosCompra = (c.isEmpty() ? 0: c.get().getTotalArticulos());
            int articulosPersona = (p.getCesta().isEmpty() ? 0: p.getCesta().get().getTotalArticulos());
    		if(articulosCompra == articulosPersona) {
    			return true;
    		}else
    			return false;
    	};
    }

}
