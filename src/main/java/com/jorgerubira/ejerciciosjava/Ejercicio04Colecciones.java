package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Ejercicio04Colecciones {
    
    /**
     * Si el valor no es negativo (>=0) insertarlo a la lista de destino.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnLista(long valor, List<Long> destino){
        if(valor>=0) destino.add(valor);
    }

    /**
     * Si no está la clave en el Map lo inserta. Si ya estuviese no hace nada.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnTabla(String clave, Integer valor, Map<String, Integer> destino){
       if(!destino.containsKey(clave)) destino.put(clave, valor);
    }


    /**
     * Copiar los elementos positivos >=0 del Array Origen al Array Destino
     * No hace falta verificar si valen nulo.
     */
    public void copiar(List<Double> origen, List<Double> destino){
       for (Double i:origen){
           if(i>=0){
               destino.add(i);
           }
       }
    }
    
    /**
     * Contar cuantos elementos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosEnSet(List<Integer> lista, Set<Integer> enLista){
        int resultado=0;
        for (int i=0;i<lista.size();i++){
            if(enLista.contains(lista.get(i)))resultado++;
        }
        return resultado;
    }
    
    /**
     * Contar cuantos elementos no repetidos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     * Pista. Al encontrar un elemento sacarlo del Set para que no lo vuelva a contar.
     */
    public int contarElementosEnSetNoRepetidos(List<Integer> lista, Set<Integer> enLista){
        int resultado=0;
        for (int i=0;i<lista.size();i++){
            if(enLista.contains(lista.get(i))){
                resultado++;
                enLista.remove(lista.get(i));
            }
        }
        return resultado;
    }    
    
    /**
     * Contar cuantos elementos del Hashtable son de tipo Integer.
     * Para comprobar si un valor es de tipo Integer utilizar instanceOf
     */
    public int contarIntegers(Map<String, Object> tabla){
        int resultado=0;
        for(String a:tabla.keySet()){
            if(tabla.get(a) instanceof Integer)resultado++;
        }
        return resultado;
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Lisboa.
     * No hace falta verificar si valen nulo.
     */
    public void borrarPersonasHuescaDeLista(List<Persona> listaPersonas){
        for(int i=listaPersonas.size()-1; i>=0; i--){
            if(listaPersonas.get(i).getCiudad().equals("Huesca")){
                listaPersonas.remove(i);
            }
        }
        
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Lisboa.
     * No hace falta verificar si valen nulo.
     * 
     */
    public void borrarPersonasHuescaDeMapa(Map<String, Persona> listaPersonas){
        ArrayList<String> aux=new ArrayList<>();
        for (String a:listaPersonas.keySet()){
            if(listaPersonas.get(a).getCiudad().equals("Huesca")){
                aux.add(a);
            }
        }
        for(String a:aux){
            listaPersonas.remove(a);
        }
       
    }
    
    /**
     * Si la persona que va a ser atendida en la cola tiene menos de 5 artículos en la compra o no tiene compra, añadimos la persona personaNueva al final.
     * La persona tiene una compra como atributo pero puede valer null también si no tiene compra.
     * No hace falta verificar si valen nulo.
     * Pista: para ver que persona va a salir pero sin sacarla utilizar peek
     */    
    public void entrarPersonaALaCola(Queue<Persona> colaPersonas, Persona personaNueva){
        //No entiendo bien que es lo que me pide
         throw new RuntimeException("Pendiente de hacer");

    }

    /**
     * Genera una Lista a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     * Pista: Utilizar el método Arrays.asList <<Devuelve una lista inmutable
     */    
    public List<Integer> generarLista(int valores[]){
        List<Integer> resultado=new ArrayList<>();
        for(int a:valores){
            resultado.add(Integer.valueOf(a));
        }
        return resultado;
        //Arrays.asList no funciona con primitivos. 
    }
    
    /**
     * Genera un ArrayList a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     */    
    public ArrayList<Integer> generarArrayList(int valores[]){
        ArrayList<Integer> resultado=new ArrayList<>();
        for(int a:valores){
            resultado.add(Integer.valueOf(a));
        }
        return resultado;
    }

    /**
     * Devuelve el texto "Mineral" si el objeto está en el conjunto de minerales o "Organico" si esta en el conjunto de orgánico.
     * Devuelve "" si no es ni mineral y orgánico.
     * No hace falta verificar si valen nulo.
     */    
    public String catalogar(String objeto, Set<String> minerales, Set<String> organico){
        if(minerales.contains(objeto)){
            return "Mineral";
        }
        else if(organico.contains(objeto)){
            return "Organico";
        }
        else
            return "";
    }    

    /**
     * Devuelve el Set donde se almacena que palabras sirven para nombrar frutas y colores.
     * No hace falta verificar si valen nulo.
     * Pista: Para la interseccion utilizar retainAll. 
     */    
    public Set<String> coincidencias(Set<String> frutas, Set<String> colores){
      frutas.retainAll(colores);
        return frutas;
    }        

    /**
     * Recibimos un Map con las notas de una lista de personas. En la clave se almacena el nombre de la persona y el valor es su nota
     * Se pide hacer un algoritmo que devuelva un List con los nombres de las peronas que han sacado >=5
     * No hace falta verificar si valen nulo.
     */    
    public List<String> aprobados(Map<String, Integer> notas){
        List<String> aprobados=new ArrayList<>();
        for(String a:notas.keySet()){
            if(notas.get(a)>=5){
                aprobados.add(a);
            }
        }
        return aprobados;
    } 

    
    /**
     * Devuelve un Map cuya clave es el nombre de la persona y el valor es el número de articulos totales que hay. 
     * Nota la persona puede aparecer varias veces en la lista, en ese caso se irá sumando 
     * No hace falta verificar si valen nulo.
     */    
    public Map<String, Integer> totalProductos(List<Persona> personas){
      /* Map<String, Integer> resultado=new HashMap<>();
        Integer a=0;
        for(Persona p:personas){
            if(p.getCesta().isPresent() || p.getCesta().get()!=null){
            a=p.getCesta().get().getTotalArticulos();
            if(resultado.containsKey(p.getNombre())){
                a+=resultado.get(p.getNombre());
                resultado.put(p.getNombre(), a);
            }
            else
                resultado.put(p.getNombre(), a);
            }
        }
        return resultado;*/
      throw new RuntimeException("Pendiente de hacer");
        
    }     
    
    
    /**
     * Añade multiples valores a la lista.
     * No hace falta verificar si valen nulo.
     */    
    public void annadirElementosMultiples(List<Integer> destino, int ... valores){
        for(int a:valores){
            destino.add(a);
        }
    }

}
