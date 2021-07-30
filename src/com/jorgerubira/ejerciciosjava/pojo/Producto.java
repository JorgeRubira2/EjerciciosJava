package com.jorgerubira.ejerciciosjava.pojo;

public class Producto {
	 private long id;
	    private String nombre;
	    private TipoProducto familia;
	    private double precio;

	    public Producto(long id, String nombre, TipoProducto familia, double precio) {
	        this.id = id;
	        this.nombre = nombre;
	        this.familia = familia;
	        this.precio = precio;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public TipoProducto getFamilia() {
	        return familia;
	    }

	    public void setFamilia(TipoProducto familia) {
	        this.familia = familia;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }
	    
	    @Override
	    public boolean equals(Object obj) {
	        return id==((Producto)obj).id;
	    }
}
