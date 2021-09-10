
import com.jorgerubira.ejerciciosspringweb.entities.ImagenFichero;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenes {
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaR;
    
    @Autowired
    private ImagenRepository servicio;
    
    @GetMapping("/inicio")
    public String inicio(Model m, String des){
        if(des==null)
            m.addAttribute("imagen", servicio.findAll());
        else
            m.addAttribute("imagen", servicio.findByDescripcionContaining(des));
            
        return "/ej11/inicio";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile img, String des){
        int aux=img.getOriginalFilename().lastIndexOf(".");
        String ext=img.getOriginalFilename().substring(aux);
        String nombre=UUID.randomUUID().toString()+ext;
        servicio.save(new ImagenFichero(null, nombre, img.getOriginalFilename(), des));
        String ruta=rutaR+"\\ej11\\"+nombre;
        File f=new File(ruta);
        f.getParentFile().mkdirs();
        try{
            Files.copy(img.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "redirect:/ej11";
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        
        return "redirect:/ej11";
    }
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource> mostrar(String img){
        String ruta=rutaR+"\\ej11\\"+img;
        
        HttpHeaders header=new HttpHeaders();
        header.add("Content-Disposition", "attachment; filename=imagen.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        
        String tipo="image/";
        if(ruta.endsWith(".jpg"))
            tipo=tipo+".jpeg";
        else if(ruta.endsWith(".png"))
            tipo=tipo+".png";
        else if(ruta.endsWith(".svg"))
            tipo=tipo+".svg+xml";
        
        try{
            return ResponseEntity.ok()
                    .headers(header)
                    .contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType(tipo)) //Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
    
    @GetMapping("/borrar")
    public String borrar(Integer i){
        String nombre=servicio.findById(i).get().getNombre();
        String ruta=rutaR+"\\ej11\\"+nombre;
        servicio.deleteById(i);
        try{
            Files.deleteIfExists(Paths.get(ruta));
        }catch(IOException e){
            e.printStackTrace();
        }
        return "redirect:/ej11";
    }
}
