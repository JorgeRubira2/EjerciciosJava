/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio05")
public class Ejercicio05MedalleroController {
	
	

	    @Autowired
	    private IEjercicio05MedalleroService medallero;
	    
	    @GetMapping ("/medallero")
	    public String verKanban(Model model){        
		 
	    	model.addAttribute("medallero", medallero.getMedallas());
	        return"ej05/TablaMedallero";
	    }
	    @GetMapping("/rankingPorPaises")
	    public String paises(Model model) {
	        model.addAttribute("medallero", medallero.obtenerRankingPorPais());
	        return "ej05/TablaMedallero";
	    }

	    @GetMapping("/rankingPorAtletas")
	    public String atletas(Model model) {
	        model.addAttribute("atletas", medallero.obtenerRankingPorAlteta());
	        return "ej05/atletas";
	    }
	    

	    @GetMapping("/deporteDeUnaMedalla")
	    public String deporteUnaMedalla(Model model, String pais, String medalla) {
	        model.addAttribute("medallero", medallero.obtenerDeportesDeUnaMedalla(pais, medalla));
	        return "ej05/deportesUnaMedalla";
	    }

	    @GetMapping("/deporteConMedalla")
	    public String deporteConMedalla(Model model, String pais) {
	        model.addAttribute("medallas", medallero.obtenerDeportesConMedalla(pais));
	        return "ej05/deportesConMedalla";
	    }


	}