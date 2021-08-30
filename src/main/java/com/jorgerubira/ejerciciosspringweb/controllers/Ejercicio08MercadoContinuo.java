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
import java.util.Optional;
import java.util.stream.Collectors;
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
            Cotiza cot = new Cotiza();
            m.addAttribute("cotiza",cot);
            m.addAttribute("saldo",0d);
        }else{
            m.addAttribute("cotiza",repoCotiza.findAll());
            m.addAttribute("saldo",obtenerSaldo());
        }
        return "/ej08/cotizar";
    }
    
    @GetMapping("/comprar")
    public String compra(Model m, String titulo, Double ultimo){
        m.addAttribute("titulo",titulo);
        m.addAttribute("ultimo",ultimo);
        return "/ej08/comprar";
    }
    @GetMapping("/vender")
    public String venta(Model m,Integer id, String titulo, Double ultimo, Integer cantidad){
        m.addAttribute("titulo",titulo);
        m.addAttribute("ultimo",ultimo);
        m.addAttribute("cantidad",cantidad);
        m.addAttribute("id",id);
        return "/ej08/vender";
    }
    
    @PostMapping("/comprar")
    public String comprar(Model m, String titulo, Double ultimo, Integer cantidad){
        Cotiza aux = new Cotiza();
        aux.setCantidad(cantidad);
        aux.setFechaOperacionInicio(new Date());
        aux.setPrecioInicial(ultimo);
        aux.setTipoOperacion("Compra");
        aux.setTitulo(titulo);  
        repoCotiza.save(aux);
        return "redirect:/ejercicio8";
    }
    
    @PostMapping("/vender")
    public String vender(Model m,Integer id, String titulo, Double ultimo){
        Optional<Cotiza> aux = repoCotiza.findById(id);
        aux.get().setFechaOperacionFinal(new Date());
        aux.get().setPrecioFinal(ultimo);
        aux.get().setTipoOperacion("Venta");
        repoCotiza.save(aux.get());
        
        return "redirect:/ejercicio8";
    }
    
    public Double obtenerSaldo(){
        var saldo = new Object(){ Double total = 0d; };
        List<Cotiza> aux = repoCotiza.findAll();
        aux.stream()
                .forEach(x->{
                        if("Compra".equalsIgnoreCase(x.getTipoOperacion())){
                            saldo.total = (-1)* (x.getCantidad()*x.getPrecioInicial()) + saldo.total;
                        }else{
                            saldo.total = (x.getCantidad()*x.getPrecioFinal()) + saldo.total;
                        }
                    });
        return saldo.total;
    }
}
