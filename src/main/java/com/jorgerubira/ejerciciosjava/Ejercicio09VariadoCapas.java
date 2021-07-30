package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;
import com.jorgerubira.ejerciciosjava.interfaces.ICiudadesRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IComprasRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IPersonasRepository;
import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Pair;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
ir a buscar la info
 y tratar la info aqui o llamar a una capa de servicio para que la trate
en esta capap no recibes las personas hay que llamar a al capa repositorio 
que si recibe estas personas
p.e necesito una lista de personas pero no la tengo tengo que llamar al intrfaz
que tiene esa lista y que nos devuelve esa lista que contiene la base de datos
LLAMAR A LOS METODOS QUE LO HACEN
 */
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
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Calcular el total de productos comprados por las personas de una ciudad.
     * Será necesario leer personas utilizando IPersonasRepository y las compras
     * utilizando IComprasRepository Utilizar StreamsParalelos para optimizar el
     * rendimiento de servidores si es posible.
     */
    public Long calcularComprasDeUnaCiudad(String ciudad) {
        throw new RuntimeException("Pendiente de hacer");
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
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Recibimos una lista de personas y deseamos calcular el total ingresado
     * por aduana obtenido entre dos fechas. Estas personsa no tienen la compra
     * informada por lo que la tendremos que obtener utilizando
     * IComprasRepository Para el cálculo del precio utilizar el servicio
     * IAduanaService.
     */
    public Double calcularImpuestoPorAduanaDeComprasDeListaDePersonasEntreFechas(List<Persona> personas, Date fechaDesde, Date fechaHasta) {
        throw new RuntimeException("Pendiente de hacer");
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
        throw new RuntimeException("Pendiente de hacer");
    }

}
