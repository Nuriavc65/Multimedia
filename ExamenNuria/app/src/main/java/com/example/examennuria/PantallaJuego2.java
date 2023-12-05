package com.example.examennuria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;

public class PantallaJuego2 extends AppCompatActivity {

    TextView contador; //para mostrar el numero en pantalla al no ser capaz de meterlo como un tiempo lo almaceno como un numero
    //no puedo lograr ponerlo como timer por lo cual lo pongo como texView
    BigInteger valorContador = new BigInteger("0"); //almacenamos el numero del contador
    int valor = 1;          //para ir sumando de uno en uno
    boolean start = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego2);
        contador = (TextView) findViewById(R.id.textoContador);

    }
    public void play() {  //contador comienza a contar de uno en uno
        start = true;
        Thread hilo = new Thread(() -> {
            while (start) {
                valorContador = valorContador.add(BigInteger.valueOf(valor));
                runOnUiThread(() -> {
                    contador.setText(valorContador.toString());
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        hilo.start();
    }
    public void pausa(){ //contador para
        start = false;
    }


}