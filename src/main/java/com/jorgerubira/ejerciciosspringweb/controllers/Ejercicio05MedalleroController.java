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

@Controller
@RequestMapping("/medallero")
public class Ejercicio05MedalleroController {

    @Autowired
    private IEjercicio05MedalleroService gestionMedallero;

    @GetMapping("/rankingPaises")
    public String paises(Model model) {
        model.addAttribute("medallero", gestionMedallero.obtenerRankingPorPais());
        return "ej05/medallero";
    }

    @GetMapping("/rankingAtletas")
    public String atletas(Model model) {
        model.addAttribute("atletas", gestionMedallero.obtenerRankingPorAlteta());
        return "ej05/atletas";
    }
    //mirar para hacerlo mejor modal

    @GetMapping("/deporteUnaMedalla")
    public String deporteUnaMedalla(Model model, String pais, String medalla) {
        model.addAttribute("medallero", gestionMedallero.obtenerDeportesDeUnaMedalla(pais, medalla));
        return "ej05/deportesUnaMedalla";
    }

    @GetMapping("/deporteConMedalla")
    public String deporteConMedalla(Model model, String pais) {
        model.addAttribute("medallas", gestionMedallero.obtenerDeportesConMedalla(pais));
        return "ej05/deportesConMedalla";
    }

    @GetMapping("/deportistasConMedalla")
    public String deportistasConMedalla(Model model) {
       model.addAttribute("deportista",gestionMedallero.obtenerDeportistaConMedalla("china"));
        return "ej05/deportistasConMedalla";
    }

}
