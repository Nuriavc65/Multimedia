package com.example.contador;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    ImageView img;
    int valorClick = 1;
    int costeBillete = 100;
    BigInteger monedas = new BigInteger("93");
    BigDecimal decimal;
    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    //animacion del programa
    BigInteger mejoras = new BigInteger("1");
    int valorAutoClick = 1;
    int costeBilleteAuto = 100;

    MediaPlayer musica;
    int m;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.textoContador);
        img = (ImageView) findViewById(R.id.imageView);
        musica = MediaPlayer.create(this, R.raw.coinsound);
        fade_in.setDuration(100);
        musica.start();
        sumarAuto();
        bundle = getIntent().getExtras();
        if (bundle != null) {
        monedas = new BigInteger(bundle.getString("monedas"));
        contador.setText(bundle.getString("contador"));
        valorClick = bundle.getInt("valorClick");
        mejoras = new BigInteger(bundle.getString("mejoras"));
        costeBilleteAuto = bundle.getInt("costeAuto");

        }


    }
    public void sumar( View v){
        monedas = monedas.add(BigInteger.valueOf(valorClick));
        img.startAnimation(fade_in);
        if(monedas.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){ //pares --> monedas%2==0
            contador.setTextColor(Color.rgb(0,255,255));
        }else{
            contador.setTextColor(Color.rgb(0,255,0));
        }
        if(monedas.equals(BigInteger.valueOf(39))){         //cuando llegue a 39 color rojo
            contador.setTextColor(Color.rgb(255,0,0));
        }
        if(monedas.longValue()>10000){ //1000d d de double para obtener el numero decimal --> monedas >= 10000
            decimal = BigDecimal.valueOf(monedas.longValue()/1000d);
            contador.setText(decimal.toString().substring(0,1)+"M");
        }else {
            contador.setText(monedas.toString()); //como texto es un String hay que pasar el numero a String
        }

    }
    public void  sumarAuto() {
        Thread hilo = new Thread(() -> {
            while (true) {
                monedas = monedas.add(BigInteger.valueOf(valorAutoClick));
                runOnUiThread(() -> {
                    contador.setText(monedas.toString());
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        hilo.start();

    }

    public void irInicio(View v){
        Intent n = new Intent(this,PantallaInicio.class);


        startActivity(n);
    }
    public void comprasNivel (View v){
        Intent n = new Intent(this,ComprasNivel.class);
        n.putExtra("monedas",monedas.toString());
        n.putExtra("contador",contador.toString());
        n.putExtra("valorClick",valorClick);
        n.putExtra("mejoras",mejoras.toString());
        n.putExtra("costeAuto",costeBilleteAuto);
        startActivity(n);

    }


}