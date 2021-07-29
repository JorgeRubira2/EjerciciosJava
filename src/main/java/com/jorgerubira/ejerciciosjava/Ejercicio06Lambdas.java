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
     * Devolver una función Comparator con Lambdas que compare dos enteros y
     * devuelva si el primero parametro1 es menor que el parametro2 No hace
     * falta comprobar los valores nulos.
     */
    public Comparator<Integer> compararIntegers() {
        return (p1, p2) -> p1 - p2;

    }

    /**
     * Devolver una función Comparator con Lambdas que compare dos Strings y
     * devuelva si el primero parametro1 es menor que el parametro2 Los valores
     * null se considerarán los más bajos a nivel de comparación
     */
    public Comparator<String> compararStrings() {
        Comparator<String> comparador = ((a, b) -> {
            if (a == null && b != null) {
                return -1;
            } else if (a != null && b == null) {
                return 1;
            } else if (a == null && b == null) {
                return 0;
            } else {
                return a.compareToIgnoreCase(b);
            }
        });
        return comparador;
    }

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para
     * ordenar por edad de menor a mayor. No hace falta comprobar personas con
     * valor nulo.
     */
    public Comparator<Persona> compararPersonasPorEdadAscendente() {
        Comparator<Persona> comparador = ((o1, o2) -> {
            if (o1.getEdad() == o2.getEdad()) {
                return 0;
            } else if (o1.getEdad() > o2.getEdad()) {
                return 1;
            } else {
                return -1;
            }
        });
        return comparador;

    }

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para
     * ordenar por edad de mayor a menor
     */
    public Comparator<Persona> compararPersonasPorEdadDescendente() {
        Comparator<Persona> comparador = ((o1, o2) -> {
            if (o1.getEdad() == o2.getEdad()) {
                return 0;
            } else if (o1.getEdad() > o2.getEdad()) {
                return -1;
            } else {
                return 1;
            }
        });
        return comparador;

    }

    /**
     * Devolver una función Comparator con Lambdas que compare dos Personas para
     * ordenar ascendentemente por la ciudad y los que tengan la misma ciudad
     * por nombre. No hace falta comprobar los nulos.
     */
    public Comparator<Persona> compararPersonasPorCiudadYNombre() {

        Comparator<Persona> comparador = ((p1, p2) -> {
            if (p1.getCiudad().equals(p2.getCiudad())) {

                return p1.getNombre().compareTo(p2.getNombre());

            } else {
                return p1.getCiudad().compareTo(p2.getCiudad());

            }
        });
        return comparador;

    }

    /**
     * Devolver una función Predicate que permita saber si la persona es de
     * Huesca. tener en cuenta también valores nulos en la ciudad.
     */
    public Predicate<Persona> esLaPersonaDeHuesca() {
        Predicate<Persona> predicate = (p -> "Huesca".equals(p.getCiudad()));

        return predicate;
    }

    /**
     * Devolver una función Predicate que diga si la persona esta en edad
     * laboral: Mayor o igual que 16 y menor que 64
     */
    public Predicate<Persona> esEnEdadLaboral() {
        Predicate<Persona> predicate = (p -> p.getEdad() < 64 && p.getEdad() >= 16);

        return predicate;
    }

    /**
     * Devolver una función Function que devuelva el nombre de las personas.
     */
    public Function<Persona, String> obtenerNombreDePersonas() {
        Function<Persona, String> funcion = (p -> p.getNombre());

        return funcion;
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las
     * personas.
     */
    public Function<Persona, Optional<Compra>> obtenerCompraOpcionalDePersonas() {
        Function<Persona, Optional<Compra>> funcion = (p -> p.getCesta());

        return funcion;
    }

    /**
     * Devolver una función Function que devuelva la compra (Opcional) de las
     * personas. Devolver null si no tiene compra.
     */
    public Function<Persona, Compra> obtenerCompraDePersonas() {
        Function<Persona, Compra> funcion = (p -> {
            if (p.getCesta().isPresent()) {
                return p.getCesta().get();
            } else {
                return null;
            }
        });

        return funcion;
    }

    /**
     * Crear una función Consumer que incremente la edad de las personas en 1
     */
    public Consumer<Persona> incrementarEdad() {
        Consumer<Persona> consume = (p -> p.setEdad(p.getEdad() + 1));

        return consume;
    }

    /**
     * Crear una función BiConsumer que copie la compra de la segunda persona a
     * la primera. La cesta de la segunda persona debe quedar empty. BiConsumer
     * recibe dos parametros y lleva void
     */
    public BiConsumer<Persona, Persona> moverCompraAlInicio() {
        BiConsumer<Persona, Persona> biconsume = ((p1, p2) -> {

            if (p2.getCesta().isPresent()) {
                p1.setCesta(p2.getCesta().get());
                p2.setCesta(null);

            } else {
                p1.setCesta(null);
                p2.setCesta(null);
            }
        });

        return biconsume;
    }

    /**
     * Devuelve una compra vacia.
     */
    public Supplier<Optional<Compra>> generarCompraVacia() {

        /* Supplier<Optional<Compra>> suplier=()->Optional.empty();    
       return suplier;*/
        return () -> Optional.empty();

    }

    /**
     * Devuelve una compra con 0 unidades y false en el carro.
     */
    public Supplier<Compra> generarCompra0Unidades() {
        return () -> new Compra(0, false);
    }

    /**
     * Devuelve la cadena enviada en mayúsculas No hace falta comprobar valores
     * nulos.
     */
    public UnaryOperator<String> convertirAMayusculas() {
        UnaryOperator<String> string = (s -> s.toUpperCase());
        return string;
    }

    /**
     * Devuelve la suma de dos enteros. Recibe dos parametros int y devuelve un
     * parametro int
     */
    public IntBinaryOperator sumar() {
        IntBinaryOperator operator = ((a, b) -> a + b);
        return operator;
    }

    /**
     * Devuelve un comparador para ver si la compra de la persona es mayor que
     * la compra recibida. Se comparará el número de artículos y si tiene mas
     * devolverá true Comprobar si la compra recibida vale empty. En ese caso
     * será equivalente a 0 unidades.
     */
    public IComparadorPersonaCompra miCompraEsMayorQueOtra() {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Devuelve un comparador para ver si la compra de una persona tiene las
     * mismas unidades que otra compra. Tener el valor empty equivale a tener 0
     * unidades.
     */
    public IComparadorPersonaCompra igualNumeroDeUnidades() {
        throw new RuntimeException("Pendiente de hacer");
    }

}
