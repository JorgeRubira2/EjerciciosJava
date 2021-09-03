/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210902.relaciones.controllers;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Telefono;
import com.jorgerubira.explicaciones.D20210902.relaciones.repositorios.PersonaRepository;
import com.jorgerubira.explicaciones.D20210902.relaciones.repositorios.TelefonoRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/d20210902")
public class MiController {
    
    @Autowired
    private TelefonoRepository repTel;
    
    @Autowired
    private PersonaRepository repPer;    
    
    @GetMapping("/leerTelefono")
    @ResponseBody
    public String obtenerTelefono(){
        Telefono tel=repTel.findById(2).get();
        //return "Informacion:" + tel.getNumero() ; 
        return "Informacion:" + tel.getNumero() + " " + 
                                tel.getPersona().getNombre() + " " +
                                tel.getPersona().getApellidos() + " " +
                                tel.getPersona().getId(); 
    }
    
    @GetMapping("/leerPersona")
    @ResponseBody
    public String obtenerPersona(){
        Persona per=repPer.findById(1).get();
        
        return "Informacion:" + per.getNombre() + " " + per.getTelefonos().size();
    }
    
    @GetMapping("/verTodo")
    public String obtenerPersona(Model m){
        m.addAttribute("personas", repPer.findAll());
        return "d20210902/verPersonas";
    }
    
    @GetMapping("/accionGenerarDatos")
    @ResponseBody
    public String insertarEjemplo(Model m){
        ArrayList<Telefono> telefonos=new ArrayList<>();
        Persona p=new Persona(null, "Ana", "Perez", telefonos);
        telefonos.add(new Telefono(null, "4234234234", p));
        telefonos.add(new Telefono(null, "4242422", p));
        
        repPer.save(p);
        for (Telefono telefono : telefonos) {
            repTel.save(telefono);
        }
        return "Ok";
        
    }    


}
