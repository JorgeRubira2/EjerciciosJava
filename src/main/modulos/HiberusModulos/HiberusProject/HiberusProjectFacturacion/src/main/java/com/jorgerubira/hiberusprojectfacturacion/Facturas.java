/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.hiberusprojectfacturacion;

import com.jorgerubira.hiberusprojectclientes.interfaces.ClienteInterfaz;
import java.util.Optional;
import java.util.ServiceLoader;

public class Facturas {
   
    //public Cliente cliente; 
    public static void main(String[] args) {
        
        //Iterable<ClienteInterfaz> cliente=ServiceLoader.load(ClienteInterfaz.class);
        Optional<ClienteInterfaz> cliente=ServiceLoader.load(ClienteInterfaz.class).findFirst();
        if (cliente.isPresent()){
            cliente.get().saludar();
        }
        
        System.out.println("Hola");
    }
}
