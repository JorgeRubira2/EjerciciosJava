package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.Casilla;
import java.util.List;

public interface IEjercicio06BuscaminasService {
   
    public void empezarPartida();
    public void pulsarCasilla(Long id);
    public List<List<Casilla>> getTablero();
    public int getCasillasDescubiertas();
    public String getEstado();  //Devuelve. {"Jugando", "Game Over", "Conseguido"}.
    
}
