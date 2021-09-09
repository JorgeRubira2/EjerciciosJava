/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesCrudRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11MostrarImagenesController {
    
    @Autowired
    private ImagenesCrudRepository lista;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping("/lista")
    public String listaImagenes(Model model){         
               
       model.addAttribute("lista", lista.findAll());
       return "ej11/mostrarImagenes";
    }
    
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(String imagen){
        //String ruta=rutaRecursos +  imagen ;
        String ruta=rutaRecursos + "\\ej11\\" + imagen ;
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + ruta );
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
    
    
       
    @PostMapping("/subir")
    public String subirImagenes(Model model, MultipartFile archivo, String descripcion){         

        Imagen imagen = new Imagen();
        String codigo1 = UUID.randomUUID().toString();
        
        imagen.setNombre (codigo1);
        imagen.setDescripcion(descripcion);
       
       
        String subir= rutaRecursos + "\\ej11\\"  + codigo1;
        File f=new File(subir);
        f.getParentFile().mkdirs();
        try{
            Files.copy(archivo.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            e.printStackTrace();
        }
            
        lista.save(imagen);
        
        return "redirect:lista";
        
        }
    
        @GetMapping("/eliminar")
        public String eliminar(Model model, Integer codigo){
            Imagen imagen = lista.getById(codigo);
            lista.deleteById(codigo);
            String arhivo = rutaRecursos + "\\ej11\\"  + imagen.getNombre();
            File f=new File(arhivo);
            boolean eliminado = f.delete();
            return "redirect:lista";    
        }
    
    
         @PostMapping("/filtrar")
         public String filtrar(Model model, String descripcion){
           
             model.addAttribute("lista", lista.findByDescripcionContaining(descripcion));
             return "ej11/mostrarImagenes";
            
            
        }
    }
    
    
     
