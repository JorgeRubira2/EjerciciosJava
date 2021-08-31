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
@NoArgsConstructor
@AllArgsConstructor
public class Cotizacion {
    
    private String titulo;
    private double ultimo;
    private double variacion;
    private double variacionPorcentaje;
    private long volumen;
    private double maximo;
    private double minimo;
    private String hora;
           
}
