/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import java.util.List;

/**
 *
 * @author janus
 */

public interface IEjercicio09GestorImagenesImagenService {
    List<Imagen> obtenerImagenes();
    void altaImagen(Imagen img);

    
}
