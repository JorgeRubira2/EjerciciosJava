package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/ejercicio8")
public class Ejercicio08MercadoContinuo {
    
    @Autowired
    private IEjercicio08MercadoContinuoService mercadoContinuo;
    
    @GetMapping("/listaCotizaciones")
    //@ResponseBody
    //public List<Cotizacion> mercadoContinuo(Model model) throws Exception{
    public String mercadoContinuo(Model model) throws Exception{
        model.addAttribute("datosMercado", mercadoContinuo.obtenerCotizaciones());
        return ("ej08/mercado");
    }
}
