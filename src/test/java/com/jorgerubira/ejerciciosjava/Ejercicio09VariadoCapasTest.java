package test.java.com.jorgerubira.ejerciciosjava;

	import com.jorgerubira.ejerciciosjava.Ejercicio09VariadoCapas;
import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;

	import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
	import com.jorgerubira.ejerciciosjava.pojo.Compra;
	import com.jorgerubira.ejerciciosjava.pojo.Pair;
	import com.jorgerubira.ejerciciosjava.pojo.Persona;
	import com.jorgerubira.ejerciciosjava.pojo.Producto;
	import com.jorgerubira.ejerciciosjava.pojo.TipoProducto;

import java.time.Duration;
	import java.util.Date;
	import java.util.List;
	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	


	public class Ejercicio09VariadoCapasTest {
	    

	    private static final Date FECHA_DESDE=new Date(2000,01,01);
	    private static final Date FECHA_HASTA=new Date(2001,01,01);
	    private static final String CIUDAD="Madrid";
	    private static final int RND=(int)(Math.random()*10);
	    
	    private List<Compra> lc1=List.of(new Compra(RND, true),
	                    new Compra(5, false),
	                    new Compra(5, true)
	        );
	        
	    private List<Compra> lc2=List.of(
	                    new Compra(4, true),
	                    new Compra(1, true)
	        );

	    private List<Compra> lc3=List.of(new Compra(1, true),
	                    new Compra(4, true),
	                    new Compra(RND, true)
	    );
	    
	    private List<Compra> getConRetardo(List<Compra> lista){
	        try{
	            //Control de eficiencia.
	            //Incluimos un retardo de 500. Como hay 3 personas las consultas sin concurrencia tardarán 1500.
	            Thread.sleep(500); 
	        }catch(Exception e){}
	        return lista;
	    }

	    private List<Persona> listaPersonasExtensas=List.of(
	                    new Persona("Ana", "Zaragoza"),
	                    new Persona("Juan", "Madrid"),
	                    new Persona("Carlos", "Madrid"),
	                    new Persona("Alberto", "Madrid"),
	                    new Persona("Fran", "Zaragoza"),
	                    new Persona("Pepe", "Huesca")
	        );
	    
	    private List<Persona> listaPersonas=List.of(
	                    new Persona("Ana", "Madrid"),
	                    new Persona("Juan", "Madrid"),
	                    new Persona("Pepe", "Madrid")
	        );

	    private List<TipoProducto> tipos=List.of(
	                new TipoProducto(1, "Alimentacion"),
	                new TipoProducto(2, "Informatica"),
	                new TipoProducto(3, "Lujo"),
	                new TipoProducto(4, "Otros")
	        );
	    private List<Producto> prod=List.of(
	                new Producto(1, "Sandia", tipos.get(0), 5), //1
	                new Producto(2, "Teclado", tipos.get(1), 24),   //2
	                new Producto(3, "Anillo", tipos.get(2), 50),    //4
	                new Producto(4, "Periodico", tipos.get(3), 2)   //8
	        );
	        //hay 3 sandias = 3 puntos
	        //hay 3 teclados = 6 puntos
	        //hay 2 lujos= 8 puntos

	    private List<Compra> compras=List.of(   
	                    new Compra(List.of(prod.get(0))),   
	                    new Compra(List.of(prod.get(0),prod.get(2),prod.get(1))),   
	                    new Compra(List.of(prod.get(0),prod.get(2),prod.get(1),prod.get(1)))   
	        );

	    
	  

	    public Ejercicio09VariadoCapasTest(){
	        

	    }
	    
	    @Test
	    public void testBuscarCiudadesDePersonasNacidasEntreFechas() {
	
	     
	    }


	    @Test
	    public void testCalcularComprasDeUnaCiudad() {
	      
	        
	    }

	    @Test
	    public void testCalcularComprasDeUnaCiudadEntreFechas() {
	       
	    }

	    @Test
	    public void testCalcularImpuestoPorAduanaCompras() {
	      
	    }

	    @Test
	    public void testCalcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas() {
	       
	    }

	    @Test
	    public void calcularImpuestoPorTipoSegunAduanaDeComprasDeListaDePersonasEntreFechas() {
	       
	    }
	    
	}


