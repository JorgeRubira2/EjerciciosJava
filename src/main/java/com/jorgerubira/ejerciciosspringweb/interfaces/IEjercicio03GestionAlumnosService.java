
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface IEjercicio03GestionAlumnosService {
    
    /**
     * Busca el ID del alumno y si ya existe modifica el resto de campos (o lo sustituye)
     * si no está el ID lo inserta.
     */
    public void guardarAlumno(Alumno alumno);
    
    /**
     * Borra alumno del codigo indicado.
     * @param codigo
     */
    public void borrarAlumno(Long codigo);
    
    /**
     * Devuelve todos los alumnos
     */
    public List<Alumno> getAlumnos();
    
    /**
     * Devuelve la información del alumno del codigo indicado
     */
    public Optional<Alumno> getAlumno(Long codigo);    

    /**
     * Busca los alumnos filtrando por nombre 
     */
    public List<Alumno> getAlumnos(String buscar);
    
    
}
