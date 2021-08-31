package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@RequestMapping("/ej10")
public class Ejercicio10MostrarDiscoDuro {

    @GetMapping("/lista")
    public String ver(Model model, String ruta){
        if(ruta==null){
            ruta = "C:\\";
        }
        File f = new File(ruta);
        File []ficherosInternos = f.listFiles();
        String padre;
        if(("C:\\").equals(ruta)){
            padre = "C:\\";
        } else {
            padre = f.getParent();
        }
        model.addAttribute("ficheros", ficherosInternos);
        model.addAttribute("padre", padre);
        return "/ej10/lista";
    }
}
