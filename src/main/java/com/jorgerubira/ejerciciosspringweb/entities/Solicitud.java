
package com.jorgerubira.ejerciciosspringweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Isabel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "solicitud_plazas")
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "curso_academico")
    private String cursoAcademico;
    private String estudio;
    private String localidad;
    private String centro;
    @Column(name = "tipo_centro")
    private String tipoCentro;
    @Column(name = "tipo_estudio")
    private String tipoEstudio;
    @Column(name = "plazas_ofertadas")
    private int plazasOfertadas;
    @Column(name = "plazas_matriculadas")
    private int plazasMatriculadas;
    @Column(name = "plazas_solicitadas")
    private int plazasSolicitadas;
    @Column(name = "indice_ocupacion")
    private Double indiceOcupacion;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    
}
