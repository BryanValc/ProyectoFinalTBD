package BaseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import DAO.*;
import Entidades.*;

@Database(entities = {Usuario.class, Country.class, City.class, CountryLanguage.class},version = 1,exportSchema = false)

public abstract class WorldBD extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();
    public abstract CountryDAO countryDAO();
    public abstract CityDAO cityDAO();
    public abstract CountryLanguageDAO countryLanguageDAO();

    private static WorldBD INSTANCE;

    public static WorldBD getAppDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WorldBD.class, "@world").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }


}
