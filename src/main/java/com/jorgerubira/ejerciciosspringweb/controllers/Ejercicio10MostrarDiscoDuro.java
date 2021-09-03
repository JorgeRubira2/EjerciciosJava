/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuro {
    
    @GetMapping("/discoDuro") 
    public String listar(Model model, String ruta){
        
        if(ruta==null){
            ruta="C:\\";
        }
        File ficheros=new File(ruta);
        
        File []ficherosInternos=ficheros.listFiles();
        
        model.addAttribute("Ficheros", ficherosInternos);
        model.addAttribute("Parent", ficheros.getParent());
        return "ej10/index";
    }    
    


@GetMapping("/descarga")
    public ResponseEntity<Resource> descargar(String ruta){
        File archivo=new File(ruta);
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + archivo.getName());
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