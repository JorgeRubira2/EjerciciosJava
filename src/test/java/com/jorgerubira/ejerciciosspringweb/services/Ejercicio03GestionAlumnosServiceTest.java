/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio03GestionAlumnosServiceTest {

    public Ejercicio03GestionAlumnosServiceTest() {
    }

    @Test
    public void testGuardarAlumno() {
        Ejercicio03GestionAlumnosService instance = new Ejercicio03GestionAlumnosService();
        long codigo = (int) (Math.random() * 99999999);
        Alumno alumno = new Alumno(codigo, "A", "A", "A");
        int size = instance.getAlumnos().size();
        instance.guardarAlumno(alumno);
        assertEquals(size + 1, instance.getAlumnos().size());
        Alumno alumno2 = new Alumno(codigo, "B", "B", "B");
        instance.guardarAlumno(alumno2);
        assertEquals(0, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "A".equals(x.getNombre())).count());
        assertEquals(0, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "A".equals(x.getDireccion())).count());
        assertEquals(0, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "A".equals(x.getTelefono())).count());
        assertEquals(1, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "B".equals(x.getNombre())).count());
        assertEquals(1, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "B".equals(x.getDireccion())).count());
        assertEquals(1, instance.getAlumnos().stream().filter(x -> x.getCodigo() == codigo && "B".equals(x.getTelefono())).count());

    }

    @Test
    public void testBorrarAlumno() {
        System.out.println("borrarAlumno");
        long codigo = (int) (Math.random() * 99999999);
        Ejercicio03GestionAlumnosService instance = new Ejercicio03GestionAlumnosService();
        Alumno alumno = new Alumno(codigo, "A", "A", "A");
        instance.guardarAlumno(alumno);
        int size = instance.getAlumnos().size();
        instance.borrarAlumno(codigo);
        assertEquals(size - 1, instance.getAlumnos().size());
        instance.borrarAlumno(codigo); //Si no lo encuentra no lo borra
        assertEquals(size - 1, instance.getAlumnos().size());
    }

    @Test
    public void testGetAlumnos_0args() {
        Ejercicio03GestionAlumnosService instance = new Ejercicio03GestionAlumnosService();
        assertNotEquals(null, instance.getAlumnos());
    }

    @Test
    public void testGetAlumno() {
        Ejercicio03GestionAlumnosService instance = new Ejercicio03GestionAlumnosService();
        long codigo1 = (int) (Math.random() * 99999999);
        long codigo2 = (int) (Math.random() * 99999999);
        Alumno a = new Alumno(codigo1, "A", "A", "A");
        instance.guardarAlumno(a);
        assertEquals(true, instance.getAlumno(codigo1).isPresent());
        assertEquals(a, instance.getAlumno(codigo1).get());
        assertEquals(false, instance.getAlumno(codigo2).isPresent());
    }

    @Test
    public void testGetAlumnos_String() {
        String nombre = UUID.randomUUID().toString();
        Alumno a1 = new Alumno((int) (Math.random() * 99999999), nombre, "A", "A");
        Alumno a2 = new Alumno((int) (Math.random() * 99999999), nombre, "A", "A");
        Ejercicio03GestionAlumnosService instance = new Ejercicio03GestionAlumnosService();
        instance.guardarAlumno(a1);
        instance.guardarAlumno(a2);
        assertEquals(2, instance.getAlumnos(nombre).stream().count());

    }

}
