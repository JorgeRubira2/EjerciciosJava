/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author PC
 */
@Controller
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    @GetMapping("/gestionAlumnos")
    public String gestionAlumnos(Model model) {

        model.addAttribute("alumno", service.getAlumnos());
        //model.addAttribute("mensajeError", "");
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/añadir")
    public String incluirAlumnos(Model model, Alumno alumno) {

       
            service.guardarAlumno(alumno);
       

        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/buscar")
    public String buscarAlumnosPorCodigo(Model model, Long codigo) {

       
            service.getAlumno(codigo);
        

        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/buscarporNombre")
    public String buscarAlumnosNombre(Model model, String nombre) {

        
            service.getAlumnos(nombre);
      
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/remove")
    public String eliminarAlumnos(Model model, Long codigo) {
        service.borrarAlumno(codigo);
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

    @PostMapping("/edit")
    public String aditarAlumnos(Model model, Alumno alumno) {
        service.guardarAlumno(alumno);
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/gestionAlumnos";
    }

}
