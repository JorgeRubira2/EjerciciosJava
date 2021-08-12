package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="clientes")    //Poner las anotaciones que creas convenientes.
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String firstName;
    private String lastName;
    private String title;
    private String descripcion;
    private String primaryAccount;
    private String telefono;
    private String email;
    private String direccion;
    private String city;
    private String estado;
    private String country;
    private Integer codigoPostal;

    //poner aquí los campos que creas conveniente.
}
