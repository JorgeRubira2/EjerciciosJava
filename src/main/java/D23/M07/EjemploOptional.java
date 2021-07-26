/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D23.M07;

import java.util.Optional;

/**
 *
 * @author PC
 */

class Ciudad{
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj!=null){
            return nombre.equalsIgnoreCase(((Ciudad)obj).nombre);     
        }else{
            return false;     
        }
    }
}

class Repositorio{
    
    //Optional<Ciudad> -> El objeto esta de otro objeto.
    //get() -> Obtener el objeto de dentro. Ciudad.
    //isPresent() -> Si vale nulo o no boolean if(op.isPresent() ) - if(op.get()!=null ).
    
    Ciudad variable;
    
    public Optional<Ciudad> buscarCiudadEspanya(){
        Optional<Ciudad> elemento=Optional.empty();
        if(elemento.isEmpty()){ //No utilizar elemento.get()==null
            
        }
        
        //Optional.ofNullable(variable);
        
        return Optional.of(new Ciudad("Guadalajara"));   //Conecta contra la base de datos
        //        return new Ciudad("Guadalajara");   //Conecta contra la base de datos
        
    }
    
    public Optional<Ciudad> buscarCiudadMexico(){
        return Optional.empty();            //Null;
    }

}

public class EjemploOptional {


    public static void main(String[] args) {
        //Java 8. Optional 
        
        Repositorio rep=new Repositorio();
        Optional<Ciudad> c1=rep.buscarCiudadEspanya();
        Optional<Ciudad> c2=rep.buscarCiudadMexico();
        if (c1.equals(c2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("Son diferentes");
        }
        System.out.println(c1);
        System.out.println(c2);
        
        if (c1.isPresent()){        //c1.isEmpty
            Ciudad ciu=c1.get();    //Objeto
            ciu.getNombre();
        }
        if (c1.isEmpty()){
            System.out.println("c1 es nulo");
        }
        //JPA
        
        Ciudad ciu1=c1.orElseThrow();    //get
        
        Ciudad ciu2=c1.orElse(new Ciudad("Ciudad desconocida"));    //get. Null
        ciu2.getNombre();   //Guadalajara. Ciudad desco
        
        
        //Optional[Guadalajara]
        //Optional.empty
        
        //Son iguales Pulgar
        //Son diferentes Cara
        //Excepction Fiesta
    }
}
