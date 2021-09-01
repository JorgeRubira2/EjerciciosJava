package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenes {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private ImagenesRepository repositorio;

    @GetMapping("/formulario")
    public String verFormulario(Model m){
        m.addAttribute("imagen", new Imagen());
        return "/ej11/formulario";
    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, Imagen imagen){
        imagen.setNombre(fichero.getOriginalFilename());
        imagen.setCodigo(UUID.randomUUID().toString());
        String ruta = rutaRecursos + "\\ej11\\" + imagen.getCodigo() + imagen.getNombre();
        imagen.setRuta(ruta);
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            repositorio.save(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:imagenes";
    }

    @GetMapping("/imagenes")
    public String verImagenes(Model m, String cadena){
        if(cadena==null){
            m.addAttribute("imagenes", repositorio.findAll());
        } else {
            m.addAttribute("imagenes", repositorio.findByDescripcionContaining(cadena));
        }
        return "/ej11/ver";
    }

    @GetMapping("/verImagen")
    public ResponseEntity<Resource> visualizarImagen(String imagen){
        String ruta=rutaRecursos + "\\ej11\\" + imagen;

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

    @GetMapping("/eliminar/{id}")
    public String eliminarImagen(@PathVariable Long id){
        Imagen imagen = repositorio.findById(id).get();
        try {
            Files.deleteIfExists(Path.of(imagen.getRuta()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repositorio.deleteById(id);
        return "redirect:/ej11/imagenes";
    }
}
