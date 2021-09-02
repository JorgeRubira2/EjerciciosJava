
package com.jorgerubira.explicaciones.D20210830;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coche/v2")
public class DefinicionServicioRest {

    /*
    http://localhost:8080/coche
    http://localhost:8080/coche/2
    http://localhost:8080/coche/puertas/3/ruedas/4
    */
    
    //GET Leer datos 
    @GetMapping
    public List<Coche> allCoche(){
        return null;
    }
    
    //GET 
    @GetMapping("/{id}")
    public Coche getCoche(@PathVariable long id){
        return null;
    }
    
    //GET 
    @GetMapping("/puertas/{puertas}/ruedas/{ruedas}")
    public Coche getCoche2(@PathVariable long puertas, @PathVariable long ruedas){
        return null;
    }    
    
    //Insertar datos 
    @PostMapping
    public void guardar(Coche coche){
        
    }
    
    //Modificar datos 
    @PutMapping
    public void guardar2(Coche coche){
        
    }    

    //Borrado datos 
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable long id){
        
    }

}
