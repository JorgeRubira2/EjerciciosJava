
package com.jorgerubira.explicaciones.D20210903.crud.controllers;

import com.jorgerubira.explicaciones.D20210903.crud.entities.PersonaDia3;
import com.jorgerubira.explicaciones.D20210903.crud.entities.TelefonoDia3;
import com.jorgerubira.explicaciones.D20210903.crud.repositories.PersonaRepository;
import com.jorgerubira.explicaciones.D20210903.crud.repositories.TelefonoRepository;
import com.jorgerubira.explicaciones.D20210903.crud.services.ITelefonosService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/d20210903")
public class PersonasTelefonosController {
    
    @Autowired
    private PersonaRepository repoPer;
    
    @Autowired
    private ITelefonosService telefonoService;
    
    @Autowired
    private TelefonoRepository repoTel;

    @GetMapping("/verPersonas")
    public String verPersonas(Model m){
        m.addAttribute("personas", repoPer.findAll());
        return "d20210903/listado";
    }

    @GetMapping("/altaPersona")
    public String altaPersonas(Model m){
        m.addAttribute("persona", new PersonaDia3());
        return "d20210903/formPersona";
    }    

    @GetMapping("/altaTelefono")
    public String altaTelefono(Model m, int idPersona){
        TelefonoDia3 telefono=new TelefonoDia3();
        telefono.setPersona(repoPer.findById(idPersona).get());
        m.addAttribute("telefono", telefono);
        return "d20210903/formTelefono";
    }    
    
    @GetMapping("/editarPersona")
    public String editarPersonas(Model m, int id){
        
        //m.addAttribute("persona", repoPer.findById(id).orElse(new PersonaDia3()));    
        
        Optional<PersonaDia3> persona=repoPer.findById(id);
        if (persona.isPresent()){
            m.addAttribute("persona", persona.get());    
        }else{
            return "redirect:verPersonas";
        }
        return "d20210903/formPersona";
    }    

    @GetMapping("/editarTelefono")
    public String editarTelefono(Model m, int id){
        m.addAttribute("telefono", repoTel.findById(id).get());
        return "d20210903/formTelefono";
    }    

    @PostMapping("/guardarPersona")
    public String guardarPersonas(Model m, PersonaDia3 persona){
        repoPer.save(persona);
        //m.addAttribute("personas", repoPer.findAll());
        return "redirect:verPersonas";
    }    

    @PostMapping("/guardarTelefono")
    public String guardarTelefono(Model m, TelefonoDia3 telefono, int idPersona){
        telefono.setPersona(repoPer.findById(idPersona).get());
        repoTel.save(telefono);
        telefonoService.calcularTotalTelefonos(idPersona);

        //m.addAttribute("personas", repoPer.findAll());
        return "redirect:editarPersona?id=" + idPersona;
    }    

    @GetMapping("/borrarPersona")
    public String borrarPersona(Model m, int id){
        repoPer.deleteById(id);
        return "redirect:verPersonas";
    }    

    @GetMapping("/borrarTelefono")
    public String borrarTelefono(Model m, int id){
        TelefonoDia3 tel=repoTel.findById(id).get();
        int idPersona=tel.getPersona().getId();
        repoTel.deleteById(id);
        telefonoService.calcularTotalTelefonos(idPersona);
        return "redirect:editarPersona?id=" + idPersona;
    }    
    
}
