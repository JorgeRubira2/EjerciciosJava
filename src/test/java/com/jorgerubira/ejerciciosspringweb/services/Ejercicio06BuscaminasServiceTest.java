/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Casilla;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio06BuscaminasServiceTest {
    
    public Ejercicio06BuscaminasServiceTest() {
    }

    @Test
    public void testEmpezarPartida() {
        Ejercicio06BuscaminasService instance = new Ejercicio06BuscaminasService();
        instance.empezarPartida();
        assertNotEquals(null, instance.getTablero());
        assertEquals(10, instance.getTablero().size());
        assertEquals(10, instance.getTablero().get(9).size());
        assertEquals(10L, instance.getTablero().stream().collect(
                                Collectors.summingLong(
                                     x-> x.stream().filter(y->y.getValor()==9).count()
                                )
                    ));
    }

    @Test
    public void testPulsarCasilla() {
        List<List<Casilla>> tablero=List.of(
             List.of(new Casilla(0L, true, 9), new Casilla(1L, true, 1), new Casilla(2L, true, 0)),
             List.of(new Casilla(10L, true, 1), new Casilla(11L, true, 1), new Casilla(12L, true, 0)),
             List.of(new Casilla(20L, true, 0), new Casilla(21L, true, 0), new Casilla(22L, true, 0))
        );
        Ejercicio06BuscaminasService instance = new Ejercicio06BuscaminasService();
        instance.setTablero(tablero);
        instance.setFilas(3);
        instance.setColumnas(3);
        instance.pulsarCasilla(11L);
        assertEquals(false, tablero.get(1).get(1).isOculto());
        assertEquals(true, tablero.get(2).get(1).isOculto());
        assertEquals(true, tablero.get(0).get(2).isOculto());
        assertEquals("Jugando", instance.getEstado());
        instance.pulsarCasilla(22L);
        assertEquals(false, tablero.get(0).get(2).isOculto());
        assertEquals(false, tablero.get(2).get(0).isOculto());
        assertEquals("Jugando", instance.getEstado());
        instance.pulsarCasilla(0L);
        assertEquals(false, tablero.get(0).get(1).isOculto());
        assertEquals("Game Over", instance.getEstado());
    }

}
