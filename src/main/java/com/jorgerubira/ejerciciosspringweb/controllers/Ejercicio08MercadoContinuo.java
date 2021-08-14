package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import com.jorgerubira.ejerciciosspringweb.entities.Cotiza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;
import com.jorgerubira.ejerciciosspringweb.repositories.CotizacionRepository;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/ejercicio8")
public class Ejercicio08MercadoContinuo {
    
    @Autowired
    private IEjercicio08MercadoContinuoService mercadoContinuo;
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private CotizacionRepository repoCotiza;
    
    @GetMapping("/listaCotizaciones")
    @ResponseBody
    public List<Cotizacion> mercadoContinuo() throws Exception{

        return mercadoContinuo.obtenerCotizaciones();
    }
    
    @GetMapping
    public String inicio(Model m){
        if(repoCotiza.findAll().isEmpty()){
            m.addAttribute("cotiza",new Cotiza());
        }else{
            m.addAttribute("cotiza",repoCotiza.findAll());
        }
        return "/ej08/cotizar";
    }
    
    @GetMapping("/comprar")
    public String compra(Model m, String titulo, Double ultimo){
        m.addAttribute("titulo",titulo);
        m.addAttribute("ultimo",ultimo);
        return "/ej08/comprar";
    }
    @PostMapping("/comprar")
    public String comprar(Model m, String titulo, Double ultimo, Integer cantidad){
        if(repoCotiza.findByTitulo(titulo)!=null){
            Cotiza aux = repoCotiza.findByTitulo(titulo);
            aux.setCantidad(aux.getCantidad()+cantidad);
            repoCotiza.save(aux);
        }else{
            Cotiza aux = new Cotiza();
            aux.setCantidad(cantidad);
            aux.setFechaOperacionInicio(new Date());
            aux.setPrecioInicial(ultimo);
            aux.setTipoOperacion("Compra");
            aux.setTitulo(titulo);  
            repoCotiza.save(aux);
        }
        return "redirect:/ejercicio8";
    }
}
