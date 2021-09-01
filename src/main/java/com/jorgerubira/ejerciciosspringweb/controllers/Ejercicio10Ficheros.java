package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ejercicio10Ficheros {

    @GetMapping("/ej10/lista")
    public String lista(Model model, String ruta) {
        if (ruta == null) {
            ruta = "C:\\";
        }
        File file = new File(ruta);
        ArrayList<Fichero> contenido = new ArrayList<>();
        if (file.isDirectory()) {
            File[] ficherosInternos = file.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                try {
                    contenido.add(new Fichero(ficheroInterno.getName(), ficheroInterno.isDirectory(), ficheroInterno.getAbsolutePath()));

                } catch (Exception e) {

                }
            }
            model.addAttribute("contenido", contenido);
            if (ruta != null) {
                model.addAttribute("ruta", file.getParent());
            }
        }
        return "ej10/vista";
    }

    @GetMapping("/descarga")
    public ResponseEntity<Resource> descarga(String ruta) {
        File file = new File(ruta);

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + file.getName());
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
