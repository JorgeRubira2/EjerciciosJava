/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.ICalculadoraBasica;

import main.java.com.jorgerubira.ejerciciosjava.Ejercicio08CadenaMetodosCalculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio08CadenaMetodosCalculadoraTest {
    
    public Ejercicio08CadenaMetodosCalculadoraTest() {
    }

    @Test
    public void testGeneral() {
        Ejercicio08CadenaMetodosCalculadora instance = new Ejercicio08CadenaMetodosCalculadora();
        assertEquals(3, instance.reset().sumar(4).restar(2).multiplicar(3).dividir(4).getResultado());
        assertEquals(8, instance.reset().sumar(6).dividir(3).multiplicar(5).restar(2).getResultado());
        assertEquals(7.5, instance.reset().sumar(6).dividir(3).multiplicar(5).restar(2.5).getResultado());
        assertEquals(Double.POSITIVE_INFINITY, instance.reset().sumar(6).dividir(0).getResultado());
        assertEquals(Double.NEGATIVE_INFINITY, instance.reset().restar(6).dividir(0).getResultado());
    }
    
}