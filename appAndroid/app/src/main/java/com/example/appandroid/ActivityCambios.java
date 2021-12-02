package com.example.appandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityCambios extends AppCompatActivity {
    EditText caja_id, caja_name, caja_countryCode, caja_district, caja_population;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);
        caja_id = findViewById(R.id.caja_id3);
        caja_name = findViewById(R.id.caja_name3);
        caja_countryCode = findViewById(R.id.caja_countryCode3);
        caja_district= findViewById(R.id.caja_district3);
        caja_population = findViewById(R.id.caja_population3);
    }

    public boolean comprobarCampos(){
        if (caja_id.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el id",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_name.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el nombre",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_countryCode.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el código de país",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_district.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el distrito",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_population.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta la población",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void cambiarCity (View v){
        if(comprobarCampos()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    City city=null;
                    WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                    city=conexionBD.cityDAO().buscarPorId(Integer.parseInt(caja_id.getText().toString()));
                    if(city!=null){
                        int id=Integer.parseInt(caja_id.getText().toString());
                        String name=caja_name.getText().toString();
                        String countryCode=caja_countryCode.getText().toString();
                        String district=caja_district.getText().toString();
                        int population=Integer.parseInt(caja_population.getText().toString());
                        conexionBD.cityDAO().modificarPorId(id,name,countryCode,district,population);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"La ciudad fue actualizada",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).start();
        }
    }

}
