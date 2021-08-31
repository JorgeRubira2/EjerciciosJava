/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoController {

    @GetMapping("/listado")
    public String obtenerListadoFicheros(Model model,String ruta) {
        if (ruta == null){
            ruta = "C:\\";
        } 
        System.out.println("ruta: " + ruta);
        File file = new File(ruta);
        List<Fichero> lista = new ArrayList<Fichero>();
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] ficheros = file.listFiles();
                for (File f:ficheros){
                    lista.add(new Fichero(f.getParent(),f.getName(),f.isDirectory()));
                }
            }
        }
        model.addAttribute("ruta", file.getParent());
        model.addAttribute("lista", lista);
        return "ej10/listado";
    }

}
