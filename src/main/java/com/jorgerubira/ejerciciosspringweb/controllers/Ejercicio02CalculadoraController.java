package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.services.Ejercicio02CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Crear una calculadora web que ejecute el servicio con la interface 
 * IEjercicio02CalculadoraService encargada de 
 * sumar, restar, multiplicar y dividir dos números.
 * El resultado se mostrará en la parte inferior.
 */
@RequestMapping("/ejercicio2")
@Controller
public class Ejercicio02CalculadoraController {
    @Autowired
    
private Ejercicio02CalculadoraService miCalculadora;
    Integer resultado;
 @GetMapping("/calculadora")
 public String Resultado(Model model){
     model.addAttribute("Resultado",0);
     return "ej02/calculadora";
 }
 @PostMapping("/calculadora")
 public String sumar(Model model,Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
      resultado=miCalculadora.sumar(a, b);
     model.addAttribute("resultado",resultado);
      return "ej02/calculadora";
 }
 
 @PostMapping("/calculadora")
 public String restar(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
     resultado=miCalculadora.restar(a, b);
     model.addAttribute("resultado",resultado);
      return "ej02/calculadora";
 }
 
  @PostMapping("/calculadora")
 public String multiplicar(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
    resultado=miCalculadora.restar(a, b);
     model.addAttribute("resultado",resultado);
      return "ej02/calculadora";
 }
 
  @PostMapping("/calculadora")
 public String dividir(Model model, Integer a, Integer b){
     model.addAttribute("termino1",a);
     model.addAttribute("termino2",b);
         
       if(b!=0){
           resultado = a/b;
       } else{
         resultado=null;  
       }    
       model.addAttribute("resultado",resultado);
       return "ej02/calculadora";
 }
 
}
