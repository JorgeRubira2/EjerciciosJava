package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio1")
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService list;
    
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("nombre", " ");
        model.addAttribute("personas", list.getLista());
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/listaagregar")
    public String agregar(Model model, String nombre) {
        
        try {
            list.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "El nombre está repetido");
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("nombre", " ");
        model.addAttribute("personas", list.getLista());
         
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/listaborrado")
    public String borrar(Model model, String nombre){
        list.bajaNombre(nombre);
        model.addAttribute("nombre", " ");
        model.addAttribute("personas", list.getLista());
        return "ej01/listaPersonas";
    }
}
