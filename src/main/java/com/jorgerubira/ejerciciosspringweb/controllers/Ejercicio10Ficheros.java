/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio10FicheroService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public FileSystemResource download(String ruta){    
        return new FileSystemResource(new File(ruta));
    }
}
