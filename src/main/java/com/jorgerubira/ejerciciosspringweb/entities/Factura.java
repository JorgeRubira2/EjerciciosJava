
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

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity  
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;
    private Date fecha;
    private String nombre;
    private String nif;
    private Double totalFinal;
    
    @OneToMany(mappedBy = "idDetalle")    //Por defecto es carga pereza. Carga temprana -> fetch = FetchType.EAGER
    private List<DetalleFactura> facturas;
}
