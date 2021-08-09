
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    
    @Autowired
    private IEjercicio03GestionAlumnosService servicio;
    
    @GetMapping("/gestion")
    public String gestion(Model model){
        model.addAttribute("alumnos", servicio.getAlumnos());
        return "ej03/gestionAlumnos";
    }
    
    @GetMapping("/nuevo")
    public String nuevoAlumno(){
       return "ej03/formAlumno";
    }
    
    @PostMapping("/guardar")
    public String guardarAlumno(Model model, Alumno alumno){
       servicio.guardarAlumno(alumno);
        
        return "ej03/gestionAlumnos";
    }
    
    @GetMapping("/borrar/{codigo}")
    public String borrar(Model model) {
        
        return "/ej03/gestionAlumnos";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(Model model) {
        return "/ej03/formAlumno";
    }
    
}
