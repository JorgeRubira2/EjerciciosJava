package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ej05")
public class Ejercicio05MedalleroController {

    @Autowired
    private IEjercicio05MedalleroService servicio;
    
    @GetMapping("/medallas")
    public String inicio(Model m){
        m.addAttribute("medallas",servicio.obtenerRankingPorPais());
        return "ej05/medallero";
    }
}
