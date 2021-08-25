/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Jesus
 */
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
    

    public List<Imagen> findByCategoriaOrderByFechaHoraFichero(String categoria);
    public List<Imagen> findByDescripcionContainingOrderByFechaHoraFichero (String descripcion);
    public List<Imagen> findByCategoriaOrderByFechaHoraFicheroDesc(String categoria);
    public List<Imagen> findByDescripcionContainingOrderByFechaHoraFicheroDesc (String descripcion);
    public List<Imagen> findByCategoriaAndDescripcionContainingOrderByFechaHoraFichero (String categoria, String descripcion);
    public List<Imagen> findByCategoriaAndDescripcionContainingOrderByFechaHoraFicheroDesc (String categoria, String descripcion);

    public List<Imagen> findAllByOrderByFechaHoraFichero();
    public List<Imagen> findAllByOrderByFechaHoraFicheroDesc();
    
    //public List<Imagen> findByCategoriaAndTipoImagenAndOrientacionAndContenidoAndUso(String categoria, String tipoImagen, String orietnacion, String contenido, String uso);
}
