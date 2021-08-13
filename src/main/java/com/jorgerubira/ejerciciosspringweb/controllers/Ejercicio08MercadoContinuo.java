package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import com.jorgerubira.ejerciciosspringweb.entities.Bolsa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;
import com.jorgerubira.ejerciciosspringweb.repositories.BolsaRepository;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/ejercicio8")
public class Ejercicio08MercadoContinuo {
    
    @Autowired
    private IEjercicio08MercadoContinuoService mercadoContinuo;
    @Autowired
    private BolsaRepository bolsaService;
    
    @GetMapping
    public String inicio(Model m){
        m.addAttribute("bolsa",new Bolsa());
        return "/ej08/inicio";
    }
    
    @GetMapping("/listaCotizaciones")
    @ResponseBody
    public List<Cotizacion> mercadoContinuo() throws Exception{

        return mercadoContinuo.obtenerCotizaciones();
    }
    
    @PostMapping("/formulario")
    @ResponseBody
    public Bolsa compra(Bolsa b){
        return b;
    }
}
