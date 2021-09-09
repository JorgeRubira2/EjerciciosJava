/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.LineasFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


 @Controller
@RequestMapping("/factura")
public class Ejercicio13FacturaController {
     @Autowired
     private FacturasRepository repoFactura;
     @Autowired
     private LineasFacturasRepository repoLineas;
     
     @GetMapping
    
     public String verFactura(Model m){
         m.addAttribute("facturas",repoFactura.findAll());
        
       
         
      
         return "ej13/factura";
     }
     
     
     
    
}
