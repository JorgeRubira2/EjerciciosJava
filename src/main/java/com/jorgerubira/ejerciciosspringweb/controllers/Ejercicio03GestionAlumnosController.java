package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/controlador")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    @GetMapping("/gestionAlumnos")
    public String gestionAlumnos(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/add")
    public RedirectView incluirAlumnos(Model model, Alumno alumno) {
        service.guardarAlumno(alumno);
        return new RedirectView ("gestionAlumnos");
    }

    @PostMapping("/buscarPorNombre")
    public String buscarAlumnosPorNombre(Model model, String nombre) {
        model.addAttribute("alumno", service.getAlumnos(nombre));
        return "ej03/gestionAlumnos";
    }

    @GetMapping("/remove")
    public RedirectView eliminarAlumnos(Model model, Long codigo) {
        service.borrarAlumno(codigo);
        model.addAttribute("alumno", service.getAlumnos());
        return new RedirectView ("gestionAlumnos");
    }

    @GetMapping("/edit")
    public RedirectView aditarAlumnos(Model model, Long codigo) {
        model.addAttribute("alumno", service.getAlumno(codigo));
        model.addAttribute("alumno", service.getAlumnos());
        return new RedirectView ("gestionAlumnos");
    }
    
    @GetMapping("/formulario")
    public String formulario(Model model, Long codigo) {
        if(codigo!=null){
        model.addAttribute("alumno", service.getAlumno(codigo));
        } else{
        model.addAttribute("alumno", new Alumno());
        }
        return "ej03/formulario";
    }
    
}
