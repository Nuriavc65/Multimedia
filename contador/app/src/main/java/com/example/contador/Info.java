package com.example.contador;

public class Info { //creamos el objeto Info que va a ser cada elemento del ListView para guardarlo mas comodo
    String texto;
    String textoMenor;
    int image; //IMPORTANTE LAS IMAGENES SE GUARDAN EN INTS GILIPOLLAS QUE SEGURO QUE NO LO PONES :3

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
