/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLinea;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13Factura;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jesus
 */
@Service
public class Ejercicio13FacturaService implements IEjercicio13Factura {

    @Override
    public Double total(FacturaEncabezado encabezado, FacturaLinea linea) {
        Double total;
        if(encabezado.getTotal()==null){
            total=0.0;
        }else{
            total=encabezado.getTotal();
        }
        if(linea.getCantidad()==null){
            linea.setCantidad(0);
        }
        if(linea.getImporte()==null){
            linea.setImporte(0.0);
        }
        total+=linea.getCantidad()*linea.getImporte();
        return total;
    }
    @Override
    public Double totalResto(FacturaEncabezado encabezado, FacturaLinea linea) {
        Double total;
        if(encabezado.getTotal()==null){
            total=0.0;
        }else{
            total=encabezado.getTotal();
        }
        if(linea.getCantidad()==null){
            linea.setCantidad(0);
        }
        if(linea.getImporte()==null){
            linea.setImporte(0.0);
        }
        total-=linea.getCantidad()*linea.getImporte();
        return total;
    }
    
    
}
