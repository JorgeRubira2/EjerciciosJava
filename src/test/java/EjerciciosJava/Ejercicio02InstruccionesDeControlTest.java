/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosJava;

import EjerciciosJava.Ejercicio02InstruccionesDeControl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio02InstruccionesDeControlTest {
    
    public Ejercicio02InstruccionesDeControlTest() {
    }
    
    public int suma(int a,int b){
        int c=a+b;
        return c;
    }

    @Test
    public void testMaximoValor() {
        Ejercicio02InstruccionesDeControl instance = new Ejercicio02InstruccionesDeControl();
        assertEquals(6, instance.maximoValor(3, 5, 6));
        assertEquals(3, instance.maximoValor(3, -5, 2));
        assertEquals(6, instance.maximoValor(6, 6, 3));
    }

    @Test
    public void testSumarElementos() {
        Ejercicio02InstruccionesDeControl instance = new Ejercicio02InstruccionesDeControl();
        int[] vector={1,2,5,2};
        assertEquals(10, instance.sumarElementos(vector));
    }

    @Test
    public void testContarPares() {
        Ejercicio02InstruccionesDeControl instance = new Ejercicio02InstruccionesDeControl();
        int[] vector={1,2,5,2};
        assertEquals(2, instance.contarPares(vector));
    }

    @Test
    public void testMaximoComunDivisor() {
        Ejercicio02InstruccionesDeControl instance = new Ejercicio02InstruccionesDeControl();
        assertEquals(3, instance.maximoComunDivisor(12, 9));
        assertEquals(5, instance.maximoComunDivisor(25, 15));
    }

    @Test
    public void testContarVocales() {
        Ejercicio02InstruccionesDeControl instance = new Ejercicio02InstruccionesDeControl();
        assertEquals(9, instance.contarVocales("Esto Es Un Murcielago"));
    }
    
}
