package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class infocontador extends AppCompatActivity {

    TextView texto1;
    TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infocontador);
        texto1 = (TextView) findViewById(R.id.textView4);
        texto2 = (TextView) findViewById(R.id.textView5);

       List <Info> l = Arrays.asList(
            new Info("Lenguaje usado", "java", R.drawable.treslunas),
            new Info("Tiempo de llorera", "10 dias", R.drawable.serpiente),
            new Info("Imagenes", "pinterest",R.drawable.lunas)


        );
       ListView lv = (ListView) findViewById(R.id.listView);
       Info_adaptador upgrade = new Info_adaptador(this, R.layout.esquema,l);
       lv.setAdapter(upgrade);
    }
    public void irInicio(View v){
        Intent n = new Intent(this,PantallaInicio.class);
        startActivity(n);
    }
}