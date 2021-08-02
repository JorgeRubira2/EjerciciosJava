/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;

import main.java.com.jorgerubira.ejerciciosjava.Ejercicio05Strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

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
        assertEquals(instance.convertirAMinusculas("HOLA"),"hola");
     
    }

    @Test
    public void testSegundaPalabra() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(instance.segundaPalabra("hola que tal"),"que");
       
    }

    @Test
    public void testBuscar() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(0,instance.buscar("Hola","Hola que tal"));
    }

    @Test
    public void testEqualsInsensibleMayusculasYTildes() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
      
    }

    @Test
    public void testConvertirCamelCase() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("holaQueTal",instance.convertirCamelCase("hola que tal"));
       
    }

    @Test
    public void testContarPalabras() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(3,instance.contarPalabras("hola que tal"));
    }

    @Test
    public void testContarLineas() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(1,instance.contarLineas("hola\n"));
        assertEquals(2,instance.contarLineas("hola\ntu\n"));
        
    }
    
}
