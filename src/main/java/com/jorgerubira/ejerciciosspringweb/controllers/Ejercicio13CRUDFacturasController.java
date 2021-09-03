/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13DetallesFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Joche
 */
@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13CRUDFacturasController {
    
    @Autowired
    private IEjercicio13FacturaRepository repFact;
    
    @Autowired
    private IEjercicio13DetallesFacturaRepository repDetFact;
    
    @GetMapping("/verFacturas")
    public String verFacturas(Model model){
        model.addAttribute("facturas", repFact.findAll());
        return "ej13/listado";
    }
    
}
