package com.plataformasespeciales.api_procesador.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataformasespeciales.api_procesador.dto.OperacionRequest;
import com.plataformasespeciales.api_procesador.dto.OperacionResponse;
import com.plataformasespeciales.api_procesador.service.TransaccionService;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

    @PostMapping
    public OperacionResponse guardarOperacion(
            @RequestBody OperacionRequest request) {

        return service.guardarOperacion(request);

    }

}