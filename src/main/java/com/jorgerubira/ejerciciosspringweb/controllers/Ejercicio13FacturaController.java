/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Facturas;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.LineasFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


 @Controller
@RequestMapping("/factura")
public class Ejercicio13FacturaController {
     @Autowired
     private FacturasRepository repoFactura;
     @Autowired
     private LineasFacturasRepository repoLineas;
     
    
     
     @GetMapping
    
     public String verFactura(Model m, Integer id){
         m.addAttribute("facturas",repoFactura.findById(id).get());
        
         return "ej13/verFactura";
     }
     
     
      @PostMapping("/buscar")
    
     public String verUnaFactura(Model m, Integer id){
         m.addAttribute("facturas",repoFactura.findById(id).get());
        
        return "ej13/verFactura";
     }
     
     
     @PostMapping("/guardar")
    
     public String guardar(Model m, Facturas factura){
         
         repoFactura.save(factura);
        
        return "ej13/verFactura";
     }
     
     
    
     
     
     
    
}
