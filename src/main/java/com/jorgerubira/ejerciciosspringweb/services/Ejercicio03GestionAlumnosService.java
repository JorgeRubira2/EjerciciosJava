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

    private List<Alumno> lista = new ArrayList<>();

    public Ejercicio03GestionAlumnosService() {
        //Añadimos varios nombres por defecto.
        lista.add(new Alumno(1, "Ana", "666666666", "Calle Inventada"));
        lista.add(new Alumno(2, "Pepe", "666666666", "Calle Inventada2"));
        lista.add(new Alumno(3, "Juan", "666666666", "Calle Inventada3"));
    }

    @Override
    public void guardarAlumno(Alumno alumno) {

        if (null==alumno) {
            
        }else{
             lista.add(alumno);
        }
           
    }

    @Override
    public void borrarAlumno(Long codigo) {
        for (Alumno a : lista) {
            if (a.getCodigo() == codigo) {
                lista.remove(a.getCodigo());
            }

        }
    }

    @Override
    public List<Alumno> getAlumnos() {
        return lista;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
      /*  Optional<Alumno> alumno;
         for (Alumno a : lista) {
             
            if (a.getCodigo() == codigo) {
                alumno=a;
            }

        }
         
         return alumno;*/
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
