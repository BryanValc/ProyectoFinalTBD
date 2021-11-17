/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.City;
import conexionBD.ConexionBD;
import java.util.ArrayList;


/**
 *
 * @author bryan
 */
public class CityDAO {
    
    public boolean insertarRegistro(City c){
        boolean resultado=false;
        resultado=ConexionBD.AgregarRegistro(c);
        return resultado;
    }
    
    public boolean modificarRegistro(City c){
        boolean resultado=false;
        resultado=ConexionBD.actualizarRegistro(c);
        return resultado;
    }
    
    public ArrayList<City> buscar(String filtro){
        ArrayList<City> lista= new ArrayList<City>();
        ResultSet rs = ConexionBD.ejecutarConsulta(filtro);
        try{
            if(rs.next()){
                do{
                    lista.add(new City(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5)));
                }while(rs.next());
            
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean borrarRegistro(City c){
        boolean resultado = false;
        String sql = "DELETE FROM City where Id="+c.getId();
        resultado = ConexionBD.eliminarRegistro(sql);
        return resultado;
    }
}
