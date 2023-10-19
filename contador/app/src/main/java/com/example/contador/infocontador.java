package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class infocontador extends AppCompatActivity {

    TextView texto1;
    TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infocontador);
        texto1 = (TextView) findViewById(R.id.textView4);
        texto2 = (TextView) findViewById(R.id.textView5);
    }
    public void irInicio(View v){
        Intent n = new Intent(this,PantallaInicio.class);
        startActivity(n);
    }
}