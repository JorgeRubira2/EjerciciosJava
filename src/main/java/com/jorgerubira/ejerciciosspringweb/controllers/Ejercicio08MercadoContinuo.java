package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;

@Controller
@RequestMapping("/ejercicio8")
public class Ejercicio08MercadoContinuo {
    
    @Autowired
    private IEjercicio08MercadoContinuoService mercadoContinuo;
    
    @GetMapping("/listaCotizaciones")
    @ResponseBody
    public List<Cotizacion> mercadoContinuo() throws Exception{

        return mercadoContinuo.obtenerCotizaciones();
    }
    @GetMapping("/lista")
    public String lista (){
    return "ej08/listaCotizaciones";
            }
}
