
package com.jorgerubira.ejerciciosspringweb.entities;

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
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String numFactura;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    private String nombre; 
    private String direccion;
    private String nif;
    
    @OneToMany(mappedBy = "factura")
    private List<FacturaDetalle> detalle;//factura
    
    //private Double total;
}
