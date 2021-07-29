/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio07StreamsNivelDificilTest {
    
    public Ejercicio07StreamsNivelDificilTest() {
    }

    @Test
    public void testPersonaEnDosGrupos() {
        Set<Persona> personasGradoMedio = Set.of(
                                            new Persona("Ana"),
                                            new Persona("Juan"),
                                            new Persona("Fran"),
                                            new Persona("Susana")
                                           );
        Set<Persona> personasUniversidad = Set.of(
                                            new Persona("Alberto"),
                                            new Persona("Juan"),
                                            new Persona("Pepe"),
                                            new Persona("Susana")
                                        );
        Set<Persona> personasCertificado = Set.of(
                                            new Persona("Alberto"),
                                            new Persona("Fran"),
                                            new Persona("Juanito"),
                                            new Persona("Susana")
                                        );
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        Set<Persona> result = instance.personaEnDosGrupos(personasGradoMedio, personasUniversidad, personasCertificado);
        assertEquals(4, result.size());
        assertEquals(true, result.contains("Susana"));
        assertEquals(true, result.contains("Alberto"));
        assertEquals(true, result.contains("Juan"));
        assertEquals(true, result.contains("Fran"));

    }

    @Test
    public void testRepartoDeCompraPersona() {
        Compra compraConjunta=new Compra(1000,true);

        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan"));
        lista.add(new Persona("Ana"));
        lista.add(new Persona("Pepe"));
        lista.add(new Persona("Fran"));

        Map<String,Integer> reparto=Map.of("Juan",20,"Ana",50,"Fran",30);
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        instance.repartoDeCompraPersona(compraConjunta, lista, reparto);
        assertEquals(true, lista.get(0).getCesta().isPresent() );
        assertEquals(200, lista.get(0).getCesta().get().getTotalArticulos() );
        assertEquals(true, lista.get(1).getCesta().isPresent() );
        assertEquals(500, lista.get(1).getCesta().get().getTotalArticulos() );
        assertEquals(false, lista.get(2).getCesta().isPresent() );
        assertEquals(true, lista.get(3).getCesta().isPresent() );
        assertEquals(300, lista.get(3).getCesta().get().getTotalArticulos() );
    }

    @Test
    public void testGeneradorDePersonasAlAzar() {
        List<String> nombres=List.of("Ana", "Juan", "Pepe", "Fran");
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        List<Persona> result = instance.generadorDePersonasAlAzar(100, nombres);
        assertEquals(100, result.size());
        result.stream().forEach(x->{
            assertEquals(true, nombres.contains(x.getNombre()));
        });
        //Deben utilizarse los cuatro nombres. (De 100 estadisticamente casi-seguro que aparece).
        assertEquals(4, result.stream().map(x->x.getNombre()).distinct().count());
    }

    @Test
    public void testObtenerTuplaPorEdad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Jorge","Zaragoza", 13));
        lista.add(new Persona("Juan","Zaragoza", 15));
        lista.add(new Persona("Ana","Huesca", 17));
        lista.add(new Persona("Fran","Huesca", 18));
        lista.add(new Persona("Pepe","Huesca", 73));        
        lista.add(new Persona("Alfredo","Huesca", 33)); 
        
        Set<String> descartes=Set.of("Juan","Pepe","Alfredo");
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        Pair<List<Persona>, List<Persona>> result = instance.obtenerTuplaPorEdad(lista, descartes);
        assertEquals(2, result.getValue0().size());
        assertEquals("Jorge", result.getValue0().get(0).getNombre());
        assertEquals("Ana", result.getValue0().get(1).getNombre());
        assertEquals(1, result.getValue1().size());
        assertEquals("Fran", result.getValue1().get(0).getNombre());
        
    }

    @Test
    public void testDevolverDeQuePersonasCorrespondenLasCompras() {
        Compra c1=new Compra(5,true);
        Compra c2=new Compra(5,true);
        Compra c3=new Compra(5,true);
        
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", c1));
        lista.add(new Persona("Ana" ));
        lista.add(new Persona("Pepe", c2));
        lista.add(new Persona("Fran", c3));
        
        Set<Compra> compras=Set.of(c1,c2);
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        List<Persona> result = instance.devolverDeQuePersonasCorrespondenLasCompras(lista, compras);
        assertEquals(2, result.size()); 
        assertEquals("Juan", result.get(0).getNombre());
        assertEquals("Pepe", result.get(1).getNombre());
    }

    @Test
    public void testEliminarCompraDePersonas() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", new Compra(2,true)));
        lista.add(new Persona("Ana" ));
        lista.add(new Persona("Juan2", new Compra(6,true)));
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        List<Persona> result = instance.eliminarCompraDePersonas(lista);
        assertEquals(3, result.size());
        assertEquals(true, result.get(0).getCesta().isEmpty());
        assertEquals(true, result.get(1).getCesta().isEmpty());
        assertEquals(true, result.get(2).getCesta().isPresent());
        

    }

    @Test
    public void testClone() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan","Zaragoza", 17, new Date(2004,1,1),  170, 70, new Compra(2,true)));
        lista.add(new Persona("Ana","Madrid", 18, new Date(2003,1,1),  160, 60));
        lista.add(new Persona("Juan2","Zaragoza", 15, new Date(2004,1,1),  170, 70, new Compra(2,true)));
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        List<Persona> result = instance.clone(lista);
        assertEquals(2, lista.size());
        
        assertEquals(result.get(0).getNombre(), lista.get(0).getNombre());
        lista.get(0).setNombre("A");
        assertNotEquals(result.get(0).getNombre(), lista.get(0).getNombre());

        assertEquals(result.get(0).getCiudad(), lista.get(0).getCiudad());
        lista.get(0).setCiudad("A");
        assertNotEquals(result.get(0).getCiudad(), lista.get(0).getCiudad());

        assertEquals(result.get(0).getFechaNacimiento(), lista.get(0).getFechaNacimiento());
        lista.get(0).getFechaNacimiento().setTime(44);
        assertNotEquals(result.get(0).getFechaNacimiento(), lista.get(0).getFechaNacimiento());

        assertEquals(result.get(0).getAltura(), lista.get(0).getAltura());
        lista.get(0).setAltura(44);
        assertNotEquals(result.get(0).getAltura(), lista.get(0).getAltura());

        assertEquals(result.get(0).getPeso(), lista.get(0).getPeso());
        lista.get(0).setPeso(44);
        assertNotEquals(result.get(0).getPeso(), lista.get(0).getPeso());

        assertEquals(result.get(0).getCesta().get().getTotalArticulos(), lista.get(0).getCesta().get().getTotalArticulos());
        lista.get(0).getCesta().get().setTotalArticulos(44);
        assertNotEquals(result.get(0).getCesta().get().getTotalArticulos(), lista.get(0).getCesta().get().getTotalArticulos());        

        assertEquals(result.get(0).getCesta().get().isCarro(), lista.get(0).getCesta().get().isCarro());
        lista.get(0).getCesta().get().setCarro(false);
        assertNotEquals(result.get(0).getCesta().get().isCarro(), lista.get(0).getCesta().get().isCarro());        

        assertEquals(true, result.get(1).getCesta().isEmpty());
    }

    @Test
    public void testObtenerPersonasDeCadaCiudad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan","Zaragoza", 17));
        lista.add(new Persona("Ana","Madrid", 18));
        lista.add(new Persona("Fran","Madrid", 27));
        lista.add(new Persona("Pepe","Huesca", 73));        
        lista.add(new Persona("Alfredo","Huesca", 33)); 
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        Map<String, List<Persona>> result = instance.obtenerPersonasDeCadaCiudad(lista);
        assertEquals(3, result.size());
        
        //Debe haber 1 persona en Zaragoza
        assertEquals(1, result.get("Zaragoza").size());
        assertEquals("Juan", result.get("Zaragoza").get(0).getNombre());
        
        //Debe haber 2 personas en Madrid
        assertEquals(2, result.get("Madrid").size());
        assertEquals("Ana", result.get("Madrid").get(0).getNombre());
        assertEquals("Fran", result.get("Madrid").get(1).getNombre());
        
        //Debe haber 2 personas en Huesca
        assertEquals(2, result.get("Huesca").size());
        assertEquals("Pepe", result.get("Huesca").get(0).getNombre());
        assertEquals("Alfredo", result.get("Huesca").get(1).getNombre());
        
    }

    @Test
    public void testObtenerPersonaMasMayorDeCadaCiudad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan","Zaragoza", 17));
        lista.add(new Persona("Ana","Madrid", 18));
        lista.add(new Persona("Fran","Madrid", 27));
        lista.add(new Persona("Pepe","Huesca", 73));        
        lista.add(new Persona("Alfredo","Huesca", 33));        
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        Map<String, Persona> result = instance.obtenerPersonaMasMayorDeCadaCiudad(lista);
        assertEquals(3, result.size());
        assertEquals("Pepe", result.get("Huesca").getNombre());
        assertEquals("Juan", result.get("Zaragoza").getNombre());
        assertEquals("Fran", result.get("Madrid").getNombre());
    }


    @Test
    public void testObtenerLasTresPersonasMasMayoresDeCadaCiudad() {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan","Zaragoza", 17));
        lista.add(new Persona("Ana","Huesca", 18));
        lista.add(new Persona("Fran","Huesca", 27));
        lista.add(new Persona("Pepe","Huesca", 73));        
        lista.add(new Persona("Alfredo","Huesca", 33)); 
        
        Ejercicio07StreamsNivelDificil instance = new Ejercicio07StreamsNivelDificil();
        Map<String, List<Persona>> result = instance.obtenerLasTresPersonasMasMayoresDeCadaCiudad(lista);
        //Debe haber 1 persona en Zaragoza
        assertEquals(1, result.get("Zaragoza").size());
        assertEquals("Juan", result.get("Zaragoza").get(0).getNombre());
        
        //Debe haber 3 personas en Huesca
        assertEquals(3, result.get("Huesca").size());
        assertEquals("Pepe", result.get("Huesca").get(0).getNombre());
        assertEquals("Alfredo", result.get("Huesca").get(1).getNombre());
        assertEquals("Fran", result.get("Huesca").get(2).getNombre());
    }
    
    
}
