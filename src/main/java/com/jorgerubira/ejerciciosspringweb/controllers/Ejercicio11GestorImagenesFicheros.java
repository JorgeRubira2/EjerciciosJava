/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.ImagenFichero;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenFicheroRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestorImagenesFicheros {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private ImagenFicheroRepository service;

    @GetMapping
    public String inicio(Model m, String descripcion) {
        if (descripcion == null) {
            m.addAttribute("imagen", service.findAll());
        } else {
            m.addAttribute("imagen", service.findByDescripcionContaining(descripcion));
        }

        return "/ej11/inicio";
    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile imag, String descripcion) { //, HttpServletResponse response){
        int aux = imag.getOriginalFilename().lastIndexOf(".");
        String extension = imag.getOriginalFilename().substring(aux);
        String nombre = UUID.randomUUID().toString() + extension;
        service.save(new ImagenFichero(null, nombre, imag.getOriginalFilename(), descripcion));

        String ruta = rutaRecursos + "\\ejercicio11\\" + nombre;

        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(imag.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "redirect:/ej11";
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }

        return "redirect:/ej11";
    }

    @GetMapping("/descarga")
    public ResponseEntity<Resource> mostrarFormulario(String imagen) {
        String ruta = rutaRecursos + "\\ejercicio11\\" + imagen;

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=imagen.jpg");
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        String contentType = "image/";
        if (ruta.endsWith(".jpg")) {
            contentType = contentType + "jpeg";
        } else if (ruta.endsWith(".png")) {
            contentType = contentType + "png";
        } else if (ruta.endsWith(".svg")) {
            contentType = contentType + "svg+xml";
        }
        try {
            return ResponseEntity.ok()
                    .headers(cabeceras)
                    .contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType(contentType)) //Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/borrar")
    public String borrar(Integer id){
        String nombre=service.findById(id).get().getNombre();
        String ruta=rutaRecursos + "\\ejercicio11\\" +nombre;
        service.deleteById(id);
        try {
            Files.deleteIfExists(Paths.get(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio11GestorImagenesFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return "redirect:/ej11";
    }

}
