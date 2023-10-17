package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}