package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenesController {
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private ImagenRepository repoImg;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping
    public String inicio(Model m, String success, String borrado){
        if(repoImg.findAll().isEmpty()){
            m.addAttribute("imagenes", new Imagen());
        }else{
            m.addAttribute("imagenes", repoImg.findAll());
        }
        m.addAttribute("success", success);
        m.addAttribute("borrado", borrado);
        return "/ej11/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, String descripcion){ //, HttpServletResponse response){
        String nombre = fichero.getOriginalFilename();
        String codigo = UUID.randomUUID().toString();
        String ext = nombre.substring(nombre.lastIndexOf("."), nombre.length());
        String ruta=rutaRecursos + "\\ej11\\" + codigo + ext;
        
        File f=new File(ruta);
        f.getParentFile().mkdirs();

        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Imagen img = new Imagen();
            img.setCodigo(codigo);img.setDescripcion(descripcion);img.setNombre(nombre);img.setRuta(ruta);
            repoImg.save(img);
            return "redirect:/ejercicio11?success=Fichero subido";
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "/ej11/vista";
    }
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(String codigo,String nombre){
        String ext = nombre.substring(nombre.lastIndexOf("."), nombre.length());
        String ruta=rutaRecursos + "\\ej11\\" + codigo + ext;
        
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename="+nombre);
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
    @GetMapping("/borrar")
    public String borrar(Model m, String codigo){
        Imagen borrar = repoImg.findByCodigo(codigo);
        String del = "";
        if (borrar != null){
            repoImg.delete(borrar);
            del = "Imagen borrada con exito";
        }else{
            del = "Error inesperado";
        }
        return "redirect:/ejercicio11?borrado="+del;
    }
}
