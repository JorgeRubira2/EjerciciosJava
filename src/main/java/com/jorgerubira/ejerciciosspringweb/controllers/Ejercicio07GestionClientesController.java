package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Cliente;
import com.jorgerubira.ejerciciosspringweb.repositories.ClientesRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ejercicio7")
public class Ejercicio07GestionClientesController {
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private ClientesRepository repoClientes;
    
    /**
     * Debe devolver la vista ej07/lista con el atributo 'clientes' que sea la lista
     */
    @GetMapping
    public String lista(Model m){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Debe devolver la vista ej07/formulario con el atributo clientes que sea la lista
     */
    @GetMapping("/{id}")
    public String read(Model m, @PathVariable Long id){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Debe devolver un JSON del alumno buscado
     */
    @GetMapping("/ajax/{id}")
    @ResponseBody 
    public Cliente readAjax(Model m, @PathVariable Long id){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * guardar el objeto en la base de datos y redireccionar a la lista
     */    
    @PostMapping
    public String save(Model m, Cliente alumno){
        throw new RuntimeException("Pendiente de hacer");
    }    

    /**
     * Borrar el objeto con el id y redireccionar a la lista
     */    
    @GetMapping("/delete/{id}")
    public String delete(Model m, @PathVariable Long id){
        throw new RuntimeException("Pendiente de hacer");
    }    

}
