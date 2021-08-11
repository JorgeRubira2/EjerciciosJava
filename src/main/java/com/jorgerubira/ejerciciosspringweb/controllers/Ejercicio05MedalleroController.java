package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.MedallaAtleta;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaPais;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ej05")
public class Ejercicio05MedalleroController {

    @Autowired
    private IEjercicio05MedalleroService servicio;
    
    @GetMapping("/medallas")
    public String inicio(Model m){
        m.addAttribute("medallas",servicio.obtenerRankingPorPais());
        return "ej05/medallero";
    }
    @GetMapping("/deportistas")
    public String inicio2(Model m){
        m.addAttribute("medallas",servicio.obtenerRankingPorAlteta());
        return "ej05/deportistas";
    }
    
    @GetMapping("/jsonMedallas")
    @ResponseBody   //Json (no HTML)
    public List<String> listaMedallas(Model m, String pais, String medalla){
        //m.addAttribute("medallas",servicio.obtenerDeportesDeUnaMedalla(pais, medalla));
        return servicio.obtenerDeportesDeUnaMedalla(pais, medalla);
    }      
    @GetMapping("/jsonPersonas")
    @ResponseBody   //Json (no HTML)
    public List<MedallaAtleta> listaPersonas(Model m, String pais){
        //m.addAttribute("medallas",servicio.obtenerDeportesDeUnaMedalla(pais, medalla));
        return servicio.obtenerRankingPorAltetaPais(pais);
    }
}
