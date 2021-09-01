/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;
import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;

import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 * TODO:
 * 
 * El Kanban se muestra correctamente.
 * 
 * Ahora se permite añadir un nuevo Kanban através de un Ajax.
 * 
 * Ya se pueden modificar los Kanban con su respectivo botón.
 */
@Controller
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {

    @Autowired
    private IEjercicio04KanbanService list;

    @GetMapping("")
    public String listado(Model model) {

        model.addAttribute("Roadmap", list.getTareas().stream().filter(var -> var.getEstado().equals("Roadmap"))
                .collect(Collectors.toList()));

        model.addAttribute("Waiting", list.getTareas().stream().filter(var -> var.getEstado().equals("Waiting"))
                .collect(Collectors.toList()));

        model.addAttribute("Working", list.getTareas().stream().filter(var -> var.getEstado().equals("Working"))
                .collect(Collectors.toList()));

        model.addAttribute("Done",
                list.getTareas().stream().filter(var -> var.getEstado().equals("Done")).collect(Collectors.toList()));

        return "ej04/Kanban";
    }

    // Mostramos el formulario para crear/modificar la tarea Kanban
    @GetMapping("/formAgregarModificar")
    public String formAgregarModificar(Model model, TareaKanban tarea, String codigo) {
        if (list.getTarea(codigo).isPresent()) {
            model.addAttribute("codigoControlador", list.getTarea(codigo));
        } else {
            model.addAttribute("codigoControlador", tarea);
        }
        return "ej04/formAgregarModificar";
    }

    /**
     * Subimos a la lista el Kanban con su descripción y estimación. En caso de
     * estar ya en la lista, modifica.
     */

    @PostMapping("/nuevoModificarKanban")
    public String nuevoModificarKanban(Model model, String codigo, String descripcion, Integer horasEstimacion) {
        if (list.getTarea(codigo).isPresent()) {
            try {
                list.modificarTarea(codigo, descripcion, horasEstimacion);
            } catch (OperacionEnListaException ex) {
                model.addAttribute("error", "El kanban está repetido");
                Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            list.crearTarea(descripcion, horasEstimacion);
        }
        return "redirect:";
    }

    // Mostramos el formulario para editar la persona
    @GetMapping("/formAsignarPropietario")
    public String formAsignarPersona(Model model, String codigo) {
        model.addAttribute("codigoControlador", list.getTarea(codigo));
        return "ej04/formAsignarPropietario";
    }

    // Modificamos el propietario del Kanban
    @PostMapping("/asignarPropietario")
    public String nuevoModificarKanban(Model model, String codigo, String propietario) {
        try {
            list.asignarPersona(codigo, propietario);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "El kanban está repetido");
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:";
    }

    // Mostramos el formulario para cambiar estado
    @GetMapping("/formCambiarEstado")
    public String formCambiarEstado(Model model, String codigo) {
        model.addAttribute("codigoControlador", list.getTarea(codigo));
        return "ej04/formCambiarEstado";
    }

    // Modificamos el estado del Kanban
    @PostMapping("/cambiarEstado")
    public String cambiarEstado(Model model, String codigo, String estado) {
        try {
            list.cambiarEstado(codigo, estado);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "El kanban está repetido");
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:";
    }

    // Mostramos el formulario para imputar horas
    @GetMapping("/formImputarHoras")
    public String formImputarHoras(Model model, String codigo) {
        model.addAttribute("codigoControlador", list.getTarea(codigo));
        return "ej04/formImputarHoras";
    }

    // Imputamos las horas
    @PostMapping("/imputarHoras")
    public String imputarHoras(Model model, String codigo, Integer horasTrabajadas) {
        try {
            list.imputarHorasTrabajadas(codigo, horasTrabajadas);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "El kanban está repetido");
            Logger.getLogger(Ejercicio04KanbanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:";
    }

}
