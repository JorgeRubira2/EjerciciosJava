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
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuro {

    //Listamos los ficheros en un array y lo mostramos
    @GetMapping("")
    public String directorio(Model model, String ruta) {

        ArrayList<Fichero> listDirectorios = new ArrayList<>();

        if (ruta == null) {
            ruta = "C:\\";
        }

        File archivo = new File(ruta);

        File[] ficheros = archivo.listFiles();
        for (var var1 : ficheros) {
            listDirectorios.add(new Fichero(var1.getName(), var1.isDirectory(), var1.getAbsolutePath()));
        }
        model.addAttribute("directorios", listDirectorios);

        return "ej10/Vista";
    }

    // Método cogido de los apuntes
    @GetMapping("/descargar")
    public ResponseEntity<Resource> descarga(String ruta) {
        File archivo = new File(ruta);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + archivo.getName());
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
}