package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {
	private List<Alumno> alumno = new ArrayList<>();
	
    @Override
    public void guardarAlumno(Alumno alumno) {
       if(((Collection<Alumno>) alumno).stream()
    		   .noneMatch(x->x.equals(alumno.getCodigo()))) {
    	   ((List<Alumno>) alumno).add(alumno);
       }else {
    	   ((Collection<Alumno>) alumno).stream()
    	   .filter(x->x.getCodigo()== alumno.getCodigo())
    	   .findFirst().get();
       }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumno;
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
