package com.jorgerubira.explicaciones.D20210804.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

//Alt + Intro. implementar los metodos
@Service //Detecte Spring como que es un servicio.
public class GestorPersonasService implements IGestorPersonasService{
    
    private List<Persona> personas=new ArrayList<>();
    
    @Override
    public void nuevaPersona(Persona p) {
        personas.add(p);
    }
    @Override
    public List<Persona> getPersonas() {
        return personas;
    }
}
