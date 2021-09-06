package com.jorgerubira.ejerciciosspringweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalles")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;
    private Double importe;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
}
