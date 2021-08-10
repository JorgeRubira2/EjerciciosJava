/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    
        /******* SERVICE *******/
    @Autowired
    private IEjercicio03GestionAlumnosService serviceAlumnos;

    @GetMapping("/alumnos")
    public String serviceAlumnos(Model model) {
        model.addAttribute("lista", serviceAlumnos.getAlumnos());
        return "/ej03/listadoAlumnos";
    }
}
