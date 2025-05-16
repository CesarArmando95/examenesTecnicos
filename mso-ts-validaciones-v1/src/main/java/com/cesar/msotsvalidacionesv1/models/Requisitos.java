package com.cesar.msotsvalidacionesv1.models;

public class Requisitos {
    private int edadMinima;
    private int edadMaxima;
    private int[] IdGenero;

    public Requisitos(int edadMinima, int edadMaxima, int[] idGenero) {
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        IdGenero = idGenero;
    }

    public Requisitos(){}

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int[] getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(int[] idGenero) {
        IdGenero = idGenero;
    }
}
