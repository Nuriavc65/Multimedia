package com.example.contador;

import java.io.Serializable;

public class User implements Serializable {
    String user; //
    String password; //
    int precioAutoClick; //costeBilleteAuto
    int precioClick; //costeBillete
    int autoClick; //valorAutoClick
    int click; //valorClick
    String clicker; //monedas

    public User (String user ,String password,int precioAutoClick,int precioClick,int autoClick,int click,String clicker ){
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
    public int getPrecioAutoClick (){return precioAutoClick; }
    public void setPrecioAutoClick(int precioAutoClick){ this.precioAutoClick = precioAutoClick; }
    public int getPrecioClick(){return precioClick;}
    public void setPrecioClick(int precioClick){this.precioClick = precioClick;}
    public int getAutoClick(){return autoClick;}
    public void setAutoClick(int autoClick){this.autoClick = autoClick;}
    public int getClick(){ return click; }
    public void setClick(int click){this.click = click;}
    public  String getClicker(){return clicker; }
    public void setClicker(String clicker){this.clicker = clicker;}
}
