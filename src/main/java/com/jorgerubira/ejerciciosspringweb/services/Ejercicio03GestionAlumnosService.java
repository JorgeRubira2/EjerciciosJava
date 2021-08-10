package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    private List<Alumno> alumnos = new ArrayList<>();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarAlumno(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> alumno = codigo.stream()
                .
        //El orElse de arriba es para que se trague los posibles nulos y los ponga a 0.
        return alumno;
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        List<Alumno> alumno = buscar.equals(alumno)
        return alumno;
    }
    
}
