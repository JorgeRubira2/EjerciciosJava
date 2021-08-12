package com.jorgerubira.explicaciones.D20210811;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface CancionRepository extends CrudRepository<Cancion, Integer>{
public interface CancionRepository extends JpaRepository<Cancion, Integer>{
    
    public List<Cancion> findByAutorIgnoreCaseContaining(String autor); 
    public List<Cancion> findByAutorOrTitulo(String autor, String titulo);
    public List<Cancion> findByAutorAndTitulo(String autor, String titulo);
    public List<Cancion> findAllByOrderByAutorDesc();
    
    //public int contarElemntor();
    
}
