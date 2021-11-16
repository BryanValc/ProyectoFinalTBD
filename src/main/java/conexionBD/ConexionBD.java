/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
/**
 *
 * @author bryan
 */
public class ConexionBD {
    
    private static PreparedStatement pstm;
    private static ResultSet rs;
	
    private static ConexionBD conexionBD;
    private static Connection conexion= null;
	
    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String URL = "jdbc:mysql://localhost:3306/world";
            
            conexion = DriverManager.getConnection(URL,"BryanValc","c1s1g7o");
            
            System.out.println("Conexion establecida");
			
	} catch (ClassNotFoundException e) {
            System.out.printf("Error de Driver");
	} catch (SQLException e) {
            System.out.printf("Error de conexion a MySQL o de la BD");
	}
    }
    
    public static synchronized ConexionBD getInstance() {
        if (conexionBD == null) {
            new ConexionBD();
	}
        return conexionBD;
	}
	
    public static Connection getConexion() {
	if (conexion == null) {
		new ConexionBD();
	}
	return conexion;
    }
	
    static void cerrarConnexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean eliminarRegistro(String sql) {
	try {
            String consulta = sql;
            pstm = conexion.prepareStatement(consulta);
            pstm.executeUpdate();
            return true;
	} catch (Exception ex) {
		 
	}
	return false;
    }
    
}
