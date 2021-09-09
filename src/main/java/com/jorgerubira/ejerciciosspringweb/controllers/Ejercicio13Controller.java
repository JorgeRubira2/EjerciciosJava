package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.LineaFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jorgerubira.ejerciciosspringweb.domain.Factura;
import com.jorgerubira.ejerciciosspringweb.domain.LineaFactura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13Controller {

    @Autowired
    private FacturaRepository facturaRepository;
    private LineaFacturaRepository lineaFacturaRepository;

    public Date parsearFecha(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Ejercicio12Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fecha;

    }

    @GetMapping("/facturas")
    public String o() {
        return "ej13/facturas.html";

    }

    @PostMapping("addfactura")
    private String altaFactura(String numfactura, String fecha, String nombre, String direccion, String nif, Model model) {

        List<LineaFactura> lista = new ArrayList();

        try {
            Factura factura = new Factura(numfactura, parsearFecha(fecha), nombre, direccion, nif, 0.0, lista);

            facturaRepository.save(factura);
            model.addAttribute("correcto", "Se ha añadido correctamente");
            /* 
    int id = facturaRepository.findByNumeroFactura(numfactura);
   LineaFactura lineaFactura = new LineaFactura(id,cantidad, descripcion, importe, factura);
            lista.add(lineaFactura);
            
    lineaFacturaRepository.save(lineaFactura);*/
        } catch (Exception e) {
            model.addAttribute("error", "Ha ocurrido un error al insertar");

        }

        return "ej13/facturas.html";
    }

    @GetMapping("/verFacturas")
    public String lista(Model model) {

        model.addAttribute("listaFacturas", facturaRepository.findAll());

        return "ej13/verFacturas.html";
    }

    @GetMapping("/borrar") //URL A LLAMAR
    public String borrarAlumno(Model model, int id) {

        facturaRepository.deleteById(id);

        return "redirect:verFacturas";
    }

    @GetMapping("/modificar") //URL A LLAMAR 
    public String editarFactura(Model model, int id) {
        try {
            Optional<Factura> f = facturaRepository.findById(id);
            if (f.isPresent()) {
                model.addAttribute("factura", f);
                model.addAttribute("listaLineas", lineaFacturaRepository.findById(id));
            }

        } catch (Exception e) {
            model.addAttribute("errormodificado", "Ha ocurrido un error al modificado ");
        }
        return "ej13/editarFactura.html";
    }

    @PostMapping("altalinea")
    private String altaLinea(int id, int cantidad, String descripcion, int importe, Model model) {
        try {
            Optional<Factura> factura = facturaRepository.findById(id);
            if (factura.isPresent()) {
                LineaFactura lineaFactura = new LineaFactura((int)id, cantidad, descripcion, importe, factura.get());

                lineaFacturaRepository.save(lineaFactura);
            }
        } catch (Exception e) {
            model.addAttribute("error", "Ha ocurrido un error al insertar");

        }

        return "ej13/editarFactura.html"; 
    }

}
