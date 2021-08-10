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
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        instance.crearTarea("PruebaTest2", 9998);
        List<TareaKanban> tareas=instance.getTareas();
        int pos=tareas.size()-1;
        instance.modificarTarea(tareas.get(pos).getCodigo(), "PruebaTest3", 9997);
        assertEquals(9997, tareas.get(pos).getHorasEstimacion());
        assertEquals("PruebaTest3", tareas.get(pos).getDescripcion());
        assertEquals(9999, tareas.get(0).getHorasEstimacion());
        assertEquals("PruebaTest", tareas.get(0).getDescripcion());
    }

    @Test
    public void testAsignarPersona() throws Exception {
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        instance.crearTarea("PruebaTest2", 9998);
        List<TareaKanban> tareas=instance.getTareas();
        int pos=tareas.size()-1;
        instance.asignarPersona(tareas.get(pos).getCodigo(), "Juan");
        assertEquals("Juan", tareas.get(pos).getPropietario());
    }

    @Test
    public void testImputarHorasTrabajadas() throws Exception {
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        instance.crearTarea("PruebaTest2", 9998);
        List<TareaKanban> tareas=instance.getTareas();
        int pos=tareas.size()-1;
        instance.imputarHorasTrabajadas(tareas.get(pos).getCodigo(), 10);
        assertEquals(10, tareas.get(pos).getHorasTrabajadas());
        instance.imputarHorasTrabajadas(tareas.get(pos).getCodigo(), 5);
        assertEquals(15, tareas.get(pos).getHorasTrabajadas());
    }

    @Test
    public void testCambiarEstado() throws Exception {
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        instance.crearTarea("PruebaTest2", 9998);
        List<TareaKanban> tareas=instance.getTareas();
        int pos=tareas.size()-1;
        instance.cambiarEstado(tareas.get(pos).getCodigo(), "Waiting");
        assertEquals("Waiting", tareas.get(pos).getEstado());
    }

    @Test
    public void testGetTarea() {
        Ejercicio04KanbanService instance = new Ejercicio04KanbanService();
        instance.crearTarea("PruebaTest", 9999);
        instance.crearTarea("PruebaTest2", 9998);
        List<TareaKanban> tareas=instance.getTareas();
        int pos=tareas.size()-1;
        assertEquals(tareas.get(pos), instance.getTarea(tareas.get(pos).getCodigo()).get());
        assertNotEquals(tareas.get(0), instance.getTarea(tareas.get(pos).getCodigo()).get());
    }
}
