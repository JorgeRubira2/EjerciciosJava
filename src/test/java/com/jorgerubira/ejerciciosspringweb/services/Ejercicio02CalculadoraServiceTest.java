/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio02CalculadoraServiceTest {
    
    public Ejercicio02CalculadoraServiceTest() {
    }

    @Test
    public void testSumar() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(7, instance.sumar(3, 4));
        assertEquals(9, instance.sumar(5, 4));
        assertEquals(14, instance.sumar(10, 4));
    }

    @Test
    public void testRestar() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(2, instance.restar(4, 2));
        assertEquals(0, instance.restar(4, 4));
        assertEquals(5, instance.restar(9, 4));
    }

    @Test
    public void testMultiplicar() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(8, instance.multiplicar(2, 4));
        assertEquals(4, instance.multiplicar(1, 4));
        assertEquals(12, instance.multiplicar(3, 4));
        
    }

    @Test
    public void testDividir() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(2, instance.dividir(5, 2));
        assertEquals(5, instance.dividir(5, 1));
        assertEquals(1, instance.dividir(5, 5));
    }
    
}
