
package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fichero {
    String nombre;
    boolean directorio;
    String RutaAbsoluta;
}
