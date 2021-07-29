/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.RangoEdad;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio07StreamsTest {
    
    public Ejercicio07StreamsTest() {
    }

    @Test
    public void testElementosPositivos() {
        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<Double> res=instance.elementosPositivos(List.of(4.2d,-2d,4d,-2d,12d,0d));
        assertEquals(4, res.size());
        assertEquals(4.2d, res.get(0));
        assertEquals(4d, res.get(1));
        assertEquals(12d, res.get(2));
        assertEquals(0d, res.get(3));
    }

    @Test
    public void testMaximoElemento() {
        Ejercicio07Streams instance = new Ejercicio07Streams();
        assertEquals(4, instance.maximoElemento(List.of(2,3,4,1)));
        assertEquals(3, instance.maximoElemento(List.of(2,3,-4,1)));
    }

    @Test
    public void testContarElementosNoRepetidos() {
        Ejercicio07Streams instance = new Ejercicio07Streams();
        assertEquals(2, instance.contarElementosNoRepetidos(List.of(2,3,2,1)));
        assertEquals(3, instance.contarElementosNoRepetidos(List.of(2,3,2,5,2,1)));
    }

    @Test
    public void testPersonasDeHuescaALista() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", "Zaragoza"));
        lista.add(new Persona("Ana", "Huesca"));
        lista.add(new Persona("Fran", "Huesca"));
        lista.add(new Persona("Pepe", "Teruel"));
        
        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<Persona> result = instance.personasDeHuescaALista(lista);
        assertEquals(2, result.size());
        assertEquals("Ana", result.get(0).getNombre());
        assertEquals("Fran", result.get(1).getNombre());
    }

    @Test
    public void testPersonasDeHuescaAArrayBasico() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", "Zaragoza"));
        lista.add(new Persona("Ana", "Huesca"));
        lista.add(new Persona("Fran", "Huesca"));
        lista.add(new Persona("Pepe", "Teruel"));
        
        Ejercicio07Streams instance = new Ejercicio07Streams();
        Persona[] result = instance.personasDeHuescaAArrayBasico(lista);
        assertEquals(2, result.length);
        assertEquals("Ana", result[0].getNombre());
        assertEquals("Fran", result[1].getNombre());
    }

    @Test
    public void testPersonasConMasArticulo() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", new Compra(10, true)));
        lista.add(new Persona("Ana"));
        lista.add(new Persona("Fran", new Compra(15, true)));
        lista.add(new Persona("Pepe", new Compra(2, true)));

        Ejercicio07Streams instance = new Ejercicio07Streams();
        Optional<Persona> result=instance.personasConMasArticulo(lista);
        assertEquals(true, result.isPresent());
        assertEquals("Fran", result.get().getNombre());
        
        //Si no se envian personas devuelve un optional vacio.
        Optional<Persona> result2=instance.personasConMasArticulo(new ArrayList<>());
        assertEquals(true, result2.isEmpty());
        
        //Si se envia una persona aunque no tenga cesta -> el que mas articulos tiene es esa persona que sería 0.
        Optional<Persona> result3=instance.personasConMasArticulo(List.of(new Persona("Ana")));
        assertEquals(true, result3.isPresent());
        assertEquals("Ana", result3.get().getNombre());
    }

    @Test
    public void testCestasDeLasPersonas() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", new Compra(10, true)));
        lista.add(new Persona("Ana"));
        lista.add(new Persona("Fran", new Compra(15, false)));
        lista.add(new Persona("Pepe", new Compra(2, true)));
        
        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<Compra> result = instance.cestasDeLasPersonas(lista);
        assertEquals(3, result.size());
        assertEquals(10, result.get(0).getTotalArticulos());
        assertEquals(15, result.get(1).getTotalArticulos());
        assertEquals(2, result.get(2).getTotalArticulos());
        assertEquals(true, result.get(0).isCarro());
        assertEquals(false, result.get(1).isCarro());
    }

    @Test
    public void testEdadesDeLasPersonas() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", 23 ));
        lista.add(new Persona("Ana", 24));
        lista.add(new Persona("Fran", 25));
        lista.add(new Persona("Pepe", 21));
        Ejercicio07Streams instance = new Ejercicio07Streams();
        int[] result = instance.edadesDeLasPersonas(lista);
        assertArrayEquals(new int[]{23,24,25,21}, result);
    }

    @Test
    public void testCuantasPersonasHayPorCiudad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", "Huesca" ));
        lista.add(new Persona("Ana", "Zaragoza"));
        lista.add(new Persona("Fran", "Zaragoza"));
        lista.add(new Persona("Pepe", "Teruel"));
        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<Ciudad> result = instance.cuantasPersonasHayPorCiudad(lista);
        assertEquals(3, result.size());
        for (Ciudad c:result){
            if (c.getNombre().equals("Huesca") || c.getNombre().equals("Teruel")){
                assertEquals(1, c.getPersonas());
            }else if (c.getNombre().equals("Zaragoza")){
                assertEquals(2, c.getPersonas());
            }else{
                fail("Nombre de ciudad incorrecto");
            }
        }
        
        //Para el caso de vector vacio.
        assertEquals(0, instance.cuantasPersonasHayPorCiudad(new ArrayList<>()).size());
    }

    @Test
    public void testTop3Personas() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", new Compra(10, true)));
        lista.add(new Persona("Ana"));
        lista.add(new Persona("Fran", new Compra(15, false)));
        lista.add(new Persona("Tony", new Compra(1, true)));
        lista.add(new Persona("Pepe", new Compra(2, true)));

        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<Persona> result = instance.top3Personas(lista);
        assertEquals(3, result.size());
        assertEquals("Fran", result.get(0).getNombre());
        assertEquals("Juan", result.get(1).getNombre());
        assertEquals("Pepe", result.get(2).getNombre());
        
        //Probar casos extremos: 2 casos y uno sin compra.
        lista=new ArrayList<>();
        lista.add(new Persona("Ana"));
        lista.add(new Persona("Tony", new Compra(1, true)));
        result = instance.top3Personas(lista);
        assertEquals(2, result.size());
        assertEquals("Tony", result.get(0).getNombre());
        assertEquals("Ana", result.get(1).getNombre());
        
        //Probar casos vacios.
        assertEquals(0, instance.top3Personas(new ArrayList<>()).size());
    }

    @Test
    public void testTop3Ciudades() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", "Huesca" ));
        lista.add(new Persona("Alvaro", "Huesca" ));
        lista.add(new Persona("Ana", "Zaragoza"));
        lista.add(new Persona("Susana", "Zaragoza"));
        lista.add(new Persona("Fran", "Zaragoza"));
        lista.add(new Persona("Alberto", "Zaragoza"));
        lista.add(new Persona("Pepe", "Teruel"));
        lista.add(new Persona("Jose", "Teruel"));
        lista.add(new Persona("Jose Antonio", "Teruel"));
        lista.add(new Persona("Josefina", "Cuenca"));
        lista.add(new Persona("Ania", "Madrid"));

        Ejercicio07Streams instance = new Ejercicio07Streams();
        Set<String> result = instance.top3Ciudades(lista);
        assertEquals(3, result.size());
        assertEquals(true, result.contains("Zaragoza"));
        assertEquals(true, result.contains("Huesca"));
        assertEquals(true, result.contains("Teruel"));
        assertEquals(false, result.contains("Cuenca"));
        assertEquals(false, result.contains("Madrid"));

        //Solo 2 casos
        lista=new ArrayList<>();
        lista.add(new Persona("Juan", "Huesca" ));
        lista.add(new Persona("Ana", "Zaragoza"));
        result = instance.top3Ciudades(lista);
        assertEquals(2, result.size());
        assertEquals(true, result.contains("Zaragoza"));
        assertEquals(true, result.contains("Huesca"));

        //Sin casos
        assertEquals(0, instance.top3Ciudades(new ArrayList<>()).size());
        
    }

    @Test
    public void testClasificacionPorRangoDeEdad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", 17 ));
        lista.add(new Persona("Ana", 18));
        lista.add(new Persona("Fran", 60));
        lista.add(new Persona("Pepe", 61));
        
        Ejercicio07Streams instance = new Ejercicio07Streams();
        List<RangoEdad> result = instance.clasificacionPorRangoDeEdad(lista);
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).getPersonas());
        assertEquals(RangoEdad.Rango.Menor18, result.get(0).getRango());
        assertEquals(2, result.get(1).getPersonas());
        assertEquals(RangoEdad.Rango.Entre18y60, result.get(1).getRango());
        assertEquals(1, result.get(2).getPersonas());
        assertEquals(RangoEdad.Rango.Mayor60, result.get(2).getRango());
        
        //No hay de un rango
        lista=new ArrayList<>();
        lista.add(new Persona("Ana", 18));
        lista.add(new Persona("Fran", 60));
        lista.add(new Persona("Pepe", 61));

        result = instance.clasificacionPorRangoDeEdad(lista);
        assertEquals(3, result.size());
        assertEquals(0, result.get(0).getPersonas());
        assertEquals(RangoEdad.Rango.Menor18, result.get(0).getRango());
        assertEquals(2, result.get(1).getPersonas());
        assertEquals(RangoEdad.Rango.Entre18y60, result.get(1).getRango());
        assertEquals(1, result.get(2).getPersonas());
        assertEquals(RangoEdad.Rango.Mayor60, result.get(2).getRango());
        
        //Sin elementos
        result = instance.clasificacionPorRangoDeEdad(new ArrayList<>());
        assertEquals(3, result.size());
        assertEquals(0, result.get(0).getPersonas());
        assertEquals(RangoEdad.Rango.Menor18, result.get(0).getRango());
        assertEquals(0, result.get(1).getPersonas());
        assertEquals(RangoEdad.Rango.Entre18y60, result.get(1).getRango());
        assertEquals(0, result.get(2).getPersonas());
        assertEquals(RangoEdad.Rango.Mayor60, result.get(2).getRango());

        
    }

    @Test
    public void testCuantasPersonasMayoresDeEdadPorCiudad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan","Zaragoza", 17, new Date(2004,1,1),  170, 70));
        lista.add(new Persona("Ana","Madrid", 18, new Date(2003,1,1),  160, 60));
        lista.add(new Persona("Fran","Madrid", 27, new Date(1994,1,1),  200, 110));
        lista.add(new Persona("Pepe","Huesca", 73, new Date(1948,1,1),  160, 70));

        Ejercicio07Streams instance = new Ejercicio07Streams();
        Map<String, Integer> result = instance.cuantasPersonasMayoresDeEdadPorCiudad(lista);
        assertEquals(2, result.size());
        assertEquals(2, result.get("Madrid"));
        assertEquals(1, result.get("Zaragoza"));
    }
    
}

