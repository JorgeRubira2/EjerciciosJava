/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Cotizacion;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio08MercadoContinuoTest {
    
    public Ejercicio08MercadoContinuoTest() {
    }

    @Test
    public void testLeerUrl() {
        String ruta="https://www.estrategiasdeinversion.com/cotizaciones/indices/mercado-continuo";
        Ejercicio08MercadoContinuoService instance = new Ejercicio08MercadoContinuoService();
        try {
            String result = instance.leerUrl(ruta);
            System.out.println(result);
            assertEquals(true, result.length()>0);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio08MercadoContinuoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testTratarHTML() {
        String texto="<div id=\"pane-1_tbl_quotation--index\" class=\"tabbed-pane\"><div class=\"md-slider-table\"><div class=\"item\"><article class=\"md-table-generic\">" + 
                    "<table class='tbl tbl-cn-3'><thead><tr><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##nombre?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Nombre\">Nombre</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##ultimo-precio?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Ãšltimo\">Ãšltimo</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##variacion?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Var\">Var</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##variacion-porcentual?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Var %\">Var %</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##volumen?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Vol\">Vol</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##maximo?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Max\">Max</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##minimo?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Min\">Min</span></th><th><span     class=\"sortable smartfollow\"             data-href=\"##cotizaciones##indices##mercado-continuo##1##asc##fecha-hora?campaign=adwords&amp;gclid=EAIaIQobChMIzK2PhLX22wIVk4bVCh0m1QZ6EAAYAiAAEgJOtfD_BwE\" title=\"Fecha\">Fecha</span></th></tr></thead>" + 
                    " <tbody><tr><td><div><a href=\"cotizaciones/indices/mercado-continuo/abengoa-a\" class=\"lnk\" title=\"CotizaciÃ³n de Abengoa A\">Abengoa A</a></div></td><td colspan=\"7\" style=\"text-align: left\"> Suspendido de cotizaciÃ³n</td></tr><tr><td><div>" +
                    " <a href=\"https://www.estrategiasdeinversion.com/cotizaciones/indices/mercado-continuo/abengoa-b\" class=\"lnk\" title=\"CotizaciÃ³n de Abengoa B\">Abengoa B</a></div></td><td colspan=\"7\" style=\"text-align: left\"> Suspendido de cotizaciÃ³n</td></tr><tr><td><div><a href=\"https://www.estrategiasdeinversion.com/cotizaciones/indices/mercado-continuo/acciona\" class=\"lnk\" title=\"CotizaciÃ³n de Acciona\">Acciona</a></div></td><td class=\"last-14062\" data-value=\"135.8\" data-decimal=\"3\">135,8</td><td class=\"valueUp var-14062\" data-value=\"0.5\" data-decimal=\"3\">0,5 </td><td class=\"valueUp varPerc-14062\" data-value=\"0.3695\" data-decimal=\"2\">0,37% </td><td class=\"contractVol-14062\" data-value=\"53849\" data-decimal=\"2\">53.849</td><td>136,2</td><td>134,4</td><td class=\"date-14062\" data-decimal=\"0\" data-value=\"1628696280000\" data-filter=\"ES0125220311\" data-order=\"1628696280000\">\n" +
                    "            17:38:00\n" +
                    "        </td></tr><tr><td><div><a href=\"cotizaciones/indices/mercado-continuo/acerinox\" class=\"lnk\" title=\"CotizaciÃ³n de Acerinox\">Acerinox</a></div></td><td class=\"last-31882\" data-value=\"11.44\" data-decimal=\"3\">11,44</td><td class=\"valueUp var-31882\" data-value=\"0.125\" data-decimal=\"3\">0,125 </td><td class=\"valueUp varPerc-31882\" data-value=\"1.1047\" data-decimal=\"2\">1,1% </td><td class=\"contractVol-31882\" data-value=\"507137\" data-decimal=\"2\">507.137</td><td>11,45</td><td>11,24</td><td class=\"date-31882\" data-decimal=\"0\" data-value=\"1628696280000\" data-filter=\"ES0132105018\" data-order=\"1628696280000\">\n" +
                    "            17:38:00\n" +
                    "        </td></tr><tr><td><div><a href=\"cotizaciones/indices/mercado-continuo/acs\" class=\"lnk\" title=\"CotizaciÃ³n de ACS\">ACS</a></div></td><td class=\"last-39717\" data-value=\"23.13\" data-decimal=\"3\">23,13</td><td class=\"valueUp var-39717\" data-value=\"0.37\" data-decimal=\"3\">0,37 </td><td class=\"valueUp varPerc-39717\" data-value=\"1.6257\" data-decimal=\"2\">1,63% </td><td class=\"contractVol-39717\" data-value=\"384967\" data-decimal=\"2\">384.967</td><td>23,19</td><td>22,87</td><td class=\"date-39717\" data-decimal=\"0\" data-value=\"1628696280000\" data-filter=\"ES0167050915\" data-order=\"1628696280000\">\n" +
                    " 17:38:00\n " + 
                    "        </td></tr></tbody></table></article></div></div></div><div id=\"pane-2_tbl_quotation--index\" " +
                    "               ";
        Ejercicio08MercadoContinuoService instance = new Ejercicio08MercadoContinuoService();
        List<Cotizacion> cotizaciones = instance.tratarHTML(texto);
        assertEquals(3, cotizaciones.size());
        assertEquals("Acciona", cotizaciones.get(1).getTitulo());
        assertEquals(135.8, cotizaciones.get(1).getUltimo());
    }

    @Test
    public void testObtenerCotizaciones() throws Exception {
    }

    
}
