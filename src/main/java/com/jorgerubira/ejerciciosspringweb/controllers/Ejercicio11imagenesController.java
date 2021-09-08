package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;

@Controller
@RequestMapping("/gestorImagenes")

public class Ejercicio11imagenesController {

    @Autowired(required = false)//Con required = false no es obligatorio que esté el repository 

    private ImagenesRepository repoImagenes;

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping("/mostrarTodo")
    public String mostrarTodo(Model m) {

        m.addAttribute("imagen", new Imagenes());
        m.addAttribute("imagenes", repoImagenes.findAll());

        return "ej11/imagenes";

    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, Imagenes imagen) {

        /*  if (fichero.getOriginalFilename().toLowerCase().endsWith(".pdf")==false){
            m.addAttribute("error", "Formato incorrecto");
            return "ej11/imagenes";
        }*/
        String nAleatorio = UUID.randomUUID().toString() + ".jpg";
        String ruta = rutaRecursos + "\\ej11\\imagenes\\" + nAleatorio;
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {

            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);

            imagen.setRuta(nAleatorio); //añadimos a bd
            imagen.setNombre(fichero.getOriginalFilename());
            repoImagenes.save(imagen);

            // return "redirect:mostrarTodo?success=Fichero subido";
        } catch (IOException e) {
            e.printStackTrace();
            //m.addAttribute("error", "Error inesperado");
        }

        return "redirect:/gestorImagenes/mostrarTodo";
    }

    @GetMapping("/descargar")
    public ResponseEntity<Resource> mostrarImagen(String nAleatorio) {

        String ruta = rutaRecursos + "\\ej11\\imagenes\\" + nAleatorio;

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + nAleatorio);
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try {
            return ResponseEntity.ok()
                    .headers(cabeceras)
                    .contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType("application/octet-stream")) //Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/borrar")
    public String borrar(String nAleatorio) {

        Imagenes img = repoImagenes.findByRuta(nAleatorio);

        repoImagenes.delete(img); //elimina bd

        String ruta = rutaRecursos + "\\ej11\\imagenes\\" + nAleatorio; //eliminamos imagen
        try {
            Files.delete(Path.of(ruta));
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio11imagenesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/gestorImagenes/mostrarTodo";
    }

    @GetMapping("/filtrar")
    public String filtrar(Model m, String descripcion) {

        m.addAttribute("imagen", new Imagenes());
        m.addAttribute("imagenes", repoImagenes.findByDescripcionContaining(descripcion));

        return "ej11/filtradas";
    }
}
