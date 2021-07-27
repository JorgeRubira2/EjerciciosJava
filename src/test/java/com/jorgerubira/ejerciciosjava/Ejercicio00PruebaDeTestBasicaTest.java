package com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Ejercicio00PruebaDeTestBasicaTest {

    @Test                 
    public void testSumar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(10, instance.sumar(6, 4));
    }

    @Test
    public void testRestar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(2, instance.restar(6, 4));
    }

    @Test
    public void testMultiplicar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(24, instance.multiplicar(6, 4));
    }
    
}