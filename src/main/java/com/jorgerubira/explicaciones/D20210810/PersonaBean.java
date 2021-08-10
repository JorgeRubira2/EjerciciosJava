/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210810;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaBean {
    private Long id;
    private String nombre;
    private String apellido1;
    private String direccion;
}
