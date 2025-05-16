package com.cesar.msotsvalidacionesv1.controller;

import com.cesar.msotsvalidacionesv1.dto.RespuestaServicio;
import com.cesar.msotsvalidacionesv1.dto.ValidacionRequest;
import com.cesar.msotsvalidacionesv1.dto.ValidacionResponse;
import com.cesar.msotsvalidacionesv1.services.ValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validacion")
public class ValidacionController {
    private final ValidacionService validacionService;


    @Autowired
    public ValidacionController(ValidacionService validacionService) {
        this.validacionService = validacionService;
    }

    @PostMapping
    public ResponseEntity validar(@RequestBody ValidacionRequest validacionRequest) {
        try {
            RespuestaServicio respuestaServicio = validacionService.validarCliente(validacionRequest);
            if(respuestaServicio!= null) {
                if(respuestaServicio.isEstado()) {
                    ValidacionResponse response = new ValidacionResponse(
                            201,
                            "Nos complace informarle que cumple con los requisitos para acceder al seguro " + respuestaServicio.getNombre()  + " ¡Felicitaciones!"
                    );
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }
                else {
                    ValidacionResponse response = new ValidacionResponse(
                            401,
                            "Lamentamos informarle que no podemos ofrecerle el seguro " + respuestaServicio.getNombre() + " porque no cumple con ciertos requisitos establecidos. Por favor, revise los criterios necesarios o considere otras opciones"
                    );
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                }
            }
            else {
                ValidacionResponse response = new ValidacionResponse(
                        404,
                        "No se encontro Seguro"
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
