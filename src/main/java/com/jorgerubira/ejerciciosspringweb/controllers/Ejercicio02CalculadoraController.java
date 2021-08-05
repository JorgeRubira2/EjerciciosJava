package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Crear una calculadora web que ejecute el servicio con la interface 
 * IEjercicio02CalculadoraService encargada de 
 * sumar, restar, multiplicar y dividir dos números.
 * El resultado se mostrará en la parte inferior.
 */
@Controller
@RequestMapping("ejercicio02")
public class Ejercicio02CalculadoraController {
    @Autowired
    private IEjercicio02CalculadoraService serviceCalculadora;
    
    @GetMapping("/calculadora")
    public String capuraNumeros(Model model){
        return "ej02/calculadora";
    }

    @PostMapping("/calcular")
    public String tratar (Model model,@RequestParam("accion") String accion,@RequestParam("A") Integer A, @RequestParam("B") Integer B){
        Integer resultado = 0;
        // pendiente : casteo de elementos de entrada a String y de estos verificar que es entero
        if (accion.equals("Sumar")) {
           resultado = serviceCalculadora.sumar(A, B);
        }
        if (accion.equals("Restar")) {
           resultado = serviceCalculadora.restar(A, B);
        }
        if (accion.equals("Multiplicar")) {
            resultado = serviceCalculadora.multiplicar(A, B);
        }
        if (accion.equals("Dividir")) {
            resultado = serviceCalculadora.dividir(A, B);
        }
        model.addAttribute("A", A);
        model.addAttribute("B", B);
        model.addAttribute("resultado",resultado);
        return "ej02/calculadora";
    }
    
}
