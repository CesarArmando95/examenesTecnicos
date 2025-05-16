package com.cesar.segurosprueba.controller;

import com.cesar.segurosprueba.exception.SeguroIdInvalidoException;
import com.cesar.segurosprueba.exception.SeguroNoEncontradoException;
import com.cesar.segurosprueba.models.Seguros;
import com.cesar.segurosprueba.service.SegurosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seguros")
public class SegurosController {
    private final SegurosService segurosService;

    @Autowired
    public SegurosController(SegurosService segurosService) {
        this.segurosService = segurosService;
    }

    @GetMapping
    public ResponseEntity<List<Seguros>> getAll() {
        return new ResponseEntity<>(segurosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seguros> getById(@PathVariable Long id) {
        try {
            Optional<Seguros> seguro = segurosService.findById(id);
            return seguro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseThrow(() -> new SeguroNoEncontradoException("No se encontró información asociada con el identificador ingresado. Asegúrese que sea correcto."));
        } catch (SeguroIdInvalidoException e) {
            throw e;
        } catch (SeguroNoEncontradoException e) {
            throw e;
        }
    }
}
