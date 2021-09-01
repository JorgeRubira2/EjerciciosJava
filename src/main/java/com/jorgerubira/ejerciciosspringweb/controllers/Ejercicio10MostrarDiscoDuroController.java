
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuroController {
    
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
                        dirFrag = path.split("/");
                        for(int i= 0; i<= dirFrag.length;i++){
                            System.out.println(dirFrag[i]);
                        }
                    }catch(Exception e){}
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
}
