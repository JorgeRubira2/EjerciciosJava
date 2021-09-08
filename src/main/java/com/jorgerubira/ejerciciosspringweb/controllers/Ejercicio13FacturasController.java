package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;

import lombok.Setter;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13FacturasController {

    @Setter 
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private FacturaRepository facturasRepo;
}
