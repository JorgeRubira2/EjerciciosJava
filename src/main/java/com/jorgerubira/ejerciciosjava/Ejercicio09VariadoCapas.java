package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;
import com.jorgerubira.ejerciciosjava.interfaces.ICiudadesRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IComprasRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IPersonasRepository;
import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosjava.pojo.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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
        List<Ciudad> ciudades = repoPersonas.buscarPersonaEntreFechas(fechaDesde, fechaHasta)
                .stream()
                .collect(Collectors.groupingBy(Persona::getCiudad))
                .entrySet()
                .stream()
                .map(x -> new Ciudad(x.getKey(), x.getValue().size()))
                .sorted((x, y) -> y.getPersonas() - x.getPersonas())
                .collect(Collectors.toList());
        return ciudades;
    }

    /**
     * Calcular el total de productos comprados por las personas de una ciudad.
     * Será necesario leer personas utilizando IPersonasRepository y las compras
     * utilizando IComprasRepository Utilizar StreamsParalelos para optimizar el
     * rendimiento de servidores si es posible.
     */
    public Long calcularComprasDeUnaCiudad(String ciudad) {
        List<Persona> personas = repoPersonas.buscarPersonasDeUnaCiudad(ciudad);
        Optional<Long> salida = personas.parallelStream()
                .filter(x -> x.getCiudad() == ciudad)
                .map(x -> {
                    List<Compra> compras = repoCompras.obtenerComprasDeUnaPersona(x.getNombre());
                    Long comprasPersona = compras.parallelStream()
                            .mapToLong(y -> y.getTotalArticulos())
                            .reduce(0, (y, z) -> y + z);
                    return comprasPersona;
                })
                .reduce((x, y) -> x + y);

        if (salida.isPresent()) {
            return salida.get();
        } else {
            return 0L;
        }

    }

    /**
     * Calcular el total de productos comprados por las personas de una ciudad
     * entre dos fechas. Será necesario leer personas utilizando
     * IPersonasRepository y las compras utilizando IComprasRepository Las
     * compras se pueden obtener utilizando Utilizar StreamsParalelos para
     * optimizar el rendimiento de servidores si es posible.
     */
    public Long calcularComprasDeUnaCiudadEntreFechas(String ciudad, Date fechaDesde, Date fechaHasta) {
        List<Persona> personas = repoPersonas.buscarPersonasDeUnaCiudad(ciudad);
        Optional<Long> salida = personas.parallelStream()
                .filter(x -> x.getCiudad() == ciudad)
                .map(x -> {
                    List<Compra> compras = repoCompras.obtenerComprasDeUnaPersonaEntreFechas(x.getNombre(), fechaDesde, fechaHasta);
                    Long comprasPersona = compras.parallelStream()
                            .mapToLong(y -> y.getTotalArticulos())
                            .reduce(0, (y, z) -> y + z);
                    return comprasPersona;
                })
                .reduce((x, y) -> x + y);

        if (salida.isPresent()) {
            return salida.get();
        } else {
            return 0L;
        }
    }

    /**
     * Nos envian una lista de compras realizadas y debemos calcular el importe
     * pasado por la aduana. Para el cálculo del precio utilizar el servicio
     * IAduanaService.
     */
    public Double calcularImpuestoPorAduanaCompras(List<Compra> compras) {
        return serAduana.calcularPrecioSegunAduanaDeListaDeProductos(compras);
    }

    /**
     * Recibimos una lista de personas y deseamos calcular el total ingresado
     * por aduana obtenido entre dos fechas. Estas personsa no tienen la compra
     * informada por lo que la tendremos que obtener utilizando
     * IComprasRepository Para el cálculo del precio utilizar el servicio
     * IAduanaService.
     */
    public Double calcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas(List<Persona> personas, Date fechaDesde, Date fechaHasta) {
        Optional<Double> preciosAduana = personas.parallelStream()
                .map(x -> repoCompras.obtenerComprasDeUnaPersonaEntreFechas(x.getNombre(), fechaDesde, fechaHasta))
                .map(x -> serAduana.calcularPrecioSegunAduanaDeListaDeProductos(x))
                .reduce((x, y) -> x + y);

        if (preciosAduana.isPresent()) {
            return preciosAduana.get();
        } else {
            return 0d;
        }
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
//        List<Producto> productosTotales = personas.parallelStream()
//                .filter(x -> x.getCesta().isPresent())
//                .filter(x -> x.getCesta().get().contieneDetalleDeProductos())
//                .map(x -> x.getCesta().get())
//                .map(x -> {
//                        List<Producto> prods = Arrays.asList(new Producto[x.getTotalArticulos()]);
//                        for (int i = 0; i < x.getTotalArticulos(); i++) {
//                            prods.add(x.getProducto(i));
//                        }
//                        return prods;
//                    }
//                )
//                .collect(Collectors.toList());
        

       return null;
    }

}
