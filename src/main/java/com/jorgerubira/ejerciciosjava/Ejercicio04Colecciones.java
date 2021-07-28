package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class Ejercicio04Colecciones {
    
    /**
     * Si el valor no es negativo (>=0) insertarlo a la lista de destino.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnLista(long valor, List<Long> destino){
        if(valor>=0)
            destino.add(valor);
    }

    /**
     * Si no está la clave en el Map lo inserta. Si ya estuviese no hace nada.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnTabla(String clave, Integer valor, Map<String, Integer> destino){
        if(!destino.containsKey(clave))
            destino.put(clave,valor);
    }


    /**
     * Copiar los elementos positivos >=0 del Array Origen al Array Destino
     * No hace falta verificar si valen nulo.
     */
    public void copiar(List<Double> origen, List<Double> destino){
        for(Double d:origen){
            if(d>=0)
                destino.add(d);
        }
    }
    
    /**
     * Contar cuantos elementos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosEnSet(List<Integer> lista, Set<Integer> enLista){
        int cont=0;
        for(Integer i:lista){
            for(Integer j:enLista)
                if(i.equals(j))
                    cont++;
        }
        return cont;
    }
    
    /**
     * Contar cuantos elementos no repetidos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     * Pista. Al encontrar un elemento sacarlo del Set para que no lo vuelva a contar.
     */
    public int contarElementosEnSetNoRepetidos(List<Integer> lista, Set<Integer> enLista){
        int cont=0;
        for(Integer i:lista){
            for(Integer j:enLista)
                if(enLista.equals(i)){
                    enLista.remove(i);
                    cont++;
                }
                    
        }
        return cont;
    }    
    
    /**
     * Contar cuantos elementos del Hashtable son de tipo Integer.
     * Para comprobar si un valor es de tipo Integer utilizar instanceOf
     */
    public int contarIntegers(Map<String, Object> tabla){
        int cont=0;
        for(Object o:tabla.values()){
            if(o instanceof Integer)
                cont++;
        }
        return cont;
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Huesca.
     * No hace falta verificar si valen nulo.
     */
    public void borrarPersonasHuescaDeLista(List<Persona> listaPersonas){
        List<Persona> oscense=new LinkedList<>();
        for(Persona p:listaPersonas){
            if(p.getCiudad().equals("Huesca"))
                oscense.add(p);
        }
        listaPersonas.retainAll(oscense);
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Huesca.
     * No hace falta verificar si valen nulo.
     * 
     */
    public void borrarPersonasHuescaDeMapa(Map<String, Persona> listaPersonas){
        Map<String, Persona> oscense=new HashMap<>();
        for(String s:listaPersonas.keySet()){
            if(listaPersonas.get(s).getCiudad().equals("Huesca"))
                oscense.put(s,listaPersonas.get(s));
        }
        listaPersonas=oscense;
    }
    
    /**
     * Si la persona que va a ser atendida en la cola tiene menos de 5 artículos en la compra o no tiene compra, añadimos la persona personaNueva al final.
     * La persona tiene una compra como atributo pero puede valer null también si no tiene compra.
     * No hace falta verificar si valen nulo.
     * Pista: para ver que persona va a salir pero sin sacarla utilizar peek
     */    
    public void entrarPersonaALaCola(Queue<Persona> colaPersonas, Persona personaNueva){
        if(colaPersonas.peek()==null||personaNueva.getCesta().isEmpty()||personaNueva.getCesta().get().getTotalArticulos()<5)
            colaPersonas.add(personaNueva);
    }

    /**
     * Genera una Lista a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     * Pista: Utilizar el método Arrays.asList <<Devuelve una lista inmutable
     */    
    public List<Integer> generarLista(int valores[]){
        List<Integer> lista=new ArrayList();
        for(int a:valores){
            lista.add(a);
        }
        return lista;
    }
    
    /**
     * Genera un ArrayList a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     */    
    public ArrayList<Integer> generarArrayList(int valores[]){
        ArrayList<Integer> lista=new ArrayList();
        for(int a:valores){
            lista.add(a);
        }
        return lista;
    }

    /**
     * Devuelve el texto "Mineral" si el objeto está en el conjunto de minerales o "Organico" si esta en el conjunto de orgánico.
     * Devuelve "" si no es ni mineral y orgánico.
     * No hace falta verificar si valen nulo.
     */    
    public String catalogar(String objeto, Set<String> minerales, Set<String> organico){
        String s="";
        boolean m=minerales.contains(objeto);
        boolean org=organico.contains(objeto);
        if(m==true)
            s="Mineral";
        else if(org==true)
            s="Organico";
        return s;
    }    

    /**
     * Devuelve el Set donde se almacena que palabras sirven para nombrar frutas y colores.
     * No hace falta verificar si valen nulo.
     * Pista: Para la interseccion utilizar retainAll. 
     */    
    public Set<String> coincidencias(Set<String> frutas, Set<String> colores){
        Set<String> coin=new HashSet<>();
        coin.retainAll(frutas);
        coin.retainAll(colores);
        return coin;
    }        

    /**
     * Recibimos un Map con las notas de una lista de personas. En la clave se almacena el nombre de la persona y el valor es su nota
     * Se pide hacer un algoritmo que devuelva un List con los nombres de las peronas que han sacado >=5
     * No hace falta verificar si valen nulo.
     */    
    public List<String> aprobados(Map<String, Integer> notas){
        List<String> aprob=new ArrayList<>();
        for(String i:notas.keySet()){
            if(notas.get(i)>=5)
                aprob.add(i);
        }
        return aprob;
    } 

    
    /**
     * Devuelve un Map cuya clave es el nombre de la persona y el valor es el número de articulos totales que hay. 
     * Nota la persona puede aparecer varias veces en la lista, en ese caso se irá sumando 
     * No hace falta verificar si valen nulo.
     */    
    public Map<String, Integer> totalProductos(List<Persona> personas){
        Map<String,Integer> total=new TreeMap<>();
        for(Persona p:personas){
            total.put(p.getNombre(),p.getCesta().get().getTotalArticulos());
            if(total.containsKey(p.getNombre()))
                total.put(p.getNombre(),p.getCesta().get().getTotalArticulos()+p.getCesta().get().getTotalArticulos());
        }
        return total;
    }     
    
    
    /**
     * Añade multiples valores a la lista.
     * No hace falta verificar si valen nulo.
     */    
    public void annadirElementosMultiples(List<Integer> destino, int ... valores){
        for(int i:valores)
            destino.add(i);
    }

}
