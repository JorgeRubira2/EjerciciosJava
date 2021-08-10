/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
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
    
    @Autowired
    private IEjercicio03GestionAlumnosService gest;
    
    @GetMapping("/listado")
    public String lista(Model model) {
        model.addAttribute("listaAlumnos", gest.getAlumnos());
        return "ej03/listadoAlumnos";
    }
}
