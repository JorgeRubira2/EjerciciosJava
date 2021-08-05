
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
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
    private IEjercicio01ListaNombresService servicio;
    
    @GetMapping("/lista")
    public String lista(){
        return "ej01/listaPersonas";
    }
    
    @GetMapping("/verlista")
    public String verLista(){
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/anadir")
    public String anadir(Model model, String nombre){
        try {
            servicio.altaNombre(nombre);
            model.addAttribute("lista",servicio.getLista());
            return "ej01/listaPersonas";
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error","Elemento Duplicado");
            model.addAttribute("lista",servicio.getLista());
            return "ej01/listaPersonas";
        }
    }
    
    @PostMapping("/borrar")
    public String borrar(Model model, String nombre){
        servicio.bajaNombre(nombre);
        model.addAttribute("lista",servicio.getLista());
        return "ej01/listaPersonas";
    }
    
}
