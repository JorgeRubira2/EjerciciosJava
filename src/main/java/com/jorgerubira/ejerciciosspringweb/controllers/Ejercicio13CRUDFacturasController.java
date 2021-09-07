/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEntity;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLineaEntity;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio13CRUDFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13CRUDFacturasController {
    @Autowired 
    private Ejercicio13CRUDFacturasService serviceFacturas;
    
    
    @RequestMapping(value = "/consultaFacturas",method={RequestMethod.GET,RequestMethod.POST} )
    public String consultaFacturas(Model m){
        m.addAttribute("facturas", serviceFacturas.consultaFacturas());
    return "ej13/consultaFacturas";
    }
    
    
    
    @PostMapping(value = "/factura")
    public String verFactura (Model model,FacturaEntity factura){
        System.out.println("es nulo "+ (factura == null));
        System.out.println("factura " + factura);
        if (factura.getId() == null)
        {
            model.addAttribute("factura",new FacturaEntity());
        } else {
            model.addAttribute("factura",serviceFacturas.consultaFactura(factura));
        }
        return "ej13/facturas";
    }
    
    
    @PostMapping("/altaFacturaLinea")
    public String formularioAltaModifLinea(Model model, FacturaEntity factura, FacturaLineaEntity facturaLinea){
        System.out.println("factura linea " + facturaLinea );
        model.addAttribute("factura", factura);
        model.addAttribute("facturaLinea", facturaLinea);
        return "ej13/facturasLinea";
    }
    
    @PostMapping("/guardarLinea")
    public String guardaLinea(Model model, FacturaLineaEntity facturaLinea){
        serviceFacturas.altaFacturaLinea(facturaLinea);
        model.addAttribute("factura", serviceFacturas.consultaFactura(facturaLinea.getFacturasId()));
        return "ej13/facturas";
    }
    
    @PostMapping("/volverLinea")
    public String volverLinea(Model model, FacturaLineaEntity facturaLinea){
        model.addAttribute("factura", serviceFacturas.consultaFactura(facturaLinea.getFacturasId()));
        return "ej13/facturas";
    }
    
    @PostMapping("/altaFactura")
    public String altaFacturas(Model model, FacturaEntity factura){
        System.out.println("Alta");
        serviceFacturas.altaFactura(factura);
        model.addAttribute("factura",serviceFacturas.consultaFactura(factura.getId()));
        return "ej13/facturas";
    }
   
    @PostMapping("/bajaFactura")
    public String bajaFacturas(Model model, FacturaEntity factura){
        serviceFacturas.bajaFactura(factura.getId());
        model.addAttribute("factura",serviceFacturas.consultaFactura(factura.getId()));
        return "ej13/facturas";
            }
    @PostMapping("/modificaFactura")
    public String modificaFacturas(Model model, FacturaEntity factura){
        model.addAttribute("factura",factura);
        serviceFacturas.modificaFactura(factura);
        return "ej13/facturas";
    }
    
    @PostMapping("/bajaLinea")
    public String eliminaFacturaLinea(Model model, FacturaEntity factura, FacturaLineaEntity facturaLinea){
        serviceFacturas.bajaFacturaLinea(facturaLinea);
        model.addAttribute("factura", serviceFacturas.consultaFactura(facturaLinea.getFacturasId()) );
        return "ej13/facturas";
    }
    
    @PostMapping("/modificaLinea")
    public String modificaFacturaLinea(Model model, FacturaEntity factura, FacturaLineaEntity facturaLinea){
        model.addAttribute("facturaLinea", facturaLinea);
        model.addAttribute("factura", serviceFacturas.consultaFactura(facturaLinea.getFacturasId()) );
        return "ej13/facturasLinea";
    }
    
}
