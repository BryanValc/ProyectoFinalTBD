package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.Usuario;

@Dao
public interface UsuarioDAO {

    //Altas
    @Insert
    public void insertarUsuario(Usuario usuario);

    //Bajas
    @Query("DELETE FROM Usuario WHERE username=:nom")
    public void eliminarPorNombre(String nom);

    //Cambios
    @Query("UPDATE Usuario SET password=:pwd WHERE username=:unm")
    public void modificarPorNumControl(String unm,String pwd);

    //Consultas
    @Query("SELECT * FROM Usuario")
    public List<Usuario> optenerTodos();

    @Query("SELECT * FROM Usuario WHERE username LIKE :unm")
    public Usuario buscarPorNombre(String unm);

}
