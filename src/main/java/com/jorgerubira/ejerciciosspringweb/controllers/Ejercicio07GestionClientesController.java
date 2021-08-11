package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Cliente;
import com.jorgerubira.ejerciciosspringweb.repositories.ClientesRepository;
import java.util.Optional;
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
    
    
    
    
//    @GetMapping 
//    public String inicioClientes(Model m){
//        m.addAttribute("cliente", new Cliente());
//        return "ej07/formulario";
//    }
    /**
     * Debe devolver la vista ej07/lista con el atributo 'clientes' que sea la lista
     */
    @GetMapping
    public String lista(Model m){
        m.addAttribute("clientes", repoClientes.findAll());
        System.out.println(repoClientes.findAll());
        return "ej07/lista";
    }
    
    /**
     * Debe devolver la vista ej07/formulario con el atributo clientes que sea la lista
     */
    @GetMapping("/{id}")
    public String read(Model m, @PathVariable Long id){
        Optional<Cliente> cliente= repoClientes.findById(id);
        if (cliente.isPresent()){
            m.addAttribute("clientes",cliente.get());
        } else {
            m.addAttribute("clientes",new Cliente());
        }
        return "ej07/formulario";
    }

    /**
     * Debe devolver un JSON del alumno buscado
     */
    @GetMapping("/ajax/{id}")
    @ResponseBody 
    public Cliente readAjax(Model m, @PathVariable Long id){
        Optional<Cliente> cliente= repoClientes.findById(id);
        if (cliente.isPresent()){
             return cliente.get();
        } else {
             return new Cliente();
        }
    }

    /**
     * guardar el objeto en la base de datos y redireccionar a la lista
     */    
    @PostMapping
    public String save(Model m, Cliente alumno){
        repoClientes.save(alumno);
        return "redirect:ej07/lista";
    }    

    /**
     * Borrar el objeto con el id y redireccionar a la lista
     */    
    @GetMapping("/delete/{id}")
    public String delete(Model m, @PathVariable Long id){
        repoClientes.deleteById(id);
        return "redirect:ej07/lista";
    }    

}
