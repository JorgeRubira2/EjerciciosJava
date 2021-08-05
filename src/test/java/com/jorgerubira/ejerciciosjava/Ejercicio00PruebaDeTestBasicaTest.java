package test.java.com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;

import com.jorgerubira.ejerciciosjava.Ejercicio00PruebaDeTestBasica;

import static org.junit.jupiter.api.Assertions.*;


public class Ejercicio00PruebaDeTestBasicaTest {
    
    public Ejercicio00PruebaDeTestBasicaTest() {
    }

    @Test
    public void testSumar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(14, instance.sumar(10, 4));
    }

    @Test
    public void testRestar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(-6, instance.restar(0, 6));
    }

    @Test
    public void testMultiplicar() {
        Ejercicio00PruebaDeTestBasica instance = new Ejercicio00PruebaDeTestBasica();
        assertEquals(9, instance.multiplicar(3, 3));
    }
    
}
