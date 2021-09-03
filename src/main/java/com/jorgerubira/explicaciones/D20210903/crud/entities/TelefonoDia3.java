package com.jorgerubira.explicaciones.D20210903.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Telefonos")
public class TelefonoDia3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String numero;    
    
    @ManyToOne              //Por defect EAGER -> (fetch = FetchType.LAZY) Carga perezosa
    @JoinColumn(name = "id_persona")
    private PersonaDia3 persona;
}
