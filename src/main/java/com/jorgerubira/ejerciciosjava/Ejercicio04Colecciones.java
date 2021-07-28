package com.jorgerubira.ejerciciosjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/**
 *
 * @author PC
 */
public class Ejercicio04Colecciones {

    /**
     * Si el valor no es negativo (>=0) insertarlo a la lista de destino. No
     * hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnLista(long valor, List<Long> destino) {
        if (valor >= 0) {
            destino.add(valor);
        }
    }

    /**
     * Si no está la clave en el Map lo inserta. Si ya estuviese no hace nada.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnTabla(String clave, Integer valor, Map<String, Integer> destino) {
        if (destino.isEmpty()) {
            destino.put(clave, valor);
        } else if (!destino.containsKey(clave)) {
            destino.put(clave, valor);
        }
    }

    /**
     * Copiar los elementos positivos >=0 del Array Origen al Array Destino No
     * hace falta verificar si valen nulo.
     */
    public void copiar(List<Double> origen, List<Double> destino) {
        for (int i = 0; i < origen.size(); i++) {
              if ( origen.get(i) >= 0 && destino.get(i) == null) {
                destino.add(i, origen.get(i));
              }
        }
    }

    /**
     * Contar cuantos elementos del List lista están en el Set. Devolver el
     * resultado. No hace falta verificar si valen nulo.
     */
    public int contarElementosEnSet(List<Integer> lista, Set<Integer> enLista) {
        int contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (enLista.contains(lista.get(i))) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Contar cuantos elementos no repetidos del List lista están en el Set.
     * Devolver el resultado. No hace falta verificar si valen nulo. Pista. Al
     * encontrar un elemento sacarlo del Set para que no lo vuelva a contar.
     */
    public int contarElementosEnSetNoRepetidos(List<Integer> lista, Set<Integer> enLista) {
        int contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (enLista.contains(lista.get(i))) {
                contador++;
                enLista.remove(lista.get(i));
            }
        }
        return contador;
    }

    /**
     * Contar cuantos elementos del Hashtable son de tipo Integer. Para
     * comprobar si un valor es de tipo Integer utilizar instanceOf
     */
    public int contarIntegers(Map<String, Object> tabla) {
        int contador = 0;
        for (Map.Entry<String, Object> entrada : tabla.entrySet()) {
            if (entrada.getValue() instanceof Integer) {
                contador++;
            }

        }
        return contador;
    }

    /**
     * Borrar todas las personas del List que sean de la ciudad Huesca . No hace
     * falta verificar si valen nulo.
     */
    public void borrarPersonasHuescaDeLista(List<Persona> listaPersonas) {
        for (int i = listaPersonas.size() - 1; i >= 0; i--) {
            if (listaPersonas.get(i).getCiudad().equalsIgnoreCase("Huesca")) {
                listaPersonas.remove(listaPersonas.get(i));
            }
        }
    }

    /**
     * Borrar todas las personas del Map que sean de la ciudad Lisboa. No hace
     * falta verificar si valen nulo.
     *
     */
    public void borrarPersonasHuescaDeMapa(Map<String, Persona> listaPersonas) {
        Set<Entry<String, Persona>> entradas = listaPersonas.entrySet();
        Iterator<Entry<String, Persona>> iterator = entradas.iterator();

        while (iterator.hasNext()) {
            Entry<String, Persona> entrada = iterator.next();
            Persona persona = entrada.getValue();
            if (persona.getCiudad().equalsIgnoreCase("Huesca")) {
                iterator.remove();
            }

        }
    }

    /**
     * Si la persona que va a ser atendida en la cola tiene menos de 5 artículos
     * en la compra o no tiene compra, añadimos la persona personaNueva al
     * final. La persona tiene una compra como atributo pero puede valer null
     * también si no tiene compra. No hace falta verificar si valen nulo. Pista:
     * para ver que persona va a salir pero sin sacarla utilizar peek
     */
    public void entrarPersonaALaCola(Queue<Persona> colaPersonas, Persona personaNueva) {

        if (colaPersonas.isEmpty()) {
            colaPersonas.add(personaNueva);
     
        } else if (colaPersonas.peek().getCesta().isEmpty() ||colaPersonas.peek().getCesta().get().getTotalArticulos() < 5  ) {
            colaPersonas.add(personaNueva);
        }
    }

    /**
     * Genera una Lista a partir de un vector de datos primarios. No hace falta
     * verificar si valen nulo. Pista: Utilizar el método Arrays.asList
     * <<Devuelve una lista inmutable
     */
    public List<Integer> generarLista(int valores[]) {
        //Integer[] vector = new Integer[valores.length];(OK)
        List<Integer> lista = new LinkedList<>();
        for (int i = 0; i < valores.length; i++) {
            //vector[i] = Integer.valueOf(valores[i]);(OK)
            lista.add(valores[i]);
        }
        //List<Integer> lista = Arrays.asList(vector);(OK)

        return lista;
    }

    /**
     * Genera un ArrayList a partir de un vector de datos primarios. No hace
     * falta verificar si valen nulo.
     */
    public ArrayList<Integer> generarArrayList(int valores[]) {
        ArrayList<Integer> lista = new ArrayList<>(valores.length);
        for (int valor : valores) {
            lista.add(valor);
        }
        return lista;
    }

    /**
     * Devuelve el texto "Mineral" si el objeto está en el conjunto de minerales
     * o "Organico" si esta en el conjunto de orgánico. Devuelve "" si no es ni
     * mineral y orgánico. No hace falta verificar si valen nulo.
     */
    public String catalogar(String objeto, Set<String> minerales, Set<String> organico) {
        if (minerales.contains(objeto)) {
            return "Mineral";
        } else if (organico.contains(objeto)) {
            return "Organico";
        }
        return "";
    }

    /**
     * Devuelve el Set donde se almacena que palabras sirven para nombrar frutas
     * y colores. No hace falta verificar si valen nulo. Pista: Para la
     * interseccion utilizar retainAll.
     */
    public Set<String> coincidencias(Set<String> frutas, Set<String> colores) {

        Set<String> coin = new HashSet<>();
        for (String color : colores) {
            if (frutas.contains(color)) {
                coin.add(color);

            }
        }
        return coin;
    }

    /**
     * Recibimos un Map con las notas de una lista de personas. En la clave se
     * almacena el nombre de la persona y el valor es su nota Se pide hacer un
     * algoritmo que devuelva un List con los nombres de las peronas que han
     * sacado >=5 No hace falta verificar si valen nulo.
     */
    public List<String> aprobados(Map<String, Integer> notas) {
        List<String> lista = new LinkedList<>();
        for (Entry<String, Integer> entrada : notas.entrySet()) {
            if (entrada.getValue() >= 5) {
                lista.add(entrada.getKey());
            }

        }
        return lista;
    }

    /**
     * Devuelve un Map cuya clave es el nombre de la persona y el valor es el
     * número de articulos totales que hay. Nota la persona puede aparecer
     * varias veces en la lista, en ese caso se irá sumando No hace falta
     * verificar si valen nulo.
     */
    public Map<String, Integer> totalProductos(List<Persona> personas) {
        Map<String, Integer> mapa = new HashMap<>();
        Integer total = 0;
        String nombre = "";
        for (Persona persona : personas) {
            nombre = persona.getNombre();
            if (persona.getCesta().isPresent()) {
                total = persona.getCesta().get().getTotalArticulos();
            }
            mapa.put(nombre, total);
        }
          
        return mapa;
    }

    /**
     * Añade multiples valores a la lista. No hace falta verificar si valen
     * nulo.
     */
    public void annadirElementosMultiples(List<Integer> destino, int... valores) {
        for (int valor : valores) {
            destino.add(valor);
        }
            
        
    }

}
