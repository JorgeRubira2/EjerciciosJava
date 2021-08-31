package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Isabel
 */
@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuro {

    @GetMapping("/ver")
    public String verDirectorios(Model model, String ruta) {
        
        if(ruta == null){
            ruta = "C:\\";
        }
        
        File f = new File(ruta);
        File []ficheros = f.listFiles();

        model.addAttribute("directorios", ficheros);
        
        return "/ej10/ficheros";
    }
}
