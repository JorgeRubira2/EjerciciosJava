package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {

    // Debe devolver true si los dos enteros contienen el mismo valor.
    // Si no devuelve false
    // Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2) {
        try {
            return i1.equals(i2);
        } catch (Exception e) {
            return false;
}
    }

    // Debe devolver true si los dos enteros contienen el mismo valor.
    // Si no devuelve false
    // Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2) {
        try {
return Long.valueOf(i1).equals(i2);
        } catch (Exception e) {
            return false;
        }
    }

    // Debe devolver true si el texto que se ha enviado en un número.
    // Si no devuelve false
    // Si se envia null devuelve false
    public boolean comprobarNumero(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Debe devolver true si los dos números son iguales.
    // Si no devuelve false
    // Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2) {
        try {
            Optional<Integer> op = Optional.of(valor2);
return valor1.equals(op);
        } catch (Exception e) {
            return false;
        }
    }

    // Debe devolver true si los dos números son iguales.
    // Si no devuelve false
    // Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2) {
        try {
            Optional<Double> op = Optional.of(Double.valueOf(valor1.get()));
            return valor2.equals(op);
        } catch (Exception e) {
            return false;
        }
    }

}
