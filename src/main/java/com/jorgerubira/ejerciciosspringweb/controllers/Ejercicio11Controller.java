package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Optional;
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

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11Controller {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaBase;

    @Autowired
    private ImagenRepository repositorio;

    @GetMapping("/pagina")
    public String o() {
        return "ej11/vista.html";
    }

    @GetMapping("/verImagenes")
    public String verImagenes(Model model) {
        model.addAttribute("imagenes", repositorio.findAll());
        return "ej11/verImagen.html";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> mostrarImagen(String imagen) throws IOException {
        String descargar = rutaBase + "ej11\\" + imagen;
        File file = new File(descargar);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment;");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        try {

            InputStreamResource resource = new InputStreamResource(new FileInputStream(descargar));
            return ResponseEntity.ok()
                    .headers(header)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/subir")
    public String s(MultipartFile fichero, Imagen img) {
        String nombre = UUID.randomUUID().toString();
        String subir = rutaBase + "ej11\\" + nombre + ".jpg";
        File f = new File(subir);
        f.getParentFile().mkdirs();

        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);

            img.setRuta(subir);
            img.setNombre(nombre + ".jpg");

            repositorio.save(img);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:pagina";
    }

    @GetMapping("/borrar")
    public String borrar(Integer id) {
        Optional<Imagen> img = repositorio.findById(id);
        if (img.isPresent()) {
            repositorio.delete(img.get());
        }
      
        String rutarchivo = rutaBase + "ej11\\" + img.get().getNombre();
        try {
            Files.delete(Path.of(rutarchivo));
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio11Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:verImagenes"; 
        
    }

}
