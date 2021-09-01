package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;

public interface IEjercicio11GestionImagenes {

    public void guardarImagen(Imagen imagen);
    public void eliminarImagen(long id);
}
