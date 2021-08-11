/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Cliente;
import com.jorgerubira.ejerciciosspringweb.repositories.ClientesRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



@WebMvcTest(value=Ejercicio07GestionClientesController.class)
public class Ejercicio07GestionClientesControllerTest {
     
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientesRepository repoClientes;
    
    private Cliente cli; 
    private List<Cliente> listaCli;

    @BeforeEach
    void setup() {
        cli=new Cliente(); 
        cli.setId(1L);
        listaCli=new ArrayList<>();
        listaCli.add(cli);
        given(this.repoClientes.findAll()).willReturn(listaCli);
        given(this.repoClientes.findById(1L)).willReturn(Optional.of(cli));
    }
     
    @Test   
    public void testLista() throws Exception{
        //Al ejecutar la URL /ejercicio7 debe devolver ok.
        mockMvc.perform(get(new URI("/ejercicio7")))  
               .andExpect(status().isOk())
               .andExpect(view().name("ej07/lista"))
               .andExpect(model().attributeExists("clientes"))
               .andExpect(model().attribute("clientes", listaCli));
    }

    @Test
    public void testRead() throws Exception {
        mockMvc.perform(get(new URI("/ejercicio7/1")))
               .andExpect(status().isOk())
               .andExpect(view().name("ej07/formulario"))
               .andExpect(model().attributeExists("cliente"))
               .andExpect(model().attribute("cliente", cli));
    }

    @Test
    public void testReadAjax() throws Exception {
        //Pendiente de mejorar
        mockMvc.perform(get(new URI("/ejercicio7/ajax/1")))
               .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testSave() throws Exception {
        mockMvc.perform(post("/ejercicio7").param("id", "1"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/ejercicio7"));
        Mockito.verify(repoClientes, Mockito.times(1)).save(any(Cliente.class));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(get(new URI("/ejercicio7/ajax/1")))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/ejercicio7"));
        Mockito.verify(repoClientes, Mockito.times(1)).deleteById(1L);
    }
   
}
