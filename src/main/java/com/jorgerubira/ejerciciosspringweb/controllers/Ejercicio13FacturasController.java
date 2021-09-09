package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLineas;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.LineasRepository;

import lombok.Setter;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13FacturasController {

    @Setter 
    @Autowired(required = false)
    private FacturaRepository facturasRepo;
    
    @Setter 
    @Autowired(required = false)
    private LineasRepository lineasRepo;
    
    @GetMapping
    public String lista(Model m) {
    	m.addAttribute("facturas", facturasRepo.findAll());
    	return "ej13/lista";
    }
    //formulario vacio
	@GetMapping("/factura")
	public String read(Model m){
		m.addAttribute("factura", new Factura());
		return "ej13/formFactura";
	}
	//formulario para editar
	@GetMapping("/factura/{id}")
	public String read(Model m, @PathVariable Long id){
		m.addAttribute("factura", facturasRepo.findById(id));
		return "ej13/formFactura";
	}
	//formulario para insertar linea
    @GetMapping("/linea")
    public String altaLinea(Model m, long idFactura){
        FacturaLineas linea=new FacturaLineas();
        linea.setFactura(facturasRepo.findById(idFactura).get());
        m.addAttribute("linea", linea);
        return "ej13/formLinea";
    }   
    //formulario para editar linea
    @GetMapping("/linea/{id}")
    public String editarLinea(Model m, int id){
        m.addAttribute("linea", lineasRepo.findById(id).get());
        return "ej13/formLinea";
    } 
    //guardar factura
    @PostMapping("/guardarFactura")
    public String guardarFactura(Model m, Factura factura){
        facturasRepo.save(factura);
        return "redirect:/ejercicio13";
    }    
    //guardar loinea
    @PostMapping("/guardarLinea")
    public String guardarTelefono(Model m, FacturaLineas linea, long idFactura){
        linea.setFactura(facturasRepo.findById(idFactura).get());
        lineasRepo.save(linea);
        return "redirect:factura?id=" + idFactura;
    }    
	//borrar factura
	@GetMapping("/deleteFactura/{id}")
	public String deleteFactura(Model m, @PathVariable Long id){
		facturasRepo.deleteById(id);
		return "redirect:/ejercicio13";
	}
	//borrar linea
	@GetMapping("/deleteLinea/{id}")
	public String deleteLinea(Model m, @PathVariable Integer id){
		FacturaLineas linea = lineasRepo.findById(id).get();
		Long idFactura = linea.getFactura().getId();
		return "redirect:factura?id=" + idFactura;
	}
}
