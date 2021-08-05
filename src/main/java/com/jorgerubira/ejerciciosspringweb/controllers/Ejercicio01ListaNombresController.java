package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que
 * permite almacenar y borrar nombres de personas. Se pide exponerlo en una web
 * de manera que podremos ver las personas que están en la lista y añadir o
 * quitar nombres. Los nombres no se deben repetir, el servicio lanza una
 * excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio01")
public class Ejercicio01ListaNombresController {

    @Autowired
    private IEjercicio01ListaNombresService service;

    @PostMapping("/altanombre") //URL A LLAMAR
    public String altaNombre(Model model, String nombre) {

        try {
            model.addAttribute("nombre", nombre);
            service.altaNombre(nombre);

        } catch (OperacionEnListaException ex) {
            model.addAttribute("error", "Ha ocurrido un error al insertar, o el nombre esta repetido.");
        }

        model.addAttribute("listaPersonas", service.getLista());

        return "ej01/listaPersonas";
    }

    @PostMapping("/borrarnombre") //URL A LLAMAR
    public String borrarNombre(Model model, String nombre) {
        model.addAttribute("nombre", nombre);
        service.bajaNombre(nombre);
        model.addAttribute("listaPersonas", service.getLista());

        return "ej01/listaPersonas";
    }

    @GetMapping("/altanombre") //URL A LLAMAR
    public String altaNombre2(Model model) {

        model.addAttribute("listaPersonas", service.getLista());

        return "ej01/listaPersonas";
    }

}
