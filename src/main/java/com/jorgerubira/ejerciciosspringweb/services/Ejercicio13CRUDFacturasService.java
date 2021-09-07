package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13CRUDFacturasService;
import com.jorgerubira.ejerciciosspringweb.repositories.DetalleRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ejercicio13CRUDFacturasService implements IEjercicio13CRUDFacturasService {

    @Autowired
    FacturaRepository fraRep;

    @Autowired
    DetalleRepository detRep;

    @Override
    public void calcularTotal(long idFactura) {
        Factura fra = fraRep.findById(idFactura).get();
        double total = detRep.findByFactura(fra).stream()
                .mapToDouble(d->d.getImporte())
                .sum();
        fra.setTotal(total);
        fraRep.save(fra);
    }
}
