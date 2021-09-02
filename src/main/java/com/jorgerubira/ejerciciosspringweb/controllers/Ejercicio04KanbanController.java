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
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/tablaKanban")
    public String mostrar(Model m){
        m.addAttribute("tareas", servicio.getTareas());
        return "ej04/tablero";
    }
    
    @GetMapping("/nueva")
    public String nuevaTarea(Model m){
        m.addAttribute("modo", "nuevaTarea");
        m.addAttribute("tarea", new TareaKanban());
        return "ej04/nuevaTarea";
    }
    
    @GetMapping("/asignar/{codigo}")
    public String asignar(Model m, @PathVariable("codigo") String codigo){
        return null;
    }
}
