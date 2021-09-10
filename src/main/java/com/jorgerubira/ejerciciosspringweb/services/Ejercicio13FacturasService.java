
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13FacturasService;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleFacturaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isabel
 */
@Service
public class Ejercicio13FacturasService implements IEjercicio13FacturasService {
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    
    @Override
    public List<DetalleFactura> findByFactura(Long idFactura) {
        return detalleFacturaRepository.findByIdFactura(idFactura);
    }
}
