package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import com.jorgerubira.ejerciciosspringweb.entities.Valor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;
import com.jorgerubira.ejerciciosspringweb.repositories.ValoresRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ejercicio8")
public class Ejercicio08MercadoContinuo {

    @Autowired
    private IEjercicio08MercadoContinuoService mercadoContinuo;

    @Autowired
    private ValoresRepository repoValores;

    @GetMapping("/listaCotizaciones")
    @ResponseBody
    public List<Cotizacion> mercadoContinuo() throws Exception {

        return mercadoContinuo.obtenerCotizaciones();
    }

    @GetMapping("/lista")
    public String lista() {
        return "ej08/listaCotizaciones";
    }

    // pendiente, hacerlo como formulario con seleccion de cantidad a comprar o vender, formulario de posiciones propias
    @PostMapping("/comprar")
    public String comprar(Model model, @RequestParam("titulo") String titulo,
             @RequestParam("ultimo") String ultimo,
             @RequestParam("hora") String hora) {
        Valor valor = new Valor();
        valor.setCantidad(1);
        valor.setValor(titulo);

        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        valor.setImporteUnitario(Float.parseFloat(ultimo));
        valor.setFechaTransaccion(timestamp);
        valor.setFechaDatos(hora);
        System.out.println("valor " + valor.toString());
        repoValores.save(valor);
        return "ej08/listaCotizaciones";
    }

    @PostMapping("/vender")
    public String vender(@RequestParam("titulo") String titulo, @RequestParam("ultimo") String ultimo) {
        List<Valor> vals = repoValores.findByValorAndImporteUnitario(titulo, Float.parseFloat(ultimo));

        if (vals.size() > 0) {
            for (Valor v : vals) {
                repoValores.deleteById(v.getId());
            }
        } else {
            // TODO: return formulario de seleccion de elemento a eliminar
        }
        return "ej08/listaCotizaciones";
    }
}
