package com.example.examennuria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pantallaJuego (View v) {  //pasa a la actividad
        Intent abrir = new Intent(this,PantallaJuego2.class);
        startActivity(abrir);
    }
    public void salir(View view){ //finaliza la actividad
        finish();
    }
}