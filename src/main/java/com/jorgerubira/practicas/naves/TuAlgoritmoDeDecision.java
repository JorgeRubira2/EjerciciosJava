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
        //la base entre 950,1050 de altura
        //velodicdad <200 para aterrizar && angulo entre -20 y 20 de angulo para aterrizar 

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
