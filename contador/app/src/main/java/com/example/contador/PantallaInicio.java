package com.example.contador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }
    public void pantallaJuego (View v) {
        Intent abrir = new Intent(this,MainActivity.class);
        startActivity(abrir);
    }
    public void pantallaInfo(View v){
        Intent info = new Intent(this,infocontador.class);
        startActivity(info);
    }
    public void salir(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("¿Estas seguro que quieres salir?")
                .setIcon(R.drawable.carrito)
                .setPositiveButton("Si",(_x,_y) -> finish())
                .setNegativeButton("no",null)
                .show();
    }
}