package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Plaza;
import com.jorgerubira.ejerciciosspringweb.repositories.PlazaRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSVController {
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private PlazaRepository repoPlazas;
    
    @GetMapping
    public String inicio(Model m,String msg){
        if(msg!=null){
            if (msg.toLowerCase().contains("error")){
                m.addAttribute("error",msg);
            }else if (msg.toLowerCase().contains("exito")){
                m.addAttribute("success",msg);
            }
        }
        
        return "/ej12/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero){ //, HttpServletResponse response){
        String msg = null;
        String linea = "";
        try{
            String csv = new String(fichero.getBytes(),StandardCharsets.UTF_8);
            Reader inputString = new StringReader(csv);
            BufferedReader br = new BufferedReader(inputString);
            br.readLine();
            while((linea = br.readLine()) != null){
                String[] aux = linea.split(";");
                Integer cursoAca = Integer.parseInt(aux[0]);
                String estudio = aux[1];
                String localidad = aux[2];
                String centro = aux[3];
                String tipoCentro = aux[4];
                String tipoEstudio = aux[5];
                Integer plazasOf = Integer.parseInt(aux[6]);
                Integer plazasMa = Integer.parseInt(aux[7]);
                Integer plazasSol= Integer.parseInt(aux[8]);
                Double indice = Double.parseDouble(aux[9]);
                Date fecha = new Date(aux[10]);
                repoPlazas.save(new Plaza(null,cursoAca,estudio,localidad,centro,tipoCentro,tipoEstudio,plazasOf,plazasMa,plazasSol,indice,fecha));
            }
            msg = "Fichero subido con exito";
        }catch(Exception e){
            e.printStackTrace();
            msg = "Error en la subida";
        }
        return "redirect:/ejercicio12?msg="+msg;
    }
}
