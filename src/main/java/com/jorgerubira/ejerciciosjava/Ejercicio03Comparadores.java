package com.jorgerubira.ejerciciosjava;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Optional;

public class Ejercicio03Comparadores {

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2) {

        if (i1 != null && i2 != null && i1.equals(i2)) {
            return true;
        } else {
            return false;
        }
    }

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2) {

        if (i1 != null && i2 != null && i1.longValue() == i2.longValue()) {
            return true;
        } else {
            return false;
        }
    }

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero) {
        if (numero != null) {
            try {
                parseDouble(numero);
                return true;

            } catch (Exception E) {

            }

        }
        return false;

    }

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2) {

        if (valor1.isPresent() && valor2 != null) {

            if (valor1.get().equals(valor2)) {
                return true;

            } else {
                return false;
            }
        }
        return false;

    }

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2) {

        throw new RuntimeException("Pendiente de hacer");
    }

}
