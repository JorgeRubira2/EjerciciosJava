package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
@RequestMapping("/ejercicio11")
public class Ejercicio11Controller {
    
    @GetMapping("/pagina")
    public String o(){
        return "ej11/vista.html";
    }

    @GetMapping("/listaficheros") //URL A LLAMAR
    public String listarFicheros(Model model, String ruta) {
        if (ruta == null) {
            ruta = "C:\\";
        }
        File f = new File(ruta);
        ArrayList<Fichero> nombres = new ArrayList<>();
        if (f.isDirectory()) {
            File[] ficherosInternos = f.listFiles();
            for (File ficherosinterno : ficherosInternos) {
                ficherosinterno.getParent();
                try {
                    nombres.add(new Fichero(ficherosinterno.getName(), ficherosinterno.isDirectory(), ficherosinterno.getAbsolutePath()));
                } catch (Exception e) {

                }
            }

        }
        model.addAttribute("nombres", nombres);
        model.addAttribute("ruta", f.getAbsolutePath());
        model.addAttribute("volver", f.getParent());
        return "ej10/vista";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> d(String descargar) throws IOException {

        File file = new File(descargar);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=" + file.getName());
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

}
