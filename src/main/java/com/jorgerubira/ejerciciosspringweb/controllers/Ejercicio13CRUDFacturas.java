/*package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ej13")
public class Ejercicio13CRUDFacturas {
    
    //Hacemos este método para convertir la fecha a formato standard (lleva try-catch pq es metodo un poco especial)
    private Date convertirStringADate(String fecha){
        try{
            SimpleDateFormat fechaFormatoStandard = new SimpleDateFormat("dd/mm/yy");
            return fechaFormatoStandard.parse(fecha);
        }catch(Exception e){
            return null;    
        }
                  
    }

    
    //Conectamos con la BD para que pueda subir los datos
    @Autowired
    private CsvRepository db;
    
    //Mostramos la página
    @GetMapping("/ver")
    public String mostrarFormulario(Model m, String success) {
        m.addAttribute("success", success);
        return "ej12/subirCsv";
    }
    
    //Post para subir (hace falta un form en el html)
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero) { //, HttpServletResponse response){            
        
       //Comprobamos el formato del archivo
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv") == false) {
            m.addAttribute("error", "Formato incorrecto");
            return "ej12/subirCsv";
        }
        
        //Creamos las carpetas para guardar el directorio en el disco y cogemos el nombre original
        String ruta = rutaRecursos + "\\ej12\\ficheros\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            //Copiamos el fichero al disco, si existe lo reemplaza 
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            /*Subimos el fichero a la BD. Con Files.lines lo convierte a Stream
            //  1-Hacemos skip para quitar la cabecera
            //  2-.map para convertirlo y separar cada campo por su separador (;)
            //  3-.map de nuevo para convertir a objeto de la clase Csv creada
            //      3.1-null para el identificador (lo rellenará solo). Despues convertimos el texto a su correspondiente formato para cada campo
            */
/*
            Files.lines(f.toPath()).skip(1)
                                   .map(x->x.split(";"))
                                   .map(x->new Csv(
                                           null,
                                           Integer.parseInt(x[0]),
                                           x[1],
                                           x[2],
                                           x[3],
                                           x[4],
                                           x[5],
                                           Integer.parseInt(x[6]),
                                           Integer.parseInt(x[7]),
                                           Integer.parseInt(x[8]),
                                           Float.parseFloat(x[9]),
                                           convertirStringADate(x[10])))//aplicamos el metodo creado para convertir formato fechas
                                    .forEach(x->db.save(x)); //método final para guardar en la BD
            return "redirect:ver?success=Fichero importado correctamente";
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "ej12/subirCsv";
    }

}
*/
