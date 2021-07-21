/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio01ConversionTiposTest {
    
    public Ejercicio01ConversionTiposTest() {
    }

    @org.junit.jupiter.api.Test
    public void testTextoAEntero() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals(245, instance.textoAEntero("245"));
        assertEquals(-15, instance.textoAEntero("-15"));
        assertThrows(Exception.class, ()-> instance.textoAEntero("aaa"));
    }

    @org.junit.jupiter.api.Test
    public void testDecimalesAEntero() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals(24, instance.decimalesAEntero(-24.2f));
        assertEquals(44, instance.decimalesAEntero(44.8f));
    }

    @org.junit.jupiter.api.Test
    public void testEnteroAFloat() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals(2f, instance.enteroAFloat(2));
        assertEquals(-2f, instance.enteroAFloat(-5));
    }

    @org.junit.jupiter.api.Test
    public void testSiguienteCaracter() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals('b', instance.siguienteCaracter('a'));
        assertEquals('D', instance.siguienteCaracter('C'));
    }

    @org.junit.jupiter.api.Test
    public void testObtenerAscii_char() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals(65, instance.obtenerAscii('A'));
        assertEquals(97, instance.obtenerAscii('a'));
        
    }

    @org.junit.jupiter.api.Test
    public void testTextoADouble_String() {
        Ejercicio01ConversionTipos instance = new Ejercicio01ConversionTipos();
        assertEquals(42.5,  instance.textoADouble("42.5"));
        assertEquals(-22.9, instance.textoADouble("-22.9"));
        assertEquals(null,  instance.textoADouble("aaa"));
    }
    
}
