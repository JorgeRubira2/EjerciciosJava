/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;


import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

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
    private List<TareaKanban> tareas;

    @Autowired
    IEjercicio04KanbanService service;

    @GetMapping("/verkanban")
    public String verKanbas(Model model){
        model.addAttribute("tareas", tareas);
        return "/ej04/kanban";
    }

    @GetMapping("/subirEstado/{codigo}")
    public RedirectView subirEstado(@PathVariable String codigo){
        Optional<TareaKanban> tarea = service.getTarea(codigo);
        if(tarea.isPresent()) {
            try {
                switch (tarea.get().getEstado()) {
                    case "Roadmap":
                        service.cambiarEstado(codigo, "Waiting");
                        break;
                    case "Waiting":
                        service.cambiarEstado(codigo, "Working");
                        break;
                    case "Working":
                        service.cambiarEstado(codigo, "Done");
                        break;
                    case "Done":
                        break;
                }
            } catch (OperacionEnListaException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/ej04/verkanban");
    }
}
