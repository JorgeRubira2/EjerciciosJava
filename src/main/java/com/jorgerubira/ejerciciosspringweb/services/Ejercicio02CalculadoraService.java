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
         
    }

    @Override
    public Double multiplicar(Double a, Double b) {
        
         return a*b; 
       
              
    }

    @Override
    public Double dividir(Double a, Double b) {
        
         return a/b;
      
    }
    
}
