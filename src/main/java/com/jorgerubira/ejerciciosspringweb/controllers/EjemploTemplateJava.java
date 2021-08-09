/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejemplotemplate")
public class EjemploTemplateJava {
    // ejte de ejemplo template
    @GetMapping("/texto1")
    public String text1(){
        return "ejte/vista1";
    }
    
    @GetMapping("/texto2")
    public String text2(){
            return "ejte/vista2";
    }
}
