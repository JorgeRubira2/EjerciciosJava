package com.jorgerubira.ejerciciosspringweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturalinea")
public class FacturaLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreProducto;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;
}