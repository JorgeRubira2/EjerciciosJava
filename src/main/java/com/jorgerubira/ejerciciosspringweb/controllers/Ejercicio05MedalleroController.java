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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ej05")
public class Ejercicio05MedalleroController {

    @Autowired
    IEjercicio05MedalleroService service;

    @GetMapping("/medallero")
    public String verMedallero(Model model){
        model.addAttribute("rankingPais", service.obtenerRankingPorPais());
        model.addAttribute("rankingDeportista", service.obtenerRankingPorAlteta());
        return "/ej05/medallero";
    }

    @GetMapping("/detalle")
    public String verDetalle(Model model, String pais, String medalla){
        String titulo = "";
        if(medalla==null) {
            model.addAttribute("lista", service.obtenerDeportistasConMedalla(pais));
            titulo = "Atletas";
        } else {
            model.addAttribute("lista", service.obtenerDeportesDeUnaMedalla(pais, medalla));
            titulo = "Deportes";
        }
        model.addAttribute("titulo", titulo);
        return "/ej05/detalle";
    }
}
