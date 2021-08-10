package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/borrar/{codigo}")
    public String borrarAlumno(@PathVariable Long codigo){
        alumnosService.borrarAlumno(codigo);
        
        return "/ej03/alumnos";
    }
    
    @PostMapping("/guardar")
    public String formulario(Model model, Alumno alumno){
        alumnosService.guardarAlumno(alumno);
 
        return ("/ej03/editAlumno");
    }
    
    @GetMapping("/editar/{codigo}")
    public String editarAlumno(Model model, @PathVariable Long codigo){
        Alumno editAlumno = alumnosService.getAlumno(codigo).get();
        model.addAttribute("alumno", editAlumno);
        
        return "/ej03/editAlumno";
    }
    
    @PostMapping("/buscar")
    public String buscarAlumno(Model model, String nombre){
        
        List<Alumno> encontrados = new ArrayList<>();
        model.addAttribute("alumnos", alumnosService.getAlumnos(nombre));
        
        return "/ej03/alumnos";
    }
}
