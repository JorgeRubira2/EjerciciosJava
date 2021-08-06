package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Producto;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio02CalculadoraService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jorgerubira.ejerciciosspringweb.repositories.ProductoCrudRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/ejercicio0")
public class Ejercicio00Muestra {
    
    /******************************************
     *     Ejemplo de Servicio calculadora
     ******************************************/
    @Autowired
    private IEjercicio02CalculadoraService calc;
    
    @GetMapping("/calculadora")
    public String calc(Model model){
        model.addAttribute("resultado", 0);
        model.addAttribute("valor1", 0);
        model.addAttribute("valor2", 0);
        return "ej02/calculadora";
    }

    @PostMapping("/sumar")
    public String sumar(Model model, Integer valor1, Integer valor2){
        if (valor1==null){
            valor1=0;
        }
        if (valor2==null){
            valor2=0;
        }
        model.addAttribute("resultado", calc.sumar(valor1, valor2));    
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }
    
    @PostMapping("/restar")
    public String restar(Model model, Integer valor1, Integer valor2){
        if (valor1==null){
            valor1=0;
        }
        if (valor2==null){
            valor2=0;
        }
        model.addAttribute("resultado", calc.restar(valor1, valor2));    
        model.addAttribute("valor1", valor1);
        model.addAttribute("valor2", valor2);
        return "ej02/calculadora";
    }

    /******************************************
     *     Ejemplo de Repositorio
     ******************************************/
    @Autowired
    private ProductoCrudRepository repoProductos;
    
    @GetMapping("/productos1")
    @ResponseBody   //Response body sirve para no devolver una vista. Devuelve un JSON
    public List<Producto> obtenerProductos(){
        List<Producto> resultado=new ArrayList<>();
        repoProductos.findAll().forEach(resultado::add);    //Convertir de iterable a List
        return resultado;
    } 
    
    @GetMapping("/productos2")
    @ResponseBody   //Response body sirve para no devolver una vista. Devuelve un JSON
    public Iterable<Producto> obtenerProductos2(){
        return repoProductos.findAll();    //Convertir de iterable a List
    }     

    /******************************************
     *     Ejemplo de Value
     ******************************************/
    /*
    @Value("${ejemplo00.informacion}")
    private String informacion;
    
    @GetMapping("/informacion")
    @ResponseBody
    public String obtenerInformacion(){
        return informacion;
    }     
*/
    /**********************************************************
     *     Ejemplo de Metodo GET y POST simultaneamente.
     **********************************************************/
    @RequestMapping(value = "/prueba", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String prueba(HttpServletRequest request){
        return "Esto es una prueba de RequestMapping/RequestMapping. " + 
                    request.getMethod() +  
                    request.getServletPath(); 
    }

    /**********************************************************
     *     Ejemplo de @Configuration y @Bean .Mirar fichero ConfiguracionAplicacion
     **********************************************************/
    /*
    @Autowired
    private Alumno alumno;
    
    @GetMapping("/alumno")
    @ResponseBody
    public Alumno obtenerAlumno(){
        return alumno;
    }  
    */
 

    
}
