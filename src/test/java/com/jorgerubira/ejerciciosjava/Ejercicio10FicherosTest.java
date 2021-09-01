/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.io.File;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio10FicherosTest {
    
    public Ejercicio10FicherosTest() {
    }

    @Test
    public void testContarCuantosEventosHay() {
        Ejercicio10Ficheros instance = new Ejercicio10Ficheros();
        assertEquals(9, instance.contarCuantosEventosHay());
    }

    @Test
    public void testBuscarId() {
        Ejercicio10Ficheros instance = new Ejercicio10Ficheros();
        assertEquals("11320438", instance.buscarId());
    }

    @Test
    public void testContarCoincidencias() {
        Ejercicio10Ficheros instance = new Ejercicio10Ficheros();
        int result = instance.contarCoincidencias("TutorialJava.txt", "clase");
        assertEquals(10, result);
    }



    @Test
    public void testCalcularPromedio() {
        Ejercicio10Ficheros instance = new Ejercicio10Ficheros();
        assertEquals(7.5, instance.calcularPromedio().get());
    }

    @Test
    public void testCargarPersona() throws Exception {
        Ejercicio10Ficheros instance = new Ejercicio10Ficheros();
        assertEquals(5, instance.cargarPersona().size());
    }
    
}
