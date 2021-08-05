/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaKanban {

    private String codigo; //Se generará al azar al insertar. UUID.randomUUID().toString();
    private String descripcion; //Descripcion de la tarea
    private String propietario; //Persona que está realizando esta tarea.
    private Integer horasEstimacion; //Tiempo estimado en la tarea. Opcional
    private Integer horasTrabajadas; //Tiempo de trabajo en la tarea. 
    private String estado; //Roadmap (Pensada), Waiting (Se hace en breve), Working (Realizandose), Done (Finalizada). 
    
}
