/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210903.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class MainJDBC {
    
    public static void ejecutarModificacion(){
        //JDBC 4
        //Class.forName("com.mysql.jdbc.Driver")
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            Statement stmt=con.createStatement();
            
            int cuantos=stmt.executeUpdate("insert into Personas (nombre,apellidos) values( 'Ana', 'Perez')");
            System.out.println(cuantos + " filas afectadas");

            System.out.println("Ha conectado");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void lecturaBasica(){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Personas");
            ResultSetMetaData rsmd=rs.getMetaData();
            while (rs.next()){
                System.out.println(rs.getString("nombre") + " " + 
                                   rs.getString("apellidos") + " " + 
                                   rs.getObject("total_telefonos") + " " + 
                                   rs.getInt("total_telefonos") + " " +
                                   rs.getString(2) + " " + 
                                   rsmd.getColumnTypeName(5));
            }
            
            System.out.println("Ha conectado");
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }
    
 
    public static void lecturaBasicaConParametros(String nombre){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            Statement stmt=con.createStatement();
            String sql="select * from Personas where nombre like '%" + nombre + "%'";
            ResultSet rs=stmt.executeQuery(sql);
            System.out.println(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            while (rs.next()){
                System.out.println(rs.getString("nombre") + " " + 
                                   rs.getString("apellidos") + " " + 
                                   rs.getObject("total_telefonos") + " " + 
                                   rs.getInt("total_telefonos") + " " +
                                   rs.getString(2) + " " + 
                                   rsmd.getColumnTypeName(5));
            }
            
            System.out.println("Ha conectado");
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    public static void lecturaBasicaConParametrosPreparedStat(String nombre){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            String sql="select * from Personas where nombre like ? ";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, "%" + nombre + "%");
            
            ResultSet rs=stmt.executeQuery();
            System.out.println(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            while (rs.next()){
                System.out.println(rs.getString("nombre") + " " + 
                                   rs.getString("apellidos") + " " + 
                                   rs.getObject("total_telefonos") + " " + 
                                   rs.getInt("total_telefonos") + " " +
                                   rs.getString(2) + " " + 
                                   rsmd.getColumnTypeName(5));
            }
            
            System.out.println("Ha conectado");
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    public static void insertarMuchas(){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            
            String sql="insert into Personas (nombre,apellidos) values (?,?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, "Ana");
            stmt.setString(2, "Perez");
            stmt.executeUpdate();
            stmt.setString(1, "Juan");
            stmt.setString(2, "Lopez");
            stmt.executeUpdate();
            stmt.setString(1, "Alfredo");
            stmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    public static void insertarMuchas2(){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Hiberus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", 
                                                       "root", "1111")){
            con.setAutoCommit(false);
            Statement stmt=con.createStatement();
            
            stmt.addBatch("insert into Personas (nombre,apellidos) values ('A1','A2')");
            stmt.addBatch("insert into Personas (nombre,apellidos) values ('B1','B2')");
            stmt.addBatch("insert into Personas (nombre,apellidos) values ('C1','C2')");
            
            int[] cuantos=stmt.executeBatch();
            con.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }        
    }

    
    
    public static void main(String[] args) {
        insertarMuchas2();
        //lecturaBasicaConParametrosPreparedStat("Ana");
        
    }
}
