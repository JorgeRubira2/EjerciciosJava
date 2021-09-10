package com.jorgerubira.ejerciciosspringweb.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13Factura {

	@GetMapping("/vista")
    public String vista(Model model, String mensaje){
		
			//
        return "/ej13/vista";
	}

@GetMapping("/nuevaFactura")
public String altaFacturas(Model model) {
    Factura fact = new Factura();
    fact.setFecha(new Date());
    model.addAttribute("factura", fact);
    return "/ej13/nuevafactura";
	}
}