
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
@Controller
@RequestMapping("/ej01")
public class Ejercicio01ListaNombresController {
    @Autowired
    private IEjercicio01ListaNombresService listaNombres;
    
    @GetMapping("/listaPersonas")
    public String lista(){   
        return "ej01/listaPersonas";
    }
    
    @PostMapping("/listaPersonas")
    public String listaInserta(Model m, String nombre, String accion){
        nombre = nombre.trim();
        try{
            if(nombre!=null && !nombre.isEmpty()){
                if(accion.equals("add")){
                    listaNombres.altaNombre(nombre); 
                }else if (accion.equals("del")){
                    listaNombres.bajaNombre(nombre);
                }
            }
        }catch(OperacionEnListaException e){
            m.addAttribute("error",true);
        }
        m.addAttribute("listaNombres",listaNombres.getLista());
        return "ej01/listaPersonas";
    }
}
