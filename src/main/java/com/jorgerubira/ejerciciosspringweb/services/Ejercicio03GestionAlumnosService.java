package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.Collections;
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
       // Optional<Alumno> alu = listaAlumnos.stream().filter(x -> alumno.getCodigo());
        
       // Optional<Alumno> alu = alumno;
        
        //codigo = alumno.getCodigo();
        listaAlumnos.add(alumno);
        
        
        
//        if (alu!=null){ 
//            throw new NullPointerException();
//        }
//        if (listaAlumnos.stream().noneMatch(x->x.equals(alumno.getNombre()))){
//            alumno.add(alumno.getNombre());
//            
//        }else{
//            throw new OperacionEnListaException(alumno);
//        }
       
    }

    @Override
    public void borrarAlumno(Long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos() {
      //Devuelve una lista inmutable.
        return Collections.unmodifiableList(listaAlumnos);
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
