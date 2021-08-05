package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio2")
public class Ejercicio02CalculadoraController {
    
    @Autowired
    private IEjercicio02CalculadoraService servicio;
    
    @GetMapping("/calculadora")
    public String calculadora(){
        return "/ej02/calculadora";
    }
}
