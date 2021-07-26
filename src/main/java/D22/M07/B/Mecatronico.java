package D22.M07.B;


public interface Mecatronico extends Programador, Electronico{

    @Override
    public default void apagarYEncender() {     //Programador
        Programador.super.apagarYEncender();
    }
    
    /*@Override
    public void apagarYEncender();  //Electronico */ 
    
}
