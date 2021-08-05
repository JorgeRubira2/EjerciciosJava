
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
        
    @PostMapping("/listaPersona")
    public String agregarPersona(Model model, String nombre){
        
        try{
            service.altaNombre(nombre);
        }catch (OperacionEnListaException ex){
            model.addAttribute("error", "ha ocurrido un error");
            
        }
        return "ej01/listaPersonas";
            
    }
}
