/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.*;

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
            System.out.printf("Error al cerrar la conexion");
        }
    }
    
    public static boolean eliminarRegistro(String sql) {
	try {
            String consulta = sql;
            pstm = conexion.prepareStatement(consulta);
            pstm.executeUpdate();
            return true;
	} catch (Exception ex) {
		 System.out.printf("Error al eliminar el registro");
	}
	return false;
    }
    
    public static boolean Transaccion(String instruccion){
	try{
            pstm = conexion.prepareStatement(instruccion);
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.printf("Error al ejecutar la transaccion");
	}
        return false;
    }
    
    public static ResultSet ejecutarConsulta(String sql) {
	try {
            String consulta = sql;
            pstm = conexion.prepareStatement(consulta);
            return pstm.executeQuery();
	} catch (Exception e) {
            System.out.printf("Error al ejecutar la consulta");
        }
        return null;
    }
    
    public static boolean actualizarRegistro(City city) {
	try {
            pstm = conexion.prepareStatement("UPDATE City SET Name=?,CountryCode=?,District=?,Population=? WHERE ID="+city.getId()+"");
            pstm.setString(1, city.getName());
            pstm.setString(2, city.getCountryCode());
            pstm.setString(3, city.getDistrict());
            pstm.setInt(4, city.getPopulation());
			
            pstm.executeUpdate();
            return true;
	} catch (Exception e) {
	}
        return false;
    }
    public static boolean actualizarRegistro(CountryLanguage countryLanguage) {
	try {
            pstm = conexion.prepareStatement("UPDATE CountryLanguage SET IsOfficial=?,Percentage=? WHERE CountryCode='"+countryLanguage.getCountryCode()+"' AND Language='"+countryLanguage.getLanguage()+"'");
            pstm.setString(1, countryLanguage.getIsOfficial()+"");
            pstm.setFloat(2, countryLanguage.getPercentage());
			
            pstm.executeUpdate();
            return true;
	} catch (Exception e) {
	}
        return false;
    }
    
    public static boolean actualizarRegistro(Country country) {
	try {
            pstm = conexion.prepareStatement("UPDATE Country SET Name=?,Continent=?,Region=?,SurfaceArea=?,IndepYear=?,Population=?,LifeExpectancy=?,GNP=?,GNPOld=?,LocalName=?,GovernmentForm=?,HeadOfState=?,Capital=?,Code2=? WHERE Code='"+country.getCode()+"'");
            pstm.setString(1, country.getName());
            pstm.setString(2, country.getContinent());
            pstm.setString(3, country.getRegion());
            pstm.setFloat(4, country.getSurfaceArea());
            pstm.setInt(5, country.getIndepYear());
            pstm.setInt(6, country.getPopulation());
            pstm.setFloat(7, country.getLifeExpectancy());
            pstm.setFloat(8, country.getGNP());
            pstm.setFloat(9, country.getGNPOld());
            pstm.setString(10, country.getLocalName());
            pstm.setString(11, country.getGovernmentForm());
            pstm.setString(12, country.getHeadOfState());
            pstm.setInt(13, country.getCapital());
            pstm.setString(14, country.getCode2());
			
            pstm.executeUpdate();
            return true;
	} catch (Exception e) {
	}
        return false;
    }
    
    public static boolean actualizarRegistro(Usuario usuario) {
	try {
            pstm = conexion.prepareStatement("UPDATE Usuario SET Password=? WHERE Username='"+usuario.getNombre()+"'");
            pstm.setString(1, usuario.getContraseña());
			
            pstm.executeUpdate();
            return true;
	} catch (Exception e) {
	}
        return false;
    }
    
    public static boolean AgregarRegistro(City city) {
	try {
            pstm = conexion.prepareStatement("INSERT INTO City VALUES(?,?,?,?,?)");
            pstm.setInt(1,city.getId());
            pstm.setString(2,city.getName());
            pstm.setString(3,city.getCountryCode());
            pstm.setString(4,city.getDistrict());
            pstm.setInt(5,city.getPopulation());
            
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
	}
	return false;
    }
    
    public static boolean AgregarRegistro(CountryLanguage countryLanguage) {
	try {
            pstm = conexion.prepareStatement("INSERT INTO CountryLanguage VALUES(?,?,?,?)");
            pstm.setString(1, countryLanguage.getCountryCode());
            pstm.setString(2, countryLanguage.getLanguage());
            pstm.setString(3, countryLanguage.getIsOfficial()+"");
            pstm.setFloat(4, countryLanguage.getPercentage());
			
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
	}
	return false;
    }
    
    public static boolean AgregarRegistro(Country country) {
	try {
            pstm = conexion.prepareStatement("INSERT INTO Country VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, country.getCode());
            pstm.setString(2, country.getName());
            pstm.setString(3, country.getContinent());
            pstm.setString(4, country.getRegion());
            pstm.setFloat(5, country.getSurfaceArea());
            pstm.setInt(6, country.getIndepYear());
            pstm.setInt(7, country.getPopulation());
            pstm.setFloat(8, country.getLifeExpectancy());
            pstm.setFloat(9, country.getGNP());
            pstm.setFloat(10, country.getGNPOld());
            pstm.setString(11, country.getLocalName());
            pstm.setString(12, country.getGovernmentForm());
            pstm.setString(13, country.getHeadOfState());
            pstm.setInt(14, country.getCapital());
            pstm.setString(15, country.getCode2());
			
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
	}
	return false;
    }
    
    public static boolean AgregarRegistro(Usuario usuario) {
	try {
            pstm = conexion.prepareStatement("INSERT INTO Usuario VALUES(?,?)");
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getContraseña());
			
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            
	}
	return false;
    }
    
    
}
