package main.java.com.jorgerubira.explicaciones.D20210722b;


public interface Mecatronico extends Programador, Electronico{

    @Override
    public default void apagarYEncender() {     //Programador
        Programador.super.apagarYEncender();
    }
    
    /*@Override
    public void apagarYEncender();  //Electronico */ 
    
}
