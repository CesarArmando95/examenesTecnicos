package com.cesar.segurosprueba.service;

import com.cesar.segurosprueba.exception.SeguroIdInvalidoException;
import com.cesar.segurosprueba.models.Seguros;
import com.cesar.segurosprueba.repository.SegurosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SegurosService {
    private final SegurosRepository segurosRepository;

    @Autowired
    public SegurosService(SegurosRepository segurosRepository) {
        this.segurosRepository = segurosRepository;
    }

    public List<Seguros> findAll() {
        return segurosRepository.findAll();
    }

    public Optional<Seguros> findById(Long id) {
        if(id <= 0) {
            throw new SeguroIdInvalidoException("El indertificador ingresado no es valido, verifica e intenta nuevamente");
        }
        return segurosRepository.findById(id);
    }
}
