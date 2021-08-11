/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Cosas interesantes para implementar en la vista. Si las horas superiores es
 * superior que el doble de la hora estimada marcar el fondo en rojo Si las
 * horas superiores es superior a la hora estimada marcar el fondo en naranja Si
 * las horas superiores es inferior o igual a la hora estimada marcar el fondo
 * en verde
 *
 * En las tarjetas mostrar la descripción, persona responsable, horas
 * trabajadas/horas estimadas.
 *
 */
@Controller
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {

    @Autowired
    private IEjercicio04KanbanService tareas;

    
    @GetMapping("/tareas")
    public String crud(Model model) {
        model.addAttribute("tareas", tareas.getTareas());
        return ("ej04/listatareas");
    }
    
    
    
    @GetMapping("/formulario")
    public String form(Model m, String codigo){
        m.addAttribute("tareas", tareas.getTarea(codigo).get());
        return "ej04/formulariotareas";
    }
    
    @GetMapping("/formularioNuevo")
    public String formNuevo(Model m, TareaKanban tarea){        
         m.addAttribute("tareas", tareas.getTareas());
        return "ej04/formularionuevo";
    }
    
    @PostMapping("/editar")
    public String editar(Model m, String codigo, TareaKanban tarea){
        
        TareaKanban t = tareas.getTarea(codigo).get();
        
        t.setDescripcion(tarea.getDescripcion());
        t.setEstado(tarea.getEstado());
        t.setPropietario(tarea.getPropietario());
        t.setHorasEstimacion(tarea.getHorasEstimacion());
        t.setHorasTrabajadas(tarea.getHorasTrabajadas());
        
        return "redirect:tareas";
    }
    
    @PostMapping("/nuevo")
    public String nuevo(Model m, TareaKanban tarea){
        
        tareas.crearTarea(tarea.getDescripcion(), tarea.getHorasEstimacion());
        m.addAttribute("tareas", tareas.getTareas());
        return "redirect:tareas";
    }
    
}
