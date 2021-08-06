
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
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ejercicio01ListaNombresController {
    
    @Autowired
    private IEjercicio01ListaNombresService service;
    
    
    
    @GetMapping("/listapersona")
    //@RequestMapping (value= "/operaciones", method ={RequestMethod.GET, RequestMethod.POST})
    public String verLista(Model model){
        
        model.addAttribute("personas",service.getLista());
      
        return "ej01/listaPersonas";
        
    }
    
    
    @PostMapping("/listapersona")
    public String aniadirPersona(Model model, String nombre){

        try {
            service.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "ha ocurrido un error");
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("personas",service.getLista());
        
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/eliminarpersona")
    
    public String eliminar(Model model, String nombre){
        
        service.bajaNombre(nombre);    
        model.addAttribute("personas",service.getLista());
        return "ej01/listaPersonas";
    }
    
    
    
}
