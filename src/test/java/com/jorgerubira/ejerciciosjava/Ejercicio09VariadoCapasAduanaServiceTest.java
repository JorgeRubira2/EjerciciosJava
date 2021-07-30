package com.jorgerubira.ejerciciosjava;

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
        Ejercicio09VariadoCapasAduanaService instance = new Ejercicio09VariadoCapasAduanaService();
        
        //2(alimentacion) *5€ + 3(informatica)* 10€ + 2(lujo)* 15€ + 1(otros)*10 + 15€ fijo
        assertEquals(15d+2*5+3*10+2*15+1*10, instance.calcularPrecioSegunAduanaDeListaDeProductos(comprasInformadas));
        //Compra no informada: 2 compras * 15€ + 9 * productos * 10 €
        assertEquals(15d*2+9*10, instance.calcularPrecioSegunAduanaDeListaDeProductos(comprasNoInformadas));
    }

    @Test
    public void testObtenerTiposDeLasCompras(){
        Ejercicio09VariadoCapasAduanaService instance = new Ejercicio09VariadoCapasAduanaService();
        
        //Si no esta informado debe enviarse una excepción.
        assertThrows(NoDatoDisponibleException.class, ()->instance.obtenerTiposDeLasCompras(comprasNoInformadas));

        try{
            List<TipoProducto> result = instance.obtenerTiposDeLasCompras(comprasInformadas);
            assertEquals(3, result.size());
            assertEquals(true, result.contains(tipos.get(0)));
            assertEquals(true, result.contains(tipos.get(1)));
            assertEquals(true, result.contains(tipos.get(2)));
            assertEquals(false, result.contains(tipos.get(3)));
        }catch(Exception e){
            fail("Excepción no controlada");
        }

    }

    @Test
    public void testCalcularPrecioSegunAduanaDeUnProducto() {
        Ejercicio09VariadoCapasAduanaService instance = new Ejercicio09VariadoCapasAduanaService();
        
        assertEquals(5d, instance.calcularPrecioSegunAduanaDeUnProducto(prod.get(0)));
        assertEquals(10d, instance.calcularPrecioSegunAduanaDeUnProducto(prod.get(1)));
        assertEquals(15d, instance.calcularPrecioSegunAduanaDeUnProducto(prod.get(2)));
        assertEquals(10d, instance.calcularPrecioSegunAduanaDeUnProducto(prod.get(3)));
    }
    
}
