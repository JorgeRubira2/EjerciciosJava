/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;

import main.java.com.jorgerubira.ejerciciosjava.Ejercicio04Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio04ColeccionesTest {
    
    public Ejercicio04ColeccionesTest() {
    }

    @Test
    public void testInsertarElementoEnLista() {
        List<Long> l= new ArrayList<>();
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.insertarElementoEnLista(1L,l);
        assertEquals(l.size(),1);
        instance.insertarElementoEnLista(2L,l);
        assertEquals(l.size(),2);
        
    }

    @Test
    public void testInsertarElementoEnTabla() {
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Map<String, Integer>m= new HashMap();
        instance.insertarElementoEnTabla("Primero",1,m);
        assertEquals(m.size(),1);
        instance.insertarElementoEnTabla("Segundo",2,m);
        assertEquals(m.size(),2);
        
        
    }

    @Test
    public void testCopiar() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List original= new ArrayList<Double>();
        List destino= new ArrayList<Double>();
        original.add(1d);
        original.add(2d);
        original.add(3d);
        instance.copiar(original,destino);
        assertEquals(destino.size(),3);
        }

    @Test
    public void testContarElementosEnSet() {
      
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Set<Integer> s1=new HashSet<Integer>();
        s1.add(1);
        s1.add(2);
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        assertEquals(instance.contarElementosEnSet(l,s1),2);
       
    }
    
    @Test
    public void testContarElementosEnSetNoRepetidos() {
       
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Set<Integer> s1=new HashSet<Integer>();
        s1.add(1);
        s1.add(2);
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(instance.contarElementosEnSetNoRepetidos(l,s1),1);
     
    }    

    @Test
    public void testContarIntegers() {
      
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Map<String, Object> tabla= new HashMap<String,Object>();
        tabla.put("1",1);
        tabla.put("2",2);
        tabla.put("3",3);   
        assertEquals(instance.contarIntegers(tabla),3);
    }

    @Test
    public void testBorrarPersonasHuescaDeLista() {
       
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<Persona> listaPersonas= new ArrayList<Persona>();
        listaPersonas.add(new Persona("I","Huesca"));
        listaPersonas.add(new Persona("J","Zaragoza"));
        listaPersonas.add(new Persona("K","Teruel"));
        listaPersonas.add(new Persona("L","Huesca"));
        instance.borrarPersonasHuescaDeLista(listaPersonas);
        assertEquals(listaPersonas.size(),2);
    }
 
    @Test
    public void testBorrarPersonasHuescaDeMapa() {
      
    	Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
    	 /*Map<String, Persona> tabla= new HashMap<String,Persona>();
         tabla.put("Huesca",new Persona("1"));
         tabla.put("Huesca",new Persona("2"));
         tabla.put("Huesca",new Persona("3"));
         instance.borrarPersonasHuescaDeMapa(tabla);*/
         //assertEquals(tabla.size(),3);
        
     
    }

    @Test
    public void testEntrarPersonaALaCola() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        
     
    }

    @Test
    public void testGenerarLista() {
      
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
       
    }

    @Test
    public void testGenerarArrayList() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        
    }

    @Test
    public void testCatalogar() {
       
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
      
    }

    @Test
    public void testCoincidencias() {
       
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        
     
    }
    
    @Test
    public void testAprobados() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
      
    }

    @Test
    public void testTotalProductos() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        
        
    }

    @Test
    public void testAnnadirElementosMultiples() {
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
       
    }
    
}
