/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210903.crud.entities; 

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Personas")
public class PersonaDia3 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String apellidos;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;   //yyyy-MM-dd
    
    @OneToMany(mappedBy = "persona")    //Por defecto es carga pereza. Carga temprana -> fetch = FetchType.EAGER
    private List<TelefonoDia3> telefonos;
    
    private Integer totalTelefonos;
    
}
