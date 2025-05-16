package com.cesar.msotsvalidacionesv1.dto;

public class ValidacionResponse {
    private int codigo;
    private String respuesta;

    // Constructores, getters y setters

    public ValidacionResponse(int codigo, String respuesta) {
        this.codigo = codigo;
        this.respuesta = respuesta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
