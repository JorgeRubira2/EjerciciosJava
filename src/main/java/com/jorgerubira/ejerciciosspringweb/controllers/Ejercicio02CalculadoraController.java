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
@RequestMapping("/ej02")
public class Ejercicio02CalculadoraController {

    @Autowired
    private IEjercicio02CalculadoraService service;

    @GetMapping("/calculadora")
    public String verCalculadora(){
        return "ej02/calculadora2";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2){
        if(valor1==null){
            valor1=0;
        }
        if(valor2==null){
            valor2=0;
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        model.addAttribute("resultado", service.sumar(valor1, valor2));

        return "ej02/calculadora2";
    }

    @PostMapping("/restar")
    public String restar(Model model, Integer valor1, Integer valor2){
        if(valor1==null){
            valor1=0;
        }
        if(valor2==null){
            valor2=0;
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        model.addAttribute("resultado", service.restar(valor1, valor2));

        return "ej02/calculadora2";
    }

    @PostMapping("/multiplicar")
    public String multiplicar(Model model, Integer valor1, Integer valor2){
        if(valor1==null){
            valor1=0;
        }
        if(valor2==null){
            valor2=0;
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        model.addAttribute("resultado", service.multiplicar(valor1, valor2));

        return "ej02/calculadora2";
    }

    @PostMapping("/dividir")
    public String dividir(Model model, Integer valor1, Integer valor2){
        if(valor1==null){
            valor1=0;
        }
        if(valor2==null){
            valor2=0;
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        model.addAttribute("resultado", service.dividir(valor1, valor2));

        return "ej02/calculadora2";
    }

}
