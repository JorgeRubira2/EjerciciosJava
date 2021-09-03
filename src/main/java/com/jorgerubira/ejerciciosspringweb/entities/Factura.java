/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Joche
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Factura")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //número de la factura
    
    private String nombre;
    private String direccion;
    private String nif;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;   //yyyy-MM-dd
    
    @OneToMany(mappedBy = "factura")    //Por defecto es carga pereza. Carga temprana -> fetch = FetchType.EAGER
    private List<DetallesFactura> facturas;
    
    
}
