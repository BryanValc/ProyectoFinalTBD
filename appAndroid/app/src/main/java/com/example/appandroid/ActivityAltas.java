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
import Entidades.City;

public class ActivityAltas extends AppCompatActivity {
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<City> e;

    EditText id, caja_name, caja_countryCode, caja_district, caja_population;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        recycler=findViewById(R.id.recyclerViewAltas);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        id = findViewById(R.id.caja_id);
        caja_name = findViewById(R.id.caja_name);
        caja_countryCode = findViewById(R.id.caja_countryCode);
        caja_district= findViewById(R.id.caja_district);
        caja_population = findViewById(R.id.caja_population);

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
                if (!id.getText().toString().isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().buscarPorId("%"+id.getText().toString()+"%");

                            if(e.size()!=0){
                                adapter=new AdaptadorRegistros(e,getBaseContext());
                                recycler.setAdapter(adapter);
                            }


                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();

                            if(e.size()!=0) {
                                adapter = new AdaptadorRegistros(e, getBaseContext());
                                recycler.setAdapter(adapter);
                            }
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
        if(caja_name.getText().toString().isEmpty()){
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

    public void agregarCity(View v){
        if(comprobarCampos()){
            City city = new City(
                    Integer.parseInt(id.getText().toString()),
                    caja_name.getText().toString(),
                    caja_countryCode.getText().toString(),
                    caja_district.getText().toString(),
                    Integer.parseInt(caja_population.getText().toString())
            );


            new Thread(new Runnable() {
                @Override
                public void run() {
                    WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                    try{
                        conexionBD.cityDAO().insertarCity(city);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"Agregada con éxito",Toast.LENGTH_LONG).show();
                                id.setText("");
                                caja_name.setText("");
                                caja_countryCode.setText("");
                                caja_district.setText("");
                                caja_population.setText("");
                            }
                        });
                    }catch (Exception e){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"El registro agregado ya existe",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                }
            }).start();

        }

    }

}
