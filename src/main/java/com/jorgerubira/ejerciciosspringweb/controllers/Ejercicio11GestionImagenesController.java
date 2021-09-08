package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagenes;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
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

@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenesController {

    @Controller
    @RequestMapping("/ej11")
    public class FicherosController {

        @Value("${carpetas.recursos.hiberus}")
        private String rutaRecursos;

        @Autowired
        private ImagenesRepository db;

        @GetMapping("/ver")
        public String mostrarFormulario(Model m, String success) {
            m.addAttribute("success", success);
            m.addAttribute("mostrarImagen", db.findAll());
            return "ej11/index";
        }
        
        @PostMapping("/ver")
        public String mostrarImagenFiltrada(Model m, String descripcion) {
            m.addAttribute("success", "");
            m.addAttribute("mostrarImagen", db.findByDescripcionContaining(descripcion));
            return "ej11/index";
        }

        @GetMapping("/descargarImagen")
        public ResponseEntity<Resource> mostrarFormulario(String rutaRecursos) {
            String ruta = this.rutaRecursos + "\\ej11\\imagenes\\" + rutaRecursos;
            File archivo = new File(ruta);

            HttpHeaders cabeceras = new HttpHeaders();
            cabeceras.add("Content-Disposition", "attachment; filename=" + archivo.getName() + ".jpg");
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

        @PostMapping("/subir")
        public String subir(Model m, MultipartFile fichero, Imagenes imagen) { //, HttpServletResponse response){

            if (fichero.getOriginalFilename().toLowerCase().endsWith(".jpg") == false) {
                m.addAttribute("error", "Formato incorrecto");
                return "ej11/index";
            }
            String idRandom = UUID.randomUUID().toString();
            imagen.setCodigo(idRandom);
            db.save(imagen);//Guardar de la BD
            String ruta = rutaRecursos + "\\ej11\\imagenes\\" + idRandom;
            File f = new File(ruta);
            f.getParentFile().mkdirs();
            try {
                Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);

                return "redirect:ver?success=Fichero subido correctamente";
            } catch (IOException e) {
                e.printStackTrace();
                m.addAttribute("error", "Error inesperado");
            }
            return "redirect:ver";
        }

        @GetMapping("/borrarImagen")
        public String borrar(Integer id) {

            Imagenes imagenBorrar = db.findById(id).get();
            String ruta = this.rutaRecursos + "\\ej11\\imagenes\\" + imagenBorrar.getCodigo();

            try {
                Files.deleteIfExists(Path.of(ruta));

            } catch (Exception e) {
                e.printStackTrace();
            }

            db.deleteById(id);

            return "redirect:ver";
        }

    }
}
