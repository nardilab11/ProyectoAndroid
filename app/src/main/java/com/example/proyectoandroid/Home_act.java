package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Home_act extends AppCompatActivity {
    private VideoView videoBotellas;
    private TextView tvUsuarioActivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoBotellas = findViewById(R.id.vwBotellas);
        tvUsuarioActivo = findViewById(R.id.tvUsuarioActivo);

        String usuarioActivoCarga = getIntent().getStringExtra("usuarioActivo2");
        tvUsuarioActivo.setText("Bienvenido, " + usuarioActivoCarga);

        String rutaVideoBotellas = "android.resource://" + getPackageName() + "/" + R.raw.video_sacando_botellas;
        Uri uriVideoBotellas = Uri.parse(rutaVideoBotellas);
        videoBotellas.setVideoURI(uriVideoBotellas);

        MediaController media = new MediaController(this);
        videoBotellas.setMediaController(media);
        videoBotellas.start();

        videoBotellas.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoBotellas.start();
            }
        });
    }

    public void Calculos(View view){
        Intent i = new Intent(this, Calculos_act.class);
        startActivity(i);
    }

    public void Locales(View view){
        Intent i = new Intent(this, Locales_act.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoBotellas.start();
    }
}