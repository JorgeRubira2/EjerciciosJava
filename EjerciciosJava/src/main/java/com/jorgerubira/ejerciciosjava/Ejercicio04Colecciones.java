
import java.util.ArrayList;
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
         destino.add(valor);
       
    }

    /**
     * Si no está la clave en el Map lo inserta. Si ya estuviese no hace nada.
     * No hace falta comprobar si destino es nulo.
     */
    public void insertarElementoEnTabla(String clave, Integer valor, Map<String, Integer> destino){
        destino.put(clave,valor);
    }


    /**
     * Copiar los elementos positivos >=0 del Array Origen al Array Destino
     * No hace falta verificar si valen nulo.
     */
    public void copiar(List<Double> origen, List<Double> destino){
        Collections.copy(destino, origen);
    }
    
    /**
     * Contar cuantos elementos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     */
    public int contarElementosEnSet(List<Integer> lista, Set<Integer> enLista){
    	for (double elemento : origen) {
            if (elemento >= 0) {
                destino.add(elemento);
            }
        }
    }
    
    /**
     * Contar cuantos elementos no repetidos del List lista están en el Set. Devolver el resultado.
     * No hace falta verificar si valen nulo.
     * Pista. Al encontrar un elemento sacarlo del Set para que no lo vuelva a contar.
     */
    public int contarElementosEnSetNoRepetidos(List<Integer> lista, Set<Integer> enLista){
    	 int resultado = 0;
         for (int n = 0; n < lista.size(); n++) {
             if (enLista.contains(lista.get(n))) {
                 resultado++;
             }
         }
         return resultado;
    }    
    
    /**
     * Contar cuantos elementos del Hashtable son de tipo Integer.
     * Para comprobar si un valor es de tipo Integer utilizar instanceOf
     */
    public int contarIntegers(Map<String, Object> tabla){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Lisboa.
     * No hace falta verificar si valen nulo.
     */
    public void borrarPersonasHuescaDeLista(List<Persona> listaPersonas){
    	int contador = 0;

        for (Object o : tabla.values()) {
            if (o instanceof Integer) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Borrar todas las personas del Map que sean de la ciudad Lisboa.
     * No hace falta verificar si valen nulo.
     * 
     */
    public void borrarPersonasHuescaDeMapa(Map<String, Persona> listaPersonas){
    	for (int i = listaPersonas.size() - 1; i > 0; i--) {
            if ((listaPersonas.get(i)).getCiudad().equals("Huesca")) {
                {
                    listaPersonas.remove(i);
                }
            }

        }
    }
    
    /**
     * Si la persona que va a ser atendida en la cola tiene menos de 5 artículos en la compra o no tiene compra, añadimos la persona personaNueva al final.
     * La persona tiene una compra como atributo pero puede valer null también si no tiene compra.
     * No hace falta verificar si valen nulo.
     * Pista: para ver que persona va a salir pero sin sacarla utilizar peek
     */    
    public void entrarPersonaALaCola(Queue<Persona> colaPersonas, Persona personaNueva){
    	List<String> borrarPersonas = new ArrayList<>();
        for (String clave : listaPersonas.keySet()) {
            if ((listaPersonas.get(clave).getCiudad()).equals("Huesca")) {
                borrarPersonas.add(clave);
            }
        }
        for (int i = 0; i < borrarPersonas.size(); i++) {
            listaPersonas.remove(borrarPersonas.get(i));
        }
    }

    /**
     * Genera una Lista a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     * Pista: Utilizar el método Arrays.asList <<Devuelve una lista inmutable
     */    
    public List<Integer> generarLista(int valores[]){
    	Integer[] array = Arrays.stream(valores).boxed().toArray(Integer[]::new);

        List<Integer> lista = Arrays.asList(array);
        return lista;
    }
    
    /**
     * Genera un ArrayList a partir de un vector de datos primarios. 
     * No hace falta verificar si valen nulo.
     */    
    public ArrayList<Integer> generarArrayList(int valores[]){
    	ArrayList<Integer> miArrayList = new ArrayList();
        for (int i : valores) {
            miArrayList.add(i);
        }
        return miArrayList;
    }

    /**
     * Devuelve el texto "Mineral" si el objeto está en el conjunto de minerales o "Organico" si esta en el conjunto de orgánico.
     * Devuelve "" si no es ni mineral y orgánico.
     * No hace falta verificar si valen nulo.
     */    
    public String catalogar(String objeto, Set<String> minerales, Set<String> organico){
    	if (minerales.contains(objeto)) {
            return "Mineral";
        } else if (organico.contains(objeto)) {
            return "Organico";
        }
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
    	List<String> numaprobados = new ArrayList<>();
        for (Map.Entry<String, Integer> map : notas.entrySet()) {
            if (map.getValue() >= 5) {
                numaprobados.add(map.getKey());
            }
        }
        return numaprobados;
    } 

    
    /**
     * Devuelve un Map cuya clave es el nombre de la persona y el valor es el número de articulos totales que hay. 
     * Nota la persona puede aparecer varias veces en la lista, en ese caso se irá sumando 
     * No hace falta verificar si valen nulo.
     */    
    public Map<String, Integer> totalProductos(List<Persona> personas){
    	Map<String, Integer> miMapa = new HashMap<>();
        for (Persona p : personas) {
            if (miMapa.containsKey(p.getNombre())) {
            	miMapa.replace(p.getNombre(), miMapa.get(p.getNombre()) + p.getCesta().get().getTotalArticulos());
            } else {
            	miMapa.put(p.getNombre(), p.getCesta().get().getTotalArticulos());
            }
        }
        return miMapa;
    }     
    
    
    /**
     * Añade multiples valores a la lista.
     * No hace falta verificar si valen nulo.
     */    
    public void annadirElementosMultiples(List<Integer> destino, int ... valores){
        for(int i: valores) {
        	destino.add(i);
        }
    }

}