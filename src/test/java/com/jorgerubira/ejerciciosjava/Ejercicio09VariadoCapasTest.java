package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;
import com.jorgerubira.ejerciciosjava.interfaces.IComprasRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IPersonasRepository;
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
import org.mockito.Mock;
import org.mockito.Mockito;


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

    
    @Mock private IPersonasRepository iperExtenso=Mockito.mock(IPersonasRepository.class);
    @Mock private IPersonasRepository iper=Mockito.mock(IPersonasRepository.class);
    @Mock private IComprasRepository icomConRetardo=Mockito.mock(IComprasRepository.class);
    @Mock private IComprasRepository icom=Mockito.mock(IComprasRepository.class);
    @Mock private IAduanaService iadu=Mockito.mock(IAduanaService.class);    
    @Mock private IAduanaService iaduCaso2=Mockito.mock(IAduanaService.class);
    @Mock private IComprasRepository icomCaso2=Mockito.mock(IComprasRepository.class);


    public Ejercicio09VariadoCapasTest(){
        //Mock iperExtenso. Lista larga de personas.
        Mockito.when(iperExtenso.buscarPersonaEntreFechas(FECHA_DESDE, FECHA_HASTA)).thenReturn(listaPersonasExtensas);
        //Mockito.when(iperExtenso.buscarPersonaEntreFechas(Mockito.anyVararg(), Mockito.anyVararg())).thenThrow(new Exception("Parametro incorrecto"));

        //Mock iper. Lista corta de personas.
        Mockito.when(iper.buscarPersonasDeUnaCiudad(CIUDAD)).thenReturn(listaPersonas);
        //Mockito.when(iper.buscarPersonasDeUnaCiudad(Mockito.any(String.class))).thenThrow(new Exception("Parametro incorrecto"));

        //Mock para probar rendimiento. streamParallel
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersona("Ana")) .thenReturn(getConRetardo(lc1));
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersona("Juan")) .thenReturn(getConRetardo(lc2));
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersona("Pepe")) .thenReturn(getConRetardo(lc3));
        //Mockito.when(icomConRetardo.obtenerComprasDeUnaPersona(Mockito.any(String.class))) .thenThrow(new Exception("Parametro incorrecto"));
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersonaEntreFechas("Ana", FECHA_DESDE, FECHA_HASTA)).thenReturn(getConRetardo(lc1)) ;
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersonaEntreFechas("Juan", FECHA_DESDE, FECHA_HASTA)).thenReturn(getConRetardo(lc2)) ;
        Mockito.when(icomConRetardo.obtenerComprasDeUnaPersonaEntreFechas("Pepe", FECHA_DESDE, FECHA_HASTA)).thenReturn(getConRetardo(lc3)) ;
        //Mockito.when(icomConRetardo.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class))).thenThrow(new Exception("Parametro incorrecto"));
        
        //Mock de pruebas básicas.
        Mockito.when(icom.obtenerComprasDeUnaPersona("Ana")) .thenReturn(lc1);
        Mockito.when(icom.obtenerComprasDeUnaPersona("Juan")) .thenReturn(lc2);
        Mockito.when(icom.obtenerComprasDeUnaPersona("Pepe")) .thenReturn(lc3);
        //Mockito.when(icom.obtenerComprasDeUnaPersona(Mockito.any(String.class))) .thenThrow(new Exception("Parametro incorrecto"));
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Ana", FECHA_DESDE, FECHA_HASTA)).thenReturn(lc1) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Juan", FECHA_DESDE, FECHA_HASTA)).thenReturn(lc2) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Pepe", FECHA_DESDE, FECHA_HASTA)).thenReturn(lc3) ;
        //Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class))).thenThrow(new Exception("Parametro incorrecto"));

        //Mock de calculo del servicio de la aduana
        Mockito.when(iadu.calcularPrecioSegunAduanaDeListaDeProductos(lc3)).thenReturn((double)((5+RND)*10));
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(0))).thenReturn(1d); //Alimentación
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(1))).thenReturn(2d); //Informatica
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(2))).thenReturn(4d); //Lujo
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(3))).thenReturn(8d); //Otros
        //Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(Mockito.any(Producto.class))).thenThrow(new Exception("Parametro incorrecto"));
        
        //Otra aduana que da otros importes.
        Mockito.when(iaduCaso2.calcularPrecioSegunAduanaDeListaDeProductos(lc1)).thenReturn(2d);        
        Mockito.when(iaduCaso2.calcularPrecioSegunAduanaDeListaDeProductos(lc2)).thenReturn(4d);        
        Mockito.when(iaduCaso2.calcularPrecioSegunAduanaDeListaDeProductos(lc3)).thenReturn(6d);  

        //Mock de compra caso 2. No haya muchos elementos para calcularlo más facilmente.
        Mockito.when(icomCaso2.obtenerComprasDeUnaPersonaEntreFechas("Ana", FECHA_DESDE, FECHA_HASTA)).thenReturn(List.of(compras.get(0),compras.get(1)));
        Mockito.when(icomCaso2.obtenerComprasDeUnaPersonaEntreFechas("Juan", FECHA_DESDE, FECHA_HASTA)).thenReturn(List.of(compras.get(0),compras.get(2)));
        Mockito.when(icomCaso2.obtenerComprasDeUnaPersonaEntreFechas("Pepe", FECHA_DESDE, FECHA_HASTA)).thenReturn(List.of(compras.get(1),compras.get(2))) ;
        //Mockito.when(icomCaso2.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class))).thenThrow(new Exception("Parametro incorrecto"));

    }
    
    @Test
    public void testBuscarCiudadesDePersonasNacidasEntreFechas() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iperExtenso, null, icom, iadu);
       
    }


    @Test
    public void testCalcularComprasDeUnaCiudad() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iper, null, icom, null) ;
    
    }

    @Test
    public void testCalcularComprasDeUnaCiudadEntreFechas() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iper, null, icom, null) ;
     
    }

    @Test
    public void testCalcularImpuestoPorAduanaCompras() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,null,iadu);
       
    }

    @Test
    public void testCalcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,icom,iaduCaso2);
       

    }

    @Test
    public void calcularImpuestoPorTipoSegunAduanaDeComprasDeListaDePersonasEntreFechas() {
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,icomCaso2,iadu) ;
        

    }
    
}
