package com.cesar.msotsvalidacionesv1.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ValidacionRequest {
    @NotNull(message = "idSeguro es obligatorio")
    private Long idSeguro;

    @Valid
    @NotNull(message = "cliente es obligatorio")
    private ClienteDTO cliente;

    public ValidacionRequest(Long idSeguro, ClienteDTO cliente) {
        this.idSeguro = idSeguro;
        this.cliente = cliente;
    }

    public ValidacionRequest() {}

    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
