package test.java.com.jorgerubira.ejerciciosjava;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import com.jorgerubira.ejerciciosjava.Ejercicio03Comparadores;

import static org.junit.jupiter.api.Assertions.*;


public class Ejercicio03ComparadoresTest {
    
    public Ejercicio03ComparadoresTest() {
    }

    @Test
    public void testCompararEnteros() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(instance.compararEnteros(1,1),true);
        assertEquals(instance.compararEnteros(11,11),true);
        assertEquals(instance.compararEnteros(0,1),false);
        
    }

    @Test
    public void testCompararEnteroConLong() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(instance.compararEnteroConLong(1,1L),true);
        assertEquals(instance.compararEnteroConLong(2,8L),false);
        assertEquals(instance.compararEnteroConLong(9,9L),true);
       
    }

    @Test
    public void testComprobarNumero() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        
        assertEquals(true, instance.comprobarNumero("1"));
        assertEquals(true, instance.comprobarNumero("2"));
        assertEquals(true, instance.comprobarNumero("10"));
        assertEquals(false, instance.comprobarNumero("a"));
        
       
    }

    @Test
    public void testComprobarOptionalConInteger() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.of(3), new Integer(2)));
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.of(9), new Integer(7)));
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.of(8), new Integer(1)));

    }

    @Test
    public void testComprobarOptionalesIntegerYDouble() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        Optional<Integer> i=Optional.of(1);
        Optional<Double> i2=Optional.of(1d);
        assertEquals(true, instance.comprobarOptionalesIntegerYDouble(i, i2));
        Optional<Integer> i3=Optional.of(1);
        Optional<Double> i4=Optional.of(2d);
        assertEquals(false, instance.comprobarOptionalesIntegerYDouble(i3, i4));
    }
    
}
