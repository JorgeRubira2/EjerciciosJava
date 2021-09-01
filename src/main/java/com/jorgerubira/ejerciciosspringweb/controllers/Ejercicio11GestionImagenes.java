
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
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
public class Ejercicio11GestionImagenes {
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping("/gestor")
    public String gestion(){
    
        return "ej11/gestionimagenes";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero){ //, HttpServletResponse response){
        
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".jpg")==false){
            m.addAttribute("error", "Formato incorrecto");
            return "d20210901/formulario";
        }
        //UUID.randomUUID().toString();
        String ruta=rutaRecursos + "\\d20210901\\ejemplo1\\" + fichero.getOriginalFilename();
        File f=new File(ruta);
        f.getParentFile().mkdirs();
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
            return "redirect:ver?success=Fichero subido";
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
             return "redirect:ver";
        }
        
        //response.addCookie(new Cookie("username", "Jovan"));
       
    }
    
    
    
    
    @GetMapping("/ver")
    public String ver(Model model, String ruta){
        String path="";
        String[] dirFrag = null;
        List<String> ficheros = new ArrayList();
        List<String> directorios = new ArrayList();
        if(ruta == null){
            //ruta="D:\\pruebas ficheros";
            ruta="C:\\";
        }
        System.out.println(ruta);
        File f=new File(ruta);
        if (f.exists()){
                File []ficherosInternos=f.listFiles();
                try{
                    for (File ficheroInterno : ficherosInternos) {
                        try{
                            if (ficheroInterno.isDirectory()){
                                directorios.add(ficheroInterno.getName());
                                //ficheroInterno.getName()
                            }else{
                                ficheros.add(ficheroInterno.getName());
                                //ficheroInterno.getName()
                            }

                            path = ficheroInterno.getParent();
                            path.replaceAll("\\\\\\\\\\\\\\\\", "/");
                            dirFrag = path.split("/");
                            //dirFrag = path.split(File.separator.replaceAll("\\", "\\\\"));
                            System.out.println(dirFrag.length);
                            for(int i= 0; i< dirFrag.length;i++){
                                System.out.println("\n"+dirFrag[i]);
                            }
                        }catch(Exception e){}
                    } 
                }catch(NullPointerException e){
                   model.addAttribute("error","Error al cargar la URL");
                   model.addAttribute("dir",ruta);
                }
                
        }else{
            System.out.println("No existe");
        }
        
        model.addAttribute("ficheros",ficheros);
        model.addAttribute("directorio",directorios);
        model.addAttribute("currentPath",path);
        model.addAttribute("dirFrag",dirFrag);
        return "ej10/discoduro";
    }
    
    @GetMapping("/descargar")
    public ResponseEntity<Resource> descargar(String fichero, String nombre){
        
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename="+nombre);
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");
        
        try{
            return ResponseEntity.ok()
                                 .headers(cabeceras)
                                 .contentLength((new File(fichero)).length())
                                 .contentType(MediaType.parseMediaType( "application/octet-stream" ))  
                                 .body(new InputStreamResource(new FileInputStream( fichero )) );
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
        
    }    
}
