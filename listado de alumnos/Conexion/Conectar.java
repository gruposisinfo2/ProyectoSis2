package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
    private Connection connection = null;
private ResultSet rs = null;
private Statement s = null;

    /*static String bd = "archivos";
    static String login = "root";
    static String password = "mika";
    static String url = "jdbc:mysql://localhost/" + bd;
    Connection connection = null;*/

    public Conectar() {
        if(connection != null) {
	return;
    }
    
    String url = "jdbc:postgresql://localhost:5432/BDsis2";
    //String password = "1234";  ***si tienes password**
    try{
	Class.forName("org.postgresql.Driver");

	connection = DriverManager.getConnection(url,"postgres","admin");
	if(connection != null){
	   System.out.println("Conectando a Base de Datos...");
	}
	}catch(Exception e){
      	   System.out.println("Problemas de Conexión");
	}

        
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            connection.close();
        } catch (Exception ex) {
        }
    }
 public static void main(String arg[]){
   Conectar c = new Conectar(); 
 }
}
