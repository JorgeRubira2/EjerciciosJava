package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {
    
    private List<Alumno> alumnos = new ArrayList();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        
        if (alumnos.stream()
                .noneMatch(x -> x.equals(alumno.getCodigo()))) {
            alumnos.add(alumno);
        } else {
            
            var alum = alumnos.stream()
                    .filter(x -> x.getCodigo() == alumno.getCodigo())
                    .findFirst().get();
            
            alum.setDireccion(alumno.getDireccion());
            alum.setCodigo(alumno.getCodigo());
            alum.setNombre(alumno.getNombre());
            alum.setTelefono(alumno.getTelefono());
            //no pasa test
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void borrarAlumno(Long codigo) {
        
        alumnos.removeIf(x-> x.getCodigo()== codigo);
        

       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Alumno> getAlumnos() {
        
        return alumnos;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Alumno> getAlumnos(String buscar) {
        
       return alumnos.stream()
                .filter(x-> x.getNombre().equals(buscar))
               .collect(Collectors.toList());
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
