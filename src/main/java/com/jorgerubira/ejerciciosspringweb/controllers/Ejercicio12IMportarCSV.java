
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.FicheroCSV;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.FicheroCSVRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12IMportarCSV {
    
    @Autowired
    private FicheroCSVRepository repoFichero;
    
    @PostMapping("/subir")
    public String subirDatos(Model m, MultipartFile fichero){
        List<String> result = new ArrayList<>();
        String nombreOriginal = fichero.getOriginalFilename();
        String nombreRandom = UUID.randomUUID().toString()+".jpg";
        nombreRandom = nombreRandom.replace("-","");
        
        try(FileReader fr=new FileReader(nombreOriginal);
            BufferedReader br=new BufferedReader(fr)){
            String linea;
            while((linea = br.readLine()) != null ){
                String[] datos = linea.split(";");
                
                for (int i = 0; i < datos.length; i++) {
                   // repoFichero.save(new FicheroCSV(null,datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9],datos[10]));
                }
                 
                 
                System.out.println(linea);    
            }
        }catch(Exception e){
        }
        /*
        int contador = 0;
        String[] datos = linea.split(";");
        FicheroCSV ficherocsv = new FicheroCSV(null,datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9]);
        for (int i = 0; i < datos.length; i++) {
            repoFichero.save(null,datos[i],datos[i],datos[i],datos[i],datos[i],datos[i],datos[i],datos[i],datos[i],datos[i]);
        }
        
        */
        
        return "ej12/ficheroscsv";
    }
}
