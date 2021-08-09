/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
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
        instance.insertarElementoEnTabla("Primer elemento",1,m);
        assertEquals(m.size(),1);
        instance.insertarElementoEnTabla("Segundo elemento",2,m);
        assertEquals(m.size(),2);
        
    }

    @Test
    public void testCopiar() {
      
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List original= new ArrayList<Double>();
        List destino= new ArrayList<Double>();
        original.add(3d);
        original.add(5d);
        instance.copiar(original,destino);
        assertEquals(destino.size(),2);
   
    }

    @Test
    public void testContarElementosEnSet() {
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Set<Integer> s1=new HashSet<Integer>();
        s1.add(2);
        s1.add(4);
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(2);
        l.add(4);
        assertEquals(instance.contarElementosEnSet(l,s1),2);
        
    }
    
    @Test
    public void testContarElementosEnSetNoRepetidos() {
        
    }    

    @Test
    public void testContarIntegers() {
        Map<String, Object> tabla = Map.of("A", 4L, "B", 1, "C", "Hola", "D", 4, "E", 4.4);
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        int result = instance.contarIntegers(tabla);
        assertEquals(2, result);
    }

    @Test
    public void testBorrarPersonasHuescaDeLista() {
        List<Persona> personas=new ArrayList<>();
        personas.add(new Persona("I","Huesca"));
        personas.add(new Persona("J","Zaragoza"));
        personas.add(new Persona("K","Teruel"));
        personas.add(new Persona("L","Huesca"));
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.borrarPersonasHuescaDeLista(personas);
        assertEquals(2, personas.size() );
        
    }

    @Test
    public void testBorrarPersonasHuescaDeMapa() {
        Map<String, Persona> personas=new HashMap<>();
        personas.put("Juan", new Persona("Juan", "Zaragoza"));
        personas.put("Fran", new Persona("Fran", "Huesca"));
        personas.put("Alberto", new Persona("Alberto", "Huesca"));
        personas.put("Gutierrez", new Persona("Gutierrez", "Teruel"));
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.borrarPersonasHuescaDeMapa(personas);
        assertEquals(2, personas.size() );
        assertEquals("Juan", personas.get("Juan").getNombre() );
        assertEquals("Gutierrez", personas.get("Gutierrez").getNombre() );
    }

    @Test
    public void testEntrarPersonaALaCola() {
        
        
        
    }

    @Test
    public void testGenerarLista() {
        int[] valores = {1,2,3};
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<int[]> result = instance.generarLista(valores);
      
        assertEquals(result.contains(5),false);
        assertEquals(result.contains(8),false);
        
    }

    @Test
    public void testGenerarArrayList() {
        int[] valores = {1,2,3};
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<Integer> result = instance.generarArrayList(valores);
        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
    }

    @Test
    public void testCatalogar() {
       
    }

    @Test
    public void testCoincidencias() {
        Set<String> diana = new HashSet<>(Set.of("Blanco", "flecha"));
        Set<String> color = new HashSet<>(Set.of("Blanco", "Azul", "Morado"));

        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Set<String> result = instance.coincidencias(diana, color);
        assertEquals(1, result.size());
        assertEquals(true, result.contains("Blanco"));
        assertEquals(false, result.contains("Azul"));
    }
    
    @Test
    public void testAprobados() {
       
        
    }

    @Test
    public void testTotalProductos() {
        System.out.println("totalProductos");
        List<Persona> personas = new ArrayList<Persona>();
        Persona p1=new Persona("Fran", "Zaragoza");
        p1.setCesta(new Compra(4,true));
        personas.add(p1);
        Persona p2=new Persona("Ana", "Zaragoza");
        p2.setCesta(new Compra(5,true));
        personas.add(p2);
        Persona p3=new Persona("Fran", "Zaragoza");
        p3.setCesta(new Compra(2,true));
        personas.add(p3);
        Persona p4=new Persona("Fran", "Zaragoza");
        personas.add(p4);
        Persona p5=new Persona("Susana", "Zaragoza");
        personas.add(p5);

        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Map<String, Integer> result = instance.totalProductos(personas);
        assertEquals(3, result.size());
        assertEquals(6, result.get("Fran"));
        assertEquals(5, result.get("Ana"));
        assertEquals(0, result.get("Susana"));
        
    }

    @Test
    public void testAnnadirElementosMultiples() {
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<Integer> destino=new ArrayList();
        destino.add(1);
        instance.annadirElementosMultiples(destino, 2,3,4);
        assertEquals(4, destino.size());
        assertEquals(2, destino.get(1));
        assertEquals(3, destino.get(2));
        assertEquals(4, destino.get(3));
    }
    
}
