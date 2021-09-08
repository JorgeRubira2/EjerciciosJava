package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ejercicio13")
public class Ejercicio13Controller {

    @Autowired
    private FacturaRepository facturaRepository; 

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
    private String altaFactura(Model model, String numfactura, String fecha, String nombre, String direccion, String nif, Double preciofinal) {
     List<LineaFactura> lista =new ArrayList();
 
        try {
            Factura factura = new Factura(numfactura, parsearFecha(fecha), nombre, direccion, nif, preciofinal, lista);
           
            facturaRepository.save(factura);
            model.addAttribute("correcto", "Se ha añadido correctamente");
        } catch (Exception e) {
            model.addAttribute("error", "Ha ocurrido un error al insertar");
        } 

        return "redirect:facturas";
    }

}
