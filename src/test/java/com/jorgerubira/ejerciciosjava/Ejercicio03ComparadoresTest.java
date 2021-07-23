package com.jorgerubira.ejerciciosjava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;


public class Ejercicio03ComparadoresTest {
    
    public Ejercicio03ComparadoresTest() {
    }

    @Test
    public void testCompararEnteros() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(true, instance.compararEnteros(new Integer(3), new Integer(3)));
        assertEquals(false, instance.compararEnteros(new Integer(3), new Integer(2)));
        assertEquals(false, instance.compararEnteros(new Integer(3), null));
        assertEquals(false, instance.compararEnteros(null, new Integer(2)));
        assertEquals(false, instance.compararEnteros(null, null));
    }

    @Test
    public void testCompararEnteroConLong() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(true, instance.compararEnteroConLong(new Integer(3), new Long(3)));
        assertEquals(false, instance.compararEnteroConLong(new Integer(3), new Long(2)));
        assertEquals(false, instance.compararEnteroConLong(new Integer(3), null));
        assertEquals(false, instance.compararEnteroConLong(null, new Long(2)));
        assertEquals(false, instance.compararEnteroConLong(null, null));
    }

    @Test
    public void testComprobarNumero() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(true, instance.comprobarNumero("123.4"));
        assertEquals(true, instance.comprobarNumero("12"));
        assertEquals(false, instance.comprobarNumero("1a2"));
        assertEquals(false, instance.comprobarNumero(null));
    }

    @Test
    public void testComprobarOptionalConInteger() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(true, instance.comprobarOptionalConInteger(Optional.of(2), new Integer(2)));
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.of(3), new Integer(2)));
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.of(3), null));
        assertEquals(false, instance.comprobarOptionalConInteger(Optional.ofNullable(null), new Integer(2)));
    }

    @Test
    public void testComprobarOptionalesIntegerYDouble() {
        Ejercicio03Comparadores instance = new Ejercicio03Comparadores();
        assertEquals(true, instance.comprobarOptionalesIntegerYDouble(Optional.of(2), Optional.of(2d)));
        assertEquals(false, instance.comprobarOptionalesIntegerYDouble(Optional.of(2), Optional.of(2.3)));
    }
    
}
