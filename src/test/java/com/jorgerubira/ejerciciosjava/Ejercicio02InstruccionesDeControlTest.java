/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import org.junit.jupiter.api.Test;

import main.java.com.jorgerubira.ejerciciosjava.Ejercicio02InstruccionesDeControl;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio02InstruccionesDeControlTest {
    
    public Ejercicio02InstruccionesDeControlTest() {
    }
   
    public void suma(int a,int b){
    	 Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
         assertEquals(instance.suma(1,1),2);
         assertEquals(instance.suma(2,2),4);
         assertEquals(instance.suma(2,4),6);
    }

    @Test
    public void testMaximoValor() {
    	Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
        assertEquals(instance.maximoValor(1,2,3),3);
        assertEquals(instance.maximoValor(4,4,5),5);
        assertEquals(instance.maximoValor(6,5,4),6);
    }

    @Test
    public void testSumarElementos() {
    	Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
    	int[] vector = new int[4];
    	for(int i=0;i<4;i++) {
    		vector [i]=i;
    	}
    	 int[] vector2 = new int[4];
     	for(int i=0;i<4;i++) {
     		vector2 [i]=3;
     	}
     	assertEquals(instance.sumarElementos(vector),6);
     	assertEquals(instance.sumarElementos(vector2),12);
    }

    @Test
    public void testContarPares() {
    	Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
    	int[] vector = new int[4];
    	for(int i=0;i<4;i++) {
    		vector [i]=i;
    	}
    	int[] vector2 = new int[4];
    	for(int i=0;i<4;i++) {
    		vector2 [i]=i+1;
    	}
    	assertEquals(instance.contarPares(vector),2);
    
    }

    @Test
    public void testMaximoComunDivisor() {
    	Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
    	assertEquals(instance.maximoComunDivisor(2,8),2);
    	assertEquals(instance.maximoComunDivisor(3,9),3);
    	
    }

    @Test
    public void testContarVocales() {
    	Ejercicio02InstruccionesDeControl instance= new Ejercicio02InstruccionesDeControl();
    	assertEquals(instance.contarVocales("Hola"),2);
    	assertEquals(instance.contarVocales("me"),1);
    	assertEquals(instance.contarVocales("llamo"),2);
    	
    	
    }
    
}
