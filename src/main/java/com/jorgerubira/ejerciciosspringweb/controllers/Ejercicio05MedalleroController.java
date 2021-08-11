/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Medalla;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio05")
public class Ejercicio05MedalleroController {
    @Autowired
    private IEjercicio05MedalleroService service;
    
    @GetMapping("/inicial")
    public String inicio(Model model){
        model.addAttribute("paises",service.obtenerRankingPorPais());
        model.addAttribute("atletas",service.obtenerRankingPorAlteta());
        return "/ej05/inicio";    
    }
    @GetMapping("/tabla")
    public String medalla(Model model, String pais){
        List<Medalla> aux= service.getMedallas().parallelStream()
                                    .filter(x->x.getPais().equals(pais))
                                    .sorted((x,y)->x.getDeportistas().compareTo(y.getDeportistas()))
                                    .collect(Collectors.toList());
        model.addAttribute("medallas",aux);
        return "/ej05/tabla";
    }
    @GetMapping("/tablaDeporte")
    public String deporte(Model model, String pais,String medalla){
        List<String> aux=new ArrayList<>();
        if(!medalla.equals("todas")){
            aux=service.obtenerDeportesDeUnaMedalla(pais, medalla);
        }
        else{
            aux=service.obtenerDeportesConMedalla(pais);
        }
        model.addAttribute("pais",pais);
        model.addAttribute("medallas",aux);
        return "/ej05/tablaDeporte";
    } 
    
}
