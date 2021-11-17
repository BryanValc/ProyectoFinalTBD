/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import conexionBD.ConexionBD;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class UsuarioDAO {
    
    public boolean insertarRegistro(Usuario u){
        boolean resultado=false;
        resultado=ConexionBD.AgregarRegistro(u);
        return resultado;
    }
    
    public boolean modificarRegistro(Usuario u){
        boolean resultado=false;
        resultado=ConexionBD.actualizarRegistro(u);
        return resultado;
    }
    
    public ArrayList<Usuario> buscar(String filtro){
        ArrayList<Usuario> lista= new ArrayList<Usuario>();
        ResultSet rs = ConexionBD.ejecutarConsulta(filtro);
        try{
            if(rs.next()){
                do{
                    lista.add(new Usuario(
                            rs.getString(1),
                            rs.getString(2)));
                }while(rs.next());
            
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean borrarRegistro(Usuario u){
        boolean resultado = false;
        String sql = "DELETE FROM Usuario WHERE Username='"+u.getNombre()+"'";
        resultado = ConexionBD.eliminarRegistro(sql);
        return resultado;
    }
   
}
