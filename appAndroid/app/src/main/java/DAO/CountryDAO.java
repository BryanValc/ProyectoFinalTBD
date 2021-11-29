package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.Country;

@Dao
public interface CountryDAO {

    //Altas
    @Insert
    public void insertarCountry(Country contry);

    //Bajas
    @Query("DELETE FROM Country WHERE code=:cod")
    public void eliminarPorCodigo(String cod);

    //Cambios
    @Query("UPDATE Country SET name=:nm,continent=:cnt,region=:rgn,surfaceArea=:sfa,indepYear=:iyr,population=:ppl,lifeExpectancy=:lex,GNP=:GP,GNPOld=:GOl,localName=:lnm,governmentForm=:gfm,headOfState=:hos,capital=:cpt,code2=:cd2 WHERE code=:cd")
    public void modificarPorNumControl(String cd,String nm,String cnt,String rgn,float sfa,int iyr,int ppl,float lex,float GP,float GOl,String lnm,String gfm,String hos,int cpt,String cd2);

    //Consultas
    @Query("SELECT * FROM Country")
    public List<Country> optenerTodos();

    @Query("SELECT * FROM Country WHERE code LIKE :cd")
    public Country buscarPorCodigo(String cd);

}
