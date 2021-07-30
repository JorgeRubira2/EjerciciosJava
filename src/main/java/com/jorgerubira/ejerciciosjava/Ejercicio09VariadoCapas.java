package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.excepciones.NoDatoDisponibleException;
import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;
import com.jorgerubira.ejerciciosjava.interfaces.ICiudadesRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IComprasRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IPersonasRepository;
import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.TipoProducto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Ejercicio09VariadoCapas {

    private IPersonasRepository repoPersonas;
    private ICiudadesRepository repoCiudades;
    private IComprasRepository repoCompras;
    private IAduanaService serAduana;

    public Ejercicio09VariadoCapas(IPersonasRepository repoPersonas, ICiudadesRepository repoCiudades, IComprasRepository repoCompras, IAduanaService serAduana) {
        this.repoPersonas = repoPersonas;
        this.repoCiudades = repoCiudades;
        this.repoCompras = repoCompras;
        this.serAduana = serAduana;
    }

    /**
     * Busca las personas en el repository que hayan nacido entre dos fecha
     * introducidas y devuelve las ciudades donde están estas personas. Incluir
     * el número de personas que hay en cada ciudad Utilizar StreamsParalelos
     * para optimizar el rendimiento de servidores si es posible. Las ciudades
     * no se deben repetir. Devolver la información ordenada por el número de
     * personas de mayor a menor.
     */
    public List<Ciudad> buscarCiudadesDePersonasNacidasEntreFechas(Date fechaDesde, Date fechaHasta) {
        List<Persona> aux = repoPersonas.buscarPersonaEntreFechas(fechaDesde, fechaHasta);
        Map<String, Long> aux2 = aux.parallelStream().collect(Collectors.groupingBy(x -> x.getCiudad(), Collectors.counting()));
        List<Ciudad> resultado = new ArrayList<>();
        aux2.entrySet().parallelStream().forEach(x -> resultado.add(new Ciudad(x.getKey(), x.getValue().intValue())));
        return resultado.stream().sorted((x, y) -> y.getPersonas() - x.getPersonas()).collect(Collectors.toList());
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Calcular el total de productos comprados por las personas de una ciudad.
     * Será necesario leer personas utilizando IPersonasRepository y las compras
     * utilizando IComprasRepository Utilizar StreamsParalelos para optimizar el
     * rendimiento de servidores si es posible.
     */
    public Long calcularComprasDeUnaCiudad(String ciudad) {
        List<Persona> var1 = repoPersonas.buscarPersonasDeUnaCiudad(ciudad);
        Optional<Integer> aux = var1.parallelStream().map(x -> {
            List<Compra> a = repoCompras.obtenerComprasDeUnaPersona(x.getNombre());
            Optional<Integer> sumaCompras = a.parallelStream().map(z -> z.getTotalArticulos()).sequential().reduce((z, y) -> z + y);
            return sumaCompras.get();
        }).sequential().reduce((x, y) -> x + y);
        return aux.get().longValue();
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Calcular el total de productos comprados por las personas de una ciudad
     * entre dos fechas. Será necesario leer personas utilizando
     * IPersonasRepository y las compras utilizando IComprasRepository Las
     * compras se pueden obtener utilizando Utilizar StreamsParalelos para
     * optimizar el rendimiento de servidores si es posible.
     */
    public Long calcularComprasDeUnaCiudadEntreFechas(String ciudad, Date fechaDesde, Date fechaHasta) {
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Nos envian una lista de compras realizadas y debemos calcular el importe
     * pasado por la aduana. Para el cálculo del precio utilizar el servicio
     * IAduanaService.
     */
    public Double calcularImpuestoPorAduanaCompras(List<Compra> compras) {
        return serAduana.calcularPrecioSegunAduanaDeListaDeProductos(compras);
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Recibimos una lista de personas y deseamos calcular el total ingresado
     * por aduana obtenido entre dos fechas. Estas personsa no tienen la compra
     * informada por lo que la tendremos que obtener utilizando
     * IComprasRepository Para el cálculo del precio utilizar el servicio
     * IAduanaService.
     */
    public Double calcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas(List<Persona> personas, Date fechaDesde, Date fechaHasta) {
        Optional<Double> aux = personas.parallelStream().map(x -> {
            List<Compra> a = repoCompras.obtenerComprasDeUnaPersonaEntreFechas(x.getNombre(), fechaDesde, fechaHasta);
            Double sumaCompras = serAduana.calcularPrecioSegunAduanaDeListaDeProductos(a);
            return sumaCompras;
        }).sequential().reduce((x, y) -> x + y);
        return aux.get();
        //throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Recibimos una lista de personas que tienen cestas de compra con detalle
     * de producto. Se pide devolver cuantos ingresos a traves de la aduana
     * hemos obtenido por productos hay de cada tipo de producto y devolver la
     * información ordenada de mayor a menos. (El tipo más vendido al menos)
     * Utilizaremos el servicio de la aduana para obtener Para ello devolveremos
     * una tupla (Pair en el que el primer valor sea el nombre del tipos y el
     * segundo sea cuantas veces aparece).
     */
    public List<Pair<String, Long>> calcularImpuestoPorTipoSegunAduanaDeComprasDeListaDePersonasEntreFechas(List<Persona> personas, Date fechaDesde, Date fechaHasta) {
        List<List<Compra>> compras=personas.parallelStream().map(x -> repoCompras.obtenerComprasDeUnaPersonaEntreFechas(x.getNombre(), fechaDesde, fechaHasta)).collect(Collectors.toList());
        List<List<TipoProducto>> productos=compras.parallelStream().map(x->{
            List<TipoProducto> pro=new ArrayList<>();
            try {
                pro=serAduana.obtenerTiposDeLasCompras(x);
            } catch (NoDatoDisponibleException ex) {
                Logger.getLogger(Ejercicio09VariadoCapas.class.getName()).log(Level.SEVERE, null, ex);
            }
            return pro;
        }).collect(Collectors.toList());
        
        
        List<Pair<String, Long>> resultado;
        
        throw new RuntimeException("Pendiente de hacer");
    }

}
