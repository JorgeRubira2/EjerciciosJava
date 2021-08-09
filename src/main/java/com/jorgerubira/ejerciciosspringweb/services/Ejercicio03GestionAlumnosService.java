package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service

public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    private List<Alumno> alumnos=new ArrayList<>();
    
    public Ejercicio03GestionAlumnosService() {
        
        Alumno alumno = new Alumno();
        alumno.setCodigo(1);
        alumno.setNombre("Maria");
        alumno.setTelefono("722162789");
        alumno.setDireccion("calle");
        
        Alumno alumno2 = new Alumno();
        alumno2.setCodigo(2);
        alumno2.setNombre("Rosa");
        alumno2.setTelefono("789");
        alumno2.setDireccion("calle2");
        
        alumnos.add(alumno);
        alumnos.add(alumno2);
    }
   
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarAlumno(Long codigo) {
         for (int i=1;i<= alumnos.size() ;i++){
                if (alumnos.get(i).getCodigo() == codigo )
                    alumnos.remove(i);
            }
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos() {
        
        return alumnos;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
