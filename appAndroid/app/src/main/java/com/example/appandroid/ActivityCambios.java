package com.example.appandroid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityCambios extends AppCompatActivity {
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<City> e;
    EditText id;
    EditText nm;
    EditText caja_countryCode;
    EditText caja_district;
    EditText caja_population;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);

        caja_countryCode = findViewById(R.id.caja_countryCode3);
        caja_district= findViewById(R.id.caja_district3);
        caja_population = findViewById(R.id.caja_population3);

        recycler=findViewById(R.id.recyclerViewCambios);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        id = findViewById(R.id.caja_id3);
        nm = findViewById(R.id.caja_name3);


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
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter=new AdaptadorRegistros(e,getBaseContext());
                                    recycler.setAdapter(adapter);
                                }
                            });


                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter=new AdaptadorRegistros(e,getBaseContext());
                                    recycler.setAdapter(adapter);
                                }
                            });

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

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter=new AdaptadorRegistros(e,getBaseContext());
                                    recycler.setAdapter(adapter);
                                }
                            });


                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter=new AdaptadorRegistros(e,getBaseContext());
                                    recycler.setAdapter(adapter);
                                }
                            });
                        }
                    }).start();
                }

            }
        });


    }

    public boolean comprobarCampos(){
        if (id.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el id",Toast.LENGTH_LONG).show();
            return false;
        }
        if(nm.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el nombre",Toast.LENGTH_LONG).show();
            return false;
        }
        if(caja_countryCode.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el código de país",Toast.LENGTH_LONG).show();
            return false;
        }
        if(caja_district.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Falta el distrito",Toast.LENGTH_LONG).show();
            return false;
        }
        if(caja_population.getText().toString().isEmpty()){
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
                    city=conexionBD.cityDAO().buscarUnoPorId(Integer.parseInt(id.getText().toString()));
                    if(city!=null){
                        int iid=Integer.parseInt(id.getText().toString());
                        String name=nm.getText().toString();
                        String countryCode=caja_countryCode.getText().toString();
                        String district=caja_district.getText().toString();
                        int population=Integer.parseInt(caja_population.getText().toString());
                        conexionBD.cityDAO().modificarPorId(iid,name,countryCode,district,population);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"La ciudad fue actualizada",Toast.LENGTH_LONG).show();
                            }
                        });
                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"La ciudad no existe",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }).start();
        }
    }

}
