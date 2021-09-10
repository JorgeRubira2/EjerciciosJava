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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas")
public class Facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private String nombre;
    private String direccion;
    private int nif;
    private Double total;

    @OneToMany(mappedBy = "factura")
    private List<LineasFacturas> lineasFacturas;

}
