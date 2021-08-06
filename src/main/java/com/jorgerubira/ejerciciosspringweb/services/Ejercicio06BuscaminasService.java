package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Casilla;
import java.util.ArrayList;
import java.util.List;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio06BuscaminasService;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class Ejercicio06BuscaminasService implements IEjercicio06BuscaminasService{

    @Setter
    private int filas=10;
    
    @Setter
    private int columnas=10;
    
    @Setter
    private List<List<Casilla>> tablero;
    
    private String estado;
    private int casillasDescubiertas;

    public Ejercicio06BuscaminasService(){
        empezarPartida();
    }
    
    @Override
    public void empezarPartida() {
        tablero=new ArrayList<>();
        for (int n=0;n<10;n++){
            ArrayList<Casilla> fila=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Casilla c=new Casilla((long)(n*10+i), true, 0);
                fila.add(c);
            }
            tablero.add(fila);
        }
        
        //Rellenar las minas
        for (int i = 0; i < 10; i++) {
            //Obtiene una celda al azar
            int fila=0,col=0;
            do{
                fila=(int)(Math.random()*10);
                col=(int)(Math.random()*10);
            }while(tablero.get(fila).get(col).getValor()==9);
            
            //Incrementa el valor del contorno
            tablero.get(fila).get(col).setValor(9);
            for (int f1=Math.max(0, fila-1);f1<=Math.min(fila+1,filas-1);f1++){
                for (int c1=Math.max(0, col-1);c1<=Math.min(col+1,columnas-1);c1++){
                    Casilla cas=tablero.get(f1).get(c1);
                    int val=cas.getValor();
                    if (val!=9){
                        cas.setValor(val+1);
                        cas.setId((long)(f1*10+c1));
                    }
                }
            }
        }
        estado="Jugando";
        casillasDescubiertas=0;
    }

    @Override
    public void pulsarCasilla(Long id) {
        int fila=id.intValue()/10;
        int col=id.intValue()%10;
        Casilla cas=tablero.get(fila).get(col);
        if (cas.isOculto()){
            cas.setOculto(false);
            casillasDescubiertas++;
            if (cas.getValor()==0){
                for (int f1=Math.max(0, fila-1);f1<=Math.min(fila+1,filas-1);f1++){
                    for (int c1=Math.max(0, col-1);c1<=Math.min(col+1,columnas-1);c1++){
                        pulsarCasilla((long)(f1*10+c1));
                    }
                }
                if (casillasDescubiertas==90){
                    estado="Conseguido";
                }
            }else if (cas.getValor()==9){
                tablero.stream().forEach(
                        x->x.stream().forEach(
                                c->c.setOculto(false)
                        )
                );
                estado = "Game Over";
            }
        }
    }

    @Override
    public List<List<Casilla>> getTablero() {
        return tablero;
    }

    @Override
    public int getCasillasDescubiertas() {
        return casillasDescubiertas;
    }

    @Override
    public String getEstado() {
        return estado;
    }
    
}
