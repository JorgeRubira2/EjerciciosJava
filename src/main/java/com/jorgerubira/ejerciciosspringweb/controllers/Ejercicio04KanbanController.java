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
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
    
    @Autowired
    private IEjercicio04KanbanService tareaKanban;
    
    private String mensajeError  = "errorMessage";
    private String tareaAtr  = "tarea";
    private String modoAtr  = "modo";
    
    @GetMapping("/kanban")
    public String tablaKanban(Model model){
       // return "ej04/kanban";
       model.addAttribute("tareas",tareaKanban.getTareas());
       model.addAttribute(mensajeError, "Tarea no encontrada");
       return "ej04/kanban";
    }
    
    @GetMapping("/crearTarea")
    public String aFormularioAltaTarea(Model model){
        model.addAttribute(modoAtr,"altaTarea");
        model.addAttribute(tareaAtr,new TareaKanban());
        return "/ej04/kanbanformTareaKanban";
    }
    
}
