package com.example.appandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import BaseDatos.WorldBD;
import BaseDatos.WorldBD_Impl;
import Entidades.City;

public class ActivityBajas extends AppCompatActivity {
    EditText id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);

        id=findViewById(R.id.caja_id2);
    }

    /*public void busquedaBajas(View v){

        if(!id.getText().toString().isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    City cityForDeletion=null;
                    WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                    cityForDeletion = conexionBD.cityDAO().buscarPorId(Integer.parseInt(id.getText().toString()));

                    if(cityForDeletion==null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"No existe la ciudad",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).start();
        }

    }*/

    public void borrar(View v){
        if(!id.getText().toString().isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                    conexionBD.cityDAO().eliminarPorId(Integer.parseInt(id.getText().toString()));
                }
            }).start();
        }
    }

}
