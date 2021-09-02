
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ejercicio10")

public class Ejercicio10MostrarDiscoDuroController {
         
    @GetMapping("/lista")
    public String listaArchivos(Model model, String ruta){
        List<File> lista = new ArrayList<>();  
    
        File f;
        if (ruta == null){
           ruta= "C:\\";
        } 
        
       
        f =new File(ruta);  
        if(ruta!=null){
             model.addAttribute("ruta", f.getParent());
        }
               
        File []ficherosInternos = f.listFiles();
        for (File ficheroInterno : ficherosInternos) {
                //if (ficheroInterno.isDirectory()){
            lista.add(ficheroInterno);
                 
         }      
        
        model.addAttribute("lista", lista);         
        return "ej10/mostrarDisco";
    }

    
    @GetMapping("/descarga")
    public ResponseEntity<Resource> descarga(Model model, String ruta) throws IOException{
       
        File file=new File(ruta);
        
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=" + file.getName());
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache"); 
        header.add("Expires", "0"); 
        
        //try{
            InputStreamResource resource = new InputStreamResource(new FileInputStream(ruta));
            return ResponseEntity.ok()
                                 .headers(header)
                                 .contentLength(file.length())
                                 .contentType(MediaType.parseMediaType("application/octet-stream"))
                                 .body(resource); 
        /*}catch(Exception e){
            e.printStackTrace();
            return null;
        }*/
    }
    
}
