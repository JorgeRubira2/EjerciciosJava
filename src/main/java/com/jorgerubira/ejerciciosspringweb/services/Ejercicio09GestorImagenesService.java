/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.entities.Categoria;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio09GestorImagenesCategoriasService;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio09GestorImagenesImagenService;
import com.jorgerubira.ejerciciosspringweb.repositories.CategoriasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author janus
 */
@Service
public class Ejercicio09GestorImagenesService implements IEjercicio09GestorImagenesCategoriasService, IEjercicio09GestorImagenesImagenService{
    
    @Autowired
    private ImagenesRepository repoImagenes;
    @Autowired
    private CategoriasRepository repoCategorias;
    
    @Override
    public void altaCategoria(Categoria c) {
        repoCategorias.save(c);
    }

    @Override
    public List<Imagen> obtenerImagenes() {
        return repoImagenes.findAll();
    }

    @Override
    public void altaImagen(Imagen img) {
        repoImagenes.save(img);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return repoCategorias.findAll();
    }


}
