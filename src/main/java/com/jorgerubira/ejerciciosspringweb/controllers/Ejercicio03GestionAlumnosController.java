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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String verFormulario(){
        return "/ej03/formulario";
    }

    @PostMapping("/anadirAlumno")
    public String añadirAlumno(Model model, Alumno alumno){
        service.guardarAlumno(alumno);
        return "/ej03/gestion";
    }

}
