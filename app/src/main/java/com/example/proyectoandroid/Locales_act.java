package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoandroid.database.AdminSQLiteOpenHelper;

public class Locales_act extends AppCompatActivity {
    private EditText etIDLoc, etNomLoc, etStockBotLoc, etStockBidLoc;
    private TextView tvIDLoc, tvNomLoc, tvStockBotLoc, tvStockBidLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locales);

        etIDLoc = findViewById(R.id.etIDLoc);
        etNomLoc = findViewById(R.id.etNomLoc);
        etStockBotLoc = findViewById(R.id.etStockBotLoc);
        etStockBidLoc = findViewById(R.id.etStockBidLoc);
        tvIDLoc = findViewById(R.id.tvIDLoc);
        tvNomLoc = findViewById(R.id.tvNomLoc);
        tvStockBotLoc = findViewById(R.id.tvStockBotLoc);
        tvStockBidLoc = findViewById(R.id.tvStockBidLoc);
    }

    public void guardarLocal(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "adminwatersdb", null, 1);
        SQLiteDatabase db = adminDB.getWritableDatabase();

        String idLoc = etIDLoc.getText().toString().trim();
        String nomLoc = etNomLoc.getText().toString().trim();
        String stockBotLoc = etStockBotLoc.getText().toString().trim();
        String stockBidLoc = etStockBidLoc.getText().toString().trim();

        if(idLoc.isEmpty() || nomLoc.isEmpty() || stockBotLoc.isEmpty() || stockBidLoc.isEmpty()){
            Toast.makeText(this, "Error. Debe llenar todos los campos para añadir un local", Toast.LENGTH_LONG).show();
        }else{
            ContentValues cont = new ContentValues();
            cont.put("id", idLoc);
            cont.put("nombre", nomLoc);
            cont.put("stockBot", stockBotLoc);
            cont.put("stockBid", stockBidLoc);

            long cant = db.insert("locales", null, cont);
            db.close();

            if(cant == -1){
                Toast.makeText(this, "Error. Ya existe un local con ese ID", Toast.LENGTH_LONG).show();
            }else{
                LimpiarLocales();
                Toast.makeText(this, "Local guardado exitosamente", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void mostrarLocal(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "adminwatersdb", null, 1);
        SQLiteDatabase db = adminDB.getWritableDatabase();

        String idLoc = etIDLoc.getText().toString().trim();

        if(idLoc.isEmpty()){
            Toast.makeText(this, "Error. Debe ingresar el ID del local a mostrar", Toast.LENGTH_LONG).show();
        }else{
            Cursor file = db.rawQuery("SELECT nombre, stockBot, stockBid FROM locales WHERE id=" + idLoc, null);
            if(file.moveToFirst()){
                tvIDLoc.setText(idLoc);
                tvNomLoc.setText(file.getString(0));
                tvStockBotLoc.setText(file.getString(1));
                tvStockBidLoc.setText(file.getString(2));
                LimpiarLocales();
            }else{
                Toast.makeText(this, "Error. No existe un local con ese ID", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void eliminarLocal(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "adminwatersdb", null, 1);
        SQLiteDatabase db = adminDB.getWritableDatabase();

        String idLoc = etIDLoc.getText().toString().trim();

        if(idLoc.isEmpty()){
            Toast.makeText(this, "Error. Debe ingresar el ID del local a eliminar", Toast.LENGTH_LONG).show();
        }else{
            int cant = db.delete("locales", "id=" + idLoc, null);
            db.close();
            if(cant == 1){
                Toast.makeText(this, "Se eliminó el local", Toast.LENGTH_LONG).show();
                LimpiarLocales();
            }else{
                Toast.makeText(this, "Error. No existe un local con ese ID", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void modificarLocal(View view){
        AdminSQLiteOpenHelper adminDB = new AdminSQLiteOpenHelper(this, "adminwatersdb", null, 1);
        SQLiteDatabase db = adminDB.getWritableDatabase();

        String idLoc = etIDLoc.getText().toString().trim();
        String nomLoc = etNomLoc.getText().toString().trim();
        String stockBotLoc = etStockBotLoc.getText().toString().trim();
        String stockBidLoc = etStockBidLoc.getText().toString().trim();

        if(idLoc.isEmpty() || nomLoc.isEmpty() || stockBotLoc.isEmpty() || stockBidLoc.isEmpty()){
            Toast.makeText(this, "Error. Debe ingresar los datos del local a modificar", Toast.LENGTH_LONG).show();
        }else{
            ContentValues cont = new ContentValues();
            cont.put("nombre", nomLoc);
            cont.put("stockBot", stockBotLoc);
            cont.put("stockBid", stockBidLoc);

            int cant = db.update("locales", cont, "id=" + idLoc, null);
            db.close();

            if(cant == 1){
                Toast.makeText(this, "Se modificó el local", Toast.LENGTH_LONG).show();
                LimpiarLocales();
            }else{
                Toast.makeText(this, "Error. No existe un local con ese ID", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void LimpiarLocales(){
        etIDLoc.setText("");
        etNomLoc.setText("");
        etStockBotLoc.setText("");
        etStockBidLoc.setText("");
    }
}