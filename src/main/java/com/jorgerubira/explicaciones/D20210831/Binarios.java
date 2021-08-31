/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210831;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


class Ruedas implements Serializable{
    private int numeroRuedas=4;
    private int otraCosa=4;

    public int getNumeroRuedas() {
        return numeroRuedas;
    }
    
}


class Coche implements Serializable{
    private String matricula;
    private String marca;
    private int puertas; //transient
    private Ruedas ruedas;

    public Coche(String matricula, String marca, int puertas) {
        this.matricula = matricula;
        this.marca = marca;
        this.puertas = puertas;
        ruedas=new Ruedas();
    }

    public Ruedas getRuedas() {
        return ruedas;
    }

    
    
    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPuertas() {
        return puertas;
    }

}

public class Binarios {
    public static void main(String[] args) {
        String ruta="d:\\zzzCarpeta\\A\\B\\ficheroSalidaBinaria.dat";
        File file=new File(ruta);
        file.getParentFile().mkdirs();        
        String s="Hola";
        boolean b=true;
        float f=3f;
        try(FileOutputStream fos=new FileOutputStream(ruta);
            DataOutputStream dos=new DataOutputStream(fos)){
            dos.writeBoolean(b);
            dos.writeUTF(s);
            dos.writeUTF(s);
            dos.writeFloat(f);
        }catch(Exception e){
            e.printStackTrace();
        }

        try(FileInputStream fis=new FileInputStream(ruta);
            DataInputStream dis=new DataInputStream(fis)){
                b=dis.readBoolean();
                s=dis.readUTF();
                s=dis.readUTF();
                f=dis.readFloat();
        }catch(Exception e){
            e.printStackTrace();
        }        

        ArrayList<Coche> al=new ArrayList<>();
        al.add(new Coche("A","B",4));
        al.add(new Coche("A","T",2));
        al.add(new Coche("A","R",1));
        
        try(FileOutputStream fos=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(al);
        }catch(Exception e){
            e.printStackTrace();
        }  
        al=null;
        try(FileInputStream fis=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(fis)){
            al=(ArrayList)ois.readObject();
            al.stream().forEach(
                    x->System.out.println(x.getMarca()+  " " + x.getMatricula() + " " + x.getPuertas())
            );
        }catch(Exception e){
            e.printStackTrace();
        }        
        
    }
}
