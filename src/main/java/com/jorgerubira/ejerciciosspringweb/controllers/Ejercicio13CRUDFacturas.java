package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Detalle;
import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ej13")
public class Ejercicio13CRUDFacturas {

    @Autowired
    FacturaRepository fraRep;

    @Autowired
    DetalleRepository detRep;

    @GetMapping("/listado")
    public String verListado(Model m){
        m.addAttribute("facturas", fraRep.findAll());
        return "ej13/lista";
    }

    @GetMapping("/editarFactura")
    public String formularioFactura(Model m, Long idFactura){
        if(idFactura==null){
            m.addAttribute("factura", new Factura());
        } else {
            m.addAttribute("factura", fraRep.findById(idFactura).get());
        }
        return "/ej13/formularioFactura";
    }

    @PostMapping("/guardarFactura")
    public String guardarFactura(Factura factura){
        fraRep.save(factura);
        return "redirect:listado";
    }

    @GetMapping("/editarDetalle")
    public String anyadirDetalle(Model m, long idFactura, Long idDetalle){
        Detalle detalle = new Detalle();
        if(idDetalle==null){
            detalle.setFactura(fraRep.findById(idFactura).get());
        } else {
            detalle = detRep.findById(idDetalle).get();
        }
        m.addAttribute("detalle", detalle);
        return "/ej13/formularioDetalle";
    }

    @PostMapping("/guardarDetalle")
    public String guardarDetalle(Detalle detalle, long idFactura){
        detalle.setFactura(fraRep.findById(idFactura).get());
        detRep.save(detalle);
        return "redirect:editarFactura?idFactura=" + idFactura;
    }

    @GetMapping("/borrarDetalle")
    public String borrarDetalle(long idFactura, long idDetalle){
        detRep.deleteById(idDetalle);
        return "redirect:editarFactura?idFactura=" + idFactura;
    }

    @GetMapping("/borrarFactura")
    public String borrarFactura(long idFactura){
        List<Detalle> detalles = detRep.findByFactura(fraRep.findById(idFactura).get());
        detalles.stream()
                .forEach(d->detRep.deleteById(d.getId()));
        fraRep.deleteById(idFactura);
        return "redirect:listado";
    }

}
