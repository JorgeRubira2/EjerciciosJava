package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.excepciones.NoDatoDisponibleException;
import com.jorgerubira.ejerciciosjava.interfaces.IAduanaService;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Producto;
import com.jorgerubira.ejerciciosjava.pojo.TipoProducto;
import java.util.List;


public class Ejercicio09VariadoCapas{

    /**
     * Si no está el detalle de los productos -> Devuelve 10€ por cada producto + un coste de 15€ fijo por la gestión por compra
     * Si si tenemos un detalle de los productos -> Poner 15€ fijos de gestión más un importe variable según el tipo de producto.
     *                  Devuelve 5€ por cada producto de tipo "Alimentación"
     *                  Devuelve 10€ por cada producto de tipo "Informatica"
     *                  Devuelve 15€ por cada producto de tipo "Lujo"
     *                  Para el resto devuelve 10€ por productos.
     */

    public Double calcularPrecioSegunAduanaDeListaDeProductos(List<Compra> compras) {
        throw new UnsupportedOperationException("Pendiente de hacer");
    }

    /**
     * Devuelve los tipos de productos que hay en una compra. Estos productos no se pueden repetir.
     * Si los datos no están disponibles devolver un NoDatoDisponibleException indicando que no hay "Productos"
     */

    public List<TipoProducto> obtenerTiposDeLasCompras(List<Compra> compras) throws NoDatoDisponibleException{
        throw new UnsupportedOperationException("Pendiente de hacer"); 
    }

    /**
     * Devuelve el importe de un producto a nivel individual.
     * Si si tenemos un detalle de los productos -> 
     *                  Devuelve 5€ por cada producto de tipo "Alimentación"
     *                  Devuelve 10€ por cada producto de tipo "Informatica"
     *                  Devuelve 15€ por cada producto de tipo "Lujo"
     *                  Para el resto devuelve 10€ por productos.
     */

    public Double calcularPrecioSegunAduanaDeUnProducto(Producto producto) {
        throw new UnsupportedOperationException("Pendiente de hacer"); 
    }
    
}