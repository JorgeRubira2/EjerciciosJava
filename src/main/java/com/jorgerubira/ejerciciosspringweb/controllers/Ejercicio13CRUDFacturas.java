
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaDetalle;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaDetalleRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio13DetalleService;
import com.jorgerubira.explicaciones.D20210903.crud.entities.TelefonoDia3;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13CRUDFacturas {
    
    @Autowired
    FacturaRepository factRepo;
    
    @Autowired
    FacturaDetalleRepository detalleRepo;
    
    @Autowired
    Ejercicio13DetalleService detalleService;
    
    @GetMapping("/vista")
    public String vista(Model m){
        m.addAttribute("facturas",factRepo.findAll());
        return "/ej13/vista"; 
    }
    
    @GetMapping("/add")
    public String add(Model m){
        m.addAttribute("factura",new Factura());
        return "/ej13/factura"; 
    }
    
    @GetMapping("/nuevoDetalle")
    public String altaTelefono(Model m, int idFactura){
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setFactura(factRepo.findById(idFactura).get());
        m.addAttribute("detalles", facturaDetalle); 
        return "/ej13/modificarDetalles";
    } 
    
    @PostMapping("/guardarFactura")
    public String guardarFactura(Model m, Factura factura){
        factRepo.save(factura);
        return "redirect:vista";
    }
    
    @PostMapping("/guardarDetalle")
    public String guardarDetalle(Model m, FacturaDetalle factDetal , int id){
        factDetal.setFactura(factRepo.findById(id).get());
        detalleRepo.save(factDetal);
        
        //detalleService.calcularTotal(factDetal);
        //m.addAttribute("persona", new FacturaDetalle());
        return "redirect:modificarFactura?id="+id;
    }
    
    @GetMapping("/modificarFactura")
    public String modificarFactura(Model m, int id){
        Optional<Factura> factura = factRepo.findById(id);
        if(factura.isPresent()){
            m.addAttribute("factura", factura.get());
        }
        return "/ej13/factura";
    }
    
    @GetMapping("/modificarDetalles")
    public String modificarDetalles(Model m, int id){
        Optional<FacturaDetalle> detalles = detalleRepo.findById(id);
        if(detalles.isPresent()){
            m.addAttribute("detalles", detalles.get());
        }
        //m.addAttribute("detalles", detalleRepo.findById(id).get());
        return "/ej13/modificarDetalles";
    }
    
}
