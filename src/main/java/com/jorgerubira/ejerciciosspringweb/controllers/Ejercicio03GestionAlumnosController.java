/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ej03")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    IEjercicio03GestionAlumnosService service;

    @GetMapping("/gestion")
    public String verGestion(Model model){
        model.addAttribute("alumnos", service.getAlumnos());
        return "/ej03/gestion";
    }

    @GetMapping("/formulario")
    public String verFormulario(Model model){
        model.addAttribute("alumno", new Alumno());
        return "/ej03/formulario";
    }

    @PostMapping("/anadirAlumno")
    public RedirectView añadirAlumno(Model model, Alumno alumno){
        service.guardarAlumno(alumno);
        return new RedirectView("/ej03/gestion");
    }

    @GetMapping("/borrarAlumno/{codigo}")
    public RedirectView borrarAlumno(@PathVariable long codigo){
        service.borrarAlumno(codigo);
        return new RedirectView("/ej03/gestion");
    }

//    @PostMapping("/buscarAlumno")
//    public String buscarAlumno(){
//        List<Alumno> lista = new ArrayList<>();
//        service
//        return "/ej03/gestion";
//    }
}
