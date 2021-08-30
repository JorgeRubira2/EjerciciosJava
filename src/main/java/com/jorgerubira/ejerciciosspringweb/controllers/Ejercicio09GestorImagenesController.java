/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Categoria;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio09GestorImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio09")
public class Ejercicio09GestorImagenesController {

    @Autowired
    private Ejercicio09GestorImagenesService serviceImagen;

    @GetMapping("/altaImagen")
    public String altaImagen(Model model, Categoria categoria, Imagen imagen) {
        model.addAttribute("categorias", serviceImagen.obtenerCategorias());
        return "ej09/formAltaImagen";
    }

    @GetMapping("/altaCategoria")
    public String altaCategoria(Categoria cat) {
        serviceImagen.altaCategoria(cat);
        return "redirect:categorias";
    }

    @PostMapping("/imagenes")
    public String filtrarImagenes(Model model, Imagen img) {
        if(img.getId() == null || img.getId() == 0) {
             img = new Imagen();
        }
        model.addAttribute("imagen", img);
        model.addAttribute("categorias", serviceImagen.obtenerCategorias());
        model.addAttribute("ListaImagenes", serviceImagen.filtrarImagenes(img));
        return "ej09/imagenes";
    }
}
