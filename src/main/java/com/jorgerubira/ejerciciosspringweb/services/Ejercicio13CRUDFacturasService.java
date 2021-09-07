/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEntity;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLineaEntity;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaLineaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author janus
 */
@Service
public class Ejercicio13CRUDFacturasService {

    @Autowired
    private FacturaRepository repoFactura;
    @Autowired
    private FacturaLineaRepository repoFacturaLinea;

    public void altaFactura(FacturaEntity factura) {
        repoFactura.save(factura);
        modificaFactura(factura);
    }

    public void bajaFactura(Integer id){
        repoFactura.deleteById(id);
    }
    
    public void modificaFactura(FacturaEntity factura) {
        Optional<FacturaEntity> fact = repoFactura.findById(factura.getId());
        Double suma = null;
        if (fact.isPresent()){
          suma =  fact.get().getListaFacturaLineas().stream().collect(Collectors.summingDouble(x-> x.getCantidad()*x.getImporte()));
        }else {
            try {
                throw new SQLException("datos en base de datos inconsistentes , factura: " + factura.getId() + " no encontrada");
            } catch (SQLException ex) {
                Logger.getLogger(Ejercicio13CRUDFacturasService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        factura.setTotalFinal(suma.floatValue());
        
        repoFactura.save(factura);
    }
    
    public FacturaEntity consultaFactura(FacturaEntity factura){
        return repoFactura.findById(factura.getId()).orElse(new FacturaEntity());
    }
    
    public FacturaEntity consultaFactura(Integer fact){
        return repoFactura.findById(fact).orElse(new FacturaEntity());
    }
    
    public void altaFacturaLinea(FacturaLineaEntity facturaLinea){
        repoFacturaLinea.save(facturaLinea);
        if (repoFactura.findById(facturaLinea.getFacturasId()).isPresent()){
            modificaFactura(repoFactura.findById(facturaLinea.getFacturasId()).get());
        };
    }
    
    public void bajaFacturaLinea (FacturaLineaEntity facturaLinea){
        repoFacturaLinea.deleteById(facturaLinea.getId());
        if (repoFactura.findById(facturaLinea.getFacturasId()).isPresent()){
            modificaFactura(repoFactura.findById(facturaLinea.getFacturasId()).get());
        };
    }
    
    public void modificaFacturaLinea (FacturaLineaEntity facturaLinea){
        altaFacturaLinea(facturaLinea);
    }
    
    public List<FacturaEntity> consultaFacturas(){
        return repoFactura.findAll();
    }
}
