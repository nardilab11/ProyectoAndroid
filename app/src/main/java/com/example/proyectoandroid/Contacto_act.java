package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Contacto_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void Maps(View view){
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://m.facebook.com/AguasAndinas.oficial/?locale2=es_LA"));
        startActivity(i);
    }

    public void Instagram(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://instagram.com/aguas_andinas?utm_medium=copy_link"));
        startActivity(i);
    }

    public void Telefono(View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "56922634627"));
        startActivity(i);
    }

    public void Correo(View view){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:aguasandinas@gmail.com"));
        startActivity(i);
    }
}