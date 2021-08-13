package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    public Ejercicio04KanbanController() {
    }

    @GetMapping("/ver")
    public String verKanban(Model model){
        model.addAttribute("tareas", kanbanService.getTareas());
        
        return "/ej04/kanban";
    }
    
    @PostMapping("/crearTarea")
    public String crearTarea(Model model, String descripcion, Integer horasEstimadas){
        kanbanService.crearTarea(descripcion, horasEstimadas);
        return "redirect:ver";
    }
    
    @PostMapping("/modificarTarea")
    public String modificarTarea(Model model, String codigo, String descripcion, Integer horasEstamacion){
        try {
            kanbanService.modificarTarea(codigo, descripcion, horasEstamacion);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:ver";
    }
    
    @PostMapping("/asignarPersona")
    public String asignarPersona(Model model, String codigo, String persona){
        try {
            kanbanService.asignarPersona(codigo, persona);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:ver";
}
    
    @PostMapping("/horasTrabajadas")
    public String horasTrabajadas(Model model, String codigo, int horas){
        try {
            kanbanService.imputarHorasTrabajadas(codigo, horas);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:ver";
    }
    
    @PostMapping("/cambiarEstado")
    public String cambiaEstado(Model model, String codigo, String estado){
        try {
            kanbanService.cambiarEstado(codigo, estado);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:ver";
    }
    
    @PostMapping("/buscarTarea")
    public String buscarTarea(Model model, String codigo){
        model.addAttribute("tarea", kanbanService.getTarea(codigo));
        
        return "/ej03/kanban";
    }
    
}
