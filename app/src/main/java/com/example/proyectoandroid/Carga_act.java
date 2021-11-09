package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class Carga_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        new Task().execute();
    }

    class Task extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String usuarioActivoLogin = getIntent().getStringExtra("usuarioActivo");
            Intent i = new Intent(getBaseContext(), Home_act.class);
            i.putExtra("usuarioActivo2", usuarioActivoLogin);
            startActivity(i);
            finish();
        }
    }
}