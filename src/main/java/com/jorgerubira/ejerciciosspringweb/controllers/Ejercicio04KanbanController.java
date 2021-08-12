package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
@RestController("/ejercicio04")
public class Ejercicio04KanbanController {
    
    @Autowired
    private IEjercicio04KanbanService kanbanService;
    
    @GetMapping("/ver")
    public String verKanban(Model model){
        model.addAttribute("tareas", kanbanService.getTareas());
        
        return "/ej04/kanban";
    }
    
    
    
    
    
    
    
    
    
    
    
}
