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

    @PostMapping("/calculadora")
      
    public String operaciones(Model model, Integer valor1, Integer valor2, String operacion) {
       
        return "ej02/calculadora";
    }
}
