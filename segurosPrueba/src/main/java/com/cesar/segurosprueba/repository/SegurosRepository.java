package com.cesar.segurosprueba.repository;

import com.cesar.segurosprueba.models.Requisitos;
import com.cesar.segurosprueba.models.Seguros;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class SegurosRepository {
    private final List<Seguros> seguros = Arrays.asList(
            new Seguros(1L, "VIDA", "Protección económica para tu familia en caso de\n" +
                    "fallecimiento natural o accidental", 700.0, new String[]{"Beneficio económico para tu familia, que se incrementará\n" +
                    "en caso de fallecimiento accidental.", "Servicio funerario sin costo adicional."},
                    new Requisitos(18, 75, new int[]{1,2})),
            new Seguros(2L, "INFARTO", "Protección económica de $50,000 por la primera\n" +
                    "ocurrencia de infarto al miocardio.", 400.0,
                    new String[]{"Envío de ambulancia.", "Consultas médicas telefónicas ilimitadas.", "No se requiere presentar exámenes médicos."},
                new Requisitos(15, 64, new int[]{1,2})),
            new Seguros(2L, "MUJER", "Protección económica de $50,000 por el primer\n" +
                    "diagnóstico de cáncer de mama o cervicouterino.", 300.0,
                                new String[]{"20 consultas psicológicas a domicilio (aplican solo si se\n" +
                                        "diagnostica el cáncer).", "Consultas psicológicas por teléfono ilimitadas.", "No se requiere presentar exámenes médicos."},
                new Requisitos(15, 64, new int[]{2})));

    public List<Seguros> findAll() {
        return seguros;
    }

    public Optional<Seguros> findById(Long id){
        return seguros.stream().filter(seguro -> seguro.getId().equals(id)).findFirst();
    }
}
