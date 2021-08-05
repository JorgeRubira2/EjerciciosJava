package com.jorgerubira.ejerciciosspringweb.domain;


//@Data

public class Casilla {
    private Long id;
    private boolean oculto;
    private int valor;

    public Casilla(Long id, boolean oculto, int valor) {
        this.id = id;
        this.oculto = oculto;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOculto() {
        return oculto;
    }

    public void setOculto(boolean oculto) {
        this.oculto = oculto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
