/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia22;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    public Persona(String nombre, String direccion, Date fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }
    
     public void comer(){
         System.out.println("Comer");
     }
}
