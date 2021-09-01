package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenes {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private ImagenesRepository repositorio;

    @GetMapping("/formulario")
    public String verFormulario(Model m){
        m.addAttribute("imagen", new Imagen());
        return "/ej11/formulario";
    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, Imagen imagen){
        imagen.setNombre(fichero.getName());
        imagen.setCodigo(UUID.randomUUID().toString());
        String ruta = rutaRecursos + "\\ej11\\" + imagen.getCodigo() + imagen.getNombre();
        imagen.setRuta(ruta);
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            repositorio.save(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:imagenes";
    }

    @GetMapping("/imagenes")
    public String verImagenes(Model m){
        m.addAttribute("imagenes", repositorio.findAll());
        return "/ej11/ver";
    }


}
