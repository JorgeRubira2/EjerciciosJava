/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Joche
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DetallesFactura")
public class DetallesFactura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descripcion;
    private Double importe;
    
    @ManyToOne              //Por defect EAGER -> (fetch = FetchType.LAZY) Carga perezosa
    @JoinColumn(name = "id_factura")
    private Factura factura;
}
