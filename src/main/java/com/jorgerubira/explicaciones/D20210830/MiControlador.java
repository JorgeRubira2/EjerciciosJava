
package com.jorgerubira.explicaciones.D20210830;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller         //Vistas-html
@RestController     //Json
public class MiControlador {
    
    @GetMapping("/ruta")
    @ResponseBody   //Json
    public void json(){
        
    }
    
    @PostMapping("/ruta2")
    public String fomrulario(){
        return "nombreVista";
    }
    
}
