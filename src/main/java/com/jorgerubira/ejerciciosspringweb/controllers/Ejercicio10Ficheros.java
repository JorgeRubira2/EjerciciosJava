/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/directorios")
public class Ejercicio10Ficheros {

    @GetMapping("/obtener")
    public String directorio(Model m, String ruta) {
        if (ruta == null) {
            ruta = "C:\\";
        }
        File f = new File(ruta);
        if (ruta != "C:\\") {

            m.addAttribute("parent", f.getParent());
        }
        ArrayList<Fichero> directorios = new ArrayList<>();
        if (f.isDirectory()) {
            File[] ficherosInternos = f.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                try {
                    directorios.add(new Fichero(ficheroInterno.getName(), ficheroInterno.isDirectory(), ficheroInterno.getAbsolutePath()));
                } catch (Exception e) {
                }
            }
            m.addAttribute("directorios", directorios);

        }
        return "ej10/directorios";
    }

    @GetMapping("/descargar")
    public ResponseEntity<Resource> descarga(String ruta) {
        File archivo = new File(ruta);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + archivo.getName());
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
