package com.example.appandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrir_activities(View v){
        Intent i =null;
        switch (v.getId()){
            case R.id.btn_agregar:
                i=new Intent(this,ActivityAltas.class);
                break;
            case R.id.btn_eliminar:
                i=new Intent(this,ActivityBajas.class);
                break;
            case R.id.btn_modificar:
                i=new Intent(this,ActivityCambios.class);
                break;
            case R.id.btn_consultas:
                i=new Intent(this,ActivityConsultas.class);
                break;
        }
        startActivity(i);

    }

}
