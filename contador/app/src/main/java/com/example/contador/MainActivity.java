package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //ggggggggggggggggg
    TextView contador;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.textoContador);
        boton = (Button) findViewById(R.id.button);
    }
    public void sumar( View v){
        int numero;
        String fin;
        numero = Integer.parseInt(contador.getText().toString());
        numero++;
        if(numero % 2 == 0){
            contador.setTextColor(Color.rgb(0,255,255));
        }else{
            contador.setTextColor(Color.rgb(67,55,42));
        }
        if(numero == 39){
            contador.setTextColor(Color.rgb(255,0,0));
        }
        fin = Integer.toString(numero);
        contador.setText(fin);

        if(numero == 50){
            Button boton = (Button) findViewById(R.id.button);
            boton.setEnabled(false);
            contador.setText("parada");
        }

    }
}