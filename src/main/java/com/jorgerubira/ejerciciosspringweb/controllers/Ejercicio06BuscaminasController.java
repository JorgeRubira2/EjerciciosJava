/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio06BuscaminasService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio06")
public class Ejercicio06BuscaminasController {
    @Autowired
    private IEjercicio06BuscaminasService serviceBuscaminas;
    
   
    @GetMapping("/buscaminas")
    public String iniciarBuscaminas (Model model){
        serviceBuscaminas.empezarPartida();
        model.addAttribute("tablero", serviceBuscaminas.getTablero());
        model.addAttribute("estado", serviceBuscaminas.getEstado());
        model.addAttribute("minasFaltantes", 90 - serviceBuscaminas.getCasillasDescubiertas());
        System.out.println(serviceBuscaminas.getTablero());
        return "ej06/buscaminas";
    }
    
    
    @GetMapping("/pulsarCasilla/{casilla}")
    public String pulsarCasilla (Model model, @PathVariable("casilla") Long casilla){

        serviceBuscaminas.pulsarCasilla(casilla);
        model.addAttribute("tablero", serviceBuscaminas.getTablero());
        model.addAttribute("estado", serviceBuscaminas.getEstado());
        model.addAttribute("minasFaltantes", 90 - serviceBuscaminas.getCasillasDescubiertas());

        return "ej06/buscaminas";
    }
}
