package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Crear una calculadora web que ejecute el servicio con la interface 
 * IEjercicio02CalculadoraService encargada de 
 * sumar, restar, multiplicar y dividir dos números.
 * El resultado se mostrará en la parte inferior.
 */
@Controller
@RequestMapping("/ejercicio2")
public class Ejercicio02CalculadoraController {
    @Autowired
    private IEjercicio02CalculadoraService servicio;
    
    @PostMapping("/sumar")
    public String sumar(Model model, Integer v1, Integer v2){
        if(v1==null)
            v1= 0;
        if(v2==null)
            v2=0;
        model.addAttribute("resultado", servicio.sumar(v1, v2));
        model.addAttribute("v1", v1);
        model.addAttribute("v2", v2);
        return "ej02/calculadora";
    }
    
    @PostMapping("/restar")
    public String restar(Model model, Integer v1, Integer v2){
        if(v1==null)
            v1=0;
        if(v2==null)
            v2=0;
        model.addAttribute("resultado", servicio.restar(v1, v2));
        model.addAttribute("v1", v1);
        model.addAttribute("v2", v2);
        return "ej02/calculadora";
    }
    
    @PostMapping("/multiplicar")
    public String multiplicar(Model model, Integer v1, Integer v2){
        if(v1==null)
            v1=0;
        if(v2==null)
            v2=0;
        model.addAttribute("resultado", servicio.multiplicar(v1, v2));
        model.addAttribute("v1", v1);
        model.addAttribute("v2", v2);
        return "ej02/calculadora";
    }
    
    @PostMapping("/dividir")
    public String dividir(Model model, Integer v1, Integer v2){
        if(v1==null)
            v1=0;
        if(v2==null)
            v2=0;
        model.addAttribute("resultado", servicio.dividir(v1, v2));
        model.addAttribute("v1", v1);
        model.addAttribute("v2", v2);
        return "ej02/calculadora";
    }
    
    @GetMapping("/mostrar")
    public String mostrar(Model model){
        return "ej02/calculadora";
    }
}
