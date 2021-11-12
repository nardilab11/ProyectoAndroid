package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private Administrador admin = new Administrador();
    private EditText etUsuario, etContrasena;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        tvLogin = findViewById(R.id.tvLogin);
    }

    public void Ingresar(View view){
        String inputUsuario = etUsuario.getText().toString().trim();
        String inputContrasena = etContrasena.getText().toString().trim();
        if(inputUsuario.equals("") || inputContrasena.equals("")){
            tvLogin.setVisibility(View.VISIBLE);
            tvLogin.setText("Error. Tiene que llenar todos los campos.");
        }else{
            boolean exito = false;
            for(int i = 0; i < admin.getUsuarios().length; i++){
                if(inputUsuario.equals(admin.getUsuarios()[i])){
                    if(inputContrasena.equals(admin.getContrasenas()[i])){
                        exito = true;
                    }
                }
            }
            if(!exito){
                tvLogin.setVisibility(View.VISIBLE);
                tvLogin.setText("Credenciales incorrectas. Intente otra vez.");
                LimpiarLogin();
            }else{
                Intent i = new Intent(this, Carga_act.class);
                i.putExtra("usuarioActivo", inputUsuario);
                startActivity(i);
                tvLogin.setVisibility(View.INVISIBLE);
                LimpiarLogin();
            }
        }
    }

    public void Contacto(View view){
        Intent i = new Intent(this, Contacto_act.class);
        startActivity(i);
    }

    public void LimpiarLogin(){
        etUsuario.setText("");
        etContrasena.setText("");
    }

}