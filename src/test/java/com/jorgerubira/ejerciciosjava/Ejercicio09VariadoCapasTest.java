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
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;


public class Ejercicio09VariadoCapasTest {
    
    
    public Ejercicio09VariadoCapasTest() {
    }

    @Test
    public void testBuscarCiudadesDePersonasNacidasEntreFechas() {
        List<Persona> listaPersonas=List.of(
                    new Persona("Ana", "Zaragoza"),
                    new Persona("Juan", "Madrid"),
                    new Persona("Carlos", "Madrid"),
                    new Persona("Alberto", "Madrid"),
                    new Persona("Fran", "Zaragoza"),
                    new Persona("Pepe", "Huesca")
        );

        
        Date fechaDesde=new Date(2000,01,01);
        Date fechaHasta=new Date(2001,01,01);
        IPersonasRepository iper=Mockito.mock(IPersonasRepository.class);
        Mockito.when(iper.buscarPersonaEntreFechas(fechaDesde, fechaHasta)).thenReturn(listaPersonas);
        Mockito.when(iper.buscarPersonaEntreFechas(Mockito.any(Date.class), Mockito.any(Date.class))).thenThrow(new Exception("Parametro incorrecto"));

        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iper, null, null, null);
        List<Ciudad> result = instance.buscarCiudadesDePersonasNacidasEntreFechas(fechaDesde, fechaHasta);
        assertEquals(3, result.size());
        assertEquals("Madrid", result.get(0).getNombre());
        assertEquals(3, result.get(0).getPersonas());
        assertEquals("Zaragoza", result.get(1).getNombre());
        assertEquals(2, result.get(1).getPersonas());
        assertEquals("Huesca", result.get(2).getNombre());
        assertEquals(1, result.get(2).getPersonas());
    }

    @Test
    public void testCalcularComprasDeUnaCiudad() {
        List<Persona> listaPersonas=List.of(
                    new Persona("Ana", "Madrid"),
                    new Persona("Juan", "Madrid"),
                    new Persona("Pepe", "Madrid")
        );

        int random=(int)(Math.random()*10);
        List<Compra> lc1=List.of(
                    new Compra(random, true),
                    new Compra(5, false),
                    new Compra(5, true)
        );
        
        List<Compra> lc2=List.of(
                    new Compra(4, true),
                    new Compra(1, true)
        );

        List<Compra> lc3=List.of(
                    new Compra(1, true),
                    new Compra(4, true),
                    new Compra(random, true)
        );

        
        String ciudad="Madrid";
        IPersonasRepository iper=Mockito.mock(IPersonasRepository.class);
        Mockito.when(iper.buscarPersonasDeUnaCiudad(ciudad))
               .thenReturn(listaPersonas);
        Mockito.when(iper.buscarPersonasDeUnaCiudad(Mockito.any(String.class)))
               .thenThrow(new Exception("Parametro incorrecto"));
        
        IComprasRepository icom=Mockito.mock(IComprasRepository.class);
        Mockito.when(icom.obtenerComprasDeUnaPersona("Ana"))
               .thenReturn(lc1) ;
        Mockito.when(icom.obtenerComprasDeUnaPersona("Juan"))
               .thenReturn(lc2) ;
        Mockito.when(icom.obtenerComprasDeUnaPersona("Pepe"))
               .thenReturn(lc3) ;
        Mockito.when(icom.obtenerComprasDeUnaPersona(Mockito.any(String.class)))
               .thenThrow(new Exception("Parametro incorrecto"));
        
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iper, null, icom, null) ;
        Long result = instance.calcularComprasDeUnaCiudad(ciudad);
        assertEquals(20+2*random, result);
    }

    @Test
    public void testCalcularComprasDeUnaCiudadEntreFechas() {
        List<Persona> listaPersonas=List.of(
                    new Persona("Ana", "Madrid"),
                    new Persona("Juan", "Madrid"),
                    new Persona("Pepe", "Madrid")
        );

        int random=(int)(Math.random()*10);
        List<Compra> lc1=List.of(
                    new Compra(random, true),
                    new Compra(5, false),
                    new Compra(5, true)
        );
        
        List<Compra> lc2=List.of(
                    new Compra(4, true),
                    new Compra(1, true)
        );

        List<Compra> lc3=List.of(
                    new Compra(1, true),
                    new Compra(4, true),
                    new Compra(random, true)
        );

        
        String ciudad="Madrid";
        Date fechaDesde=new Date(2000,01,01);
        Date fechaHasta=new Date(2001,01,01);
        IPersonasRepository iper=Mockito.mock(IPersonasRepository.class);
        Mockito.when(iper.buscarPersonasDeUnaCiudad(ciudad))
               .thenReturn(listaPersonas);
        Mockito.when(iper.buscarPersonasDeUnaCiudad(Mockito.any(String.class)))
               .thenThrow(new Exception("Parametro incorrecto"));
        
        IComprasRepository icom=Mockito.mock(IComprasRepository.class);
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Ana", fechaDesde, fechaHasta))
               .thenReturn(lc1) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Juan", fechaDesde, fechaHasta))
               .thenReturn(lc2) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Pepe", fechaDesde, fechaHasta))
               .thenReturn(lc3) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class)))
               .thenThrow(new Exception("Parametro incorrecto"));
        
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(iper, null, icom, null) ;
        Long result = instance.calcularComprasDeUnaCiudad(ciudad);
        assertEquals(20+2*random, result);
    }

    @Test
    public void testCalcularImpuestoPorAduanaCompras() {
        int random=(int)(Math.random()*10);
        List<Compra> lc3=List.of(
                    new Compra(1, true),
                    new Compra(4, true),
                    new Compra(random, true)
        );

        IAduanaService iadu=Mockito.mock(IAduanaService.class);
        Mockito.when(iadu.calcularPrecioSegunAduanaDeListaDeProductos(lc3))
               .thenReturn((double)((5+random)*10));
        
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,null,iadu);
        Double result = instance.calcularImpuestoPorAduanaCompras(lc3);
        assertEquals((double)((5+random)*10), result);
    }

    @Test
    public void testCalcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas() {
        List<Persona> listaPersonas=List.of(
                    new Persona("Ana", "Madrid"),
                    new Persona("Juan", "Madrid"),
                    new Persona("Pepe", "Madrid")
        );

        int random=(int)(Math.random()*10);
        List<Compra> lc1=List.of(
                    new Compra(random, true),
                    new Compra(5, false),
                    new Compra(5, true)
        );
        
        List<Compra> lc2=List.of(
                    new Compra(4, true),
                    new Compra(1, true)
        );

        List<Compra> lc3=List.of(
                    new Compra(1, true),
                    new Compra(4, true),
                    new Compra(random, true)
        );

        Date fechaDesde=new Date(2000,01,01);
        Date fechaHasta=new Date(2001,01,01);

        IComprasRepository icom=Mockito.mock(IComprasRepository.class);
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Ana", fechaDesde, fechaHasta))
               .thenReturn(lc1) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Juan", fechaDesde, fechaHasta))
               .thenReturn(lc2) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Pepe", fechaDesde, fechaHasta))
               .thenReturn(lc3) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class)))
               .thenThrow(new Exception("Parametro incorrecto"));

        double total=(20+2*random)*10;
        IAduanaService iadu=Mockito.mock(IAduanaService.class);
        Mockito.when(iadu.calcularPrecioSegunAduanaDeListaDeProductos(lc1))
               .thenReturn(2d);        
        Mockito.when(iadu.calcularPrecioSegunAduanaDeListaDeProductos(lc2))
               .thenReturn(4d);        
        Mockito.when(iadu.calcularPrecioSegunAduanaDeListaDeProductos(lc3))
               .thenReturn(6d);        

        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,icom,iadu);
        Double result = instance.calcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas(listaPersonas, fechaDesde, fechaHasta);
        assertEquals(12d, result);
        Mockito.verify(iadu).calcularPrecioSegunAduanaDeListaDeProductos(lc1); //Verificación que se está llamando a este método.
        Mockito.verify(iadu).calcularPrecioSegunAduanaDeListaDeProductos(lc2); //Verificación que se está llamando a este método.
        Mockito.verify(iadu).calcularPrecioSegunAduanaDeListaDeProductos(lc3); //Verificación que se está llamando a este método.
    }

    @Test
    public void calcularImpuestoPorTipoSegunAduanaDeComprasDeListaDePersonasEntreFechas() {
        List<Persona> listaPersonas=List.of(
                    new Persona("Ana", "Madrid"),
                    new Persona("Juan", "Madrid"),
                    new Persona("Pepe", "Madrid")
        );
        List<TipoProducto> tipos=List.of(
                new TipoProducto(1, "Alimentacion"),
                new TipoProducto(2, "Informatica"),
                new TipoProducto(3, "Lujo"),
                new TipoProducto(4, "Otros")
        );
        List<Producto> prod=List.of(
                new Producto(1, "Sandia", tipos.get(0), 5), //1
                new Producto(2, "Teclado", tipos.get(1), 24),   //2
                new Producto(3, "Anillo", tipos.get(2), 50),    //4
                new Producto(4, "Periodico", tipos.get(3), 2)   //8
        );
        //hay 3 sandias = 3 puntos
        //hay 3 teclados = 6 puntos
        //hay 2 lujos= 8 puntos
        
        List<Compra> compras=List.of(   
                    new Compra(List.of(prod.get(0))),   
                    new Compra(List.of(prod.get(0),prod.get(2),prod.get(1))),   
                    new Compra(List.of(prod.get(0),prod.get(2),prod.get(1),prod.get(1)))   
        );

        Date fechaDesde=new Date(2000,01,01);
        Date fechaHasta=new Date(2001,01,01);
        IComprasRepository icom=Mockito.mock(IComprasRepository.class);
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Ana", fechaDesde, fechaHasta))
               .thenReturn(List.of(compras.get(0),compras.get(1)));
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Juan", fechaDesde, fechaHasta))
               .thenReturn(List.of(compras.get(0),compras.get(2)));
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas("Pepe", fechaDesde, fechaHasta))
               .thenReturn(List.of(compras.get(1),compras.get(2))) ;
        Mockito.when(icom.obtenerComprasDeUnaPersonaEntreFechas(Mockito.any(String.class), Mockito.any(Date.class), Mockito.any(Date.class)))
               .thenThrow(new Exception("Parametro incorrecto"));

        IAduanaService iadu=Mockito.mock(IAduanaService.class);
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(0)))
               .thenReturn(1d); //Alimentación
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(1)))
               .thenReturn(2d); //Informatica
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(2)))
               .thenReturn(4d); //Lujo
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(prod.get(3)))
               .thenReturn(8d); //Otros
        Mockito.when(iadu.calcularPrecioSegunAduanaDeUnProducto(Mockito.any(Producto.class)))
               .thenThrow(new Exception("Parametro incorrecto"));
        
        Ejercicio09VariadoCapas instance = new Ejercicio09VariadoCapas(null,null,icom,iadu) ;
        List<Pair<String, Long>> result = instance.calcularImpuestoPorTipoSegunAduanaDeComprasDeListaDePersonasEntreFechas(listaPersonas, fechaDesde, fechaHasta);
        assertEquals(3, result.size()); //Devuelve tres resultados porque solo hay 3 tipos de productos
        assertEquals("Lujos", result.get(1).getValue0());   //Hay 2 de lujo * 4 € = 8 €
        assertEquals(8, result.get(0).getValue1());
        assertEquals("Informatica", result.get(1).getValue0()); //Hay 3 de informatica * 2 € = 6 €
        assertEquals(6, result.get(1).getValue1());
        assertEquals("Alimentacion", result.get(2).getValue0());    //Hay 3 de alimentacion * 1 € = 3 €
        assertEquals(3, result.get(2).getValue1());

    }
    
}
