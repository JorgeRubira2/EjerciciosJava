
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Url;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuroController {
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping("/ver")
    public String gestion(Model model, String ruta){
        String path="";
        String[] dirFrag = null;
        String[] urlFrag = null;
        List<String> ficheros = new ArrayList();
        List<String> directorios = new ArrayList();
        if(ruta == null){
            ruta="C:\\";
        }
        File f=new File(ruta);
        if (f.exists()){
                File []ficherosInternos=f.listFiles();
                try{
                    for (File ficheroInterno : ficherosInternos) {
                        try{
                            if (ficheroInterno.isDirectory()){
                                directorios.add(ficheroInterno.getName());
                            }else{
                                ficheros.add(ficheroInterno.getName());
                            }

                            path = ficheroInterno.getParent();
                            path = path.replaceAll("\\\\", "/");  
                            dirFrag = path.split("/"); 

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    } 
                    urlFrag = new String[dirFrag.length];
                    for (int i = 0; i < dirFrag.length; i++) {
                        if(i == 0){
                            urlFrag[i] = dirFrag[i];    
                        }else if(i != 0){
                            urlFrag[i] = urlFrag[i-1] + "/" + dirFrag[i];
                        }
                    }
                }catch(NullPointerException e){
                   model.addAttribute("error","Error al cargar la URL");
                   model.addAttribute("dir",ruta);
                   e.printStackTrace();
                }    
        }else{
            System.out.println("No existe");
        }
        
        System.out.println("dirFrag");
        for (String string : dirFrag) {
            System.out.println(string);
        }
        
        System.out.println("urlFrag");
        for (String string : urlFrag) {
            System.out.println(string);
        } 
        
        model.addAttribute("ficheros",ficheros);
        model.addAttribute("directorio",directorios);
        model.addAttribute("currentPath",path);
        model.addAttribute("dirFrag",dirFrag);
        //Url url = new Url(dirFrag, urlFrag);
        model.addAttribute("urlFrag",urlFrag); 
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
