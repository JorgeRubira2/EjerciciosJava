/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13CrudService;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturasRepository;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josit
 */
@Service
public class Ejercicio13CrudService implements IEjercicio13CrudService{
    
    @Autowired
    private FacturasRepository repoFact;

    @Autowired
    private DetalleFacturaRepository repoDet;
    
    @Override
    public Double obtenerTotal(Integer idFactura) {
        Double total = 0d;
        List<DetalleFactura> det = repoDet.obtenerFacturas(idFactura);
        for (DetalleFactura detalleFactura : det) {
            total += detalleFactura.getImporte()*detalleFactura.getCantidad();
        }
        return total; 
    }
    
}
