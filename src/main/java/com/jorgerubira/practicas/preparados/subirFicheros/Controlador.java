/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.preparados.subirFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/preparado")
public class Controlador {
    
    
    @GetMapping("/pagina")
    public String o(){
        return "pre/pagina";
    }
    
    @PostMapping("/subir")
    public String s(MultipartFile fichero){
        String subir="d:\\zzzzSubirFicheros\\" + fichero.getOriginalFilename();
        File f=new File(subir);
        f.getParentFile().mkdirs();
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:pagina";
    }
    
    @GetMapping("/download")
    public ResponseEntity<Resource> d() throws IOException{
        String descargar="d:\\zzzzSubirFicheros\\Enumerador.java";
        File file=new File(descargar);
        
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=Enumerador.java");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0"); 
        
        //try{
            InputStreamResource resource = new InputStreamResource(new FileInputStream(descargar));
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
