package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.textoContador);
    }
    public void sumar( View v){
        int numero;
        String fin;
        numero = Integer.parseInt(contador.getText().toString());
        numero++;
        fin = Integer.toString(numero);
        contador.setText(fin);


    }
}