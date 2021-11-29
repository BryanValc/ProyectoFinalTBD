package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.CountryLanguage;

@Dao
public interface CountryLanguageDAO {

    //Altas
    @Insert
    public void insertarCountryLanguage(CountryLanguage countryLanguage);

    //Bajas
    @Query("DELETE FROM CountryLanguage WHERE countryCode=:cc AND language=:l")
    public void eliminarPorCodigoYLenguaje(String cc, String l);

    //Cambios
    @Query("UPDATE CountryLanguage SET isOfficial=:io,percentage=:pc WHERE countryCode=:cc AND language=:l")
    public void modificarPorCodigoYLenguaje(String cc,String l,char io,float pc);

    //Consultas
    @Query("SELECT * FROM CountryLanguage")
    public List<CountryLanguage> optenerTodos();

    @Query("SELECT * FROM countrylanguage WHERE countryCode LIKE :cc AND language LIKE :l")
    public CountryLanguage buscarPorCodigoYLenguaje(String cc, String l);

}
