/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    private IEjercicio04KanbanService serviceKanban;
    
    @GetMapping("/kanban")
    public String tablaKanban(){
        return "ej04/kanban";
    }
    
    @PostMapping("/nuevaTarea")
    public String storyAdd(Model model, @RequestParam String descripcion,@RequestParam Integer horasTrabajadas){
        serviceKanban.crearTarea(descripcion, horasTrabajadas);
        model.addAttribute("tareas",serviceKanban.getTareas());
        return "ej04/kanban";
    }
}
