package com.jorgerubira.ejerciciosspringweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private long id;
    private Integer numero;
    private String empresa;
    private String direccion;
    private String nif;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private double total;

    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles;
}
