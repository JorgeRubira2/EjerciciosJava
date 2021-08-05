
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Ejercicio01ListaNombresServiceTest {
    
    public Ejercicio01ListaNombresServiceTest() {
    }

    @Test
    public void testAltaNombre() throws Exception {
        String palabra=UUID.randomUUID().toString();
        Ejercicio01ListaNombresService instance = new Ejercicio01ListaNombresService();
        instance.altaNombre(palabra);
        assertEquals(true, instance.getLista().stream().anyMatch(x->palabra.equals(x))); 
        assertThrows(OperacionEnListaException.class, ()->instance.altaNombre(palabra));
    }

    @Test
    public void testBajaNombre() {
        String palabra=UUID.randomUUID().toString();
        Ejercicio01ListaNombresService instance = new Ejercicio01ListaNombresService();
        try{
            instance.altaNombre(palabra);    
        }catch(OperacionEnListaException e){
            fail("No funcionó el alta");
        }
        int sizePre=instance.getLista().size();
        instance.bajaNombre(palabra);
        assertEquals(sizePre-1, instance.getLista().size());
    }

    @Test
    public void testGetLista() {
        Ejercicio01ListaNombresService instance = new Ejercicio01ListaNombresService();
        assertNotEquals(null, instance.getLista());
    }
    
}
