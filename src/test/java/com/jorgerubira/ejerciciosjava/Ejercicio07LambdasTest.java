/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio07LambdasTest {
    
    public Ejercicio07LambdasTest() {
    }

    @Test
    public void testCompararIntegers() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Comparator<Integer> result = instance.compararIntegers();
        assertEquals(true, result.compare(2, 3)<0);
        assertEquals(true, result.compare(3, 2)>0);
        assertEquals(true, result.compare(2, 2)==0);
    }

    @Test
    public void testCompararStrings() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Comparator<String> result = instance.compararStrings();
        assertEquals(true, result.compare("2", "3")<0);
        assertEquals(true, result.compare("3", "2")>0);
        assertEquals(true, result.compare("2", "2")==0);
        assertEquals(true, result.compare(null, "2")<0);
        assertEquals(true, result.compare("2", null)>0);
        assertEquals(true, result.compare(null, null)==0);
    }

    @Test
    public void testCompararPersonasPorEdadAscendente() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorEdadAscendente();
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 26))<0);
        assertEquals(true, result.compare(new Persona("A", 26),new Persona("A", 24))>0);
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 24))==0);
    }

    @Test
    public void testCompararPersonasPorEdadDescendente() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorEdadDescendente();
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 26))>0);
        assertEquals(true, result.compare(new Persona("A", 26),new Persona("A", 24))<0);
        assertEquals(true, result.compare(new Persona("A", 24),new Persona("A", 24))==0);
    }

    @Test
    public void testCompararPersonasPorCiudadYNombre() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Comparator<Persona> result = instance.compararPersonasPorCiudadYNombre();
        assertEquals(true, result.compare(new Persona("B", "A"),new Persona("A", "B"))<0);
        assertEquals(true, result.compare(new Persona("A", "B"),new Persona("B", "A"))>0);
        assertEquals(true, result.compare(new Persona("A", "A"),new Persona("B", "A"))<0);
        assertEquals(true, result.compare(new Persona("B", "A"),new Persona("A", "A"))>0);
        assertEquals(true, result.compare(new Persona("A", "A"),new Persona("A", "A"))==0);
    }

    @Test
    public void testEsLaPersonaDeHuesca() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Predicate<Persona> result = instance.esLaPersonaDeHuesca();
        assertEquals(true, result.test(new Persona("A", "Huesca")));
        assertEquals(false, result.test(new Persona("A", "Zaragoza")));
    }

    @Test
    public void testEsEnEdadLaboral() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Predicate<Persona> result = instance.esEnEdadLaboral();
        assertEquals(true, result.test(new Persona("A",16)));
        assertEquals(false, result.test(new Persona("A",15)));
        assertEquals(true, result.test(new Persona("A",63)));
        assertEquals(false, result.test(new Persona("A",64)));
    }

    @Test
    public void testObtenerNombreDePersonas() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Function<Persona, String> result = instance.obtenerNombreDePersonas();
        assertEquals("A", result.apply(new Persona("A", "C")));
        assertEquals("B", result.apply(new Persona("B", "C")));
    }

    @Test
    public void testObtenerCompraOpcionalDePersonas() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Function<Persona, Optional<Compra>> result = instance.obtenerCompraOpcionalDePersonas();
        Compra res=new Compra(2,true);
        assertEquals(Optional.of(res), new Persona("A", res));
        assertEquals(Optional.empty(), new Persona("A"));
    }

    @Test
    public void testObtenerCompraDePersonas() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Function<Persona, Compra> result = instance.obtenerCompraDePersonas();
        Compra res=new Compra(2,true);
        assertEquals(res, new Persona("A", res));
        assertNull(result.apply(new Persona("A")));
    }

    @Test
    public void testIncrementarEdad() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Consumer<Persona> result = instance.incrementarEdad();
        Persona p=new Persona("A", 4);
        result.accept(p);
        assertEquals(5, p.getEdad());
    }

    @Test
    public void testMoverCompraAlInicio() {
        System.out.println("moverCompraAlInicio");
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        BiConsumer<Persona, Persona> bi=instance.moverCompraAlInicio();
        Compra c1=new Compra(3, true);
        Compra c2=new Compra(3, true);
        Persona p1=new Persona("A", c1);
        Persona p2=new Persona("B", c2);
        bi.accept(p1, p2);
        assertEquals(c2, p1.getCesta().get());
        assertEquals(Optional.empty(), p2.getCesta().get());
        assertEquals("A", p1.getNombre());
        assertEquals("B", p2.getNombre());
        
        c1=new Compra(3, true);
        p1=new Persona("A", c1);
        p2=new Persona("B");
        bi.accept(p1, p2);
        assertEquals(Optional.empty(), p1.getCesta().get());
        assertEquals(Optional.empty(), p2.getCesta().get());
        assertEquals("A", p1.getNombre());
        assertEquals("B", p2.getNombre());
    }

    @Test
    public void testGenerarCompraVacia() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Supplier<Optional<Compra>> result = instance.generarCompraVacia();
        assertEquals(Optional.empty(), result.get());
    }

    @Test
    public void testGenerarCompra0Unidades() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        Supplier<Compra> result = instance.generarCompra0Unidades();
        assertEquals(0, result.get().getTotalArticulos());
        assertEquals(false, result.get().isCarro());
    }

    @Test
    public void testConvertirAMayusculas() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        UnaryOperator<String> result = instance.convertirAMayusculas();
        assertEquals("ESTO ES UNA PRUEBA", result.apply("Esto es una prueba"));
        assertEquals("QUIZÁ ESTE NO FUNCIONE", result.apply("Quizá este no funcione"));
    }

    @Test
    public void testSumar() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        IntBinaryOperator result = instance.sumar();
        assertEquals(9, result.applyAsInt(4, 5));
    }

    @Test
    public void testMiCompraEsMayorQueOtra() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        IComparadorPersonaCompra result = instance.miCompraEsMayorQueOtra();
        assertEquals(true, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.of(new Compra(2,true)) 
                            ));
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.of(new Compra(4,true)) 
                            ));
        assertEquals(true, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.empty()
                            ));
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A"), 
                                    Optional.empty()
                            ));
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A"), 
                                    Optional.of(new Compra(4,true)) 
                            ));
    }

    @Test
    public void testIgualNumeroDeUnidades() {
        Ejercicio07Lambdas instance = new Ejercicio07Lambdas();
        IComparadorPersonaCompra result = instance.igualNumeroDeUnidades();
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.of(new Compra(2,true)) 
                            ));
        assertEquals(true, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.of(new Compra(4,true)) 
                            ));
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A", new Compra(4,false)), 
                                    Optional.empty()
                            ));
        assertEquals(true, result.compararPersonaConCompra(
                                    new Persona("A"), 
                                    Optional.empty()
                            ));
        assertEquals(false, result.compararPersonaConCompra(
                                    new Persona("A"), 
                                    Optional.of(new Compra(4,true)) 
                            ));
    }
    
}
