/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
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
@RequestMapping("/ej04")
public class Ejercicio04KanbanController {
    @Autowired
    private IEjercicio04KanbanService servicio;
    
    @GetMapping("/kanban")
    public String inicio(Model m){
        m.addAttribute("task", new TareaKanban());
        m.addAttribute("tareas", servicio.getTareas());
        return "ej04/kanban";
    }
    
    @PostMapping("/addtarea") 
    public String addTarea(Model m,String codigo, String descripcion, Integer horasEstimacion, Integer horasTrabajadas){
        if(codigo != null && !codigo.isEmpty()){
            try {
                servicio.modificarTarea(codigo, descripcion, horasEstimacion);
                if(horasTrabajadas>0){
                    servicio.imputarHorasTrabajadas(codigo, horasTrabajadas);
                }
            } catch (OperacionEnListaException ex) {
                Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            servicio.crearTarea(descripcion, horasEstimacion);
        }
        return "redirect:kanban";
    }
    
    @GetMapping("/kanban/modifica")
    public String cambiarEstado(Model m,String codigo, String estado){
        try {
            servicio.cambiarEstado(codigo, estado);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/ej04/kanban";
    }
    
    @GetMapping("/kanban/edita")
    public String editar(Model m,String codigo){
        m.addAttribute("task", servicio.getTarea(codigo).get());
        m.addAttribute("tareas", servicio.getTareas());
        //return "redirect:kanban"; //esto peta no se porque, en el estado si funciona
        return "ej04/kanban"; 
    }
    
    @GetMapping("/kanban/usuario")
    public String addUsuario(Model m,String codigo){ 
        m.addAttribute("task", servicio.getTarea(codigo).get());
        //m.addAttribute("tareas", servicio.getTareas());
        return "ej04/adduser"; 
    }
    
     
    @PostMapping("/kanban/usuario")
    public String addUsu(Model m,String codigo, String propietario ){ 
        try {
            servicio.asignarPersona(codigo, propietario);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //m.addAttribute("task", servicio.getTarea(codigo).get());
        //m.addAttribute("tareas", servicio.getTareas());
        //return "ej04/kanban"; 
        return "redirect:/ej04/kanban";
    }
}
