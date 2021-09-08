package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio13CrudService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13CrudFacturasController {

    @Setter
    @Autowired
    private FacturasRepository repoFact;

    @Setter
    @Autowired
    private DetalleFacturaRepository repoDet;
    
    @Autowired
    private Ejercicio13CrudService crudService;

    @GetMapping
    public String inicio(Model m, String msg) {
        if (msg != null) {
            if (msg.toLowerCase().contains("error")) {
                m.addAttribute("error", msg);
            } else if (msg.toLowerCase().contains("exito")) {
                m.addAttribute("success", msg);
            }
        }

        if (repoFact.findAll().isEmpty()) {
            m.addAttribute("facturas", null);
        } else {
            m.addAttribute("facturas", repoFact.findAll());
        }

        return "/ej13/vista";
    }

    @GetMapping("/altaFactura")
    public String altaFacturas(Model m) {
        Factura fact = new Factura();
        fact.setFecha(new Date());
        m.addAttribute("factura", fact);
        return "/ej13/altafactura";
    }

    @PostMapping("/guardarFactura")
    public String guardarFacturas(Model m, Factura factura) {
        repoFact.save(factura);
        return "redirect:/ejercicio13";
    }
    @PostMapping("/guardarDetalles")
    public String guardarDetalles(Model m, DetalleFactura det, Integer idFactura) {
        Optional<Factura> aux = repoFact.findById(idFactura);
        if (aux.isPresent()){
            det.setFactura(aux.get());
            repoDet.save(det);
        }else{
            
        } 
        
        return "redirect:/ejercicio13/editarFactura?id=" + idFactura;
    }

    @GetMapping("/borrarFactura")
    public String borrar(Model m, Integer id) {
        Optional<Factura> borrar = repoFact.findById(id);
        String del = "";
        if (borrar.isPresent()){
            repoFact.delete(borrar.get());
            del = "Factura borrada con exito";
        }else{
            del = "Error al borrar factura";
        }

        return "redirect:/ejercicio13?msg=" + del;
    }
    
    @GetMapping("/borrarDetalle")
    public String borrarDetalle(Model m, Integer idDetalle) {
        Optional<DetalleFactura> borrar = repoDet.findById(idDetalle);
        Integer idFact = null;
        if (borrar.isPresent()){
            idFact = borrar.get().getFactura().getIdFactura();
            repoDet.delete(borrar.get());
            return "redirect:/ejercicio13/editarFactura?id=" + idFact;
        }else{
            return "redirect:/ejercicio13?msg=Error inesperado";
        } 
    }
    
    @GetMapping("/editarFactura")
    public String editarFacturas(Model m, Integer id, Integer idDetalle) {
        String msg = null;
        Optional<Factura> fact = repoFact.findById(id);
        List<DetalleFactura> det = fact.get().getFacturas(); //
        //List<DetalleFactura> det = repoDet.obtenerFacturas(id); //Con Query directa en repository
        if(fact.isPresent()){
            m.addAttribute("factura", fact.get());
            if (det.isEmpty()){
                m.addAttribute("nueva",new DetalleFactura());
                m.addAttribute("detalles",null);
            }else{
                if (idDetalle!=null){
                    m.addAttribute("nueva",repoDet.findById(idDetalle).get());
                    m.addAttribute("detalles",det);
                    m.addAttribute("total",crudService.obtenerTotal(id));
                }else{
                    m.addAttribute("nueva",new DetalleFactura());
                    m.addAttribute("detalles",det);
                    m.addAttribute("total",crudService.obtenerTotal(id));
                }
            }
        }else{
            return "redirect:/ejercicio13?msg=" + "Error al intentar editar factura";
        }
        return "/ej13/facturas";
    }
}
