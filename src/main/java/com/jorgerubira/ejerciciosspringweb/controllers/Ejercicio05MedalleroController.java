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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio05")
public class Ejercicio05MedalleroController {
    
    @Autowired
    private IEjercicio05MedalleroService serviceMedallero;
    
    
    @GetMapping("/medallas")
    public String inicioMedallas(Model model){
        
        serviceMedallero.obtenerRankingPorPais().forEach(x ->System.out.println(x));
        model.addAttribute("medallasPaises", serviceMedallero.obtenerRankingPorPais());
    return "ej05/medallas";
    }
    
    @GetMapping("/consultaDeportesEnMedalla/{metal}/{pais}")
    public String consultaDeportesDeMedalla(Model model, @PathVariable("metal") String metal, @PathVariable("pais") String pais){
        serviceMedallero.obtenerDeportesDeUnaMedalla(pais, metal);
        model.addAttribute("deportesMedalla", pais);
        return "ej05/medallas";
    }
    
}
