/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Categoria;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.CategoriaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ejercicio9")
public class Ejercicio09GestorImagenes {

    @Autowired
    private ImagenRepository imagenService;

    @Autowired
    private CategoriaRepository categoriaService;

    @GetMapping
    public String inicio(Model m, String categoria, String descripcion, String filtro) {
        List<Imagen> aux = new ArrayList<>();
        m.addAttribute("categoria", categoriaService.findAll());
        if (categoria == null && descripcion == null) {
            if (filtro == null || filtro.equals("asc")) {
                aux = imagenService.findAllByOrderByFechaHoraFichero();
            } else {
                aux = imagenService.findAllByOrderByFechaHoraFicheroDesc();
            }
        } else if (descripcion != null && categoria == null) {
           aux=imagenService.findByDescripcionContaining(descripcion);
        } else if (descripcion == null && categoria != null) {
            aux= imagenService.findByCategoria(categoria);
        } else {
           aux=imagenService.findByCategoriaAndDescripcionContaining(categoria, descripcion);
        }
        m.addAttribute("imagen", aux);
        m.addAttribute("cate", new Categoria());
        m.addAttribute("img", new Imagen());
        return "/ej09/inicio";
    }

    @PostMapping("/etiqueta")
    public String guardarEtiqueta(Categoria c) {
        categoriaService.save(c);
        return "redirect:/ejercicio9";
    }

    @PostMapping("/img")
    public String guardarEtiqueta(Imagen i) {
        Date date = Date.from(Instant.now());
        i.setFechaHoraFichero(date);
        imagenService.save(i);
        return "redirect:/ejercicio9";
    }

}
