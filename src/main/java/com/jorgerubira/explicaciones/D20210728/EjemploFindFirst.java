
package com.jorgerubira.explicaciones.D20210728;

import java.util.List;
import java.util.Optional;


class Persona4{
    private String nombre;
    private Optional<Compra2> compra=Optional.empty();

    public Persona4(String nombre) {
        this.nombre = nombre;
    }
    
    public Persona4(String nombre, Compra2 compra) {
        this.nombre = nombre;
        this.compra = Optional.ofNullable(compra);
    }

    public Optional<Compra2> getCompra() {
        return compra;
    }

    public String getNombre() {
        return nombre;
    }

}

class Compra2{
    private int totalProductos;
    private boolean pagado;

    public Compra2(int totalProductos, boolean pagado) {
        this.totalProductos = totalProductos;
        this.pagado = pagado;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public boolean isPagado() {
        return pagado;
    }
    
    public void pagar(){
        pagado=true;
    }
    
}

public class EjemploFindFirst {
    public static void main(String[] args) {
        List<Persona4> personas=List.of(
                    new Persona4("Ana", new Compra2(4, true)),
                    new Persona4("Juan"),
                    new Persona4("Pepe", new Compra2(2, false))
        );        
        Optional<Persona4> p= personas.stream()
                                     .filter(x->x.getCompra().isPresent())
                                     .findFirst();
        if (p.isPresent()){
            System.out.print(p.get().getNombre() + " ");
        }
        
        Optional<Persona4> pMasDe10= personas.stream()
                                            .filter(x->x.getCompra().isPresent())
                                            .filter(x->x.getCompra().get().getTotalProductos()>10)
                                            .findFirst();        
        
        System.out.println("Resultado");
        if (pMasDe10.isPresent()){
            System.out.print(pMasDe10.get().getNombre() + " ");
        }else{
            System.out.print("Nada ");
        }
            //Ana pulgar
            //Nada carita
            
        //Ana       Pulgar
        //Ana Pepe  Carita
    }
}
