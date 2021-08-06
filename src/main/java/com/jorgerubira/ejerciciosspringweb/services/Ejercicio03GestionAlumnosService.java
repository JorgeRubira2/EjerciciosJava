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

    private List<Alumno> listaAlumnos = new ArrayList();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        
        
        
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setCodigo(alumno.getCodigo());
        nuevoAlumno.setNombre(alumno.getNombre());
        nuevoAlumno.setTelefono(alumno.getDireccion());
        nuevoAlumno.setDireccion(alumno.getDireccion());
        
     
    }

    @Override
    public void borrarAlumno(Long codigo) {
        Alumno alumno = new Alumno();
        alumno.getCodigo();
        
        borrarAlumno(codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
