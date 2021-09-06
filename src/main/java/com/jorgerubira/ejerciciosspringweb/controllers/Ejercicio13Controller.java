package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.UUID;
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
@RequestMapping("/ejercicio13")
public class Ejercicio13Controller {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaBase;

    private ImagenRepository repositorio;

    @GetMapping("/facturas")
    public String o() {
        return "ej13/facturas.html";
    }
/*
    @GetMapping("/download")
    public ResponseEntity<Resource> d() throws IOException {
        String descargar = "d:\\zzzzSubirFicheros\\Enumerador.java";
        File file = new File(descargar);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=Enumerador.java");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        //try{
        InputStreamResource resource = new InputStreamResource(new FileInputStream(descargar));
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
        /*}catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/subir")
    public String s(MultipartFile fichero, Imagen img, String descripcion) {
        String nombre = UUID.randomUUID().toString();
        String subir = rutaBase + "ej11\\" + nombre + ".jpg";
        File f = new File(subir);
        f.getParentFile().mkdirs();

        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);

            img.setRuta(subir);
            img.setNombre(fichero.getOriginalFilename());
            img.setDescripcion(descripcion);

            repositorio.save(img);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:pagina";
    }
*/
} 
