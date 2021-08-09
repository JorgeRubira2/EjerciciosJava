package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio03")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService alumnosService;
    

    @GetMapping("/ver")
    public String verLista(Model model) {
        model.addAttribute("alumnos", alumnosService.getAlumnos());
        return "/ej03/alumnos";
    }
    
    @DeleteMapping("/borrar/{codigo}")
    public String borrarAlumno(@PathVariable long codigo){
        alumnosService.borrarAlumno(codigo);
        
        return "/ej03/alumnos";
        
    }

}
