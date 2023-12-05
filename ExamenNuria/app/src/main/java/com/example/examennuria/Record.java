package com.example.examennuria;

public class Record { //creamos el objeto Record que va a ser cada elemento del Recycle  para guardarlo mas comodo
    String texto; //muestra Record:
    String tiempo; // muestra el tiempo

    public Record(String texto, String tiempo){
        this.texto =texto;
        this.tiempo = tiempo;
    }
    public String getTexto() {
        return texto;
    }
    public String getTiempo() {
        return tiempo;
    }
}
