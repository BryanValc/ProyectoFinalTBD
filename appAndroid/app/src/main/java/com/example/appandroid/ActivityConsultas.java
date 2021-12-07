package com.example.appandroid;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityConsultas extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<City> e;
    EditText id;
    EditText nm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        recycler=findViewById(R.id.recyclerViewConsultas);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        id = findViewById(R.id.caja_id4);
        nm = findViewById(R.id.caja_name4);

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

    /*public void busqueda (){
        String[] datos = {""};
        recycler=findViewById(R.id.recyclerView1);

        recycler.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        int[] c = new int[1];
        if(!id.getText().toString().isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                    e = conexionBD.cityDAO().busquedaFiltrada("%"+id.getText().toString()+"%");
                    c[0] =e.size();
                    for(int i=0;i<c[0];i++){
                        System.out.println(i+"--> "+e.get(i).toString());
                        datos[0] = datos[0]+e.get(i).toString()+"/";
                    }
                    System.out.println("Datos----->"+datos[0]);
                    adapter=new AdaptadorRegistros(datos[0].split("/"));
                    recycler.setAdapter(adapter);
                }
            }).start();

        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                    e = conexionBD.cityDAO().optenerTodos();
                    c[0] =e.size();
                    for(int i=0;i<c[0];i++){
                        datos[0] = datos[0]+e.get(i).toString()+"/";
                    }
                    System.out.println("Datos----->"+datos[0]);
                    adapter=new AdaptadorRegistros(datos[0].split("/"));
                    recycler.setAdapter(adapter);
                }
            }).start();


        }
    }*/

}



                                                                        //MyViewHolder
class AdaptadorRegistros extends RecyclerView.Adapter<AdaptadorRegistros.ViewHolder>{

    //private String[] mDataset;

    private List<City> mData;
    private LayoutInflater mInflater;
    private Context context;

    public AdaptadorRegistros(List<City> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public AdaptadorRegistros.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element,null);
        return new AdaptadorRegistros.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdaptadorRegistros.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<City> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView id, name, countryCode, district, population;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            id = itemView.findViewById(R.id.cityId);
            name = itemView.findViewById(R.id.cityName);
            countryCode = itemView.findViewById(R.id.cityCountryCode);
            district = itemView.findViewById(R.id.cityDistrict);
            population = itemView.findViewById(R.id.cityPopulation);
        }

        void bindData(final City city) {
            id.setText("id: "+city.getId());
            name.setText("nombre: "+city.getName());
            countryCode.setText("código de país: "+city.getCountryCode());
            district.setText("distrito: "+city.getDistrict());
            population.setText("población: "+city.getPopulation());
        }

    }

}
