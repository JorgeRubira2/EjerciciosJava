package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import org.springframework.stereotype.Service;

/**
 * Debe implementar Calculadora y ser un servicio @Service
 */
@Service
public class Ejercicio02CalculadoraService implements IEjercicio02CalculadoraService {

    @Override
    public Integer sumar(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer restar(Integer a, Integer b) {
        return a-b;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer multiplicar(Integer a, Integer b) {
       
        return a*b;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer dividir(Integer a, Integer b) {
       
        return a/b;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
