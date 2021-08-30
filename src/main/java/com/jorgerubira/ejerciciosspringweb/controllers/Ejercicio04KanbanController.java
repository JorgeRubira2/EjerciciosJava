
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;


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
    private IEjercicio04KanbanService tareas;
    
    
     @GetMapping("/kanban")
     public String listaTareas(Model model){     
         
         List<TareaKanban> tareasRoadmap= tareas.getTareas().stream().filter(x-> x.getEstado().equals("Roadmap")).collect(Collectors.toList());
         List<TareaKanban> tareasWaiting= new ArrayList<>();
         List<TareaKanban> tareasWorking= new ArrayList<>();
         List<TareaKanban> tareasDone= new ArrayList<>();
         
         model.addAttribute("tareasRoadmap", tareasRoadmap);  
         model.addAttribute("tareasWaiting", tareas.getTareas().stream().filter(x-> x.getEstado().equals("Waiting")).collect(Collectors.toList()));  
         model.addAttribute("tareasWorking", tareas.getTareas().stream().filter(x-> x.getEstado().equals("Working")).collect(Collectors.toList()));  
         model.addAttribute("tareasDone", tareas.getTareas().stream().filter(x-> x.getEstado().equals("Done")).collect(Collectors.toList()));  
         
         return "/ej04/kanban";
    }
    
     
    
}
