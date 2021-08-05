package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Crear una calculadora web que ejecute el servicio con la interface
 * IEjercicio02CalculadoraService encargada de sumar, restar, multiplicar y
 * dividir dos números. El resultado se mostrará en la parte inferior.
 */
@Controller
@RequestMapping("/ejercicio2")
public class Ejercicio02CalculadoraController {

    @Autowired
    private IEjercicio02CalculadoraService service;

    @GetMapping("/calculadora")
    public String calc(Model model) {
        model.addAttribute("resultado", 0);
        model.addAttribute("valor1", 0);
        model.addAttribute("valor2", 0);
        return "ej02/calculadoraV2";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", service.sumar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadoraV2";
    }

    @PostMapping("/restar")
    public String resta(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", service.restar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadoraV2";
    }

    @PostMapping("/producto")
    public String producto(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", service.multiplicar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadoraV2";
    }

    @PostMapping("/division")
    public String division(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", service.dividir(valor1, valor2));
        if (service.dividir(valor2, valor2) == null) {
            model.addAttribute("error", "No se puede dividir por cero");
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadoraV2";
    }
}
