/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Cosas interesantes para implementar en la vista.
 * Si las horas superiores es superior que el doble de la hora estimada marcar el fondo en rojo
 * Si las horas superiores es superior a la hora estimada marcar el fondo en naranja
 * Si las horas superiores es inferior o igual a la hora estimada marcar el fondo en verde
 * 
 * En las tarjetas mostrar la descripción, persona responsable, horas trabajadas/horas estimadas.
 * 
 */
@Controller
@RequestMapping("/ejercicio04")
public class Ejercicio04KanbanController {
    @Autowired
    private IEjercicio04KanbanService service;
    
    @GetMapping("/inicial")
    public String inicio(Model model){
        model.addAttribute("kanban",service.getTareas());
        return "/ej04/tareas";
    }
    @PostMapping("/nuevaTarea")
    public String tarea(Model model, String descripcion, Integer horasEstimacion){
        service.crearTarea(descripcion, horasEstimacion);
        model.addAttribute("kanban",service.getTareas());
        return "redirect:/ejercicio04/inicial";
    }
    @GetMapping("/editar")
    public String editar(Model model, String codigo, String accion){
        TareaKanban aux=service.getTarea(codigo).get();
        model.addAttribute("accion", accion);
        model.addAttribute("kanbanMiembro",aux);
        return "/ej04/formularioEdicion";
    }
    @PostMapping("/guardado")
    public String guardado(Model model, String codigo, String accion, String descripcion, Integer horasEstimacion, String propietario, String estado, Integer horasTrabajadas){
        if(accion.equals("editar")){
            try {
                service.modificarTarea(codigo, descripcion, horasEstimacion);
            } catch (OperacionEnListaException ex) {
                Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(accion.equals("asignar")){
            try {
                service.asignarPersona(codigo, propietario);
                service.cambiarEstado(codigo, "Waiting");
            } catch (OperacionEnListaException ex) {
                Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(accion.equals("cambio")){
            try {
                service.imputarHorasTrabajadas(codigo, horasTrabajadas);
                service.cambiarEstado(codigo, estado);
            } catch (OperacionEnListaException ex) {
                Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        return "redirect:/ejercicio04/inicial";
    }
}
