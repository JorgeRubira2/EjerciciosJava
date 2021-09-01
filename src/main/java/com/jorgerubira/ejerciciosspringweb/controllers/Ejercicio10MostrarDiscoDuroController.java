
package com.jorgerubira.ejerciciosspringweb.controllers;

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
                                directorios.add(ficheroInterno.getAbsolutePath());
                                //ficheroInterno.getName()
                            }else{
                                ficheros.add(ficheroInterno.getAbsolutePath());
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
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(int archivo){
        String ruta=rutaRecursos + "\\archivos\\" + archivo;
        
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=imagen.jpg");
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
}
