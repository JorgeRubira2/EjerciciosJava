/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.ImagenSubida;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesSubidaRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenesController {
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaBase;// ="C:\\zzCursoHiberus";  

    //private String rutaEjercicio = rutaBase + "\\ejercicio11\\";
    
    @Autowired 
    private ImagenesSubidaRepository repoImagenes;


    @GetMapping("/variable")
    @ResponseBody
    public String mostrarFormulario2(Model mode){
        return rutaBase;
    }  
    
    
    @GetMapping("/ver")
    public String mostrarFormulario(Model model, String descripcion){
        if (descripcion == null) {
            model.addAttribute("imagenes",  repoImagenes.findAll());
        } else {
            model.addAttribute("imagenes",  repoImagenes.findByDescripcionContains(descripcion));
        }
            
        return "ej11/ver";
    }  
    
    
    @PostMapping("/subirImagen")
    public String subir(Model model, MultipartFile fichero, String descripcion){ //, HttpServletResponse response){
        
        String rutaEjercicio = rutaBase + "\\ejercicio11\\";
        String nombre = fichero.getOriginalFilename().toLowerCase();
        String extension = nombre.substring(nombre.lastIndexOf("."));
        
        if (".jpg".equals(extension) ||
            ".jpeg".equals(extension) || 
            ".png".equals(extension) )
        {
        } else {
            model.addAttribute("error", "tipo de fichero erroneo");
        }

        String ruta= rutaEjercicio + UUID.randomUUID().toString() + extension;
        
        ImagenSubida imagen = new ImagenSubida(null, ruta, fichero.getOriginalFilename(), descripcion);
        System.out.println("ruta : "+ ruta);
        File f=new File(ruta);
        f.getParentFile().mkdirs();
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
            repoImagenes.save(imagen);
            return "redirect:ver";
        }catch(IOException e){
            e.printStackTrace();
            model.addAttribute("error", "Error inesperado");
        }
        
        //response.addCookie(new Cookie("username", "Jovan"));
        return "ej11/ver";
    }
    
        @GetMapping("/descarga")
        public ResponseEntity<Resource>  mostrarFormulario(String ruta){
            
        String rutaEjercicio = rutaBase + "\\ejercicio11\\";
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment");
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");
        
        
        /*String contentType="application/octet-stream";
        if (ruta.endsWith(".pdf")){
            contentType="application/pdf";
        }else if (ruta.endsWith(".png")){
            
        }*/
        
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
    
    @GetMapping("/borrarImagen")
    public String borrarImagen(Integer id){
        Optional<ImagenSubida>  imagen = repoImagenes.findById(id);
        if (imagen.isPresent()){
            repoImagenes.deleteById(id);
        }
        File file = new File(imagen.get().getRutaAlmacenamiento());
        file.delete();
        
        return "redirect:ver";
    }
    
    
}
