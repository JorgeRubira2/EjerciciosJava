
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio01")
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService serv;
    
    @GetMapping
    public String cargar(Model model){
       
        model.addAttribute("Personas",serv.getLista());
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/add")//EL REDIRECT VIEW HACE QUE LA URL NO TENGA EL /add UNA VEZ HECHA LA OPERACION
    public RedirectView add(Model model,String nombre){
        try {
            serv.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("Personas", serv.getLista());
        return new RedirectView("/ejercicio01");
        //return "ej01/listaPersonas";
    }
    
    @PostMapping("/remove")
    public RedirectView remove(Model model, String nombre){
        serv.bajaNombre(nombre);
        return new RedirectView("/ejercicio01");
    }
    
}
