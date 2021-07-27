/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;
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
        assertEquals("este es un texto normal", instance.convertirAMinusculas("Este es un texto NORMAL"));
        assertEquals("quizá este no funcione", instance.convertirAMinusculas("QUIZÁ este No funcione"));
    }

    @Test
    public void testSegundaPalabra() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("resultado", instance.segundaPalabra("El resultado es lo que hay que obtener"));
        assertEquals("es", instance.segundaPalabra("Esta es la segunda palabra"));
    }

    @Test
    public void testBuscar() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(5, instance.buscar("Hola Pepe", "pepe"));
        assertEquals(-1, instance.buscar("Hola alberto", "Alfredo"));
        assertEquals(0, instance.buscar("Quizá este no se encuentre", "QUIZÁ"));
    }

    @Test
    public void testEqualsInsensibleMayusculasYTildes() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(true, instance.equalsInsensibleMayusculasYTildes("Balón", "BALON"));
        assertEquals(true, instance.equalsInsensibleMayusculasYTildes("Cálelín", "CALélIN"));
        assertEquals(false, instance.equalsInsensibleMayusculasYTildes("rr", "çrr"));
    }

    @Test
    public void testConvertirCamelCase() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("EstaEsLaFrase", instance.convertirCamelCase("Esta_es_la_frase"));
        assertEquals("TablaDeIntereses", instance.convertirCamelCase("TABLA_DE_INTERESES"));
        assertEquals("EsteTambiénSeDebeConvertir", instance.convertirCamelCase("Este_también_Se_debe_convertir"));
    }

    @Test
    public void testContarPalabras() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(6, instance.contarPalabras("Hola.Que Tal,Esta  todo ok"));
        assertEquals(3, instance.contarPalabras("Hola.        Que Tal"));
    }

     
    
    @Test
    public void testContarLineas() {
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals(2, instance.contarLineas("Linea1\n\nEste es un texto random\n"));
        assertEquals(0, instance.contarLineas(""));
        assertEquals(2, instance.contarLineas("Prueba de salto con dos carácteres\r\n\r\nEste es un texto random\r\n"));
    }
    
    @Test
    public void testQuitarEspacios(){
        Ejercicio05Strings instance = new Ejercicio05Strings();
        assertEquals("Texto a probar", instance.quitarEspacios("   Texto a probar   "));
    }    
    @Test
    public void testContarVocales(){
        Ejercicio05Strings instance=new Ejercicio05Strings();
        assertEquals(5, instance.contarVocales("MurCIÉlagó"));
    }
   
    
}
