
package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity  
@Table(name = "cotizacion")
public class Cotiza {
    @Id
    private long id;
    private String titulo;
    private String tipoOperacion;
    private Integer cantidad;
    private Date fechaOperacionInicio;
    private Double precioInicial;
    private Date fechaOperacionFinal;
    private Double precioFinal;
    private Double saldo;
}
