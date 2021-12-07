package com.example.appandroid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import BaseDatos.WorldBD;
import BaseDatos.WorldBD_Impl;
import Entidades.City;

public class ActivityBajas extends AppCompatActivity {
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<City> e;
    EditText id, nm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);

        recycler=findViewById(R.id.recyclerViewBajas);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        id=findViewById(R.id.caja_id2);
        nm=findViewById(R.id.caja_name2);

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String[] datos = {""};
                int[] c = new int[1];
                if (!id.getText().toString().isEmpty()||!nm.getText().toString().isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                            if(!id.getText().toString().isEmpty()&&!nm.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().busquedaFiltrada("%"+id.getText().toString()+"%","%"+nm.getText().toString()+"%");
                            }else if(!id.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().buscarPorId("%"+id.getText().toString()+"%");
                            }else if(!nm.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().buscarPorNombre("%"+nm.getText().toString()+"%");
                            }
                            adapter=new AdaptadorRegistros(e,getBaseContext());
                            recycler.setAdapter(adapter);

                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();

                            adapter=new AdaptadorRegistros(e,getBaseContext());
                            recycler.setAdapter(adapter);
                        }
                    }).start();
                }




            }
        });

        nm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String[] datos = {""};
                int[] c = new int[1];
                if (!id.getText().toString().isEmpty()||!nm.getText().toString().isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                            if(!id.getText().toString().isEmpty()&&!nm.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().busquedaFiltrada("%"+id.getText().toString()+"%","%"+nm.getText().toString()+"%");
                            }else if(!id.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().buscarPorId("%"+id.getText().toString()+"%");
                            }else if(!nm.getText().toString().isEmpty()){
                                e=conexionBD.cityDAO().buscarPorNombre("%"+nm.getText().toString()+"%");
                            }

                            adapter=new AdaptadorRegistros(e,getBaseContext());
                            recycler.setAdapter(adapter);

                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();

                            adapter=new AdaptadorRegistros(e,getBaseContext());
                            recycler.setAdapter(adapter);
                        }
                    }).start();
                }




            }
        });

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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Ciudad eliminada con éxito", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).start();
        }
    }

}
