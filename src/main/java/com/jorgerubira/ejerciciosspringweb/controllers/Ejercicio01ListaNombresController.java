
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio01ListaNombresService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService service;
    
    @GetMapping("/enviarPersona")
    public String altaNombre(Model model, String nombre){
        model.addAttribute("nombre", service.getLista());
        return "ej01/listaPersonas";
    }    

    @PostMapping("/enviarPersona")
    public String enviarFormulario2(Model model, String nombre){
        try {
            service.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error","Ha ocurrido un error al insertar.");
            //Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("nombre", service.getLista());
        return "ej01/listaPersonas";
    }
    
    //Borrado de nombres
    @PostMapping("/borrado")
    public String borrarPersona(Model model, String nombre){
        service.bajaNombre(nombre);
        model.addAttribute("nombre", service.getLista());
        return "ej01/listaPersonas";
    }    

}