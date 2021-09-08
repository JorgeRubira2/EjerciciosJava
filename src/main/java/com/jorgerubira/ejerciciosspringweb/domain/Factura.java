/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    private String numeroFactura;
    private Date fecha;
    private String nombre;
    private String direccion; 
    private String NIF;
    private Double precioFinal;
  
    @OneToMany(mappedBy = "factura")
    private List<LineaFactura> lineaFactura;

    public Factura(String numeroFactura, Date fecha, String nombre, String direccion, String NIF, Double precioFinal, List<LineaFactura> lineaFactura) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.nombre = nombre;
        this.direccion = direccion;
        this.NIF = NIF;
        this.precioFinal = precioFinal;
        this.lineaFactura = lineaFactura;
    }



    
    
     
}
