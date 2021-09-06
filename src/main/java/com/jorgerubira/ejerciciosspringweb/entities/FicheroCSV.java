
package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ficherocsv")
public class FicheroCSV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cursoAcademico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipoCentro;
    private String tipoEstudio;
    private String plazasOferidas;
    private String plazasMatriculadas;
    private String indiceOcupacion;
    private String fechaActualizacion;
}
