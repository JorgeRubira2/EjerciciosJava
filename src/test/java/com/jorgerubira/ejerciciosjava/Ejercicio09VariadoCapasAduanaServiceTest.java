package test.java.com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.Ejercicio09VariadoCapasAduanaService;
import com.jorgerubira.ejerciciosjava.excepciones.NoDatoDisponibleException;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Producto;
import com.jorgerubira.ejerciciosjava.pojo.TipoProducto;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio09VariadoCapasAduanaServiceTest {
    
    public Ejercicio09VariadoCapasAduanaServiceTest() {
    }

    
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

    private List<Compra> comprasInformadas=List.of(   
                    new Compra(List.of(prod.get(0))),   
                    new Compra(List.of(prod.get(0),prod.get(2),prod.get(1))),   
                    new Compra(List.of(prod.get(3),prod.get(2),prod.get(1),prod.get(1)))   
        );
        
    private List<Compra> comprasNoInformadas=List.of(   
                    new Compra(1,true),   
                    new Compra(2,true),
                    new Compra(3,true),
                    new Compra(3,true)
        );            
    
    @Test
    public void testCalcularPrecioSegunAduanaDeListaDeProductos() {
        
    }

    @Test
    public void testObtenerTiposDeLasCompras(){
        
    }

    @Test
    public void testCalcularPrecioSegunAduanaDeUnProducto() {
       
    }
    
}