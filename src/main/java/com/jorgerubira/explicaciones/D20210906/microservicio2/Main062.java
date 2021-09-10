/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210906.microservicio2;
import com.jorgerubira.explicaciones.D20210906.microservicio1.Main06;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Main062 {
    public static void main(String[] args) {
        SpringApplication.run(Main062.class, args);    
    }
}
