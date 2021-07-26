/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.naves;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 * 
 */
public class TuAlgoritmoDeDecision implements IDecision {

    @Override
    public void decision(INave n, int segundos) {
        //velocidad <200
        //-20<angulo <20
      if(n.getAltura()==0){
          n.girarMando(30);
         n.setPropulsion(true);
       }
      if(n.getAltura()==150){
          n.setPropulsion(true);
      }
      if(n.getAltura()==300){
          n.girarMando(-40);
          n.setPropulsion(false);
      }
      if (n.getAltura()==300){
          n.girarMando(-20);
          n.setPropulsion(false);
      }
      
     // n.setPropulsion(false);
    }
    
}
