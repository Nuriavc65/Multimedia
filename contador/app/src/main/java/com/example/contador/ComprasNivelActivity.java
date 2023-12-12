package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class ComprasNivelActivity extends AppCompatActivity {
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
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras_nivel);

        nivel = findViewById(R.id.valorClicks);
        nivel2 = findViewById(R.id.valorAutoClick);
        botonAuto = findViewById(R.id.botonSubidaAuto);


        sumarAuto();
        bundle = getIntent().getExtras();
        if (bundle != null) {
            user = (User) bundle.getSerializable("USER");
            monedas = new BigInteger(user.getClicker());
            valorClick = user.getClick();
            valorAutoClick = user.getAutoClick();
            mejoras = new BigInteger("1");
            costeBillete = user.getPrecioClick();
            costeBilleteAuto = user.getPrecioAutoClick();
        }
        nivel2.setText("valor: " + costeBilleteAuto);
        nivel.setText("valor: " + costeBillete);

    }

    public void subidaDeNivel(View v) {
        if (monedas.longValue() > costeBillete) { // si el valor del contador es mayor o igual al
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBillete)));
            contador = monedas.toString();
            valorClick++;
            costeBillete = costeBillete + 10;
            nivel.setText("valor: " + costeBillete);
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
            nivel2.setText("valor: " + costeBilleteAuto);
        }
    }

    public void volver(View v) {
        Intent n = new Intent(this, MainActivity.class);
        user = new User(user.getUser(), costeBilleteAuto, costeBillete, valorAutoClick, valorClick, monedas.toString(), user.getPassword());
        n.putExtra("USER", user);
        startActivity(n);
        finish();
    }
}