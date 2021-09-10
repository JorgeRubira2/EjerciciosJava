package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity  
@Table(name = "interior_factura")
public class InteriorFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInterior;
    private Integer cantidad;
    private String descripcion;
    private Double importe;
    
    @ManyToOne              
    @JoinColumn(name = "id_factura")
    private Factura factura;
}