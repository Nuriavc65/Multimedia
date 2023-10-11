package com.example.contador;

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
    public void salir(){
        finish();
    }
}