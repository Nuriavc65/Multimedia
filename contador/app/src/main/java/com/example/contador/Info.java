package com.example.contador;

public class Info {
    String texto;
    String textoMenor;
    int image;

    public Info (String texto , String textoMenor, int image){
        this.image = image;
        this.texto = texto;
        this.textoMenor = textoMenor;
    }

    public String getTexto() {
        return texto;
    }

    public String getTextoMenor() {
        return textoMenor;
    }

    public int getImage() {
        return image;
    }
}
