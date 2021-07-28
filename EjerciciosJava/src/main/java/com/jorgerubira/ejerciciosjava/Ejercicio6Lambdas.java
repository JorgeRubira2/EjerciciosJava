package main.java.com.jorgerubira.ejerciciosjava;


import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import main.java.com.jorgerubira.ejerciciosjava.entities.Compra;
import main.java.com.jorgerubira.ejerciciosjava.entities.Persona;


public class Ejercicio6Lambdas {
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos enteros 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * No hace falta comprobar los valores nulos.
     */
    public Comparator<Integer> compararIntegers(){
        (Integer n1, Integer n2)-> if(n1<n2) System.out.println("n2 mayor") else System.out.println("n1 mayor");
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings 
     * y devuelva si el primero parametro1 es menor que el parametro2
     * Los valores null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings(){
        (String n1, String n2) ->if(n1.lenght<n2.lenght) System.out.println("n2 mayor") else System.out.println("n1 mayor");
    } 

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de menor a mayor.
     * No hace falta comprobar personas con valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente(){
        (Persona p1, Persona p2) -> if(p1.edad < p2.edad) System.out.println("p2 mayor") else System.out.println("p1 mayor");
    } 
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas 
     * para ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente(){
    	 (Persona p1, Persona p2) -> if(p1.edad > p2.edad) System.out.println("n1 menor") else System.out.println("n2 menor");
    }     
    
    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para ordenar 
     * ascendentemente por la ciudad y los que tengan la misma ciudad por nombre.
     * No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre(){
    	(Persona p1, Persona p2) -> if( p1.getNombre().equals(p2.getNombre()) && p1.getDireccion().equals(p2.getDireccion())) System.out.println("son iguales") else System.out.println("son diferentes")
    }     
    
    /**
     * Devolver una función Predicate que permita saber si la persona es de Huesca.
     * tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca(){
        (Persona p1) -> if(p1.getDireccion().equals("Huesca")) System.out.println("es de Huesca") else System.out.println("no es de Huesca")
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad laboral:
     * Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral(){
    	 (Persona p1) -> if(p1.getEdad()>16 && p1.getEdad()<64) System.out.println("En edad laboral") else System.out.println("No en edad laboral");
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas(){
    	  return (p1)->p1.getNombre();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas(){
    	  return (p1)->p1.getCesta();
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las personas.
     * DevoCompraull si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas(){
    	return(p1)->{
        	Optional<Compra> primeraComparacion = p1.getCesta();
		     return null;
        };
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad(){
    	return (Persona p1)-> p1.edad++;
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a la primera.
     * La cesta de la segunda persona debe quedar empty.
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio(){
       return(p1)->{
    	   Persona p1.obtenerCompraDePersonas().andThen(after);
    	   
        }
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
