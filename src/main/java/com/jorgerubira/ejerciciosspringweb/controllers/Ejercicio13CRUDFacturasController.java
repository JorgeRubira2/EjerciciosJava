/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13DetallesFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13FacturaRepository;
import java.util.stream.Collectors;
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
    
    @GetMapping("/facturas")
    public String verFacturas(Model model){
        model.addAttribute("facturas", repFact.findAll());
        return "ej13/listado";
    }
    
    @GetMapping("/detalles")
    public String verDetallesFacturas(Model model, int factura){
        //DetallesFactura detalle = new DetallesFactura();
        //detalle.setFactura(repFact.findById(factura).get());
        Factura detFact = repFact.findById(factura).get();
        model.addAttribute("factura", detFact);
        model.addAttribute("importeTotal", detFact.getDetallesFactura().stream().collect(Collectors.summingDouble((value) -> {
            return value.getImporte(); //To change body of generated lambdas, choose Tools | Templates.
        })));
        //model.addAttribute("detalleFactura", repDetFact.findById(factura));
        return "ej13/detalleFactura";
    }
    
}
