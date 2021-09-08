
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaDetalle;
import org.springframework.stereotype.Service;

@Service
public class Ejercicio13DetalleService implements Ejercicio13IDetalleService{
    
    @Override
    public Double calcularTotal(FacturaDetalle detalles) {
        double total = 0;
        if(detalles == null){
            total = 0;
        }else{
           total+=detalles.getCantidad()*detalles.getImporte();   
        }
       
        return total;
    }
    
}
