/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

/**
 * Subbir prueba 
 * @author Usuario
 */
@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuro {
    @GetMapping("/mostrar")
    public String mostrar(Model m, String ruta){
        if(ruta==null)
            ruta="C:\\";
        System.out.println("ruta: "+ ruta);
        File f=new File(ruta);
        List<Fichero> listaF=new ArrayList<Fichero>();
        if(f.exists()){
            if(f.isDirectory()){
                File[] ficheros=f.listFiles();
                for(File fichero : ficheros){
                    listaF.add(new Fichero(fichero.getParent(),fichero.getName(),fichero.isDirectory()));
                }
            }
        }
        m.addAttribute("ruta",f.getParent());
        m.addAttribute("acF",f);
        m.addAttribute("lista", listaF);
        return "ej10/mostrar";
    }
    @GetMapping("/descarga")
    public ResponseEntity<Resource> descarga(String f, String nombre){
        HttpHeaders head=new HttpHeaders();
        head.add("Content-Disposition", "attatchment; filename="+nombre+"");
        head.add("Cache-Control","no-cache, no-store, must-revalidate");
        head.add("Pragma", "no-cache");
        head.add("Expires", "0");
        try{
            return ResponseEntity.ok()
                    .headers(head)
                    .contentLength((new File(f)).length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(new FileInputStream(f)));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
