/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio10FicheroService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ej10")
public class Ejercicio10Ficheros {

    @Autowired
    private IEjercicio10FicheroService service;

    @GetMapping
    public String inicio(Model m, String ruta) {
        File file = null;
        if (ruta == null) {
            ruta = "C:\\";
        } else {
            file=new File(ruta);
            file = file.getParentFile();
        }
        m.addAttribute("directorio", service.fichClas(ruta));
        m.addAttribute("regreso", file);
        return "/ej10/inicio";
    }
    @GetMapping("/descarga")
    /*@ResponseBody
    public FileSystemResource download(String ruta){    
        return new FileSystemResource(new File(ruta));
    }*/
    public ResponseEntity<Resource> download(String ruta){
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/octet-stream"))//comodin descarga cualquier tipo de archivo pero guarda en disco duro
                    .body(new InputStreamResource(new FileInputStream(ruta)));   
                    
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
