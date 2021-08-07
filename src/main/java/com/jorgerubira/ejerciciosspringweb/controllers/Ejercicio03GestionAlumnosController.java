package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService gestionAlumnos;

    @GetMapping("/gestionAlumnos")
    public String verAlumnos(Model model) {

        model.addAttribute("listaAlumnos", gestionAlumnos.getAlumnos());
        return "ej03/listaAlumnos";
    }

    @PostMapping("/gestionAlumnos")
    public String agregarAlumnos(Model model, Long codigo, String nombre, String telefono, String direccion) {

        Alumno alumno = new Alumno();
  
        alumno.setCodigo(codigo);
        alumno.setNombre(nombre);
        alumno.setTelefono(telefono);
        alumno.setDireccion(direccion);
        gestionAlumnos.guardarAlumno(alumno);
        model.addAttribute("listaAlumnos", gestionAlumnos.getAlumnos());

//gestionar los nulos?? 
        return "ej03/listaAlumnos";
    }
    
    
    

}
