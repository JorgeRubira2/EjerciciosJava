package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
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
 * @author Isabel
 */
@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {

    @Autowired
    private ImagenRepository imagenRepo;

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    
    @GetMapping("ver")
    public String verImagenes(Model model){
        model.addAttribute("imagenes", imagenRepo.findAll());
        
        return "ej11/imagenes";
    }

    @PostMapping("/subir")
    public String subirFichero(Model model, MultipartFile fichero, Imagen imagen) {
        String nombre = UUID.randomUUID().toString();
        String ruta = rutaRecursos + "\\ej11\\imagenes\\" + nombre;
        String desc = imagen.getDescripcion();

        File f = new File(ruta);
        f.getParentFile().mkdirs();

        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
          
            imagen.setDescripcion(desc);
            imagen.setRuta(nombre);
            imagen.setNombreFichero(fichero.getOriginalFilename());
            imagenRepo.save(imagen);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:ver";
    }

    
    @GetMapping("/descarga")
    public ResponseEntity<Resource> mostrar(Long id) {
        Imagen img = imagenRepo.findById(id).get();
        String ruta = rutaRecursos + "\\ej11\\imagenes\\" + img.getRuta();

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + UUID.randomUUID().toString());
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
}