package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity     //Poner las anotaciones que creas convenientes.
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //Poner las anotaciones
    private String name;
    private String lastName;
    private String title;
    private String description;
    private String primaryAccount;
    private String phone;
    private String email;
    private String primaryAddress;
    private String city;
    private String country;
    private String state;
    private Integer postalCode;
}
