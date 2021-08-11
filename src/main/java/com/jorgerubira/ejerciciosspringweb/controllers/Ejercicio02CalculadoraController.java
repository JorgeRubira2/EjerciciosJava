package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.services.Ejercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Crear una calculadora web que ejecute el servicio con la interface 
 * IEjercicio02CalculadoraService encargada de 
 * sumar, restar, multiplicar y dividir dos números.
 * El resultado se mostrará en la parte inferior.
 */
public class Ejercicio02CalculadoraController {
    @Autowired
private Ejercicio02CalculadoraService miCalculadora;
 @GetMapping("Calculadora")
 public String Resultado(Model model){
     model.addAttribute("Resultado",0);
     return "Calculadora";
 }
 @PostMapping("/sumar")
 public String sumar(Model model,Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
     int resultado=miCalculadora.sumar(a, b);
     model.addAttribute("resultado",resultado);
     return "ej02/calculadora";
 }
 
 @PostMapping("/restar")
 public int restar(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
     int resultado=miCalculadora.restar(a, b);
     model.addAttribute("resultado",resultado);
     return resultado;
 }
 
  @PostMapping("/multiplicar")
 public int multiplicar(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
     int resultado=miCalculadora.restar(a, b);
     model.addAttribute("resultado",resultado);
     return resultado;
 }
 
  @PostMapping("/dividir")
 public int dividir(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
     Integer resultado;
       if(b!=0){
            resultado = a/b;
       } else{
         resultado=null;  
       }    
       model.addAttribute("resultado",resultado);
       return resultado;
 }
 
}
