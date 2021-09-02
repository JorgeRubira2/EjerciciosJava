/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaEncabezadoRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaLineaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ej13")
public class Ejercicio13CRUDFacturas {
    
    @Autowired
    private FacturaEncabezadoRepository encaService;
    @Autowired
    private FacturaLineaRepository listaService;
    
    
    @GetMapping
    public String inicio(Model m, Integer id_encabezado){
        if(id_encabezado==null){
            m.addAttribute("encabezado", new FacturaEncabezado());
        }else{
            m.addAttribute("encabezado", encaService.findById(id_encabezado).get());
        }
        
        
        return "/ej13/inicio";
    }
    
    @PostMapping("/guardarCabe")
    public String guardarCabecera(@DateTimeFormat(pattern="yyyy-MM-dd")Date fechaFactura, FacturaEncabezado encabezado){
        encabezado.setFecha(fechaFactura);
        encaService.save(encabezado);
        return "redirect:/ej13?id_encabezado="+encabezado.getId();
    }
}
