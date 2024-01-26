package com.example.blackjack;

import java.io.IOException;
import java.net.Socket;

public class ConectaServidor {


    private Socket socket;

    public void conectarse() throws IOException {
           this.socket = new Socket("localhost",9999);
    }
}
