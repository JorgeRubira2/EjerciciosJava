package com.jorgerubira.explicaciones.D20210728;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


class Persona3{
    private String nombre;
    private Optional<Compra> compra=Optional.empty();

    public Persona3(String nombre) {
        this.nombre = nombre;
    }
    
    public Persona3(String nombre, Compra compra) {
        this.nombre = nombre;
        this.compra = Optional.ofNullable(compra);
    }

    public Optional<Compra> getCompra() {
        return compra;
    }

    public String getNombre() {
        return nombre;
    }

}

class Compra{
    private int totalProductos;
    private boolean pagado;

    public Compra(int totalProductos, boolean pagado) {
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

public class EjemploStreamMap {
    
    public static void main(String[] args) {
        
        List<Persona3> personas=List.of(
                    new Persona3("Ana", new Compra(4, true)),
                    new Persona3("Juan"),
                    new Persona3("Pepe", new Compra(2, false))
        );
        
        List<Compra> comprasPersonas=personas.stream()
                                             .filter(x->x.getCompra().isPresent())
                                             .map(x->x.getCompra().get())
                                             .collect(Collectors.toList());

        comprasPersonas.stream()
                       .forEach(x->x.pagar());
        
        //hayAlguienConMasDeTresArticulos
        boolean masDe3=comprasPersonas.stream()
                                      .anyMatch(x->x.getTotalProductos()>3);
        if (masDe3==true){
            System.out.println("Si");
        }else{
            System.out.println("No");
        }
        //Si
        
        boolean masDe3b=personas.stream()
                                .filter(x->x.getCompra().isPresent())
                                .map(x->x.getCompra().get())
                                .anyMatch(x->x.getTotalProductos()>3);
        
        boolean masDe3c=personas.stream()
                                .filter(x->x.getCompra().isPresent())
                                .anyMatch(x->x.getCompra().get().getTotalProductos()>3);

        
        boolean sinCompra=personas.stream()
                                  .allMatch(x->x.getCompra().isEmpty());
        
        System.out.println(sinCompra);
    }
    
}
