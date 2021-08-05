
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

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio01")
public class Ejercicio01ListaNombresController {
    @Autowired
    private IEjercicio01ListaNombresService service;
    
    @GetMapping("/listaNombres")
    public String inicio(Model model){
        model.addAttribute("listaPersonas", service.getLista());
        return "ej01/listaPersonas";
    }
    @PostMapping("/listaNombres")
    public String accion(Model model,String nombre, String toDo){
        List<String> aux=service.getLista();
        String resultado="";
        if(toDo.equalsIgnoreCase("añadir")){
            try {
                service.altaNombre(nombre);
                resultado=nombre+" añadido con éxito";
            } catch (OperacionEnListaException ex) {
                Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
                resultado=nombre+" error al añadir";
            }
        }
        else if(toDo.equalsIgnoreCase("borrar")){
            if(aux.contains(nombre)){
                service.bajaNombre(nombre);
                resultado=nombre+" borrado correctamente";
            }
            else{
                resultado=nombre+" este elemento no se encontraba en la lista";
            }
          
        }
        model.addAttribute("resultado", resultado);
        model.addAttribute("listaPersonas", service.getLista());
        return "ej01/listaPersonas";
    }
    
}
