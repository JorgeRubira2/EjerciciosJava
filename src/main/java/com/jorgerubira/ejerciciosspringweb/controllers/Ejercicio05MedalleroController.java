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
@RequestMapping("/ej05")
public class Ejercicio05MedalleroController {
    @Autowired
    private IEjercicio05MedalleroService service;
    
    @GetMapping("/lista")
    public String listar(Model m, String opc){
        if(opc == null)
            opc="pais";
        else if(opc.equals("atleta")){
            service.obtenerRankingPorAlteta().forEach(x->System.out.println(x));
            m.addAttribute("medAtl", service.obtenerRankingPorAlteta());
        }else{
            service.obtenerRankingPorPais().forEach(x->System.out.println(x));
            m.addAttribute("medPa", service.obtenerRankingPorPais());
        }
        m.addAttribute("opc", opc);
        return "ej05/medallas";
    }
    
    @GetMapping("/consultaDeporte/{med}/{pais}")
    public String consultaDeporte(Model m, @PathVariable("med") String medalla, @PathVariable("pais") String pais){
        m.addAttribute("depMedalla", service.obtenerDeportesDeUnaMedalla(pais, medalla));
        m.addAttribute("med", medalla);
        m.addAttribute("pais", pais);
        return "ej05/medallas";
    }
    
    @GetMapping("/consultaMedalla/{pais}")
    public String medallasPais(Model m, @PathVariable("pais") String pais){
        m.addAttribute("deportes", service.obtenerDeportesConMedalla(pais));
        m.addAttribute("pais", pais);
        return "ej05/medallas";
    }
}
