/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Controller("/controlador")
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
    @Autowired
    private IEjercicio04KanbanService service;
    
    @GetMapping("/listaTareas")
    public String listarTareas(Model model){
        model.addAttribute("listaTareas",service.getTareas());
        
        return("ej04/kanban");
    }
    
    @PostMapping("/addTarea")
    public String addTarea(Model model, String descipcion,Integer horasEstimadas){
        service.crearTarea(descipcion, horasEstimadas);
        return ("redirect:listaTareas");
    }
    
    @GetMapping("/addForm")
    public String formulario() {
        return "ej04/crear";
    }
    
    @GetMapping("/modificar")
    public String modificarTarea(Model model,String codigo, String descripcion, Integer horasEstamacion){
        try {
            service.modificarTarea(codigo, descripcion, horasEstamacion);         
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error","No existe ninguna tarea relacionada con el codigo proporcionado");
        }
        return ("redirect:listaTareas");
    }
}
