package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.excepciones.NoDatoDisponibleException;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Producto;
import com.jorgerubira.ejerciciosjava.pojo.TipoProducto;
import java.util.List;

public interface IAduanaService {

    public Double calcularPrecioSegunAduanaDeListaDeProductos(List<Compra> compras);
    public Double calcularPrecioSegunAduanaDeUnProducto(Producto producto);
    public List<TipoProducto> obtenerTiposDeLasCompras(List<Compra> compras) throws NoDatoDisponibleException;
    
}
