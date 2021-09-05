package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
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
@Entity  
@Table(name = "imagenes9")
public class Imagen9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String descripcion;
    private Date fechaHoraFichero;
    private String tipoImagen;
    private String orientacion;
    private String contenido;
    private String categoria;
    private String uso;
}
