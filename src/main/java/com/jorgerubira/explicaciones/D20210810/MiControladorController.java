/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210810;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/EjemploBean")
public class MiControladorController {
    
    @Autowired
    private List<PersonaBean> personas;  //Singleton

    //Leer con Ajax HTML
    @GetMapping("/lista")
    public String vista(Model m){
        m.addAttribute("personas", personas);
        return "d20210810/lista";
    }
    
    @GetMapping("/formulario")
    public String form(Model m, Long id){
        m.addAttribute("persona", personas.stream().filter(x->x.getId()==id).findFirst().get());
        return "d20210810/formulario";
    }   
    
    
    //Leer con Ajax HTML
    @GetMapping("/lista2")
    public String vista2(Model m){
        m.addAttribute("personas", personas);
        return "d20210810/lista2";
    }
    
    @GetMapping("/jsonPersona")
    @ResponseBody   //Json (no HTML)
    public PersonaBean personaJson(Model m, Long id){
        return personas.stream().filter(x->x.getId()==id).findFirst().get();
    }      
    
    
}
