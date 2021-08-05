
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
public class Ejercicio01ListaNombresController {

    @Autowired
    IEjercicio01ListaNombresService service;

    @GetMapping("/listaNombres")
    public String listaNombres(Model model){
        model.addAttribute("listaNombres", service.getLista());
        return "ej01/listaPersonas";
    }

    @PostMapping("/enviarNombre")
    public String enviarNombre(Model model, String nombre){
        try {
            service.altaNombre(nombre);
        } catch (OperacionEnListaException e) {
            e.printStackTrace();
        }
        model.addAttribute("nombre", nombre);
        model.addAttribute("listaNombres", service.getLista());

        return "ej01/listaPersonas";
    }

    @PostMapping("/borrarNombre")
    public String borrarNombre(Model model, String nombre){
        service.bajaNombre(nombre);
        model.addAttribute("nombre", nombre);
        model.addAttribute("listaNombres", service.getLista());

        return "ej01/listaPersonas";
    }
}
