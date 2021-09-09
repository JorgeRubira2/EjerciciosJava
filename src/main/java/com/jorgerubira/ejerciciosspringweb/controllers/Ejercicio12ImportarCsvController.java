/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.jorgerubira.ejerciciosspringweb.repositories.PlazaCrudRepository;
import com.jorgerubira.ejerciciosspringweb.entities.Plaza;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.thymeleaf.util.DateUtils;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCsvController {
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @Autowired
    private PlazaCrudRepository plazas;
    
   
    
    @GetMapping("/importar")
    public String impotarCSV (Model model){
    
        return "ej12/csvUniversidad";
    }
    
    
    @PostMapping("/subir")
    public String subirCSV(Model model, MultipartFile archivo){         
        
        String subir= rutaRecursos + "\\ej12\\"  + archivo.getOriginalFilename();
       
       // f.getParentFile().mkdirs();
       
         List <Plaza> plazaInsertar = null;
   
        try{
            File f=new File(subir);
            Files.copy(archivo.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            Files.lines(f.toPath()).skip(1).map(x-> {
                
                                    String[]valores =x.split(";"); 
                                  
                                    Plaza plaza= new Plaza(null,Integer.parseInt(valores[0]),valores[1], valores[2], valores[3], 
                                    valores[4], valores[5], Integer.parseInt(valores[6]), Integer.parseInt(valores[7]),
                                    Integer.parseInt(valores[8]), Double.parseDouble(valores[9]), convertir(valores[10]))                       
                                    ;return plaza;}).forEach(x-> plazas.save(x));
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
         return "ej12/csvResumen";
        
     }
    
    
    public Date convertir (String fecha){
        
        try{
             SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
             return date.parse(fecha);
        
        } catch (Exception e){
            return null;
        }
    }
}
