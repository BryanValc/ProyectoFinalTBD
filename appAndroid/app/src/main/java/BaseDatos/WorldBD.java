package BaseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import DAO.*;
import Entidades.*;

@Database(entities = {Usuario.class, Country.class, City.class, CountryLanguage.class},version = 1,exportSchema = false)

public abstract class WorldBD extends RoomDatabase {




}
