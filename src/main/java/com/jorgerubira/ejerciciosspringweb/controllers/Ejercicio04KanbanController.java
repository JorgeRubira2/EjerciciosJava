
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
    
    @Autowired
    private IEjercicio04KanbanService servicio;
    
    @GetMapping("/kanban")
    public String kanban(Model model){
        model.addAttribute("tareas",servicio.getTareas());
        return "ej04/kanban";
    }
    
    @PostMapping("/alta")
    public String alta(Model model, String descripcion, Integer horasEstimacion){
        servicio.crearTarea(descripcion, horasEstimacion);
        model.addAttribute("tareas",servicio.getTareas());
        return "redirect:/ejercicio4/kanban";
    }
    
    @PostMapping("/modificar")
    public String modificar(Model model, String codigo, String descripcion, Integer horasEstimacion){
        try {
            servicio.modificarTarea(codigo, descripcion, horasEstimacion);
        
            model.addAttribute("tareas",servicio.getTareas());
        } catch (OperacionEnListaException ex) {
            
        }
        return "redirect:/ejercicio4/kanban";
    }
    
    @GetMapping("/cambiarEstado")
    public String estado(Model model, String codigo , String estado){
        try {
            servicio.cambiarEstado(codigo, estado);
        
            model.addAttribute("tareas",servicio.getTareas());
            //return "ej04/kanban";
        } catch (OperacionEnListaException ex) {
            //return "ej04/kanban";
        }
        return "redirect:/ejercicio4/kanban";
    }
    
    @PostMapping("/adduser")
    public String imputarHoras(Model model, String codigo , Integer horas){
        try {
            servicio.imputarHorasTrabajadas(codigo, horas);
            model.addAttribute("tareas",servicio.getTareas());
            //return "ej04/kanban";
            } catch (OperacionEnListaException ex) {
               Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return "ej04/kanban";
    }
    
}
