/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Mohamad
 */
@Controller
public class Ejercicio10MostrarDiscoDuro {

    @GetMapping("/ejercicio10/directorios")
    public String Listar(Model model,String ruta) {
        if (ruta == null) {
            ruta= "C:\\";
        }
        File f = new File(ruta);
        
        model.addAttribute("arbol", f.listFiles());
        return "ej10/arbol";
    }
 
    
}

