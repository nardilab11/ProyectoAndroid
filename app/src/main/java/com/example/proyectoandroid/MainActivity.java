package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Carga(View view){
        Intent i = new Intent(this, Carga_act.class);
        startActivity(i);
    }

    public void Contacto(View view){
        Intent i = new Intent(this, Contacto_act.class);
        startActivity(i);
    }

}