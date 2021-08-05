package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que
 * permite almacenar y borrar nombres de personas. Se pide exponerlo en una web
 * de manera que podremos ver las personas que están en la lista y añadir o
 * quitar nombres. Los nombres no se deben repetir, el servicio lanza una
 * excepción en ese caso.
 */
@Controller

public class Ejercicio01ListaNombresController {

    @Autowired
    private IEjercicio01ListaNombresService service;

    @GetMapping("/ejercicio1/listaPersona")
    public String ListaNombre(Model model) {
        model.addAttribute("listaPersonas", service.getLista());
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/ejercicio1/AddNombre")
    public String AddNombre(Model model,String nombre) {
        try {
            service.altaNombre(nombre); 
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error","No se ha podido añadir el nombre a la lista");
        }
         model.addAttribute("nombre", nombre);
         model.addAttribute("listaPersonas",service.getLista());
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/ejercicio1/EliminarNombre")
    public String EliminarNombre(Model model,String nombre) {
            service.bajaNombre(nombre);
            model.addAttribute("listaPersonas",service.getLista());
        return "ej01/listaPersonas";
    }

}
