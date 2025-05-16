package com.cesar.msotsvalidacionesv1.models;

public class Seguro {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double costoAnual;
    private String[] beneficios;
    private Requisitos requisitos;

    public Seguro(Long id, String nombre, String descripcion, Double costoAnual, String[] beneficios, Requisitos requisitos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoAnual = costoAnual;
        this.beneficios = beneficios;
        this.requisitos = requisitos;
    }

    public Seguro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCostoAnual() {
        return costoAnual;
    }

    public void setCostoAnual(Double costoAnual) {
        this.costoAnual = costoAnual;
    }

    public String[] getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String[] beneficios) {
        this.beneficios = beneficios;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }
}
