/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;


import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
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
@RequestMapping("/ejercicio5")
public class Ejercicio05MedalleroController {
    
    @Autowired
    private IEjercicio05MedalleroService medallero;
    
    
    @GetMapping("/ranking")
     public String ranking(Model model) {
        model.addAttribute("paises", medallero.obtenerRankingPorPais());
        return ("ej05/rankingpaises");
    }
}
