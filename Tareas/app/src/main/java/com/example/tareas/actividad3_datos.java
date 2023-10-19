package com.example.tareas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class actividad3_datos  extends RecyclerView.Adapter<actividad3_datos.ViewHolderDatos> {

    ArrayList<String> datos;
    public actividad3_datos(ArrayList<String> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_actividad3,null,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView dato;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.dato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
