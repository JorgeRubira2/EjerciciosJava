package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Casilla;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio06BuscaminasService;

public class Ejercicio05BuscaminasService implements IEjercicio06BuscaminasService{

    private List<List<Casilla>> tablero;
    private String estado;
    
    @Override
    public void empezarPartida() {
        tablero=Arrays.asList(new List[10]);
        /*tablero.forEach(x->{
            x.addAll(Arrays.asList(new Casilla[10]))
        });*/
        
        /*for (int n=0;n<10;n++){
            List<Casilla> 
            for (int n=0;n<10;n++){
                
            }
        }*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pulsarCasilla(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<Casilla>> getTablero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCasillasDescubiertas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
