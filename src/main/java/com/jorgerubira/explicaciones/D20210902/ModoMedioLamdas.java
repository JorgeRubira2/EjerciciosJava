/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210902;

/**
 *
 * @author PC
 */
public class ModoMedioLamdas {
    
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    }
    
    public static void algoritmo2(){
        for (int n=6;n<10;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    }

    public static void main(String[] args) {
        Thread hilo=new Thread( ()-> algoritmo1() );
        Thread hilo2=new Thread( ()-> algoritmo2() );
        hilo.start();
        hilo2.start();
    }
}
