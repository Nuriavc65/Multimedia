package com.example.tareas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Actividad3 extends AppCompatActivity {

    ArrayList<String> datos;
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_actividad3);

        recycle = findViewById(R.id.dato);
        recycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        datos = new ArrayList<String>();
        for(int i=0;i<=50;i++){
            datos.add("Pablo");
            datos.add("Nacho");
            datos.add("Carlos");
            datos.add("Abel");
        }
    }
}