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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
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
@RequestMapping("/ej04")
public class Ejercicio04KanbanController {


    @Autowired
    IEjercicio04KanbanService service;

    @GetMapping("/verkanban")
    public String verKanbas(Model model) {
        List<TareaKanban> tareasRoadmap = service.getTareas().stream()
                .filter(t->"Roadmap".equals(t.getEstado()))
                .collect(Collectors.toList());
        List<TareaKanban> tareasWaiting = service.getTareas().stream()
                .filter(t->"Waiting".equals(t.getEstado()))
                .collect(Collectors.toList());
        List<TareaKanban> tareasWorking = service.getTareas().stream()
                .filter(t->"Working".equals(t.getEstado()))
                .collect(Collectors.toList());
        List<TareaKanban> tareasDone = service.getTareas().stream()
                .filter(t->"Done".equals(t.getEstado()))
                .collect(Collectors.toList());
        model.addAttribute("tareasRoadmap", tareasRoadmap);
        model.addAttribute("tareasWaiting", tareasWaiting);
        model.addAttribute("tareasWorking", tareasWorking);
        model.addAttribute("tareasDone", tareasDone);

        return "/ej04/kanban2";
    }

    @GetMapping("/subirEstado/{codigo}")
    public RedirectView subirEstado(@PathVariable String codigo) {
        Optional<TareaKanban> tarea = service.getTarea(codigo);

        if (tarea.isPresent()) {
            String estado = tarea.get().getEstado();
            try {
                switch (estado) {
                    case "Roadmap":
                        service.cambiarEstado(codigo, "Waiting");
                        break;
                    case "Waiting":
                        service.cambiarEstado(codigo, "Working");
                        break;
                    case "Working":
                        service.cambiarEstado(codigo, "Done");
                        break;
                }
            } catch (OperacionEnListaException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/ej04/verkanban");
    }

    @GetMapping("/bajarEstado/{codigo}")
    public RedirectView bajarEstado(@PathVariable String codigo) {
        Optional<TareaKanban> tarea = service.getTarea(codigo);
        if (tarea.isPresent()) {
            String estado = tarea.get().getEstado();
            try {
                switch (estado) {
                    case "Waiting":
                        service.cambiarEstado(codigo, "Roadmap");
                        break;
                    case "Working":
                        service.cambiarEstado(codigo, "Waiting");
                        break;
                    case "Done":
                        service.cambiarEstado(codigo, "Working");
                        break;
                }
            } catch (OperacionEnListaException e) {
                e.printStackTrace();
            }
        }
        return new RedirectView("/ej04/verkanban");
    }

    @GetMapping("/asignarPersona/{codigo}")
    public String formPersona(Model model, @PathVariable String codigo){
        TareaKanban tarea = service.getTarea(codigo).get();
        model.addAttribute("tarea", tarea);
        return "/ej04/asignarPersona";
    }

    @PostMapping("/asignarPersona")
    public RedirectView asignarPersona(TareaKanban tarea){
        try {
            service.asignarPersona(tarea.getCodigo(), tarea.getPropietario());
        } catch (OperacionEnListaException e) {
            e.printStackTrace();
        }
        return new RedirectView("/ej04/verkanban");
    }

    @GetMapping("/imputarHoras/{codigo}")
    public String formHoras(Model model, @PathVariable String codigo){
        TareaKanban tarea = service.getTarea(codigo).get();
        model.addAttribute("codigo", codigo);
        return "/ej04/imputarHoras";
    }

    @PostMapping("/imputarHoras")
    public RedirectView imputarHoras(String codigo, Integer horas){
        try {
            service.imputarHorasTrabajadas(codigo, horas);
        } catch (OperacionEnListaException e) {
            e.printStackTrace();
        }
        return new RedirectView("/ej04/verkanban");
    }

    @GetMapping("/editarTarea/{codigo}")
    public String editarTarea(Model model, @PathVariable String codigo){
        TareaKanban tarea = service.getTarea(codigo).get();
        model.addAttribute("tarea", tarea);
        return "/ej04/tarea";
    }

    @PostMapping("/guardarTarea")
    public RedirectView guardarTarea(TareaKanban tarea){
        try {
            if(!tarea.getCodigo().equals("")) {
                service.modificarTarea(tarea.getCodigo(), tarea.getDescripcion(), tarea.getHorasEstimacion());
            } else {
                service.crearTarea(tarea.getDescripcion(), tarea.getHorasEstimacion());
            }
        } catch (OperacionEnListaException e) {
            e.printStackTrace();
        }
        return new RedirectView("/ej04/verkanban");
    }

    @GetMapping("/anadirTarea")
    public String anadirTarea(Model model){
        model.addAttribute("tarea", new TareaKanban());
        return "/ej04/tarea";
    }
}