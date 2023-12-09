package com.example.contador;

import java.io.Serializable;

public class User implements Serializable {
    String user;
    String password;
    String precioAutoClick;
    String precioClick;
    int autoClick;
    int click;
    int clicker;

    public User (String user ,String password,String precioAutoClick,String precioClick,int autoClick,int click,int clicker ){
        this.user = user;
        this.password = password;
        this.precioAutoClick = precioAutoClick;
        this.precioClick = precioClick;
        this.autoClick = autoClick;
        this.click = click;
        this.clicker = clicker;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPrecioAutoClick (){return precioAutoClick; }
    public void setPrecioAutoClick(String precioAutoClick){ this.precioAutoClick = precioAutoClick; }
    public String getPrecioClick(){return precioClick;}
    public void setPrecioClick(String precioClick){this.precioClick = precioClick;}
    public int getAutoClick(){return autoClick;}
    public void setAutoClick(int autoClick){this.autoClick = autoClick;}
    public int getClick(){return }
}
