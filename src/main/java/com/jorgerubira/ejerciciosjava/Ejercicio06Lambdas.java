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

public class Ejercicio06Lambdas {
	/**
     * Devolver una funci�n Comparator con Lambdas que compare dos enteros y
     * devuelva si el primero parametro1 es menor que el parametro2 No hace
     * falta comprobar los valores nulos.
     */
    public Comparator<Integer> compararIntegers() {
        return (p1, p2) -> p1 - p2;

    }

    /**
     * Devolver una funci�n Comparator con Lambdas que compare dos Strings y
     * devuelva si el primero parametro1 es menor que el parametro2 Los valores
     * null se considerar�n los m�s bajos a nivel de comparaci�n
     */
    public Comparator<String> compararStrings() {
        return (p1, p2) -> {
            if (p1 == null && p2==null) {
                return 0;
            } else if (p1==null) {
                return -1;
            } else if (p2==null) {
                return 1;
            } else if (p1.compareTo(p2) == 0) {
                return 0;
            } else if (p1.compareTo(p2) > 0) {
                return 1;
            } else {
                return -1;
            }
        };
    }

    /**
     * Devolver una funci�n Comparator con Lambdas que compare dos Personas para
     * ordenar por edad de menor a mayor. No hace falta comprobar personas con
     * valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente() {
        return (p1,p2) -> p1.getEdad() - p2.getEdad();
    }

    /**
     * Devolver una funci�n Comparator con Lambdas que compare dos Personas para
     * ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente() {
       return (p1,p2) -> p2.getEdad()- p1.getEdad();
    }

    /**
     * Devolver una funci�n Comparator con Lambdas que compare dos Personas para
     * ordenar ascendentemente por la ciudad y los que tengan la misma ciudad
     * por nombre. No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre() {
        return (p1,p2) -> {
            if (p1.getCiudad().compareTo(p2.getCiudad())==0){
                    return p1.getNombre().compareTo(p2.getNombre());
                } else {
                return p1.getCiudad().compareTo(p2.getCiudad());
            }
        };
        
    }

    /**
     * Devolver una funci�n Predicate que permita saber si la persona es de
     * Huesca. tener en cuenta tambi�n valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca() {
        return p -> p.getCiudad().equals("Huesca");
    }

    /**
     * Devolver una funci�n Predicate que diga si la persona esta en edad
     * laboral: Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral() {
        return p -> p.getEdad() >= 16 &&  p.getEdad() <64;
    }

    /**
     * Devolver una funci�n Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas() {
        return p-> p.getNombre();
    }

    /**
     * Devolver una funci�n Function que devuelva la compra (Opcional) de las
     * personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas() {
        return p -> p.getCesta();
    }

    /**
     * Devolver una funci�n Function que devuelva la compra (Opcional) de las
     * personas. Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas() {
        return p -> {
            if (p.getCesta().isPresent()){
                  return p.getCesta().get();
            }else {
                return null;
            }
        };
    }

    /**
     * Crear una funci�n Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad() {
        return p -> p.setEdad(p.getEdad()+1);
    }

    /**
     * Crear una funci�n BiConsumer que copie la compra de la segunda persona a
     * la primera. La cesta de la segunda persona debe quedar empty. BiConsumer
     * recibe dos parametros y lleva void
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio() {
        return (p1,p2) -> {
                if (p2.getCesta().isPresent()){
                    p1.setCesta(p2.getCesta().get());
                } else {
                    p1.setCesta(null);
                }
                 p2.setCesta(null);
        };
    }

    /**
     * Devuelve una compra vacia.
     */
    public Supplier<Optional<Compra>> generarCompraVacia() {
        return () ->  Optional.ofNullable((Compra)null); 
        
    }

    /**
     * Devuelve una compra con 0 unidades y false en el carro.
     */
    public Supplier<Compra> generarCompra0Unidades() {
        return () -> new Compra(0,false);
    }

    /**
     * Devuelve la cadena enviada en may�sculas No hace falta comprobar valores
     * nulos.
     */
    public UnaryOperator<String> convertirAMayusculas() {
        return p -> p.toUpperCase();
    }

    /**
     * Devuelve la suma de dos enteros. Recibe dos parametros int y devuelve un
     * parametro int
     */
    public IntBinaryOperator sumar() {
        return (i,j) -> i+j;
    }

    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que
     * la compra recibida. Se comparar� el n�mero de art�culos y si tiene mas
     * devolver� true Comprobar si la compra recibida vale empty. En ese caso
     * ser� equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra() {
		return null;
        
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las
     * mismas unidades que otra compra. Tener el valor empty equivale a tener 0
     * unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades() {
		return null;
        
    }
}
