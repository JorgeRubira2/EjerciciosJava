/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import com.jorgerubira.ejerciciosspringweb.entities.FacturaLinea;

/**
 *
 * @author Jesus
 */
public interface IEjercicio13Factura {
    
    public Double total(FacturaEncabezado encabezado,FacturaLinea linea);
}
