package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ejercicio02CalculadoraController {

    @Autowired
    private IEjercicio02CalculadoraService calculadora;

    @GetMapping("/calculadora")
    public String verCalculadora() {
        return "ej02/calculadora";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2, String operacion) {

        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);

        model.addAttribute("resultado", calculadora.sumar(valor1, valor2));
        return "ej02/calculadora";
    }

    @PostMapping("/restar")

    public String restar(Model model, Integer valor1, Integer valor2, String operacion) {
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);

        model.addAttribute("resultado", calculadora.restar(valor1, valor2));

        return "ej02/calculadora";
    }

    @PostMapping("/multiplicar")
    public String multiplicar(Model model, Integer valor1, Integer valor2, String operacion) {
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);

        model.addAttribute("resultado", calculadora.multiplicar(valor1, valor2));
        return "ej02/calculadora";
    }

    @PostMapping("/dividir")
    public String dividir(Model model, Integer valor1, Integer valor2, String operacion) {

        if (valor2 != 0) {
            model.addAttribute("valor1", valor1);
            model.addAttribute("valor2", valor2);
            model.addAttribute("resultado", calculadora.dividir(valor1, valor2));

        } else {
            model.addAttribute("error", "ha ocurrido un error");

        }

        return "ej02/calculadora";
    }

}
