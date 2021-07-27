package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Optional;

@FunctionalInterface
public interface IComparadorPersonaCompra {
    public boolean compararPersonaConCompra(Persona p, Optional<Compra> c);
}
