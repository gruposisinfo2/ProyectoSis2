/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alvaro
 */
public class conexion {

 Connection cn;
 Statement st;

 public Connection conexionBD(){
         try{
                 Class.forName("org.postgresql.Driver");
                 cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Proyecto", "postgres", "hmc7w2a");
                 System.out.println("Se hizo la conexion exitosa");
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }return cn;
 }

 Statement createStatement(){
     throw new UnsupportedOperationException("No soportado");
 }
}

