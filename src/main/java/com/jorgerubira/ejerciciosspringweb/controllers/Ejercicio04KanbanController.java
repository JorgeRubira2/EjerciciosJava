package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.stream.Collectors;
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
//@RequestMapping("/ej04")

public class Ejercicio04KanbanController {
    
    @Autowired
    private IEjercicio04KanbanService gestionKanban;
    //devolver lsita  tareas de arriba abajo
    
    
    
    @GetMapping ("/verKanban")
    
    public String verKanban(Model model){
        
        model.addAttribute("tareaRoadMap", gestionKanban.getTareas().stream().filter(x-> x.getEstado().equals("RoadMap")).collect(Collectors.toList()));
        model.addAttribute("tareaWaiting", gestionKanban.getTareas().stream().filter(x-> x.getEstado().equals("Waiting")).collect(Collectors.toList()));
        model.addAttribute("tareaWorking", gestionKanban.getTareas().stream().filter(x-> x.getEstado().equals("Working")).collect(Collectors.toList()));
        model.addAttribute("tareaDone", gestionKanban.getTareas().stream().filter(x-> x.getEstado().equals("Done")).collect(Collectors.toList()));
        

    
        return"ej04/Kanban";
    }
    
    @PostMapping("/nuevaTarea")
    
    public String nuevaTarea(Model model, String descripcion, Integer horasEstimacion){
        
        gestionKanban.crearTarea(descripcion, horasEstimacion);
        
        gestionKanban.getTareas();

        return "redirect: verkanban";
    }
}

