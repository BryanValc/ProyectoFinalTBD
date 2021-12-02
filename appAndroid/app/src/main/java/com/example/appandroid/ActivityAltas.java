package com.example.appandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityAltas extends AppCompatActivity {

    EditText caja_id, caja_name, caja_countryCode, caja_district, caja_population;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
        caja_id = findViewById(R.id.caja_id);
        caja_name = findViewById(R.id.caja_name);
        caja_countryCode = findViewById(R.id.caja_countryCode);
        caja_district= findViewById(R.id.caja_district);
        caja_population = findViewById(R.id.caja_population);
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

    public void agregarCity(View v){
        if(comprobarCampos()){
            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());

            new Thread(new Runnable() {
                @Override
                public void run() {

                    City city = new City(
                            Integer.parseInt(caja_id.getText().toString()),
                            caja_name.getText().toString(),
                            caja_countryCode.getText().toString(),
                            caja_district.getText().toString(),
                            Integer.parseInt(caja_population.getText().toString())
                    );

                    conexionBD.cityDAO().insertarCity(city);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(),"Agregada con éxito",Toast.LENGTH_LONG).show();
                        }
                    });



                }
            }).start();

        }

    }

}
