package test.java.com.jorgerubira.ejerciciosjava;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import com.jorgerubira.ejerciciosjava.Ejercicio01ConversionTipos;

public class Ejercicio01ConversionTiposTest {
    
    public Ejercicio01ConversionTiposTest() {
    	
    }

    @org.junit.jupiter.api.Test
    public void testTextoAEntero() {
       Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
       assertEquals(instance.textoAEntero("7"),7);
       assertEquals(instance.textoAEntero("2"),2);
       assertEquals(instance.textoAEntero("3"),3);
    }

    @org.junit.jupiter.api.Test
    public void testDecimalesAEntero() {
    	Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
        assertEquals(instance.decimalesAEntero(9.0F),9);
        assertEquals(instance.decimalesAEntero(8.0F),8);
        assertEquals(instance.decimalesAEntero(7.0F),7);
    }

    @org.junit.jupiter.api.Test
    public void testEnteroAFloat() {
    	Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
    	 assertEquals(instance.enteroAFloat(9),9.0f);
    	 assertEquals(instance.enteroAFloat(8),8.0f);
    	 assertEquals(instance.enteroAFloat(7),7.0f);
    }

    @org.junit.jupiter.api.Test
    public void testSiguienteCaracter() {
    Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
   	 assertEquals(instance.siguienteCaracter('a'),'b');
   	 assertEquals(instance.siguienteCaracter('b'),'c');
   	 assertEquals(instance.siguienteCaracter('c'),'d');
    }

    @org.junit.jupiter.api.Test
    public void testObtenerAscii_char() {
    	 Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
    	 assertEquals(instance.obtenerAscii('a'),97);
    	 assertEquals(instance.obtenerAscii('b'),98);
    	 assertEquals(instance.obtenerAscii('c'),99);
        
    }

    @org.junit.jupiter.api.Test
    public void testTextoADouble_String() {
    	Ejercicio01ConversionTipos instance= new Ejercicio01ConversionTipos();
    	 assertEquals(instance.textoADouble("8"),8d);
    	 assertEquals(instance.textoADouble("9"),9d);
    	 assertEquals(instance.textoADouble("1"),1d);
    }
    
}
