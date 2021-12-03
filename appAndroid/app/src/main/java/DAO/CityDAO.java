package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.City;

@Dao
public interface CityDAO {

    //Altas
    @Insert
    public void insertarCity(City city);

    //Bajas
    @Query("DELETE FROM City WHERE id=:i")
    public void eliminarPorId(int i);

    //Cambios
    @Query("UPDATE City SET name=:nm,countryCode=:cc,district=:dt,population=:pp WHERE id=:i")
    public void modificarPorId(int i,String nm,String cc,String dt,int pp);

    //Consultas
    @Query("SELECT * FROM City")
    public List<City> optenerTodos();

    @Query("SELECT * FROM City WHERE id LIKE :i")
    public List<City> buscarPorId(int i);

    @Query("SELECT * FROM City WHERE id LIKE :i")
    public City buscarUnoPorId(int i);

    @Query("SELECT * FROM City WHERE id LIKE :i")
    public List<City> busquedaFiltrada(String i);
}
