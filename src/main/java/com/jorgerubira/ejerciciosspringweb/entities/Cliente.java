package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity     //Poner las anotaciones que creas convenientes.
@Table(name ="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;    //Poner las anotaciones
    private String nombre;
    private String apellidos;
    private String titulo;
    private String email;
    private String telefono;
    private String cuenta;
    private String descripcion;
    private String calle;
    private String ciudad;
    private String estado;
    private String pais;
    private Integer postal;
}
