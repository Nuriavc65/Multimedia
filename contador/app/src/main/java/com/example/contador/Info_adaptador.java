package com.example.contador;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Info_adaptador extends ArrayAdapter<Info> {
    List <Info> infos;

    public Info_adaptador(@NonNull Context context, int resource, @NonNull List<Info>infos) {
        super(context, resource, infos);
    }
    public View getView (int posicion, @Nullable View convertView, @NonNull ViewGroup parent){
        Info info = getItem(posicion);
        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.esquema,parent,false);
        }
        ((ImageView) convertView.findViewById(R.id.img)).setImageResource(info.getImage());
        ((TextView) convertView.findViewById(R.id.texto)).setText(info.getTexto());
        ((TextView) convertView.findViewById(R.id.texto)).setTextColor(Color.WHITE);
        ((TextView) convertView.findViewById(R.id.subTexto)).setText(info.getTextoMenor());
        ((TextView) convertView.findViewById(R.id.subTexto)).setTextColor(Color.WHITE);



        return convertView;
    }

}
