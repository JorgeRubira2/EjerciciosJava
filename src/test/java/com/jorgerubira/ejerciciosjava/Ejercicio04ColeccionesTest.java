/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.jorgerubira.ejerciciosjava;

import main.java.com.jorgerubira.ejerciciosjava.pojo.Compra;
import main.java.com.jorgerubira.ejerciciosjava.pojo.Persona;

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
        List<Long> destino = new ArrayList<>();
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.insertarElementoEnLista(4, destino);
        instance.insertarElementoEnLista(-4, destino);
        instance.insertarElementoEnLista(0, destino);
        instance.insertarElementoEnLista(5, destino);
        assertEquals(3, destino.size() );
        assertEquals(4L, destino.get(0) );
        assertEquals(0L, destino.get(1) );
        assertEquals(5L, destino.get(2) );
    }

    @Test
    public void testInsertarElementoEnTabla() {
        Map<String, Integer> destino = new HashMap<>();
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.insertarElementoEnTabla("Juan", 4, destino);
        instance.insertarElementoEnTabla("Pedro", 2, destino);
        instance.insertarElementoEnTabla("Juan", 6, destino);
        assertEquals(2, destino.size() );
        assertEquals(4, destino.get("Juan") );
        assertEquals(2, destino.get("Pedro") );     //2 
    }

    @Test
    public void testCopiar() {
        List<Double> origen = Arrays.asList(1d,2d);
        List<Double> destino = new ArrayList<>();
        destino.add(3d);
        destino.add(4d);
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.copiar(origen,destino);
        assertEquals(4, destino.size() );
        assertEquals(3d, destino.get(0) );
        assertEquals(4d, destino.get(1) );
        assertEquals(1d, destino.get(2) );
        assertEquals(2d, destino.get(3) );
    }

    @Test
    public void testContarElementosEnSet() {
        List<Integer> lista = Arrays.asList(1,4,14,5,10,22,5);
        Set<Integer> enLista = Set.of(1,5,2,3);
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        int result = instance.contarElementosEnSet(lista, enLista);
        assertEquals(3, result);
    }
    
    @Test
    public void testContarElementosEnSetNoRepetidos() {
        List<Integer> lista = Arrays.asList(1,4,14,5,10,22,5);
        Set<Integer> enLista = new HashSet<>();
        enLista.add(1);
        enLista.add(5);
        enLista.add(2);
        enLista.add(3);
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        int result = instance.contarElementosEnSetNoRepetidos(lista, enLista);
        assertEquals(2, result);
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
        personas.add(new Persona("Pepe", "Zaragoza"));
        personas.add(new Persona("Botella", "Teruel"));
        personas.add(new Persona("Laura", "Huesca"));
        personas.add(new Persona("Fernando", "Huesca"));
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.borrarPersonasHuescaDeLista(personas);
        assertEquals(2, personas.size() );
        assertEquals("Pepe", personas.get(0).getNombre() );
        assertEquals("Botella", personas.get(1).getNombre() );
    }

    @Test
    public void testBorrarPersonasHuescaDeMapa() {
        Map<String, Persona> personas=new HashMap<>();
        personas.put("Pepe", new Persona("Pepe", "Zaragoza"));
        personas.put("Botella", new Persona("Botella", "Teruel"));
        personas.put("Laura", new Persona("Laura", "Huesca"));
        personas.put("Fernando", new Persona("Fernando", "Huesca"));
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.borrarPersonasHuescaDeMapa(personas);
        assertEquals(2, personas.size() );
        assertEquals("Pepe", personas.get("Pepe").getNombre() );
        assertEquals("Botella", personas.get("Botella").getNombre() );
    }

    @Test
    public void testEntrarPersonaALaCola() {
        Persona p1=new Persona("Pepe", "Zaragoza");
        p1.setCesta(new Compra(1, true));
        Persona p2=new Persona("Botella", "Teruel");
        p2.setCesta(new Compra(2, true));
        Persona p3=new Persona("Laura", "Huesca");
        p3.setCesta(new Compra(3, true));
        Persona p4=new Persona("Susana", "Zaragoza");
    
        
        
        Queue<Persona> colaPersonas=new LinkedList<>();
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        instance.entrarPersonaALaCola(colaPersonas, p1);    
        assertEquals(1, colaPersonas.size());
        colaPersonas.poll();    //Sacamos p1
        instance.entrarPersonaALaCola(colaPersonas, p2);
        assertEquals(1, colaPersonas.size());
        instance.entrarPersonaALaCola(colaPersonas, p3);
        assertEquals(2, colaPersonas.size());
        colaPersonas.poll();    //Sacamos p2
        instance.entrarPersonaALaCola(colaPersonas, p4);
        assertEquals(2, colaPersonas.size());
    }

    @Test
    public void testGenerarLista() {
        int[] valores = {1,2,6};
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<Integer> result = instance.generarLista(valores);
        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(6, result.get(2));
    }

    @Test
    public void testGenerarArrayList() {
        int[] valores = {1,2,6};
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<Integer> result = instance.generarArrayList(valores);
        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(6, result.get(2));
    }

    @Test
    public void testCatalogar() {
        String objeto = "Oro";
        Set<String> minerales = Set.of("Plata", "Cobre", "Oro");
        Set<String> organico = Set.of("Alga", "Hoja", "Rama");;
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        assertEquals("Mineral", instance.catalogar("Cobre", minerales, organico));
        assertEquals("Organico", instance.catalogar("Hoja", minerales, organico));
        assertEquals("", instance.catalogar("Agua", minerales, organico));
    }

    @Test
    public void testCoincidencias() {
        Set<String> frutas = new HashSet<>(Set.of("Pera", "Pomelo", "Naranja"));
        Set<String> colores = new HashSet<>(Set.of("Azul", "Rojo", "Naranja"));
        
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        Set<String> result = instance.coincidencias(frutas, colores);
        assertEquals(1, result.size());
        assertEquals(true, result.contains("Naranja"));
        assertEquals(false, result.contains("Azul"));
        assertEquals(false, result.contains("Pera"));
    }
    
    @Test
    public void testAprobados() {
        Map<String, Integer> notas = new HashMap<>(Map.of("Juan", 5, "Ana",8, "Richard",3));
        Ejercicio04Colecciones instance = new Ejercicio04Colecciones();
        List<String> result = instance.aprobados(notas);
        assertEquals(2, result.size());
        assertEquals(true, result.contains("Juan"));
        assertEquals(true, result.contains("Ana"));
        assertEquals(false, result.contains("Richard"));
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
        assertEquals(2, result.size());
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
