package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private ImagenRepository repositorioImg;

    @GetMapping("")
    public String verTodo(Model model, String descripcion) {
        model.addAttribute("imagenes", repositorioImg.findAll());
        return "/ej11/imagenes";
    }

    @GetMapping("/filtrar")
    public String filtrar(Model model, String descripcion) {

        model.addAttribute("imagen", new Imagen());
        model.addAttribute("imagenes", repositorioImg.findByDescripcion(descripcion));

        return "/ej11/imagenes";
    }

    @GetMapping("/formularioSubida")
    public String subirImagenFormulario(Model model) {
        model.addAttribute("imagenes", new Imagen());
        return "/ej11/formSubir";
    }

    @PostMapping("/subirImagen")
    public String subirImagen(Model model, MultipartFile fichero, Imagen img) {
        img.setNombre(UUID.randomUUID().toString() + fichero.getOriginalFilename());
        String ruta = rutaRecursos + "\\ej11\\" + img.getNombre();
        img.setRuta(ruta);
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            repositorioImg.save(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/ejercicio11";
    }

    @GetMapping("/visualizarImagen")
    public ResponseEntity<Resource> mostrarImagen(String nombre) {

        String ruta = rutaRecursos + "\\ej11\\" + nombre;

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + nombre);
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try {
            return ResponseEntity.ok().headers(cabeceras).contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType("application/octet-stream")) // Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/borrar/{id}")
    public String eliminarImagen(@PathVariable Long id) {
        Imagen imagen = repositorioImg.findById(id).get();
        try {
            Files.deleteIfExists(Path.of(imagen.getRuta()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repositorioImg.deleteById(id);
        return "redirect:/ejercicio11";
    }

}