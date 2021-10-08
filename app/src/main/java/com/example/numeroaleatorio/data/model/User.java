package com.example.numeroaleatorio.data.model;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    Integer intentos;
    int numAleatorio;
    boolean win;

    public User(String name, Integer intentos, int numAleatorio, boolean win) {
        this.name = name;
        this.intentos = intentos;
        this.numAleatorio = numAleatorio;
        this.win = win;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public int getNumAleatorio() {
        return numAleatorio;
    }

    public void setNumAleatorio(int numAleatorio) {
        this.numAleatorio = numAleatorio;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
