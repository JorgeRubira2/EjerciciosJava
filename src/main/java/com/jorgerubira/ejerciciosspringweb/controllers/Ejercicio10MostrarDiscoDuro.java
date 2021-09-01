package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;

@Controller
@RequestMapping("/ej10")
public class Ejercicio10MostrarDiscoDuro {

    @GetMapping("/lista")
    public String ver(Model model, String ruta){
        if(ruta==null){
            ruta = "C:\\";
        }
        File f = new File(ruta);
        File []ficherosInternos = f.listFiles();
        String padre;
        if(("C:\\").equals(ruta)){
            padre = "C:\\";
        } else {
            padre = f.getParent();
        }
        model.addAttribute("ficheros", ficherosInternos);
        model.addAttribute("padre", padre);
        return "/ej10/lista";
    }

    @GetMapping("/descarga")
    public ResponseEntity<Resource> descargar(String ruta){
        HttpHeaders cabeceras=new HttpHeaders();
        File f = new File(ruta);
        cabeceras.add("Content-Disposition", "attachment; filename=" + f.getName());
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try{
            return ResponseEntity.ok()
                    .headers(cabeceras)
                    .contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType( "application/octet-stream" ))  //Codigo MIME
                    .body(new InputStreamResource(new FileInputStream( ruta )) );
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
