
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio13CRUDFacturasService;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaLineaRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ejercicio13CRUDFacturasService implements IEjercicio13CRUDFacturasService {

    @Autowired
    private FacturaRepository facturaR;

    @Autowired
    private FacturaLineaRepository detalleFacturaR;

    // Con este método sacamos el total de la factura
    @Override
    public void totalPrecio(Integer id) {
        Factura factura = facturaR.findById(id).get(); // Sacamos el ID de la factura

        double totalPrecio = detalleFacturaR.findByFactura(factura).stream().mapToDouble(var1 -> var1.getPrecio())
                .sum(); // Del ID de la factura, sacamos todos los precios de las líneas y las sumamos
        factura.setTotal(totalPrecio); // Metemos el precio que hemos sacado antes en el total de la factura
        facturaR.save(factura); // Guardamos la factura
    }

}