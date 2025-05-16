package com.cesar.msotsvalidacionesv1.dto;

public class RespuestaServicio {
    private boolean estado;
    private String nombre;

    public RespuestaServicio(boolean estado, String nombre) {
        this.estado = estado;
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
