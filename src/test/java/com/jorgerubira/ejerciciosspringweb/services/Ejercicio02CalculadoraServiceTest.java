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
    }

    @Test
    public void testRestar() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(2, instance.restar(4, 2));
    }

    @Test
    public void testMultiplicar() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(8.0, instance.multiplicar(2d, 4d));
    }

    @Test
    public void testDividir() {
        Ejercicio02CalculadoraService instance = new Ejercicio02CalculadoraService();
        assertEquals(2.5, instance.dividir(5d, 2d));
    }
    
}
