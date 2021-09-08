
package com.jorgerubira.ejerciciosspringweb.controllers;


import com.jorgerubira.ejerciciosspringweb.repositories.PlazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universidad")

public class Ejercicio12CsvController {
    
    @Autowired(required = false)//Con required = false no es obligatorio que esté el repository 

    private PlazaRepository repoPlaza;

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping
    public String mostrarTodo(Model m) {

        return "ej12/formulario";

    }
    
    
}
