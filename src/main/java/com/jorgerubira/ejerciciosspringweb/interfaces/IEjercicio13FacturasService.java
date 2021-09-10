
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import java.util.List;

/**
 *
 * @author Isabel
 */
public interface IEjercicio13FacturasService {
    
    //Buscar líneas por idFactura
    List<DetalleFactura> findByFactura(Long idFactura);
}
