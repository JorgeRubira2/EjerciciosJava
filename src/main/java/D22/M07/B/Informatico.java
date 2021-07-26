package D22.M07.B;

public interface Informatico {
    public int ROJO = 1;
    public int AZUL = 2;
    public int VERDE = 3;
    public default void apagarYEncender(){
        System.out.println("Pulsar el boton y encender");
    }
    public void pulsarTeclado();
}
