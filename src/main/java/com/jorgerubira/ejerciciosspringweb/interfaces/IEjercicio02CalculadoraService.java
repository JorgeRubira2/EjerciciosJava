package com.jorgerubira.ejerciciosspringweb.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface IEjercicio02CalculadoraService {
    
    public Integer sumar(Integer a,Integer b);
    public Integer restar(Integer a,Integer b);
    public Integer multiplicar(Integer a,Integer b);
    public Integer dividir(Integer a,Integer b);
    
}
