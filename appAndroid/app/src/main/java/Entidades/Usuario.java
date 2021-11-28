package Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name="nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name="contraseña")
    private String contraseña;

    public Usuario(@NonNull String nombre, @NonNull String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(@NonNull String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
