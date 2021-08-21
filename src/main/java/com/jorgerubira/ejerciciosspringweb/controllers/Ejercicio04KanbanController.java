/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;

import java.util.Optional;
import java.util.logging.Logger;
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
@RequestMapping("/ejercicio4")
public class Ejercicio04KanbanController {
	@Autowired
    private IEjercicio04KanbanService Kanban;
	
	 @GetMapping ("/lista")
	    public String verKanban(Model model){        
		 model.addAttribute("RoadMap", Kanban.getTareas().stream().filter(x-> x.getEstado().equals("RoadMap")).collect(Collectors.toList()));
		   model.addAttribute("Working", Kanban.getTareas().stream().filter(x-> x.getEstado().equals("Working")).collect(Collectors.toList()));
	        model.addAttribute("Done", Kanban.getTareas().stream().filter(x-> x.getEstado().equals("Done")).collect(Collectors.toList()));
	        model.addAttribute("Waiting", Kanban.getTareas().stream().filter(x-> x.getEstado().equals("Waiting")).collect(Collectors.toList()));
	        
	        return"ej04/vistaKanban";
	    }
	 @PostMapping("/nuevaTarea") 
	    public String nuevaTarea(Model model, String descripcion, Integer horasEstimacion) {
	        model.addAttribute("horasEstimacion", horasEstimacion);
	        model.addAttribute("descripcion", descripcion);
	        Kanban.crearTarea(descripcion, horasEstimacion);

	        return "redirect:lista";
	    }
	 @PostMapping("/nuevaPersona") 
	    public String nuevaPersona(Model model, String codigo, String propietario) {
	    
	            try {
					Kanban.asignarPersona(codigo, propietario);
				} catch (OperacionEnListaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        
	        return "redirect:lista";
	    }
	 @PostMapping("/masHoras")
	    public String imputarHoras(Model model, String codigo2, int horas) {
	        try {

	            Kanban.imputarHorasTrabajadas(codigo2, horas);
	        } catch (OperacionEnListaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        return "redirect:lista";
	    }
	 @GetMapping("/modificar")
	    public String modificarTarea(Model model, String codigo) {
	        Optional<TareaKanban> tarea = Kanban.getTarea(codigo);
	        if (tarea.isPresent()) {
	            if ("Roadmap".equals(tarea.get().getEstado())) {
	                tarea.get().setEstado("Waiting");
	                
	            } else if ("Working".equals(tarea.get().getEstado())) {
	                tarea.get().setEstado("Done");
	                
	            } else if ("Waiting".equals(tarea.get().getEstado())) {
	                tarea.get().setEstado("Working");
	            }
	        }

	        return "redirect:lista";
	    }
	 @PostMapping("/modificarTarea") 
	    public String modificarTarea(Model model, String codigo3, String descripcion2, Integer horasEstimacion2) {

	        try {
	            Kanban.modificarTarea(codigo3, descripcion2, horasEstimacion2);
	        } catch (OperacionEnListaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        return "redirect:lista";
	    }

	}
	 

