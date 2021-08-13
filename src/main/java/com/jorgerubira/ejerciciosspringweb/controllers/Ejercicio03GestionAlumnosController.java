/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author PC
 * 
 * http://localhost:8080/ejercicio3/alumnos
 * 
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    @GetMapping("/listadoAlumnos")
    public String gestionAlumnos(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/listadoAlumnos";
    }

    @GetMapping("/nuevo")
    public String incluirAlumnos(Model model, Alumno alumno) {
        model.addAttribute("alumno", alumno);
        service.guardarAlumno(alumno);
        return ("ej03/nuevoAlumno");
    }

    @PostMapping("/buscar")
    public String buscarAlumnosPorCodigo(Model model, Long codigo) {
        service.getAlumno(codigo);
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/listadoAlumnos";
    }

    @PostMapping("/buscarPorNombre")
    public String buscarAlumnosPorNombre(Model model, String nombre) {
        service.getAlumnos(nombre);
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/listadoAlumnos";
    }

    @GetMapping("/borrar")
    public String eliminarAlumnos(Model model, Long codigo) {
        service.borrarAlumno(codigo);
        model.addAttribute("alumno", service.getAlumnos());
        return "ej03/listadoAlumnos";
    }

    @GetMapping("/editar")
    public RedirectView editarAlumnos(Model model, Long codigo) {
        model.addAttribute("alumno", service.getAlumno(codigo));
        model.addAttribute("alumno", service.getAlumnos());
        return new RedirectView ("listadoAlumnos");
    }

}