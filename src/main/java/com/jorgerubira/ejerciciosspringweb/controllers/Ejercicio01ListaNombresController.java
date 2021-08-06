
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import com.jorgerubira.explicaciones.D20210804.services.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio1")
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService service;
       
    @GetMapping("/mostrarElementos") //esta es la URL a la que llamaremos desde el navegador
    public String listar (Model model){
        model.addAttribute("personas", service.getLista()); //("elNombreQueQueramos, nombreVariableConexiónConInterface.métodoInterface())
        return "ej01/listaPersonas"; //esta es la vista que llama desde la URL
    }
 
   @PostMapping("/annadir")
    public String insertar (Model model, String nombre){
        try {
            service.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addAttribute("personas", service.getLista());
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/eliminar")
    public String borrar (Model model, String nombre){
        model.addAttribute("personas", service.getLista());
        return"ej01/listaPersonas";
    }
 
}
