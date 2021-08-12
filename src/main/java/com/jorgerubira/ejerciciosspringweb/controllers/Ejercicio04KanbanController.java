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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Cosas interesantes para implementar en la vista. Si las horas superiores es
 * superior que el doble de la hora estimada marcar el fondo en rojo Si las
 * horas superiores es superior a la hora estimada marcar el fondo en naranja Si
 * las horas superiores es inferior o igual a la hora estimada marcar el fondo
 * en verde
 *
 * En las tarjetas mostrar la descripción, persona responsable, horas
 * trabajadas/horas estimadas.
 *
 */
@Controller
@RequestMapping("/ejercicio04")
public class Ejercicio04KanbanController {

    @Autowired
    private IEjercicio04KanbanService service;

    @GetMapping("/devolverlista") //URL A LLAMAR
    public String lista(Model model) {

        model.addAttribute("listaRoadmap", service.getTareas().stream()
                .filter(x -> "Roadmap".equals(x.getEstado())).collect(Collectors.toList()));

        model.addAttribute("listaWaiting", service.getTareas().stream()
                .filter(x -> "Waiting".equals(x.getEstado())).collect(Collectors.toList()));

        model.addAttribute("listaWorking", service.getTareas().stream()
                .filter(x -> "Working".equals(x.getEstado())).collect(Collectors.toList()));

        model.addAttribute("listaDone", service.getTareas().stream()
                .filter(x -> "Done".equals(x.getEstado())).collect(Collectors.toList()));

        return "ej04/vista";
    }

    @PostMapping("/alta") //URL A LLAMAR
    public String altaTarea(Model model, String descripcion, Integer horasEstimacion) {

        model.addAttribute("descripcion", descripcion);
        model.addAttribute("horasEstimacion", horasEstimacion);
        service.crearTarea(descripcion, horasEstimacion);

        return "redirect:devolverlista";
    }

    @GetMapping("/modificar") //URL A LLAMAR 
    public String modificarTarea(Model model, String codigo) {

        Optional<TareaKanban> tar = service.getTarea(codigo);
        if (tar.isPresent()) {
            if ("Roadmap".equals(tar.get().getEstado())) {
                tar.get().setEstado("Waiting");

            } else if ("Waiting".equals(tar.get().getEstado())) {
                tar.get().setEstado("Working");

            } else if ("Working".equals(tar.get().getEstado())) {
                tar.get().setEstado("Done");
            }
        }

        return "redirect:devolverlista";
    }

    @PostMapping("/addpersona") //URL A LLAMAR
    public String addPersona(Model model, String codigo, String propietario) {
        try {

            service.asignarPersona(codigo, propietario);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:devolverlista";
    }

    @PostMapping("/addhoras") //URL A LLAMAR
    public String imputarHoras(Model model, String codigo2, int horas) {
        try {

            service.imputarHorasTrabajadas(codigo2, horas);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:devolverlista";
    }

    @PostMapping("/modificartarea") //URL A LLAMAR
    public String modificarTarea(Model model, String codigo3, String descripcion2, Integer horasEstimacion2) {

        try {
            service.modificarTarea(codigo3, descripcion2, horasEstimacion2);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:devolverlista";
    }

}
