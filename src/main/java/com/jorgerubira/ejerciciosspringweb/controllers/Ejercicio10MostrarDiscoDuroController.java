package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Isabel
 */
@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuroController {

    @GetMapping("/ver")
    public String verDirectorios(Model model, String ruta) {
        if(ruta == null){
            ruta = "C:\\";
        }
        
        File f = new File(ruta);
        if(ruta != null){
            model.addAttribute("padre", f.getParent());
        }
        
        File []ficheros = f.listFiles();

        model.addAttribute("directorios", ficheros);
      
        
        return "/ej10/ficheros";
    }
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource> descargaFichero(String ruta){
        File file = new File(ruta);
       
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + file.getName());
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try{
            return ResponseEntity.ok()
                                 .headers(cabeceras)
                                 .contentLength((new File(ruta)).length())
                                 .contentType(MediaType.parseMediaType( "application/octet-stream" ))  //Codigo MIME
                                 .body(new InputStreamResource(new FileInputStream(ruta)));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}