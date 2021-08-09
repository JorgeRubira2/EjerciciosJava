package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio2")
public class Ejercicio02CalculadoraController {

    @Autowired
    private IEjercicio02CalculadoraService calc;

    @GetMapping("")
    public String calc(Model model) {
        model.addAttribute("resultado", 0);
        model.addAttribute("valor1", 0);
        model.addAttribute("valor2", 0);
        return "ej02/calculadora";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", calc.sumar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }

    @PostMapping("/restar")
    public String restar(Model model, Integer valor1, Integer valor2) {
        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }
        model.addAttribute("resultado", calc.restar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }

    @PostMapping("/multiplicar")
    public String multiplicar(Model model, Integer valor1, Integer valor2) {

        if (valor1 == null) {
            valor1 = 0;
        }
        if (valor2 == null) {
            valor2 = 0;
        }

        model.addAttribute("resultado", calc.multiplicar(valor1, valor2));
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }

    @PostMapping("/dividir")
    public String dividir(Model model, Integer valor1, Integer valor2) {
        try {
            if (valor1 == null) {
                valor1 = 0;
            }
            if (valor2 == null) {
                valor2 = 0;
            }
            model.addAttribute("resultado", calc.dividir(valor1, valor2));
        } catch (ArithmeticException ex) {
            model.addAttribute("error", "No se puede dividir entre 0");
            Logger.getLogger(Ejercicio02CalculadoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }
}
