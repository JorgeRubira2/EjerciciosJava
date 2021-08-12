
package com.jorgerubira.ejerciciosspringweb.controllers;


import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import com.jorgerubira.explicaciones.D20210804.services.Persona;
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
    //se visualiza la vista
    @Autowired
    private IEjercicio01ListaNombresService lista;          
    @GetMapping("/listaPersonas")
    
    public String ListaPersonas(Model model){
        
        model.addAttribute("Lista", lista.getLista());   
        return "ej01/listaPersonas";
    }

                      
    @PostMapping ("/agregar")
    public String agregar( Model model, String nombre){
                   
        try {
            if ((nombre !=null) && (nombre.trim().equals("")== false))
            {
                lista.altaNombre(nombre);               
            }
            
        } catch (OperacionEnListaException e) {
            e.getStackTrace();
        }
        model.addAttribute("Lista", lista.getLista());
       // return "ej01/listaPersonas";
       return "redirect:listaPersonas";
    }
    
    @PostMapping ("/eliminar")
    public String eliminar( Model model, String nombre){
                   
       
        lista.bajaNombre(nombre);
        model.addAttribute("Lista", lista.getLista());
                 
       // return "ej01/listaPersonas";
       return "redirect:listaPersonas";
    }
    
}
