/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D22.M07.A;

import java.util.ArrayList;
import java.util.List;



//Generico
public class Empresa<T extends Persona> {
    
    private T trabaja;
    //Comer en el salon //Pulgar
    //Comer youtube //Carita

    public T getTrabaja() {
        return trabaja;
    }
    
    public void contratar(T p){
        trabaja=p;
        //p.comer();      //Comer viendo youtube
    }
    
  
    //clase abstract no se puede hacer new.
    public static void main(String[] args) {
        Informatico pepe=new Informatico();
        Abogado ana=new Abogado();
        //Persona juan=new Persona();
        //Informatico fran=new Informatico();
        
        Empresa<Informatico> empr=new Empresa<>();
        //empr.contratar(juan);
        empr.contratar(pepe); 
        
        
        //------------------------------------------------
        //ETT
        
               
        
        
        Persona fran=new Informatico();  //Tiene que ser algo en la vida
        Abogado fran2=new Abogado();  //Tiene que ser algo en la vida
        Empresa<Persona> ett=new Empresa<>();
        ett.contratar(fran2);
        
        //Pulgar arriba -> Teclado
        //Carita -> Protestar
                
                
        
        
        
        //Persona
        Persona trabajador=empr.getTrabaja();
        //trabajador.comer();
        ((Informatico)trabajador).programar();
        

        //java.lang.ClassCastException
        
        
        
        
    }
    
}
