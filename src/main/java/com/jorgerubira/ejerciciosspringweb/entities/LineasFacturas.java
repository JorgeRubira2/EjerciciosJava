/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lineas_facturas")
public class LineasFacturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    //private Integer idFactura;
    private Integer cantidad;
    private String descripcion;
    private Double importe;

    
     @ManyToOne        
    @JoinColumn(name = "id_factura")
    private Facturas factura;
}
