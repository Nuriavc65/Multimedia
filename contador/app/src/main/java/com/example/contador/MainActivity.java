package com.example.contador;

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
    ImageView boton;
    ImageView img;
    int valorClick = 1;
    int costeBillete = 100;
    BigInteger monedas = new BigInteger("93");
    BigDecimal decimal;
    TextView nivel;
    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    //animacion del programa
    BigInteger mejoras = BigInteger.valueOf(1);
    TextView nivel2;
    int valorAutoClick = 1;
    int costeBilleteAuto = 100;
    ImageView botonAuto;
    MediaPlayer musica;
    int m;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.textoContador);
        boton = (ImageView) findViewById(R.id.imageView);
        img = (ImageView) findViewById(R.id.imageView);
        nivel = (TextView) findViewById(R.id.nivel);
        nivel2 = (TextView) findViewById(R.id.nivel2);
        musica = MediaPlayer.create(this, R.raw.coinsound);
        fade_in.setDuration(100);
        sumarAuto();
        botonAuto = (ImageView)findViewById(R.id.subidaAuto);
        musica.start();

    }
    public void sumar( View v){
        monedas = monedas.add(BigInteger.valueOf(valorClick));
        img.startAnimation(fade_in);
        if(monedas.remainder(BigInteger.valueOf(2)).equals(0)){ //pares --> monedas%2==0
            contador.setTextColor(Color.rgb(0,255,255));
        }else{
            contador.setTextColor(Color.rgb(0,255,0));
        }
        if(monedas.equals(39)){         //cuando llegue a 39 color rojo
            contador.setTextColor(Color.rgb(255,0,0));
        }
        if(monedas.longValue()>10000){ //1000d d de double para obtener el numero decimal --> monedas >= 10000
            decimal = BigDecimal.valueOf(monedas.longValue()/1000d);
            contador.setText(decimal.toString().substring(0,1)+"M");
        }else {
            contador.setText(monedas.toString()); //como texto es un String hay que pasar el numero a String
        }

    }
    public void subidaDeNivel (View v) {
        if(monedas.longValue() > costeBillete) { // si el valor del contador es mayor o igual al
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBillete)));
            contador.setText(monedas.toString());
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
    public void SubidaAutoClick(View v){
        if(monedas.longValue()>costeBilleteAuto){
            monedas = monedas.subtract(new BigInteger(Integer.toString(costeBilleteAuto)));
            contador.setText(monedas.toString());
            valorAutoClick++;
            costeBilleteAuto = costeBilleteAuto + 20;
            nivel2.setText("valor: " +Integer.toString(costeBilleteAuto));
        }


    }


}