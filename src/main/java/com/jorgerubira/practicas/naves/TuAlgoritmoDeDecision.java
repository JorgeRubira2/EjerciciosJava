 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.naves;

/**
 *
 * @author PC
 */
public class TuAlgoritmoDeDecision implements IDecision {

    int currentAltura = 0;

    @Override
    public void decision(INave n, int segundos) { // esto se repite 
        //la base entre 950,1050 de latura
        //velodicdad <200 para aparcar
        //angulo entre -20 y 20 de angulo para aterrizar 
        //segundo 6 altura  parar que caiga en el angulo de 20 y velocidad??

        //TODOS: aterrizar nave
        //- 1º subir e inclinar nave
        // - poner recta nave y mantener
        // - frenar nave y mantener
        // - bajar 
        // 3 etapas ( iniciar mantener y aterrizar)
        n.setPropulsion(true);
        n.girarMando(20);
        if (n.getAltura() > 410) {
            n.setPropulsion(false);
            n.girarMando(-20);

            if (n.getAltura() == 650) {
                n.setPropulsion(true);

                n.girarMando(25);
            }

        }

    }
}
