package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

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
@RequestMapping("/controlador")
public class Ejercicio04KanbanController {

    @Autowired
    private IEjercicio04KanbanService service;

    @GetMapping("/kanban")
    public String kanban(Model model) {

        model.addAttribute("Roadmap", service.getTareas().stream().filter(t -> t.getEstado().equals("Roadmap")).collect(Collectors.toList()));
        model.addAttribute("Waiting", service.getTareas().stream().filter(t -> t.getEstado().equals("Waiting")).collect(Collectors.toList()));
        model.addAttribute("Working", service.getTareas().stream().filter(t -> t.getEstado().equals("Working")).collect(Collectors.toList()));
        model.addAttribute("Done", service.getTareas().stream().filter(t -> t.getEstado().equals("Done")).collect(Collectors.toList()));
        
        return "ej04/kanban";
    }

    @GetMapping("/read")
    @ResponseBody
    public TareaKanban read(String codigo) {
        return service.getTarea(codigo).get();
    }

    @PostMapping("/nueva")
    public RedirectView nueva(Model model, String descripcion, Integer horasEstimacion) {
        service.crearTarea(descripcion, horasEstimacion);
        return new RedirectView("kanban");
    }

    @PostMapping("/edit")
    public RedirectView edit(Model model, String codigo, String descripcion, Integer horasEstamacion) {
        try {
            service.modificarTarea(codigo, descripcion, horasEstamacion);
        } catch (OperacionEnListaException e) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName());
        }
        return new RedirectView("kanban");
    }
    
    @PostMapping("/asignar")
    public RedirectView asignar(Model model, String codigo, String persona) {
        try {
            service.asignarPersona(codigo, persona);
        } catch (OperacionEnListaException e) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName());
        }
        return new RedirectView("kanban");
    }
    
    @PostMapping("/imputar")
    public RedirectView imputar(Model model, String codigo, int horas) {
        try {
            service.imputarHorasTrabajadas(codigo, horas);
        } catch (OperacionEnListaException e) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName());
        }
        return new RedirectView("kanban");
    }
    
    @PostMapping("/estado")
    public RedirectView estado(Model model, String codigo, String persona) {
        try {
            service.cambiarEstado(codigo, persona);
        } catch (OperacionEnListaException e) {
            Logger.getLogger(Ejercicio04KanbanController.class.getName());
        }
        return new RedirectView("kanban");
    }
    
    @GetMapping("/subir/{codigo}")
    public void subir (@PathVariable String codigo) {
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
       //return new RedirectView("kanban");
    }
    
    @GetMapping("/bajar/{codigo}")
    public RedirectView bajar (@PathVariable String codigo) {
        Optional<TareaKanban> tarea = service.getTarea(codigo);
        if (tarea.isPresent()) {
            String estado = tarea.get().getEstado();
            try {
               switch (estado) {
                   case "Done":
                       service.cambiarEstado(codigo, "Working");
                       break;
                    case "Working":
                       service.cambiarEstado(codigo, "Waiting");
                       break;   
                    case "Waiting":
                       service.cambiarEstado(codigo, "Roadmap");
                       break;
                }
            } catch (OperacionEnListaException e) {
                e.printStackTrace();
            }
        }
       return new RedirectView("kanban");
    }
    
    
    @GetMapping("/formularioKanban")
    public String formulario(Model model, String codigo) {
        if(codigo!=null){
        model.addAttribute("TareaKanban", service.getTarea(codigo));
        } else{
        model.addAttribute("TareaKanban", new TareaKanban());
        }
        return "ej04/formularioKanban";
    }

}
