package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Producto;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.repositories.ProductoCrudRepository;


@Controller
@RequestMapping("/ejercicio0")
public class Ejercicio00Muestra {
    
    @Autowired
    private IEjercicio02CalculadoraService calc;
    
    @Autowired
    private ProductoCrudRepository repoProductos;
    
    @GetMapping("/calculadora")
    public String calc(Model model){
        model.addAttribute("resultado", 0);
        model.addAttribute("valor1", 0);
        model.addAttribute("valor2", 0);
        return "ej00/calculadora";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2){
        if (valor1==null){
            valor1=0;
        }
        if (valor2==null){
            valor2=0;
        }
        model.addAttribute("resultado", calc.sumar(valor1, valor2));    
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej00/calculadora";
    }
    
    @GetMapping("/productos1")
    @ResponseBody   //Response body sirve para no devolver una vista. Devuelve un JSON
    public List<Producto> obtenerProductos(){
        List<Producto> resultado=new ArrayList<>();
        repoProductos.findAll().forEach(resultado::add);    //Convertir de iterable a List
        return resultado;
    } 
    
    @GetMapping("/productos2")
    @ResponseBody   //Response body sirve para no devolver una vista. Devuelve un JSON
    public Iterable<Producto> obtenerProductos2(){
        return repoProductos.findAll();    //Convertir de iterable a List
    }     

}
