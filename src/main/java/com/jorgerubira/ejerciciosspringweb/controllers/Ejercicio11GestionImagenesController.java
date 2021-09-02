package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
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
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenesController {

    @Controller
    @RequestMapping("/ej11")
    public class FicherosController {

        @Value("${carpetas.recursos.hiberus}")
        private String rutaRecursos;

        @GetMapping("/ver")
        public String mostrarFormulario(Model m, String success) {
            m.addAttribute("success", success);
            return "ej11/index";
        }

        @GetMapping("/verImagen")
        public String mostrarImagen(String success) {
            return "ej11/index";
        }

        @GetMapping("/descarga")
        public ResponseEntity<Resource> mostrarFormulario(int imagen) {
            String ruta = rutaRecursos + "\\ej11" + imagen + ".jpg";

            HttpHeaders cabeceras = new HttpHeaders();
            cabeceras.add("Content-Disposition", "attachment; filename=imagen.jpg");
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

        @PostMapping("/ver")
        public String mostrarFormulario2() {
            return "ej11/index";
        }

        @PostMapping("/subir")
        public String subir(Model m, MultipartFile fichero) { //, HttpServletResponse response){

            if (fichero.getOriginalFilename().toLowerCase().endsWith(".pdf") == false) {
                m.addAttribute("error", "Formato incorrecto");
                return "ej11/index";
            }
            String idRandom = UUID.randomUUID().toString();
            String ruta = rutaRecursos + "\\ej11\\imagenes\\" + idRandom;
            File f = new File(ruta);
            f.getParentFile().mkdirs();
            try {
                Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return "redirect:ver?success=Fichero subido";
            } catch (IOException e) {
                e.printStackTrace();
                m.addAttribute("error", "Error inesperado");
            }

            //response.addCookie(new Cookie("username", "Jovan"));
            return "ej11/index";
        }
    }
}
