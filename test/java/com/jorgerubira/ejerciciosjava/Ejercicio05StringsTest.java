/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;

import main.java.com.jorgerubira.ejerciciosjava.Ejercicio05Strings;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio05StringsTest {
    
    public Ejercicio05StringsTest() {
    }

    @Test
    public void testConvertirAMinusculas() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("convertir a minusculas", instance.convertirAMinusculas("CONVERTIR A MINUSCULAS"));
        assertEquals("convertir a minusculas mal", instance.convertirAMinusculas("CONVERTIR A MINUSCULAS mal"));
    }

    @Test
    public void testSegundaPalabra() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("segunda", instance.segundaPalabra("la segunda palabra"));
        assertEquals("la", instance.segundaPalabra("Esta no es la segunda palabra"));
    }

    @Test
    public void testBuscar() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(5, instance.buscar("Hola caracola", "caracola"));
        assertEquals(12, instance.buscar("encuentrame esta", "esta"));
    }

    @Test
    public void testEqualsInsensibleMayusculasYTildes() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(true, instance.equalsInsensibleMayusculasYTildes("paLO", "PALO"));
        assertEquals(true, instance.equalsInsensibleMayusculasYTildes("boTa", "BOTA"));
        assertEquals(false, instance.equalsInsensibleMayusculasYTildes("k", "ra"));
    }

    @Test
    public void testConvertirCamelCase() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("FraseDePrueba", instance.convertirCamelCase("Frase_de_prueba"));
        assertEquals("SegundaPrueba", instance.convertirCamelCase("Segunda_Prueba"));
        assertEquals("TerceraPrueba", instance.convertirCamelCase("Tercera_Prueba"));
    }

    @Test
    public void testContarPalabras() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(3, instance.contarPalabras("Hola test primero"));
        assertEquals(2, instance.contarPalabras("Hola Caracola"));
    }

    @Test
    public void testContarLineas() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(2, instance.contarLineas("Texto de prueba\n\nTexto de prueba 1\n"));
        assertEquals(0, instance.contarLineas("Texto de prueba"));
        assertEquals(2, instance.contarLineas("Texto3\r\n\r\nEste es un texto random\r\n"));
    }
    
}
