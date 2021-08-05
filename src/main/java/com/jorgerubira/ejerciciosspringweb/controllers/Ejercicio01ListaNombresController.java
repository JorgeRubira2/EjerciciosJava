package com.jorgerubira.ejerciciosspringweb.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que
 * permite almacenar y borrar nombres de personas. Se pide exponerlo en una web
 * de manera que podremos ver las personas que están en la lista y añadir o
 * quitar nombres. Los nombres no se deben repetir, el servicio lanza una
 * excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio1")
public class Ejercicio01ListaNombresController {

    @Autowired
    private IEjercicio01ListaNombresService lista;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("lista", lista.getLista());
        return "ej01/listaPersonas";
    }

    @PostMapping("/enviar")
    public String enviarNombre(Model model, String nombre,
            @RequestParam(value = "Add", required = false) String add,
            @RequestParam(value = "Borrar", required = false) String borrar) {

        try {

            if (add != null && add.equals("Añadir")) {
                lista.altaNombre(nombre);
            } else if (borrar != null && borrar.equals("Borrar")) {
                lista.bajaNombre(nombre);
            }

            model.addAttribute("nombre", nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(Ejercicio01ListaNombresController.class.getName()).log(Level.SEVERE, null, ex);
        }

        model.addAttribute("lista", lista.getLista());

        return "ej01/listaPersonas";

    }

}
