/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
    
    @Autowired
    private IEjercicio04KanbanService serviceKanban;
    
    private String errorMessageAtr  = "errorMessage";
    private String tareaAtr  = "tarea";
    private String modoAtr  = "modo";
    
    @GetMapping("/kanban")
    public String tablaKanban(Model model){
       // return "ej04/kanban";
       model.addAttribute("tareas",serviceKanban.getTareas());
       model.addAttribute(errorMessageAtr, "tarea a modificar planificacnion no encontrada");
       return "ej04/kanbanNoBootbox";
       //return "ej04/kanban";
    }
    
    @GetMapping("/altaTarea")
    public String aFormularioAltaTarea(Model model){
        model.addAttribute(modoAtr,"altaTarea");
        model.addAttribute(tareaAtr,new TareaKanban());
        return "/ej04/formTareaKanban";
    }
    
    /**
     * reenvio a formulario para asignar tarea a un trabajador
     * @param model
     * @param codigo
     * @return 
     */
    @GetMapping("/asignarTrabajador/{codigo}")
    public String asinacionTrabajador(Model model,@PathVariable("codigo") String codigo){
        Optional<TareaKanban> tarea = serviceKanban.getTarea(codigo);
        model.addAttribute(modoAtr,"asignarTrabajador");
        if (tarea.isPresent()){
            model.addAttribute(tareaAtr, tarea.get());
        } else {
            model.addAttribute(tareaAtr, new TareaKanban());
            System.out.println("Tarea no encontrada" + codigo);
        }
        return "/ej04/formTareaKanban";
    }

    /**
     * Captura desde formulario para asignar la tarea a un trabajador
     * @param model
     * @param codigo
     * @param propietario
     * @return 
     */
    
    
    @PostMapping("/asignacionPersona")
    public String modificarTareaAdicionTrabajador(Model model,@RequestParam("codigo") String codigo, @RequestParam("propietario") String propietario){
        try {
            serviceKanban.asignarPersona(codigo, propietario);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute(errorMessageAtr, "tarea a modificar Propietario no encontrada");
        }
        model.addAttribute("tareas", serviceKanban.getTareas());
        return "ej04/kanbanNoBootbox";
    }
    
    
    
    
    
    @GetMapping("/eliminar/{codigo}")
    public String eliminar (Model modelo, @PathVariable("codigo") String codigo){
        // opcion no contemplada
        return "ej04/kanbanNoBootbox";
    }
    
    
    
    
    @GetMapping("/planificar/{codigo}/{plan}")
    public String planificar (Model model, @PathVariable("codigo") String codigo, @PathVariable String plan){
        try {
            serviceKanban.cambiarEstado(codigo, plan);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute(errorMessageAtr, "tarea a modificar planificacnion no encontrada");
        }
        model.addAttribute("tareas",serviceKanban.getTareas());
        return "ej04/kanbanNoBootbox";
    }
    
   
    /**
     * creacion de un nuevo task
     * @param model
     * @param descripcion
     * @param horasEstimacion
     * @return 
     */
    @PostMapping("/nuevaTarea")
    public String storyAdd(Model model,@RequestParam String descripcion, @RequestParam Integer horasEstimacion){
        serviceKanban.crearTarea(descripcion, horasEstimacion);
        model.addAttribute("tareas",serviceKanban.getTareas());
        //return "ej04/kanban";
        return "ej04/kanbanNoBootbox";
    }
    
    
    
    @GetMapping("/modificar/{codigo}")
    public String modificarHistoria  (Model model,@PathVariable("codigo") String codigo ){
        Optional<TareaKanban> tarea = serviceKanban.getTarea(codigo);
        if (tarea.isPresent()){
            model.addAttribute(tareaAtr,tarea.get());
        } else {
            model.addAttribute(errorMessageAtr, "tarea a modificar planificacnion no encontrada");
            System.out.println("tarea a modificar Descripcion estimacion no encontrada" + codigo);
        }
        model.addAttribute(modoAtr,"modificaTarea");
        return "/ej04/formTareaKanban";
    }
    
    @PostMapping("/modificacionTarea")
    public String modificarTareaCambioHorasEstimadasDescripcion(Model model
                                                                    ,@RequestParam("codigo") String codigo
                                                                    ,@RequestParam("horasEstimacion") Integer horasEstimacion
                                                                    ,@RequestParam("descripcion") String descripcion){
        try {
            serviceKanban.modificarTarea(codigo, descripcion, horasEstimacion);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute(errorMessageAtr, "tarea a modificar Descripcion estimacion no encontrada");
        }
        model.addAttribute("tareas", serviceKanban.getTareas());
        return "ej04/kanbanNoBootbox";
    }
    
    
    
    @GetMapping("/imputarHoras/{codigo}")
    public String imputarHorasTrabajadas (Model model,@PathVariable("codigo") String codigo ){
        Optional<TareaKanban> tarea = serviceKanban.getTarea(codigo);
        if (tarea.isPresent()){
            model.addAttribute(tareaAtr,tarea.get());
        } else {
            model.addAttribute(errorMessageAtr, "tarea a modificar planificacion no encontrada");
            System.out.println("tarea a modificar Horas Trabajadas no encontrada" + codigo);
        }
        model.addAttribute(modoAtr,"imputarHoras");
        return "/ej04/formTareaKanban";
    }
    
    @PostMapping("/imputarHoras")
    public String modificarTareaCambioHorasTrabajadas(Model model
                                                            ,@RequestParam("codigo") String codigo
                                                            ,@RequestParam("horasTrabajadas") Integer horasTrabajadas){
        try {
            serviceKanban.imputarHorasTrabajadas(codigo, horasTrabajadas);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute(errorMessageAtr, "tarea a modificar Descripcion estimacion no encontrada: " + codigo);
        }
        model.addAttribute("tareas", serviceKanban.getTareas());
        return "ej04/kanbanNoBootbox";
    }
    
    
}