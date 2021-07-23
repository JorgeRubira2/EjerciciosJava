
package com.jorgerubira.explicaciones.D20210722b;


public class Empresa<T> {
    
    public static final int AMARILLO=4;
    
    private T trabajadorHabitual;
    private Informatico informatico;

    public T getTrabajadorHabitual() {
        return trabajadorHabitual;
    }
    
    public void contratar(T trabajadorHabitual){
        this.trabajadorHabitual=trabajadorHabitual;
    }
    
    public void contratarInformatico(Informatico i){
        informatico=i;
    }
    
    public void estropearOrdenador(){
        informatico.apagarYEncender();
    }

    
    public static void main(String[] args) {
        Pepe pepe=new Pepe();   //Informatico
        Juan juan=new Juan();   //Informatico, Abogado.
        Ana ana=new Ana();   // Abogado.


        Empresa<Object> i=new Empresa<>();
        i.contratar(pepe);
        i.contratar(juan);
        //i.contratarInformatico(ana);
        
        Empresa<Object> em=new Empresa<>();
        em.contratar(pepe);
        em.contratar(juan);
        
    }
    
}
