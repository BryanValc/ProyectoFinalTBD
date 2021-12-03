package com.example.appandroid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import BaseDatos.WorldBD;
import Entidades.City;

public class ActivityConsultas extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerView.Adapter adaper;
    RecyclerView.LayoutManager layoutManager;
    List<City> e;
    EditText id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        String[] datos = {""};
        recycler=findViewById(R.id.recyclerView1);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        int[] c = new int[1];

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!id.getText().toString().isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD=WorldBD.getAppDatabase(getBaseContext());
                            e=null;
                            e=conexionBD.cityDAO().buscarPorId(Integer.parseInt(id.getText().toString()));
                            c[0]=e.size();
                            datos[0]="";
                            for(int i=0;i<c[0];i++){
                                System.out.println(i+"--> "+e.get(i).toString());
                                datos[0]=datos[0]+e.get(i).toString()+"/";
                            }
                            System.out.println("Datos----->"+datos[0]);
                            adaper=new AdaptadorRegistros(datos[0].split("/"));
                            recycler.setAdapter(adaper);

                        }
                    }).start();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            WorldBD conexionBD = WorldBD.getAppDatabase(getBaseContext());
                            e=conexionBD.cityDAO().optenerTodos();
                            c[0]=e.size();
                            for(int i=0;i<c[0];i++){
                                datos[0]=datos[0]+e.get(i).toString()+"/";
                            }
                            System.out.println("Datos----->"+datos[0]);
                            adaper=new AdaptadorRegistros(datos[0].split("/"));
                            recycler.setAdapter(adaper);
                        }
                    }).start();
                }




            }
        });

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                WorldBD conexionDB = WorldBD.getAppDatabase(getBaseContext());
                e=conexionDB.cityDAO().optenerTodos();
                for(City a:e){
                    Log.d("datos->",a.toString());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter adaptador=new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,e);
                        lista.setAdapter(adaptador);
                    }
                });
            }
        }).start();*/

        recycler=findViewById(R.id.recyclerView1);
        recycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

    }

    public void busqueda (){
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
                    adaper=new AdaptadorRegistros(datos[0].split("/"));
                    recycler.setAdapter(adaper);
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
                    adaper=new AdaptadorRegistros(datos[0].split("/"));
                    recycler.setAdapter(adaper);
                }
            }).start();


        }
    }

}




class AdaptadorRegistros extends RecyclerView.Adapter<AdaptadorRegistros.MyViewHolder>{

    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MyViewHolder(TextView t) {
            super(t);
            textView = t;
        }
    }

    public AdaptadorRegistros(String [] mDataset){
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public AdaptadorRegistros.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.textviewreciclerview,
                parent, false);
        MyViewHolder vh = new MyViewHolder(tv);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
