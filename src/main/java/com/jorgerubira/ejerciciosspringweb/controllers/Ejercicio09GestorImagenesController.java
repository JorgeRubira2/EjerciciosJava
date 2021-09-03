/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.CategoriaEntity;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio09GestorImagenesService;
import java.nio.charset.CodingErrorAction;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio09")
public class Ejercicio09GestorImagenesController {

    @Autowired
    private Ejercicio09GestorImagenesService serviceImagen;

    private List<String> tipoImagen = List.of("Foco", "Vector", "Ilustracion");
    private List<String> orientacion = List.of("Horizontal", "Vertical");
    private List<String> contenido = List.of("Con Personas", "Sin Personas");
    private List<String> uso = List.of("Comercial", "No Comercial");

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm");
//        System.out.println("date  :" + dateFormat.toString());
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

    @PostMapping("/altaImagen")
    public String altaImagen(Model model, CategoriaEntity categoria, Imagen imagen) {
        model.addAttribute("categorias", serviceImagen.obtenerCategorias());
        serviceImagen.altaImagen(imagen);
        return "redirect:/ejercicio09/imagenes";
    }

    @PostMapping("/altaCategoria")
    public String altaCategoria(CategoriaEntity cat) {
        System.out.println("categoria: " + cat.getCategoria() + "  id :" + cat.getId());
        serviceImagen.altaCategoria(cat);
        return "redirect:/ejercicio09/imagenes";
    }

    @RequestMapping(value = "/imagenes", method = {RequestMethod.GET,RequestMethod.POST})
    public String imagenesInsert(Model model, Imagen img, CategoriaEntity cat) {
        System.out.println("imagen " + img);
        if (img.getId() == null) {
            img = new Imagen();
        } else {
        }
        if (cat.getId() == null) {
            cat = new CategoriaEntity();
        }

        model.addAttribute("listaTipoImagen", tipoImagen);
        model.addAttribute("listaOrientacion", orientacion);
        model.addAttribute("listaContenido", contenido);
        model.addAttribute("listaUso", uso);
        model.addAttribute("imagen", img);
        model.addAttribute("categoria", cat);
        model.addAttribute("listaCategorias", serviceImagen.obtenerCategorias());
        model.addAttribute("listaImagenes", serviceImagen.filtrarImagenes(img));
        return "ej09/imagenes";
    }
}
