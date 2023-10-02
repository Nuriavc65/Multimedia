package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    ImageView boton;
    ImageView img;
    int valorClick = 1;
    int costeBillete = 100;
    int monedas =9999;
    TextView nivel;
    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = (TextView) findViewById(R.id.textoContador);
        boton = (ImageView) findViewById(R.id.imageView);
        img = (ImageView) findViewById(R.id.imageView);
        nivel = (TextView) findViewById(R.id.nivel);
        fade_in.setDuration(100);
    }
    public void sumar( View v){
        //String fin;
        monedas = monedas + valorClick;
        img.startAnimation(fade_in);
        if(monedas % 2 == 0){
            contador.setTextColor(Color.rgb(0,255,255));
        }else{
            contador.setTextColor(Color.rgb(0,255,0));
        }
        if(monedas == 39){
            contador.setTextColor(Color.rgb(255,0,0));
        }
        if(monedas >= 10000){
            contador.setText(Double.toString(monedas/10000d).substring(0,3)+"M"); //1000d la de para obtener el numero decimal
        }else {
            contador.setText(Integer.toString(monedas)); //como texto es un String hay que pasar el numero a String
        }

    }
    public void subidaDeNivel (View v) {
        int con = Integer.parseInt(contador.getText().toString());
        if(con >= costeBillete) {
            con = con - costeBillete;
            String z = Integer.toString(con);
            contador.setText(z);
            valorClick++;
            costeBillete = costeBillete + 50;
            nivel.setText("ahora el valor es: " +Integer.toString(costeBillete));
        }
    }


}