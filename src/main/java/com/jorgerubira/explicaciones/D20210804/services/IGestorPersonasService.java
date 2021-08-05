package com.jorgerubira.explicaciones.D20210804.services;

import java.util.List;

public interface IGestorPersonasService {
    public void nuevaPersona(Persona p);
    public List<Persona> getPersonas();
}
