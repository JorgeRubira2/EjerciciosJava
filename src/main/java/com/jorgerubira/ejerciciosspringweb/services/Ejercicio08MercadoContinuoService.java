/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio08MercadoContinuoService;


@Service
public class Ejercicio08MercadoContinuoService implements IEjercicio08MercadoContinuoService {

    public String leerUrl(String ruta) throws IOException, ClientProtocolException{
        URL request=new URL(ruta);
        URLConnection con=request.openConnection();
        try(BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()))){
            StringBuffer sb=new StringBuffer();
            char c[]=new char[1024];
            int cp;
            while((cp=in.read(c))>0){
                sb.append(c, 0, cp);
            }
            return sb.toString();    
        }
    }

    public String getContenido(String []dato, int pos){
        return dato[pos].split(">")[1].split("<")[0].replace("\n","").trim();
    }
    
    public double getDouble(String valor){
        try{
            valor=valor.replaceAll("\\.", "").replaceAll(",", ".").replaceAll("%","");
            
            return Double.parseDouble(valor);
        }catch(Exception e){
            return 0;
        }
    }
    
    public List<Cotizacion> tratarHTML(String html){
        html=html.split("<article class=\"md-table-generic")[1];
        html=html.split("<table")[1];
        html=html.split("</table")[0];
        List<String> lista = new ArrayList<>(Arrays.asList(html.split("lnk")));
        var res=lista.stream().map(x->{
                try{
                    String []dato=x.split("<td");
                    return new Cotizacion(
                            getContenido(dato,0), 
                            getDouble(getContenido(dato,1)), 
                            getDouble(getContenido(dato,2)), 
                            getDouble(getContenido(dato,3)), 
                            (long)getDouble(getContenido(dato,4)), 
                            getDouble(getContenido(dato,5)), 
                            getDouble(getContenido(dato,6)), 
                            getContenido(dato,7));
                }catch(Exception e){
                    return null;
                }
            })
            .filter(x->x!=null)
            .collect(Collectors.toList());
        return res;
                
    }
    
    @Override
    public List<Cotizacion> obtenerCotizaciones() throws Exception{
        String ruta="https://www.estrategiasdeinversion.com/cotizaciones/indices/mercado-continuo";
        String respuesta=leerUrl(ruta);
        return tratarHTML(respuesta);
    }
    
    /*public List<Cotizacion> obtenerCotizaciones()  { 
    }*/
    
}
