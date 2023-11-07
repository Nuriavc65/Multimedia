package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    TextView Contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras_nivel);

        nivel = (TextView) findViewById(R.id.valorClicks);
        nivel2 = (TextView) findViewById(R.id.valorAutoClick);
        botonAuto = (ImageView) findViewById(R.id.botonSubidaAuto);


        sumarAuto();
        bundle = getIntent().getExtras();
        if (bundle != null) {
            Log.d("nuria", "shop-nuria aprende a programar");
            monedas = new BigInteger(bundle.getString("monedas"));
            contador = bundle.getString("contador");
            valorClick = bundle.getInt("valorClick");
            mejoras = new BigInteger(bundle.getString("mejoras"));
            costeBilleteAuto = bundle.getInt("costeAuto");
            valorAutoClick = bundle.getInt("botonAuto");
            costeBillete = bundle.getInt("costeClick");
        }
        nivel2.setText("valor: " + Integer.toString(costeBilleteAuto));
        nivel.setText("valor: " + Integer.toString(costeBillete));

    }

    public void subidaDeNivel(View v) {
        if (monedas.longValue() > costeBillete) { // si el valor del contador es mayor o igual al
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBillete)));
            contador = monedas.toString();
            valorClick++;
            costeBillete = costeBillete + 10;
            nivel.setText("valor: " + Integer.toString(costeBillete));
            monedas = monedas.add(BigInteger.valueOf(valorClick));

        }
    }

    public void sumarAuto() {
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

    public void SubidaAutoClick(View v) {
        if (monedas.longValue() > costeBilleteAuto) {
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBilleteAuto)));
            contador = monedas.toString();
            valorAutoClick++;
            costeBilleteAuto = costeBilleteAuto + 20;
            nivel2.setText("valor: " + Integer.toString(costeBilleteAuto));
        }
    }

    public void volver(View v) {
        Intent n = new Intent(this, MainActivity.class);
        n.putExtra("monedas", monedas.toString());
        n.putExtra("contador", contador);
        n.putExtra("valorClick", valorClick);
        n.putExtra("mejoras", mejoras.toString());
        n.putExtra("costeAuto", costeBilleteAuto);
        n.putExtra("botonAuto",valorAutoClick);
        n.putExtra("costeClick",costeBillete);
        startActivity(n);
        finish();
    }
}