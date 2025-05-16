package com.cesar.msotsvalidacionesv1.services;
import com.cesar.msotsvalidacionesv1.dto.RespuestaServicio;
import com.cesar.msotsvalidacionesv1.dto.ValidacionRequest;
import com.cesar.msotsvalidacionesv1.models.Seguro;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class ValidacionService {
    @Autowired
    private SeguroClient seguroClient;

    public RespuestaServicio validarCliente(ValidacionRequest validacionRequest) {
        Optional<Seguro> seguroOpt = obtenerSeguro(validacionRequest.getIdSeguro());

        if (seguroOpt.isEmpty()) {
            return null; // No se encontró el seguro
        }

        Seguro seguro = seguroOpt.get();
        int edad = calcularEdad(validacionRequest.getCliente().getFechaNacimiento());

        // Validar edad
        if (edad < seguro.getRequisitos().getEdadMinima() || edad > seguro.getRequisitos().getEdadMaxima()) {
            return new RespuestaServicio(false, seguro.getNombre());
        }

        // Validar género (si aplica)
        if (seguro.getRequisitos().getIdGenero() != null &&
                !Arrays.stream(seguro.getRequisitos().getIdGenero()).anyMatch(n -> n == validacionRequest.getCliente().getIdGenero())) {
            return new RespuestaServicio(false, seguro.getNombre());
        }

        return new RespuestaServicio(true, seguro.getNombre()); // Cumple requisitos, devolver nombre del seguro
    }

    private Optional<Seguro> obtenerSeguro(Long idSeguro) {
        try {
            Seguro seguro = seguroClient.getById(idSeguro);
            return Optional.ofNullable(seguro);
        } catch (FeignException.NotFound e) {
            // No se encontró el seguro
            return Optional.empty();
        } catch (FeignException e) {
            // Otros errores
            throw new RuntimeException("Error al obtener seguro", e);
        }
    }

    private int calcularEdad(String fechaNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento, formatter);
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
}
