/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLinea;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13Factura;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaEncabezadoRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaLineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ej13")
public class Ejercicio13CRUDFacturas {
    
    @Autowired
    private FacturaEncabezadoRepository encaService;
    @Autowired
    private FacturaLineaRepository listaService;
    @Autowired
    private IEjercicio13Factura serviceFactura;
    
    
    
    @GetMapping
    public String inicio(Model m, Integer id_encabezado){
        if(id_encabezado==null){
            m.addAttribute("encabezado", new FacturaEncabezado());
        }else{
            m.addAttribute("encabezado", encaService.findById(id_encabezado).get());
        }
        m.addAttribute("listaId", encaService.findAllSelectId());
        return "/ej13/inicio";
    }
    
    @PostMapping("/guardarCabe")
    public String guardarCabecera(FacturaEncabezado encabezado){
        System.out.println(encabezado.getId());
        encaService.save(encabezado);
        return "redirect:/ej13?id_encabezado="+encabezado.getId();
    }
    @PostMapping("/lineaNueva")
    public String guardarLinea(FacturaLinea linea, Integer idEncabezado){
        FacturaEncabezado encabezado=encaService.findById(idEncabezado).get();
        linea.setEncabezado(encabezado);
        if(linea.getCantidad()==null){
            linea.setCantidad(0);
        }
        if(linea.getImporte()==null){
            linea.setImporte(0.0);
        }
        listaService.save(linea);
        encabezado.setTotal(serviceFactura.total(encabezado, linea));
        encaService.save(encabezado);
        return "redirect:/ej13?id_encabezado="+encabezado.getId();
    }
    @GetMapping("/borrar")
    public String borrar(Integer id){
        encaService.deleteById(id);
        return "redirect:/ej13";
    }
}
