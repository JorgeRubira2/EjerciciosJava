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

/**
 *
 * @author PC
 */
@Controller
public class Ejercicio03GestionAlumnosController {
    
    @Autowired
    private IEjercicio03GestionAlumnosService service;
    
    @GetMapping("/listaPersonas")
    public String listaPersonas(Model model) {

        //model.addAttribute("persona", service.getLista());
        //model.addAttribute("mensajeError", "");
        return "ej01/listaPersonas";
    }

    
}
