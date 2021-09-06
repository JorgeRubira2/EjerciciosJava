/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.hiberusprojectclientes.services;

import com.jorgerubira.hiberusprojectclientes.interfaces.ClienteInterfaz;

/**
 *
 * @author PC
 */
public class ClienteServicio implements ClienteInterfaz{

    @Override
    public void saludar() {
        System.out.println("Hola");
    }
    
}
