/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
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
@RequestMapping("/ej04")
public class Ejercicio04KanbanController {
    @Autowired
    private IEjercicio04KanbanService servicio;
    
    @GetMapping("/kanban")
    public String inicio(Model m){
        m.addAttribute("tareas", new TareaKanban());
        m.addAttribute(servicio.getTareas());
        return "ej04/kanban";
    }
    
    @PostMapping("/addtarea")
    public String addTarea(Model m, String descripcion, int horasEstimacion){
        servicio.crearTarea(descripcion, horasEstimacion);
        
        return "redirect:kanban";
    }
    
}
