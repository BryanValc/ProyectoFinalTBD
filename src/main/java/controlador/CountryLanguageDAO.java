/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CountryLanguage;
import conexionBD.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class CountryLanguageDAO {
    
    public boolean insertarRegistro(CountryLanguage c){
        boolean resultado=false;
        resultado=ConexionBD.AgregarRegistro(c);
        return resultado;
    }
    
    public boolean modificarRegistro(CountryLanguage c){
        boolean resultado=false;
        resultado=ConexionBD.actualizarRegistro(c);
        return resultado;
    }
    
    public ArrayList<CountryLanguage> buscar(String filtro){
        ArrayList<CountryLanguage> lista= new ArrayList<CountryLanguage>();
        ResultSet rs = ConexionBD.ejecutarConsulta(filtro);
        try{
            if(rs.next()){
                do{
                    lista.add(new CountryLanguage(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3).charAt(0),
                            rs.getFloat(4)));
                }while(rs.next());
            
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean borrarRegistro(CountryLanguage c){
        boolean resultado = false;
        String sql = "DELETE FROM CountryLanguage WHERE CountryCode='"+c.getCountryCode()+"' AND Language='"+c.getLanguage()+"''";
        resultado = ConexionBD.eliminarRegistro(sql);
        return resultado;
    }
    
}
