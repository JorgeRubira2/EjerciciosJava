/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;
import com.jorgerubira.ejerciciosspringweb.entities.Registro;
import com.jorgerubira.ejerciciosspringweb.repositories.RegistrosRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mohamad
 */
@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12RegistrosController {
    
    @Autowired
    private RegistrosRepository repReg;
    
     @Value("${carpetas.recursos.hiberus}")
        private String rutaRecursos;
     
    
    @GetMapping
    public String mostrarFormulario(Model m, String success){
        m.addAttribute("success", success);
        return "ej12/registros";
    } 
    
    @PostMapping("/subirCSV")
    public String subirCSV(Model m, MultipartFile fichero) {
         SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy"); 
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv") == false) {
            m.addAttribute("error", "Formato incorrecto");
            return "ej12/registros";
        }     
        String ruta = rutaRecursos + "\\ejercicio12\\" + fichero.getOriginalFilename() ;
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.lines(f.toPath()).skip(1).map(x->{
                    String[] campos=x.split(";");
                    Date fecha=null;
                    try{
                        fecha=formato.parse(campos[10]);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    Registro reg=new Registro(
                            null, Integer.parseInt(campos[0]),campos[1],campos[2],
                            campos[3],campos[4],campos[5],
                            Integer.parseInt(campos[6]),Integer.parseInt(campos[7]),Integer.parseInt(campos[8]),Float.parseFloat(campos[9]),
                            fecha);
                    return reg;
            }).forEach(x->repReg.save(x));
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "ej12/registros";
    }
}
