/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210902;

public class ModoAntiguo extends Thread{

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
        System.out.println("Inicio");
        ModoAntiguo ma=new ModoAntiguo();
        ModoAntiguo ma2=new ModoAntiguo();
        ma.start(); //Arrancar el hilo
        ma2.start(); //Arrancar el hilo
        System.out.println("Fin");
    }
    
    
}

