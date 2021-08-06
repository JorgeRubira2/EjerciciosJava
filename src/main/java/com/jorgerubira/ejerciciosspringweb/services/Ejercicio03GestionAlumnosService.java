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
    
    private List<Alumno> listaAlumnos = new ArrayList<>();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        if(alumno == null){
            throw new NullPointerException();
        }
        if(listaAlumnos.stream().noneMatch(v1->v1.equals(alumno.getCodigo()))){
            listaAlumnos.add(alumno);
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        Optional<Alumno> alumno = listaAlumnos.stream()
                .filter(v1 -> v1.getCodigo() == codigo)
                .findAny();
        
        if(alumno.isPresent()){
         listaAlumnos.remove(alumno.get());
        }
    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
