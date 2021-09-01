/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletResponse;
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
 * @author Mohamad
 */
@Controller
@RequestMapping("/ejercicio10")

public class Ejercicio10MostrarDiscoDuro {

    @GetMapping("/directorios")
    public String Listar(Model model,String ruta) {
        if (ruta == null) {
            ruta= "C:\\";
        }
        File f = new File(ruta);
        
        model.addAttribute("arbol", f.listFiles());
        return "ej10/arbol";
    }
 
     @GetMapping("/volver")
     public String volver(Model model,String ruta) {
          if (ruta != null) {
              File f = new File(ruta);
            model.addAttribute("ruta",f.getParent() );
        }
       return ("redirect:directorios");
     }
     
       @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(String ruta, HttpServletResponse response){
        File f = new File(ruta);
        String nombre= f.getName();
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename="+nombre);
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
            try{
                response.sendError(403, "No hay acceso");    
            }catch(Exception e2){
                
            }
            return null;
        }
        
    } 
     
}

