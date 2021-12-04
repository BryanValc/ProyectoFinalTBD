package com.example.appandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BaseDatos.WorldBD;
import Entidades.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText cajaUsername, cajaPassword;
    Usuario usrMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaUsername=findViewById(R.id.caja_username);
        cajaPassword=findViewById(R.id.caja_password);
        usrMain = new Usuario("BryanValc","c1s1g7o");
        new Thread(new Runnable() {
            @Override
            public void run() {
                WorldBD conexion = WorldBD.getAppDatabase(getBaseContext());
                conexion.usuarioDAO().insertarUsuario(usrMain);
            }
        }).start();

    }

    public void abrirMenu(View v){
        Intent i=new Intent(this, ActivityMenu.class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                WorldBD conexion = WorldBD.getAppDatabase(getBaseContext());
                Usuario usr = conexion.usuarioDAO().buscarPorNombre(cajaUsername.getText().toString());
                if (!cajaUsername.getText().toString().isEmpty() && !cajaPassword.getText().toString().isEmpty() && usr!=null){
                    if (usr.getUsername().equals(usrMain.getUsername()) && usr.getPassword().equals(usrMain.getPassword())) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Bienvenido " + usr.getUsername().toString(), Toast.LENGTH_LONG).show();
                                startActivity(i);
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();

                        }

                    });

                }

            }

        }).start();

    }

}