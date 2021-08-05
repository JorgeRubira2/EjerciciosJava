package com.jorgerubira.explicaciones.D20210804;
/*
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MiAnotacion{
}

class Clase1{
    
    @MiAnotacion
    public void saludar(){
        System.out.println("Hola");
    }
}

public class AlgoritmoReflexivo {
    
    public static void ejecutarMetodos(Clase1 obj) throws Exception{
        Class cls = obj.getClass();
        Method[] metodos=cls.getMethods();
        for (Method met:metodos){
            if (met.isAnnotationPresent(MiAnotacion.class) ){
                met.invoke(obj);    
            }
        }
    }
    
    public static void main(String[] args) {
        Clase1 c=new Clase1();
        try{
            ejecutarMetodos(c);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
*/