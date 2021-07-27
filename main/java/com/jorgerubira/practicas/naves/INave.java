/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jorgerubira.practicas.naves;

/**
 *
 * @author PC
 */
public interface INave {
    /**
     * @return Devuelve la altura de la nave
     */
    public int getAltura();

    /**
     * @return Indica los metros recorridos de la nave
     */
    public int getMetrosRecorridos();
    
    /**
     * @return Indica la velocidad que lleva la nave. 
     */
    public int getVelocidad();
    
    /**
     * @return Devuelve que angulo tiene la nave
     */
    public int getAngulo(); //0 arriba, positivo la nave gira a la derecha, negativo la nave gira a la izquierda.

    /**
     * @param angulo Valor máximo [-45,45] grados
     */
    public void girarMando(int angulo);

    /**
     * @param valor activa o desactiva la propulsión
     */
    public void setPropulsion(boolean valor);
    
    
    
}
