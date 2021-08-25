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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        if (categoria == null && descripcion == null) {
            if (filtro == null || filtro.equals("asc")) {
                aux = imagenService.findAllByOrderByFechaHoraFichero();
            } else {
                aux = imagenService.findAllByOrderByFechaHoraFicheroDesc();
            }
        } else if (descripcion != null && categoria == null) {
            if (filtro == null || filtro.equals("asc")) {
                aux=imagenService.findByDescripcionContainingOrderByFechaHoraFichero(descripcion);
            } else {
                aux = imagenService.findByDescripcionContainingOrderByFechaHoraFicheroDesc(descripcion);
            }
           
        } else if (descripcion == null && categoria != null) {
            if (filtro == null || filtro.equals("asc")) {
                aux=imagenService.findByCategoriaOrderByFechaHoraFichero(categoria);
            } else {
                aux = imagenService.findByCategoriaOrderByFechaHoraFicheroDesc(categoria);
            }
        } else {
            if (filtro == null || filtro.equals("asc")) {
                aux=imagenService.findByCategoriaAndDescripcionContainingOrderByFechaHoraFichero(categoria, descripcion);
            } else {
                aux = imagenService.findByCategoriaAndDescripcionContainingOrderByFechaHoraFicheroDesc(categoria, descripcion);
            }
        } 
        m.addAttribute("imagen", aux);
        m.addAttribute("categoria", categoriaService.findAll());
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
    @PostMapping
    public String filtrar (Model m, Imagen i){
        List<Imagen> aux=imagenService.findAll();
        if(i.getCategoria()!=null){
            aux=aux.parallelStream().filter(x->x.getCategoria().equalsIgnoreCase(i.getCategoria())).collect(Collectors.toList());  
        }
        if(i.getTipoImagen()!=null){
            aux=aux.parallelStream().filter(x->x.getTipoImagen().equalsIgnoreCase(i.getTipoImagen())).collect(Collectors.toList());  
        }
        if(i.getOrientacion()!=null){
            aux=aux.parallelStream().filter(x->x.getOrientacion().equalsIgnoreCase(i.getOrientacion())).collect(Collectors.toList());  
        }
        if(i.getContenido()!=null){
            aux=aux.parallelStream().filter(x->x.getContenido().equalsIgnoreCase(i.getContenido())).collect(Collectors.toList());  
        }
        if(i.getUso()!=null){
            aux=aux.parallelStream().filter(x->x.getUso().equalsIgnoreCase(i.getUso())).collect(Collectors.toList());  
        }
        m.addAttribute("imagen", aux);
        m.addAttribute("categoria", categoriaService.findAll());
        m.addAttribute("cate", new Categoria());
        m.addAttribute("img", new Imagen());
        return "/ej09/inicio";
    }

}
