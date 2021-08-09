/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class Ejercicio04KanbanServiceTest {
    
    public Ejercicio04KanbanServiceTest() {
    }

    @Test
    public void testCrearTarea() {
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        Optional<TareaKanban> t=instance.getTareas().stream()
                                                    .filter(x->"PruebaTest".equals(x.getDescripcion())) 
                                                    .filter(x->x.getHorasEstimacion()==9999)
                                                    .findFirst();
        assertEquals(true, t.isPresent());
        assertNotEquals(null, t.get().getCodigo());
        assertEquals("Roadmap", t.get().getEstado());
        assertEquals(null, t.get().getPropietario());
        assertEquals(0, t.get().getHorasTrabajadas());
    }

    @Test
    public void testModificarTarea() throws Exception {
        System.out.println("modificarTarea");
        String codigo = "";
        String descripcion = "";
        Integer horasEstamacion = null;
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.modificarTarea(codigo, descripcion, horasEstamacion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAsignarPersona() throws Exception {
        System.out.println("asignarPersona");
        String codigo = "";
        String persona = "";
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.asignarPersona(codigo, persona);
        fail("The test case is a prototype.");
    }

    @Test
    public void testImputarHorasTrabajadas() throws Exception {
        System.out.println("imputarHorasTrabajadas");
        String codigo = "";
        String persona = "";
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.imputarHorasTrabajadas(codigo, persona);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCambiarEstado() throws Exception {
        System.out.println("cambiarEstado");
        String codigo = "";
        String persona = "";
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.cambiarEstado(codigo, persona);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTareas() {
        System.out.println("getTareas");
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        List<TareaKanban> expResult = null;
        List<TareaKanban> result = instance.getTareas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTarea() {
        System.out.println("getTarea");
        String codigo = "";
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        Optional<TareaKanban> expResult = null;
        Optional<TareaKanban> result = instance.getTarea(codigo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
