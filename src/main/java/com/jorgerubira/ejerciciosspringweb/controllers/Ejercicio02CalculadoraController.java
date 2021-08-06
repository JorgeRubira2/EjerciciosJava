package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;

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
	private IEjercicio02CalculadoraService service;
	
	@GetMapping("/calculadora")
	public String calculadora(Model model) {
		model.addAttribute("resultado", 0);
        model.addAttribute("valor1", 0);
        model.addAttribute("valor2", 0);
        return "ej02/calculadora";
	}
	@PostMapping("/sumar")
	public String sumar(Model model,Integer valor1, Integer valor2,String op) {
		model.addAttribute("valor1", valor1);
		model.addAttribute("valor2", valor2);
		model.addAttribute("resultado", service.sumar(valor1, valor2));
        return "ej02/calculadora";
	}
	@PostMapping("/restar")
	public String restar(Model model,Integer valor1, Integer valor2,String op) {
		model.addAttribute("valor1", valor1);
		model.addAttribute("valor2", valor2);
		model.addAttribute("resultado", service.restar(valor1, valor2));
        return "ej02/calculadora";
	}
	@PostMapping("/multiplicar")
	public String multiplicar(Model model,Integer valor1, Integer valor2,String op) {
		model.addAttribute("valor1", valor1);
		model.addAttribute("valor2", valor2);
		model.addAttribute("resultado", service.multiplicar(valor1, valor2));
        return "ej02/calculadora";
	}
	@PostMapping("/dividir")
	public String dividir(Model model,Integer valor1, Integer valor2,String op) {
		if (valor2!=0 && valor1>=0)
		model.addAttribute("valor1", valor1);
		model.addAttribute("valor2", valor2);
		model.addAttribute("resultado", service.dividir(valor1, valor2));
        return "ej02/calculadora";
	}
    
}
