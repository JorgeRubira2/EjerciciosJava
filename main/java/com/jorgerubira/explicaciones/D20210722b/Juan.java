package main.java.com.jorgerubira.explicaciones.D20210722b;

import main.java.com.jorgerubira.explicaciones.D20210722.Persona;


//Alt + Intro (Cursor final Clase)
public class Juan implements Informatico, Abogado  {

    @Override
    public void apagarYEncender() {
        System.out.println("Apagar y encender");
    }

    @Override
    public void pulsarTeclado() {
        System.out.println("Pulsar");
    }

    @Override
    public void protestar() {
        System.out.println("Protestar");
    }

    @Override
    public void irAJuicio(int tiempo) {
        System.out.println("irAJuicio");
    }


    
}
