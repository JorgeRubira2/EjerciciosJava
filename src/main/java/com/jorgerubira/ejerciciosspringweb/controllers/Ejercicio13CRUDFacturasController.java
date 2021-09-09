/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.DetallesFactura;
import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13DetallesFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13FacturaRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/altaFactura")
    public String altaFactura(Model m){
        m.addAttribute("factura", new Factura());
        return "ej13/detalleFactura";
    }
    
    @GetMapping("/borrarFactura")
    public String borrarFactura(Model m, int id){
        repFact.deleteById(id);
        return "redirect:facturas";
    }
    
    @PostMapping("/guardarFactura")
    public String guardarFacatura(Model m, Factura fact){
        repFact.save(fact);
        //m.addAttribute("personas", repoPer.findAll());
        return "redirect:facturas";
    }  
    
    
    
    @GetMapping("/detalles")
    public String verDetallesFacturas(Model model, int factura, Integer idDetalle){
        DetallesFactura detalle = new DetallesFactura();
        detalle.setFactura(repFact.findById(factura).get()); 
        
        
        Optional<Factura> detFact = repFact.findById(factura);
        if (idDetalle!=null){
            model.addAttribute("detalle", detFact.get().getDetallesFactura().stream().filter(x->x.getId().equals(idDetalle)).findFirst().get() );
        }else{
            model.addAttribute("detalle", detalle);
        }

        if(detFact.isPresent()){
            model.addAttribute("factura", detFact.get());
        }
        //model.addAttribute("factura", detFact);
        model.addAttribute("importeTotal", detFact.get().getDetallesFactura().stream().collect(Collectors.summingDouble((value) -> {
            return value.getImporte(); //To change body of generated lambdas, choose Tools | Templates.
        })));
        //model.addAttribute("detalleFactura", repDetFact.findById(factura));
        return "ej13/detalleFactura";
    }
    
    
    @PostMapping("/nuevosDetalles")
    public String nuevosDetalles(Model m,DetallesFactura detFact, int idFactura){
        /*DetallesFactura fact=new DetallesFactura();
        fact.setFactura(repFact.findById(idFactura).get());
        m.addAttribute("detalles", fact);
        return "ej13/detalleFactura";*/
        detFact.setFactura(repFact.findById(idFactura).get());
        repDetFact.save(detFact);

        return "redirect:detalles?factura=" + idFactura;
    } 
    
    
    @GetMapping("/borrarDetalleFactura")
    public String borrarDetalleFactura(Model m, int idDetalle, int idFactura){
        repDetFact.deleteById(idDetalle);
        return "redirect:detalles?factura=" + idFactura;
    }
    
    
}
