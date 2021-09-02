/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210902;


public class ModoAntiguoInterface implements Runnable{

    @Override
    public void run() {
        for (int n=0;n<10;n++){
            System.out.println(n);
            try{
                Thread.sleep((int)(Math.random()*20));
            }catch(Exception e){
            }
        }        
    }
    
    public static void main(String[] args) {
        ModoAntiguoInterface m=new ModoAntiguoInterface();
        Thread hilo=new Thread(m);
        Thread hilo2=new Thread(m);
        hilo.start();
        hilo2.start();
    }
    
}

