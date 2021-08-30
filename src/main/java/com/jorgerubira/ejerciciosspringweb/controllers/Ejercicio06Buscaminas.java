
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio06BuscaminasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bm")
public class Ejercicio06Buscaminas {
    
    @Autowired
    private IEjercicio06BuscaminasService service;
    
    @GetMapping
    public String inicio(Model m, Long id){
        if(id!=null){
            service.pulsarCasilla(id);
        }
        m.addAttribute("estado", service.getEstado());
        m.addAttribute("casillas", service.getCasillasDescubiertas());
        m.addAttribute("tablero", service.getTablero());
        return "/ej06/inicio";
    }
    
    @GetMapping("/reiniciar")
    public String reiniciar(Model m){
        service.empezarPartida();
        return "redirect:/bm";
    }
    
    
    
}
