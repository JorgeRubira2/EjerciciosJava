
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

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio01")
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService listaNombresService;
    
    //Añadir nombre
    @PostMapping("/nombre")
    public String datosARellenar(Model model, String nombre){
        try {
            listaNombresService.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("nombre", listaNombresService.getLista());
        return "ej01/listaPersonas";
    }
    
    //Mostrar lista de nombres
    @GetMapping("/nombre")
    public String datosNuevos(Model model){
        model.addAttribute("nombre", listaNombresService.getLista());
        return "ej01/listaPersonas";
    }
    
    //Eliminar nombre
    @PostMapping("/eliminar")
    public String borrarDato(Model model, String nombre){
        listaNombresService.bajaNombre(nombre);
        listaNombresService.getLista();
        return "ej01/listaPersonas";
    }
}