package com.jorgerubira.ejerciciosspringweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer id;
    private Date fecha;
    private String nombre;
    private String direccion;
    private String nif;
    private double total;

    @OneToMany(mappedBy = "factura")
    private List<FacturaLinea> linea;
}