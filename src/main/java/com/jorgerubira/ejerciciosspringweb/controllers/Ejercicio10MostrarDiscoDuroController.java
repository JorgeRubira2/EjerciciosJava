package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ej10")
public class Ejercicio10MostrarDiscoDuroController {
   
    @GetMapping("/mostrarDirectorios") //esta es la URL a la que llamaremos desde el navegador
    public String listar (Model model, String ruta){
        
        if(ruta==null){
            ruta="C:\\";
        }
        
        File f=new File(ruta);
                                    
        File []ficherosInternos=f.listFiles();

        model.addAttribute("Ficheros", ficherosInternos);
        model.addAttribute("Parent", f.getParent());
        
        return "/ej10/index";
    }
}
