package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private IEjercicio02CalculadoraService calculadora;
    
    @GetMapping("/calculadora")
    public String calculadora(Model model){
        return ("ej02/calculadora");
    }
    
    @RequestMapping(value="/resultado", method=RequestMethod.POST, params="operacion=sumar")
    public String suma(Model model,
            @RequestParam("valor1") Integer a,
            @RequestParam("valor2") Integer b){   
        model.addAttribute("resultado", calculadora.sumar(a, b));
        
        return ("ej02/calculadora");
    }
    @RequestMapping(value="/resultado", method=RequestMethod.POST, params="operacion=restar")
    public String resta(Model model,
            @RequestParam("valor1") Integer a,
            @RequestParam("valor2") Integer b){   
        model.addAttribute("resultado", calculadora.restar(a, b));
        
        return ("ej02/calculadora");
    }
    @RequestMapping(value="/resultado", method=RequestMethod.POST, params="operacion=multiplicar")
    public String multiplicacion(Model model,
            @RequestParam("valor1") Integer a,
            @RequestParam("valor2") Integer b){   
        model.addAttribute("resultado", calculadora.multiplicar(a, b));
        
        return ("ej02/calculadora");
    }
    @RequestMapping(value="/resultado", method=RequestMethod.POST, params="operacion=dividir")
    public String division(Model model,
            @RequestParam("valor1") Integer a,
            @RequestParam("valor2") Integer b){   
        model.addAttribute("resultado", calculadora.dividir(a, b));
        
        return ("ej02/calculadora");
    }
    
}
