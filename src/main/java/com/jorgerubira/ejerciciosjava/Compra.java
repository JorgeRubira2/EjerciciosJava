package main.java.com.jorgerubira.ejerciciosjava;

public class Compra {
	 private int totalArticulos;
	    private boolean carro;

	    public Compra(int totalArticulos, boolean carro) {
	        this.totalArticulos = totalArticulos;
	        this.carro = carro;
	    }

	    public int getTotalArticulos() {
	        return totalArticulos;
	    }

	    public void setTotalArticulos(int totalArticulos) {
	        this.totalArticulos = totalArticulos;
	    }

	    public boolean isCarro() {
	        return carro;
	    }

	    public void setCarro(boolean carro) {
	        this.carro = carro;
	    }
}
