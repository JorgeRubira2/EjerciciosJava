
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import java.util.Date;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13CrudFacturasController {
    @Setter   
    @Autowired
    private FacturasRepository repoFact;
    
    @Setter   
    @Autowired
    private DetalleFacturaRepository repoDet;
    
    @GetMapping
    public String inicio(Model m,String msg){
        if(msg!=null){
            if (msg.toLowerCase().contains("error")){
                m.addAttribute("error",msg);
            }else if (msg.toLowerCase().contains("exito")){
                m.addAttribute("success",msg);
            }
        }
        
        if(repoFact.findAll().isEmpty()){
            m.addAttribute("facturas",null);
        }else{
            m.addAttribute("facturas",repoFact.findAll());
        }
        
        return "/ej13/vista";
    }
    
    @GetMapping("/altaFactura")
    public String altaPersonas(Model m){
        Factura fact= new Factura();
        fact.setFecha(new Date());
        m.addAttribute("factura", fact);
        return "/ej13/altafactura";
    }    
    @PostMapping("/guardarFactura")
    public String guardarPersonas(Model m, Factura factura){
        repoFact.save(factura);
        return "redirect:/ejercicio13";
    }    
}
