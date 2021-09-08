/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210901.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/d20210901")
public class FicherosController {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping("/ver")
    public String mostrarFormulario(Model m, String success) {
        m.addAttribute("success", success);
        return "d20210901/formulario";
    }

    @GetMapping("/verImagen")
    public String mostrarImagen(String success) {
        return "d20210901/verImagen";
    }

    @GetMapping("/descarga")
    public ResponseEntity<Resource> mostrarFormulario(int imagen) {
        String ruta = rutaRecursos + "\\d20210901\\ejemplo1\\imagen" + imagen + ".jpg";

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=imagen.jpg");
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        /*
         * String contentType="application/octet-stream"; if (ruta.endsWith(".pdf")){
         * contentType="application/pdf"; }else if (ruta.endsWith(".png")){
         * 
         * }
         */

        try {
            return ResponseEntity.ok().headers(cabeceras).contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType("application/octet-stream")) // Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    @PostMapping("/ver")
    public String mostrarFormulario2() {
        return "d20210901/formulario";
    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero) { // , HttpServletResponse response){

        if (fichero.getOriginalFilename().toLowerCase().endsWith(".pdf") == false) {
            m.addAttribute("error", "Formato incorrecto");
            return "d20210901/formulario";
        }
        // UUID.randomUUID().toString();
        String ruta = rutaRecursos + "\\d20210901\\ejemplo1\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "redirect:ver?success=Fichero subido";
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }

        // response.addCookie(new Cookie("username", "Jovan"));
        return "d20210901/formulario";
    }

    @GetMapping("/verMultiple")
    public String mostrarFormulario2(Model m) {
        return "d20210901/formularioMultiple";
    }

    @PostMapping("/subirMultiple")
    public String subirMultiple(Model m, MultipartFile[] fichero) { // , HttpServletResponse response){
        for (MultipartFile fic : fichero) {
            // UUID.randomUUID().toString();
            String ruta = rutaRecursos + "\\d20210901\\ejemplo1\\" + fic.getOriginalFilename();
            File f = new File(ruta);
            f.getParentFile().mkdirs();
            try {
                Files.copy(fic.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // response.addCookie(new Cookie("username", "Jovan"));
        return "d20210901/formularioMultiple";
    }

}
