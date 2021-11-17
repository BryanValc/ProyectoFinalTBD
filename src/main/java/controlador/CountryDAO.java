/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Country;
import conexionBD.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class CountryDAO {
    
    public boolean insertarRegistro(Country c){
        boolean resultado=false;
        resultado=ConexionBD.AgregarRegistro(c);
        return resultado;
    }
    
    public boolean modificarRegistro(Country c){
        boolean resultado=false;
        resultado=ConexionBD.actualizarRegistro(c);
        return resultado;
    }
    
    public ArrayList<Country> buscar(String filtro){
        ArrayList<Country> lista= new ArrayList<Country>();
        ResultSet rs = ConexionBD.ejecutarConsulta(filtro);
        try{
            if(rs.next()){
                do{
                    lista.add(new Country(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getFloat(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getFloat(8),
                            rs.getFloat(9),
                            rs.getFloat(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getInt(14),
                            rs.getString(15)));
                }while(rs.next());
            
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean borrarRegistro(Country c){
        boolean resultado = false;
        String sql = "DELETE FROM Country WHERE Code='"+c.getCode()+"'";
        resultado = ConexionBD.eliminarRegistro(sql);
        return resultado;
    }
    
}
