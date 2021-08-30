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
            Cotiza cot = new Cotiza();
            cot.setSaldo(0d);
            m.addAttribute("cotiza",cot);
            m.addAttribute("saldo",cot.getSaldo());
        }else{
            m.addAttribute("cotiza",repoCotiza.findAll());
            m.addAttribute("saldo",repoCotiza.findFirstByOrderByIdDesc().getSaldo());
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
    public String venta(Model m, String titulo, Double ultimo, Integer cantidad){
        m.addAttribute("titulo",titulo);
        m.addAttribute("ultimo",ultimo);
        m.addAttribute("cantidad",cantidad);
        return "/ej08/vender";
    }
    
    @PostMapping("/comprar")
    public String comprar(Model m, String titulo, Double ultimo, Integer cantidad){
        Double actual;
        if (repoCotiza.findFirstByOrderByIdDesc() != null){
            actual = repoCotiza.findFirstByOrderByIdDesc().getSaldo();
        }else{
            actual = 0d;
        }
        if(repoCotiza.findByTitulo(titulo)!=null){
            Cotiza aux = repoCotiza.findByTitulo(titulo);
            Cotiza ult = repoCotiza.findFirstByOrderByIdDesc();
            aux.setCantidad(aux.getCantidad()+cantidad);
            ult.setSaldo(actual - (ultimo*cantidad));
            repoCotiza.save(aux);
            repoCotiza.save(ult);
        }else{
            Cotiza aux = new Cotiza();
            aux.setCantidad(cantidad);
            aux.setFechaOperacionInicio(new Date());
            aux.setPrecioInicial(ultimo);
            aux.setTipoOperacion("Compra");
            aux.setTitulo(titulo);  
            aux.setSaldo(actual - (ultimo*cantidad));  
            repoCotiza.save(aux);
        }
        return "redirect:/ejercicio8";
    }
    
    @PostMapping("/vender")
    public String vender(Model m, String titulo, Double ultimo, Integer cantidad){
        Cotiza ul = repoCotiza.findFirstByOrderByIdDesc();
        Cotiza aux = repoCotiza.findByTitulo(titulo);
        aux.setCantidad(cantidad);
        aux.setFechaOperacionFinal(new Date());
        aux.setPrecioFinal(ultimo);
        aux.setTipoOperacion("Venta");
        
        
        return "redirect:/ejercicio8";
    }
}
