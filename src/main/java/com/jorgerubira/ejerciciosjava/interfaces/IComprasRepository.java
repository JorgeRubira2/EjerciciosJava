package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import java.util.List;


public interface IComprasRepository {
    
    List<Compra> obtenerComprasDeUnaPersona(String nombre);
    
}
