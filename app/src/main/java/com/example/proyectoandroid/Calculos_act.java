package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Cotizador;

public class Calculos_act extends AppCompatActivity {
    private Spinner spnCalculoEmpresa, spnCalculoCant, spnCalculoProd;
    private CheckBox chBEnvio;
    private TextView tvCalculoRes;
    private Cotizador cotizador = new Cotizador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);

        spnCalculoEmpresa = findViewById(R.id.spnCalculoEmpresa);
        spnCalculoCant = findViewById(R.id.spnCalculoCant);
        spnCalculoProd = findViewById(R.id.spnCalculoBot);
        chBEnvio = findViewById(R.id.chBEnvio);
        tvCalculoRes = findViewById(R.id.tvCalculoRes);

        ArrayAdapter adapterEmpresa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cotizador.getEmpresas());
        ArrayAdapter adapterCant = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cotizador.getCantidades());
        ArrayAdapter adapterProd = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cotizador.getProductos());

        spnCalculoEmpresa.setAdapter(adapterEmpresa);
        spnCalculoCant.setAdapter(adapterCant);
        spnCalculoProd.setAdapter(adapterProd);
    }

    public void Calcular(View view){
        String empresaSelec = spnCalculoEmpresa.getSelectedItem().toString();
        int cantSelec = Integer.parseInt(spnCalculoCant.getSelectedItem().toString());
        String prodSelec = spnCalculoProd.getSelectedItem().toString();
        boolean envioSelec = chBEnvio.isChecked();

        int resCalculo = cotizador.Cotizar(empresaSelec, prodSelec, cantSelec, envioSelec);
        tvCalculoRes.setText("El total es: $" + resCalculo);
    }
}