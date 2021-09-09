package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Datos;
import com.jorgerubira.ejerciciosspringweb.repositories.ImportarCSVRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ej12")
public class Ejercicio12ImportarCSV {

    @Autowired(required = false)
    private ImportarCSVRepository repoImportarCSV;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos="C:\\zzCursoHiberus";

    @GetMapping("/verDatos")
    public String verDatos(){
        return "ej12/formulario";
    }
    
    @ResponseBody
    @PostMapping("/importarDatos")
    public String importarDatos(Model m, MultipartFile fichero){ //, HttpServletResponse response){
        
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv")==false){
            m.addAttribute("error", "Formato incorrecto");
            return "ej12/formulario";
        }
        
        String ruta = rutaRecursos + "\\ej12\\" + fichero.getOriginalFilename();
        File f=new File(ruta);
        f.getParentFile().mkdirs();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
            Files.lines(f.toPath()).skip(1).map(x->x.split(";")).forEach(x-> {
                Date fecha= null;
                    try{
                        fecha=date.parse(x[10]);
                    }catch(Exception e){}
                    repoImportarCSV.save(new Datos(0, 
                                Integer.parseInt(x[0]),
                                x[1],
                                x[2],
                                x[3],
                                x[4],
                                x[5],
                                Integer.parseInt(x[6]),
                                Integer.parseInt(x[7]),
                                Integer.parseInt(x[8]),
                                Double.parseDouble(x[9]),
                                fecha));
            });
            m.addAttribute("mensaje", "Fichero subido con éxito");
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        } finally {
            f.delete();
        }
        return "ej12/formulario";
    }
}
