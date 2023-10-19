package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;

public class ComprasNivel extends AppCompatActivity {
    ImageView botonAuto;
    TextView nivel;
    TextView nivel2;
    BigInteger monedas = new BigInteger("93");
    BigInteger mejoras = BigInteger.valueOf(1);
    int costeBillete = 100;
    String contador;
    int valorClick = 1;
    int valorAutoClick = 1;
    int costeBilleteAuto = 100;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nivel = (TextView) findViewById(R.id.nivel);
        nivel2 = (TextView) findViewById(R.id.nivel2);
        botonAuto = (ImageView)findViewById(R.id.subidaAuto);
        setContentView(R.layout.activity_compras_nivel);
        sumarAuto();
        bundle = getIntent().getExtras();
        monedas = new BigInteger(bundle.getString("monedas"));
        contador = bundle.getString("contador");
        valorClick = bundle.getInt("valorClick");
        mejoras = new BigInteger(bundle.getString("mejoras"));
        costeBilleteAuto = bundle.getInt("costeAuto");

    }
    public void subidaDeNivel (View v) {
        if(monedas.longValue() > costeBillete) { // si el valor del contador es mayor o igual al
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBillete)));
            contador = monedas.toString();
            valorClick++;
            costeBillete = costeBillete + 10;
            nivel.setText("valor: " +Integer.toString(costeBillete));
            monedas = monedas.add(BigInteger.valueOf(valorClick));

        }
    }
    public void  sumarAuto() {
        Thread hilo = new Thread(() -> {
            while (true) {
                monedas = monedas.add(BigInteger.valueOf(valorAutoClick));
                runOnUiThread(() -> {
                    contador = monedas.toString();
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        hilo.start();

    }
    public void SubidaAutoClick(View v){
        if(monedas.longValue()>costeBilleteAuto){
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBilleteAuto)));
            contador = monedas.toString();
            valorAutoClick++;
            costeBilleteAuto = costeBilleteAuto + 20;
            nivel2.setText("valor: " +Integer.toString(costeBilleteAuto));
        }
    }
    public void volver (){
        Intent n = new Intent(this,PantallaInicio.class);
        startActivity(n);
    }
}