package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
@RequestMapping("/ej10")
public class Ejercicio10MostrarDiscoDuroController {
   
    @GetMapping("/mostrarDirectorios") //esta es la URL a la que llamaremos desde el navegador
    public String listar (Model model, String ruta){
        
        if(ruta==null){
            ruta="C:\\";
        }
        
        File f=new File(ruta);
                                    
        File []ficherosInternos=f.listFiles();

        model.addAttribute("Ficheros", ficherosInternos);
        model.addAttribute("Parent", f.getParent());
        
        return "/ej10/index";
    }
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(String ruta){
        
        File archivo = new File(ruta);
                
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename="+archivo.getName());
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
