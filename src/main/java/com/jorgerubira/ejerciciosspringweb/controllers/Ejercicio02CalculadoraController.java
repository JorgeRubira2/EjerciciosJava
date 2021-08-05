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
    private IEjercicio02CalculadoraService calculadora;
    
    @GetMapping("/calculadora")
    public String calc(){   
        return "ej02/calculadora";
    }
    
    @PostMapping("/calculadora")
    public String calculo(Model m, Integer num1, Integer num2, String accion){
        Integer res = 0;
        if (num1!=null && num2!=null){
            m.addAttribute("num1",num1);
            m.addAttribute("num2",num2);
            switch(accion){
                case "sumar":
                    res = calculadora.sumar(num1, num2);
                    break;
                case "restar":
                    res = calculadora.restar(num1, num2);
                    break;
                case "mult":
                    res = calculadora.multiplicar(num1, num2);
                    break;
                case "div":
                    if (num1>0 && num2>0){
                        res = calculadora.dividir(num1, num2);
                    }else{
                        m.addAttribute("error",true);
                    }
                    break;
            }
            m.addAttribute("resultado",res);
        }
        return "ej02/calculadora";
    }
}
