package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService gestionAlumnos;

    @GetMapping("/gestionAlumnos")
    public String verAlumnos(Model model) {
        model.addAttribute("listaAlumnos", gestionAlumnos.getAlumnos());
        return "ej03/listaAlumnos";
    }
    
    
    
    
    

}
