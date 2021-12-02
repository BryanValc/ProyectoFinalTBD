package com.example.appandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityAltas extends AppCompatActivity {

    EditText caja_id, caja_name, caja_countryCode, caja_district, caja_population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
        caja_id = findViewById(R.id.caja_id);
        caja_name = findViewById(R.id.caja_name);
        caja_countryCode = findViewById(R.id.caja_countryCode);
        caja_district= findViewById(R.id.caja_district);
        caja_population = findViewById(R.id.caja_population);
    }

    public boolean comprobarCampos(){
        if (caja_id.getText().equals("")){
            Toast.makeText(getBaseContext(),"Falta el id",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_name.getText().equals("")){
            Toast.makeText(getBaseContext(),"Falta el nombre",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_countryCode.getText().equals("")){
            Toast.makeText(getBaseContext(),"Falta el código de país",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_district.getText().equals("")){
            Toast.makeText(getBaseContext(),"Falta el distrito",Toast.LENGTH_LONG).show();
            return false;
        } else if(caja_population.getText().equals("")){
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

                    City city = new City();

                    conexionBD.cityDAO().insertarCity();

                }
            }).start();

        }

    }

}
