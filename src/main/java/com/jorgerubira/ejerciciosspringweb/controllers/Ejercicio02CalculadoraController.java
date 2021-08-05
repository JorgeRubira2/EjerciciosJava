package com.jorgerubira.ejerciciosspringweb.controllers;


import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ejercicio02")
public class Ejercicio02CalculadoraController {
    @Autowired
    private IEjercicio02CalculadoraService service;
    
    @GetMapping("/calculadora")
    public String inicio(){
        return "ej02/calculadora";
    }
    @PostMapping("/calculadora")
    public String calculadora(Model model, String operacion, Integer valor1, Integer valor2){
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        if(operacion.equalsIgnoreCase("Sumar")){
            model.addAttribute("valor1", valor1);
            model.addAttribute("valor2", valor2);
            model.addAttribute("resultado",service.sumar(valor1, valor2));
        }
        else if(operacion.equalsIgnoreCase("Restar")){
            model.addAttribute("valor1", valor1);
            model.addAttribute("valor2", valor2);
            model.addAttribute("resultado",service.restar(valor1, valor2));
        }
        else if(operacion.equalsIgnoreCase("multiplicar")){
            model.addAttribute("valor1", valor1);
            model.addAttribute("valor2", valor2);
            model.addAttribute("resultado",service.multiplicar(valor1, valor2));
        }
        else if(operacion.equalsIgnoreCase("dividir")){           
            if(valor2==0){
                valor2=1;
            }
            model.addAttribute("valor1", valor1);
            model.addAttribute("valor2", valor2);
            model.addAttribute("resultado",service.dividir(valor1, valor2));
        }
        
        
        return "ej02/calculadora";
    }
    
    
}
