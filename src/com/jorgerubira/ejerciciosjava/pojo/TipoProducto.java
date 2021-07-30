package com.jorgerubira.ejerciciosjava.pojo;

import java.util.List;

public class TipoProducto {
	 private long id;
	    private String nombre;
	    private List<Producto> productos;

	    public TipoProducto(long id, String nombre) {
	        this.id = id;
	        this.nombre = nombre;
	        this.productos = productos;
	    }
	    
	    public TipoProducto(long id, String nombre, List<Producto> productos) {
	        this.id = id;
	        this.nombre = nombre;
	        this.productos = productos;
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

	    public List<Producto> getProductos() {
	        return productos;
	    }

	    public void setProductos(List<Producto> productos) {
	        this.productos = productos;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        return id==((TipoProducto)obj).id;
	    }
}
