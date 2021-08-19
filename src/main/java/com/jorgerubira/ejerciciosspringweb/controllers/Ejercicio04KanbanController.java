/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;

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
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
	
    @Autowired
    private IEjercicio04KanbanService kanban;
    
    @GetMapping("/listaTareas")
    public String getPaginaLista(Model model){
        model.addAttribute("listaTareas", kanban.getTareas());
        return "ej04/listaTareas";
    }
    
    @GetMapping("/insertarTarea")
    public String getPaginaInsertar(Model model){
        model.addAttribute("descripcion", "");
        model.addAttribute("estimacion", "");
        return "ej04/guardarTarea";
    }
    
    @PostMapping("/addTarea")
    public String addTarea(Model model, TareaKanban tarea){
    	kanban.crearTarea(tarea.getDescripcion(), tarea.getHorasEstimacion());
        return "redirect:listaTareas";
    }
}
