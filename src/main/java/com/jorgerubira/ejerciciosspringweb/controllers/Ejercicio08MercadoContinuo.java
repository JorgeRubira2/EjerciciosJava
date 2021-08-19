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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
    public String inicio(Model m) {
        m.addAttribute("bolsa", new Bolsa());

        return "/ej08/inicio";
    }

    @GetMapping("/listaCotizaciones")
    @ResponseBody
    public List<Cotizacion> mercadoContinuo() throws Exception {
        return mercadoContinuo.obtenerCotizaciones();
    }

    @PostMapping("/formulario")
    @ResponseBody
    public Bolsa formulario(Bolsa b) {
        return b;
    }
    
    @PostMapping("/venta")
    public String venta(Model m, Bolsa b) {
        int sb=bolsaService.countSumaByTitle(b.getTitulo());
        m.addAttribute("titulosDisponibles",sb);
        m.addAttribute("bolsa", b);
        return "/ej08/venta";
    }

    @PostMapping("/compra")
    public String compra(Model m, String hora, String titulo, String operacion, Integer titulos, Double precio) {
        System.out.print(titulo + " " + operacion + " " + titulos + " " + precio);
        System.out.println(hora);
        Date date1 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", new Locale("es-ES"));
            date1 = sdf.parse(hora);
        } catch (ParseException ex) {
            System.err.print("error");
        }
        Bolsa b = new Bolsa(date1, titulo, operacion, titulos, precio);
        System.out.println(b.getTitulo());
        bolsaService.save(b);
        return "redirect:/ejercicio8";
    }

    @GetMapping("/cartera")
    @ResponseBody
    public List<Bolsa> cartera() {
        return bolsaService.findAll();
    }
}
