package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Facturas;
import com.jorgerubira.ejerciciosspringweb.entities.LineasFacturas;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13CRUDFacturasService;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.LineasFacturasRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ej13")
public class Ejercicio13CRUDFacturas {

    @Autowired
    private FacturasRepository repoFactura;
    
    @Autowired
    private IEjercicio13CRUDFacturasService FacturasService;

    @Autowired
    private LineasFacturasRepository repoLineasFacturas;

    @GetMapping("/verFactura")
    public String verFactura(Model m) {
        m.addAttribute("Facturas", repoFactura.findAll());
        return "ej13/factura";
    }

    @GetMapping("/altaFactura")
    public String altaFacturas(Model m) {
        m.addAttribute("Factura", new Facturas());
        return "ej13/formularioFactura";
    }

    @GetMapping("/altaLineas")
    public String altaLineas(Model m, int id_factura) {
        LineasFacturas Lineas = new LineasFacturas();
        Lineas.setFactura(repoFactura.findById(id_factura).get());
        m.addAttribute("Lineas", Lineas);
        return "ej13/formularioLineasFactura";
    }

    @GetMapping("/editarFactura")
    public String editarFactura(Model m, int id) {

        Optional<Facturas> Facturas = repoFactura.findById(id);
        if (Facturas.isPresent()) {
            m.addAttribute("Facturas", Facturas.get());
        } else {
            return "redirect:verFactura";
        }
        return "ej13/formularioFactura";
    }

    @GetMapping("/editarLineas")
    public String editarLineas(Model m, int id) {
        m.addAttribute("Lineas", repoLineasFacturas.findById(id).get());
        return "ej13/formularioLineasFactura";
    }

    @PostMapping("/guardarFactura")
    public String guardarPersonas(Model m, Facturas factura) {
        repoFactura.save(factura);
        return "redirect:verFactura";
    }

    @PostMapping("/guardarLineas")
    public String guardarLineas(Model m, LineasFacturas lineas, int id_factura) {
        lineas.setFactura(repoFactura.findById(id_factura).get());
        repoLineasFacturas.save(lineas);
        FacturasService.calcularTotal(id_factura);
        return "redirect:editarLineas?id=" + id_factura;
    }

    @GetMapping("/borrarFactura")
    public String borrarFactura(Model m, int id) {
        repoFactura.deleteById(id);
        return "redirect:verFactura";
    }

    @GetMapping("/borrarLineas")
    public String borrarLineas(Model m, int id) {
        LineasFacturas lineas = repoLineasFacturas.findById(id).get();
        int id_factura = lineas.getFactura().getId();
        repoLineasFacturas.deleteById(id);
        FacturasService.calcularTotal(id_factura);
        return "redirect:editarFactura?id=" + id_factura;
    }
}
